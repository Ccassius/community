package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xh
 * @create 2021-12-04 11:43
 */
@Service
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public AlphaService() {
        System.out.println("实例化AlphaService");
    }

    // 用来修饰一个非静态的void()方法
    // 在服务器加载Servlet时运行，只会被执行一次
    @PostConstruct
    public void init() {
        System.out.println("初始化AlphaService");
    }


    // 在销毁对象之前调用
    @PreDestroy
    public void destroy() {
        System.out.println("销毁AlphaService");;
    }

    public String find() {
        return alphaDao.select();
    }
}

