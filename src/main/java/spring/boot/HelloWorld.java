package spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Boot
 * 传说中的微服务？更轻量级？更快？
 *
 * @author liuruichao
 * @date 15/8/5 下午1:01
 */
@Controller
@EnableAutoConfiguration
public class HelloWorld {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "liuruichao";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class, args);
    }
}
