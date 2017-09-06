package com.imooc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/7/10.
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
/**
 * Created by Administrator on 2017/7/4.
 */
/*      1、@controller 控制器（注入服务）
        2、@service 服务（注入dao）
        3、@repository dao（实现dao访问）
        4、@component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）*/

    private Integer age;
    private String cupSize;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }



}
