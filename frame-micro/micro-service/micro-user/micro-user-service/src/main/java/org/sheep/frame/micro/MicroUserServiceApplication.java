package org.sheep.frame.micro;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Description:
 * @Author: YangJiong
 * @Date: 17:18 2017/12/27
 */
@SpringBootApplication
@EnableDubboConfiguration
public class MicroUserServiceApplication implements CommandLineRunner{
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(MicroUserServiceApplication.class)
                .web(false)
                .run(args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
