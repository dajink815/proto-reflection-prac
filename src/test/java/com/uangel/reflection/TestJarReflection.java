package com.uangel.reflection;

import org.junit.Test;

/**
 * @author dajin kim
 */
public class TestJarReflection {

    @Test
    public void testJar() {
        Reflection reflection = new Reflection();
        String jarPath = "./src/main/resources/jar/aipbmsg-1.0.3.jar";
        reflection.loadJarFile(jarPath);
        reflection.process();
    }

}
