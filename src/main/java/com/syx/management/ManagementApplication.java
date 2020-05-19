package com.syx.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syx.management.core.dto.FileStorageProperties;

/**
 * @author calia
 */
@SpringBootApplication
@RestController
@MapperScan("com.syx.management.core.mapper")
//@EnableConfigurationProperties({FileProperties.class})
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
