package com.zwwhnly.springbootaction;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
//@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class SpringbootActionApplication {
    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index() {
        return "author name is " + authorSettings.getName() + " and author age is " + authorSettings.getAge();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootActionApplication.class, args);
    }
}
