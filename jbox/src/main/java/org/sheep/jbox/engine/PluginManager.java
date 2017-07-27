package org.sheep.jbox.engine;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: YangJiong
 * @Date: 15:09 2017/7/27
 */
public class PluginManager {

    private Map<String, PluginClassLoader> pluginMap = new HashMap<String, PluginClassLoader>();
    private static String packagename = "com.tds.test.classloader.Plugin1";

    public PluginManager() {
    }

    public void doSome(String pluginName) {
        try {
            Class<?> forName = Class.forName(packagename, true, getLoader(pluginName));
            //this.pluginMap.get(pluginName).loadClass(packagename);
            Plugin ins = (Plugin) forName.newInstance();
            ins.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addLoader(String pluginName, PluginClassLoader loader) {
        pluginMap.put(pluginName, loader);
    }

    private PluginClassLoader getLoader(String pluginName) {
        return pluginMap.get(pluginName);
    }

    public void loadPlugin(String pluginName) {
        PluginClassLoader loader = new PluginClassLoader();
        String pluginurl = "jar:file:/D:/testclassloader/" + pluginName + ".jar!/";
        URL url = null;
        try {
            url = new URL(pluginurl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        loader.loadJarPackge(url);
        addLoader(pluginName, loader);
    }

    public void reloadPlugin(String pluginName) {
        PluginClassLoader pluginClassLoader = getLoader(pluginName);
        pluginClassLoader.reloadJarPackge();
        pluginMap.put(pluginName, pluginClassLoader);
    }

    public void unloadPlugin(String pluginName) {
        pluginMap.get(pluginName).unloadJarPackge();
        pluginMap.remove(pluginName);
    }
}
