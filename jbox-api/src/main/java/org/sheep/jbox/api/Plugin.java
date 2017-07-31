package org.sheep.jbox.api;

/**
 * @Description:
 * @Author: YangJiong
 * @Date: 18:43 2017/7/25
 */
public interface Plugin {
    void init();
    boolean start();
    boolean restart();
    boolean stop();
}
