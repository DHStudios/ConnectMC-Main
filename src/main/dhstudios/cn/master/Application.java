package cn.dhstudios.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {
    // 定义一个显式的默认构造函数
    public Application() {
        super(); // 显式调用父类的构造函数
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}