package com.imooc.service;

//import com.imooc.enums.ResultEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import com.imooc.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/7/7.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @org.springframework.transaction.annotation.Transactional
    public void insertGirl(){
        Girl girla = new Girl();
        girla.setId(3);
        girla.setAge(1);
        girla.setCupSize("a");
        girlRepository.save(girla);

        Girl girlb = new Girl();
        girlb.setId(4   );
        girlb.setAge(2);
        girlb.setCupSize("bbbb");
        girlRepository.save(girlb);
    }
    public void judgeAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age>0 && age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<18){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
