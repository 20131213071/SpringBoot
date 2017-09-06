package com.imooc.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/7/4.
 */
@Entity//对应数据库里面的一个表girl
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Girl {
    public Girl() {
    }

    @javax.persistence.Id //id 是javax.persistence.Id的
    @GeneratedValue
    private Integer id;
    @Min(value = 18, message = "未满18岁禁止登入")
    private Integer age;
    private String cupSize;
    @NotNull(message = "not null")
    private Long money;


    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
   @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                '}';
    }
}
