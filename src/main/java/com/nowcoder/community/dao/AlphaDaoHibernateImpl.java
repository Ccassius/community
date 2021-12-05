package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author xh
 * @create 2021-12-04 11:27
 */

@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
