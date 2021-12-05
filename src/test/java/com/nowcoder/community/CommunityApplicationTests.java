package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    void contextLoads() {
        System.out.println(applicationContext);

        // 输出 MyBatis，因为AlphaDaoMybatisImpl用了@Primary注解
        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
        System.out.println(alphaDao.select());

        // 输出Hibernate
        alphaDao = applicationContext.getBean("alphaHibernate", AlphaDao.class);
        System.out.println(alphaDao.select());
    }

    @Test
    public void testBeanManagement() {
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);

        alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
    }

    @Test
    public void testBeanConfig() {
        SimpleDateFormat simpleDateForma =
                applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateForma.format(new Date()));
    }

    // spring容器把AlphaDao注入到 alphaDao
    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    @Qualifier("alphaHibernate")
    private AlphaDao alphaDaoHbernate;

    @Autowired
    private AlphaService alphaService;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    // 测试依赖注入
    @Test
    public void testDI() {
        System.out.println(alphaDao);
        System.out.println(alphaDaoHbernate);
        System.out.println(alphaService);
        System.out.println(simpleDateFormat);
    }

}
