package cn.wqy.eureka.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by wqy on 2019/01/03
 */
@EnableDiscoveryClient //使用该注解将注册服务到eureka
@SpringBootApplication
@MapperScan("cn.wqy.eureka.provider.dao")//配置mybatis接口包扫描
@EnableSwagger2
public class EurekaProviderApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class, args);
    }
}
