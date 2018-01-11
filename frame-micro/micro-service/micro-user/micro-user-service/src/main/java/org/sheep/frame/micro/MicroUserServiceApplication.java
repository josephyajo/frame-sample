package org.sheep.frame.micro;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:
 * @Author: YangJiong
 * @Date: 17:18 2017/12/27
 */
@SpringBootApplication
@EnableDubboConfiguration
@ComponentScan(basePackages = {"org.sheep.frame.micro"})
public class MicroUserServiceApplication implements CommandLineRunner {
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
