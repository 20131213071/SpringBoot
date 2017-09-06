package com.imooc.repository;

import com.imooc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/4.
 * JpaRepository<Girl,Integer> JpaRepository<T,ID> write ID 类型
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{
        }