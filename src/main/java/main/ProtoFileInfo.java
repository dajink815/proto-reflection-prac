package main;

import util.StringUtil;

/**
 * @author dajin kim
 */
public class ProtoFileInfo {
    private String fileName;
    private String javaPackage;
    private String javaClassName;

    public ProtoFileInfo() {
        // nothing
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getJavaPackage() {
        return javaPackage;
    }

    public void setJavaPackage(String javaPackage) {
        this.javaPackage = javaPackage;
    }

    public String getJavaClassName() {
        return javaClassName;
    }

    public void setJavaClassName(String javaClassName) {
        this.javaClassName = javaClassName;
    }

    public boolean isFinished() {
        return StringUtil.notNull(this.javaPackage) && StringUtil.notNull(this.javaClassName);
    }

    @Override
    public String toString() {
        return "ProtoFileInfo{" +
                "javaPackage='" + javaPackage + '\'' +
                ", javaClassName='" + javaClassName + '\'' +
                '}';
    }
}
