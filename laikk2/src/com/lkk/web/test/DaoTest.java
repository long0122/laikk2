package com.lkk.web.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lkk.web.dao.interfaces.IAttentionDao;
import com.lkk.web.dao.interfaces.IUnitDao;
import com.lkk.web.model.Attention;
import com.lkk.web.model.Unit;

public class DaoTest {
	private static BeanFactory factory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new ClassPathXmlApplicationContext("beans.xml");
	}
	@Test
	public void testAttention() {
		IAttentionDao aDao = (IAttentionDao) factory
				.getBean("attentionDao");
		try {
			List<Attention> attrs = aDao.findAttByUnitId(9);
//			List<Attention> attrs = aDao.findAll();
				System.out.println(attrs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testAttentionAdd() {
		IAttentionDao aDao = (IAttentionDao) factory
				.getBean("attentionDao");
//		IUnitDao uDao = (IUnitDao) factory
//		.getBean("unitDao");
		
		try {
			Attention a = new Attention();
//			Unit u =uDao.findById(9);
//			System.out.println(u);
			//Unit u2 =uDao.findById(10);
			//System.out.println(u2);
			//a.setAttUnit(u2);
//			aDao.add(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
