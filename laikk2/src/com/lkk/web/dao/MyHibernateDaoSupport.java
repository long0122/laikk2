package com.lkk.web.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * 
 * @author wgl
 *
 */
public class MyHibernateDaoSupport extends HibernateDaoSupport {
    
     @Resource(name="sessionFactory")   //为父类HibernateDaoSupport注入sessionFactory的值ֵ
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
     }

}