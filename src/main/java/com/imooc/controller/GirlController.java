package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by smx on 2017/7/4.
 */

@RestController
public class GirlController {
    //加入日志
    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    // 获取表内信息

    @GetMapping(value = "/get")
    public List<Girl> getGirl() {
        return girlRepository.findAll();
    }

    /* 插入cupSize和age到表*/

    @PostMapping(value = "/post")
    public Girl postGirl(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /*通过id查询一个女生信息
    * 类在转化为json时，有属性值是null
    * HttpMessageNotWritableException: Could not write JSON: No serializer found for
    * 在girl类中加入JsonIgnoreProperties注解*/
    @GetMapping(value = "/get/{id}")
    public Girl findGirl(@PathVariable("id") Integer id) {
        return girlRepository.getOne(id);
    }

    /**
     * 更新*
     */

    @PutMapping(value = "/put/{id}")
    public Girl putGirl(@PathVariable("id") Integer id,
                        @RequestParam("age") Integer age,
                        @RequestParam("cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        return girlRepository.save(girl);
    }
    /* 删除* */

    @DeleteMapping(value = "/del/{id}")
    public void delGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

   /*  controller调用service调用repository接口*/

    @Autowired
    GirlService girlService = new GirlService();

    @GetMapping(value = "/insert")
    public void insertTwo() {

        girlService.insertGirl();
    }

/*    进行年纪的校验，Girl类中加Min注释，入参加Valid校验，验证后对象放到BindingResult这个对象中
    * 同时进行返回类型的封装处理，Result和Util类*/

    @PostMapping(value = "/add")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) {
        logger.info("进入方法了！");
        //期待返回格式统一为code+data+msg形式
        if (bindingResult.hasErrors()) {
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            ResultUtil resultUtil = new ResultUtil();
            return resultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girl.setMoney(girl.getMoney());
        ResultUtil resultUtil = new ResultUtil();
        return resultUtil.success(girlRepository.save(girl));
    }


//    统一异常处理demo

    @GetMapping(value = "/get/ex/{id}")
    public void judgeAge(@PathVariable(value = "id") Integer id) throws Exception {
        girlService.judgeAge(id);
    }
}