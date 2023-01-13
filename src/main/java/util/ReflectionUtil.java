package util;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.expr.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.IntStream;

/**
 *
 * @author kangmoo Heo
 */
public class ReflectionUtil {
    
    public static void main(String[] args) throws Exception {
        //umedia.library.common.ReflectionUtil.TypeValuePair typeValuePair = exec("new media.platform.stream.session.info.ConfInfo(\"testConf\", \"testClient\")");
        //System.out.println(typeValuePair.type);
/*        ConfInfo confInfo = (ConfInfo) typeValuePair.value;
        System.out.println(confInfo.getConfId());
        System.out.println(confInfo.getClientId());*/

        //System.out.println(exec("java.time.LocalDateTime.now()"));
        //System.out.println(exec("java.time.format.DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm:ss.SSS\")"));

        System.out.println(exec("java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm:ss.SSS\"))"));
        System.out.println(exec("java.util.UUID.randomUUID().toString()"));
    }

    public static umedia.library.common.ReflectionUtil.TypeValuePair exec(String expression) throws Exception {
        expression = expression.trim();
        if (expression.endsWith(";")) expression = expression.substring(0, expression.length() - 1);
        Expression expr = StaticJavaParser.parseExpression(expression);
        if (expr.isObjectCreationExpr()) {
            return execObjectCreationExpr(expr.asObjectCreationExpr());
        } else if (expr.isMethodCallExpr()) {
            return execMethodCallExpr(expr.asMethodCallExpr());
        } else if (expr.isCastExpr()) {
            return execCastExpr(expr.asCastExpr());
        } else if (expr.isFieldAccessExpr()) {
            return execFieldAccessExpr(expr.asFieldAccessExpr());
        } else if (expr.isNameExpr()) {
            return new umedia.library.common.ReflectionUtil.TypeValuePair(Class.forName(expr.toString()), null);
        } else if (expr.isNullLiteralExpr()) {
            return new umedia.library.common.ReflectionUtil.TypeValuePair(null, null);
        } else if (expr.isDoubleLiteralExpr()) {
            return new umedia.library.common.ReflectionUtil.TypeValuePair(double.class, expr.asDoubleLiteralExpr().asDouble());
        } else if (expr.isIntegerLiteralExpr()) {
            return new umedia.library.common.ReflectionUtil.TypeValuePair(int.class, expr.asIntegerLiteralExpr().asNumber().intValue());
        } else if (expr.isLongLiteralExpr()) {
            return new umedia.library.common.ReflectionUtil.TypeValuePair(long.class, expr.asLongLiteralExpr().asNumber().longValue());
        } else if (expr.isBooleanLiteralExpr()) {
            return new umedia.library.common.ReflectionUtil.TypeValuePair(boolean.class, expr.asBooleanLiteralExpr().getValue());
        } else if (expr.isStringLiteralExpr()) {
            return new umedia.library.common.ReflectionUtil.TypeValuePair(String.class, expr.asStringLiteralExpr().asString());
        }
        return null;
    }

    public static umedia.library.common.ReflectionUtil.TypeValuePair execMethodCallExpr(MethodCallExpr methodCallExpr) throws Exception {
        Class<?> clazz = null;
        umedia.library.common.ReflectionUtil.TypeValuePair object = null;
        if (methodCallExpr.hasScope()) {
            Expression superExpression = methodCallExpr.getScope().get();
            object = exec(superExpression.toString());
            clazz = object == null ? null : object.type;
        }

        umedia.library.common.ReflectionUtil.TypeValuePair[] params = exec(methodCallExpr.getArguments());
        Class<?>[] paramTypes = null;
        Object[] paramValues = null;
        if (params != null) {
            paramTypes = new Class[params.length];
            paramValues = new Object[params.length];
            for (int i = 0; i < params.length; i++) {
                paramTypes[i] = params[i].type;
                paramValues[i] = params[i].value;
            }
        }

        Method method = clazz.getMethod(methodCallExpr.getName().toString(), paramTypes);
        return new umedia.library.common.ReflectionUtil.TypeValuePair(method.getReturnType(), method.invoke(object == null ? null : object.value, paramValues));
    }

    public static umedia.library.common.ReflectionUtil.TypeValuePair execObjectCreationExpr(ObjectCreationExpr objectCreationExpr) throws Exception {
        Class<?> clazz = Class.forName(objectCreationExpr.getType().toString());
        umedia.library.common.ReflectionUtil.TypeValuePair[] params = exec(objectCreationExpr.getArguments());
        Class<?>[] paramTypes = null;
        Object[] paramValues = null;
        if (params != null) {
            paramTypes = new Class[params.length];
            paramValues = new Object[params.length];
            for (int i = 0; i < params.length; i++) {
                paramTypes[i] = params[i].type;
                paramValues[i] = params[i].value;
            }
        }
        return new umedia.library.common.ReflectionUtil.TypeValuePair(clazz, clazz.getDeclaredConstructor(paramTypes).newInstance(paramValues));
    }

    public static umedia.library.common.ReflectionUtil.TypeValuePair execFieldAccessExpr(FieldAccessExpr fieldAccessExpr) throws Exception {
        try {
            return new umedia.library.common.ReflectionUtil.TypeValuePair(Class.forName(fieldAccessExpr.toString()), null);
        } catch (Exception ignored){
        }
        umedia.library.common.ReflectionUtil.TypeValuePair object;
        try {
            object = new umedia.library.common.ReflectionUtil.TypeValuePair(Class.forName(fieldAccessExpr.getScope().toString()), null);
        } catch (Exception e2){
            object = exec(fieldAccessExpr.getScope().toString());
        }
        Field field = object.type.getDeclaredField(fieldAccessExpr.getNameAsString());
        field.setAccessible(true);
        return new umedia.library.common.ReflectionUtil.TypeValuePair(field.getType(), field.get(object.value));
    }

    public static umedia.library.common.ReflectionUtil.TypeValuePair execCastExpr(CastExpr castExpr) throws Exception {
        String type = castExpr.getType().toString();
        String value = castExpr.getExpression().toString();
        try {
            if (castExpr.getType().isPrimitiveType()) {
                switch (type) {
                    case "int":
                        return value.contains(".") ? new umedia.library.common.ReflectionUtil.TypeValuePair(int.class, (int) Double.parseDouble(value)) : new umedia.library.common.ReflectionUtil.TypeValuePair(int.class, Integer.parseInt(value));
                    case "long":
                        return value.contains(".") ? new umedia.library.common.ReflectionUtil.TypeValuePair(long.class, (long) Double.parseDouble(value)) : new umedia.library.common.ReflectionUtil.TypeValuePair(long.class, Long.parseLong(value));
                    case "short":
                        return value.contains(".") ? new umedia.library.common.ReflectionUtil.TypeValuePair(short.class, (short) Double.parseDouble(value)) : new umedia.library.common.ReflectionUtil.TypeValuePair(short.class, Short.parseShort(value));
                    case "byte":
                        return value.contains(".") ? new umedia.library.common.ReflectionUtil.TypeValuePair(short.class, (short) Double.parseDouble(value)) : new umedia.library.common.ReflectionUtil.TypeValuePair(byte.class, Byte.parseByte(value));
                    case "float":
                        return new umedia.library.common.ReflectionUtil.TypeValuePair(float.class, Float.parseFloat(value));
                    case "double":
                        return new umedia.library.common.ReflectionUtil.TypeValuePair(double.class, Double.parseDouble(value));
                    case "char":
                        return new umedia.library.common.ReflectionUtil.TypeValuePair(char.class, value.charAt(0));
                    case "boolean":
                        return new umedia.library.common.ReflectionUtil.TypeValuePair(boolean.class, Boolean.parseBoolean(value));
                    default:
                        break;
                }
            } else {
                Class<?> typeClass = Class.forName(castExpr.getType().toString());
                new umedia.library.common.ReflectionUtil.TypeValuePair(typeClass, typeClass.cast(castExpr.getType().asTypeParameter().getName().toString()));
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    public static umedia.library.common.ReflectionUtil.TypeValuePair[] exec(List<Expression> expressions) throws Exception {
        if (expressions == null) return null;
        umedia.library.common.ReflectionUtil.TypeValuePair[] res = new umedia.library.common.ReflectionUtil.TypeValuePair[expressions.size()];
        IntStream.range(0, res.length).forEach(index -> {
            try {
                res[index] = exec(expressions.get(index).toString());
            } catch (Exception e) {
                res[index] = null;
            }
        });
        return res;
    }

    public static class TypeValuePair {
        public final Class<?> type;
        public final Object value;

        public TypeValuePair(Class<?> type, Object value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }


}
