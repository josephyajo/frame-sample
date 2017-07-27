package org.sheep.jbox.engine;

import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

/**
 * @Description:
 * @Author: YangJiong
 * @Date: 15:02 2017/7/27
 */
public class PluginClassLoader extends URLClassLoader {
    private JarURLConnection jarFile;

    public PluginClassLoader() {
        super(new URL[]{}, findParentClassLoader());
    }

    public void loadJarPackge(URL file) {
        try {
            URLConnection uc = file.openConnection();
            if (uc instanceof JarURLConnection) {
                uc.setUseCaches(true);
                jarFile = (JarURLConnection) uc;
            }
        } catch (Exception e) {
            System.err.println("Failed to cache plugin JAR file: " + file.toExternalForm());
        }
        addURL(file);
    }

    public void unloadJarPackge() {
        try {
            if (jarFile != null) {
                System.err.println("Unloading plugin JAR file " + jarFile.getJarFile().getName());
                jarFile.getJarFile().close();
                jarFile = null;
            }
        } catch (Exception e) {
            System.err.println("Failed to unload JAR file\n" + e);
        }
    }

    public void reloadJarPackge() {
        try {
            if (jarFile != null) {
                System.err.println("Unloading plugin JAR file " + jarFile.getJarFile().getName());
                URL url = jarFile.getURL();
                jarFile.getJarFile().close();
                loadJarPackge(url);
            }
        } catch (Exception e) {
            System.err.println("Failed to unload JAR file\n" + e);
        }
    }

    private static ClassLoader findParentClassLoader() {
        ClassLoader parent = PluginManager.class.getClassLoader();
        if (parent == null) {
            parent = PluginClassLoader.class.getClassLoader();
        }
        if (parent == null) {
            parent = ClassLoader.getSystemClassLoader();
        }
        return parent;
    }
}
