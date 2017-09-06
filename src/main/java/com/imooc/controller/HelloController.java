package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by smx on 2017/6/22.
 *     //启动方式，run这个类或者
 // cmd中D:\Users\Administrator\workspace_javaee_new\girl mvn spring-boot：run
 //mvn install java -jar girl-0.0.1-SNAPSHOT.jar
 */
@RestController
public class HelloController {
    //获取application.yml一种方式
    @Value("${cupSize}")
    private  String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;
    //获取application.yml另一种方式
    @Autowired
    private GirlProperties girlProperties;

    /*
    * 带请求参数的get请求
    * */
    @RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value ="param",required = false,defaultValue = "100") String args) {
        int a = Integer.parseInt(args);
        return ("Hello Spring Boot!" + 100 / a);
    }
    /*
    * 请求path内含有参数的get请求//@GetMapping(Value="/say")
    * */
    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return "Hello Spring Boot!"+"content value is"+content+
                "girlProperties is "+girlProperties.getCupSize()+
                "PathVariable id is "+id;
    }
}