package com.lkk.web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lkk.web.dao.interfaces.IAdvertisementDao;
import com.lkk.web.model.Advertisement;
import com.lkk.web.vo.AdvertisementInfo;

@Component("advertisementDao")
public class AdvertisementDaoImpl extends BasicDaoImpl<Advertisement, String>
		implements IAdvertisementDao {

	public List<Advertisement> findAll(AdvertisementInfo adInfo,
			int startIndex, int pageSize) {
		String hql = "from Advertisement ad where 1=1";
		if (adInfo != null && !"".equals(adInfo)) {
			String title = adInfo.getTitle();
			String category = adInfo.getCategory();
			String unit = adInfo.getUnit();
			String costomCategory = adInfo.getCustomStorage();
			String state = adInfo.getState();
			if (title != null && !"".equals(title)) {
				hql += " and ad.title like '" + title.trim() + "%'";
			}
			if (category != null && !"".equals(category)) {
				hql += " and ad.category.id = " + category;
			}
			if (unit != null && !"".equals(unit)) {
				hql += " and ad.unit.id = " + unit;
			}
			if (costomCategory != null && !"".equals(costomCategory)) {
				hql += " and ad.customCategory.id = " + costomCategory;
			}
			if (state != null && !"".equals(state)) {
				hql += " and ad.state = " + state;
			}
		}
		hql += " order by ad.createTime desc";
		List<Advertisement> list = getSession().createQuery(hql)
				.setFirstResult(startIndex).setMaxResults(pageSize).list();
		return list;
	}

	public long countAll(AdvertisementInfo adInfo) {
		String hql = "select count(ad) from Advertisement ad where 1=1";
		if (adInfo != null && !"".equals(adInfo)) {
			String title = adInfo.getTitle();
			String category = adInfo.getCategory();
			String unit = adInfo.getUnit();
			String costomCategory = adInfo.getCustomStorage();
			String state = adInfo.getState();
			if (title != null && !"".equals(title)) {
				hql += " and ad.title like '" + title.trim() + "%'";
			}
			if (category != null && !"".equals(category)) {
				hql += " and ad.category.id = " + category;
			}
			if (unit != null && !"".equals(unit)) {
				hql += " and ad.unit.id = " + unit;
			}
			if (costomCategory != null && !"".equals(costomCategory)) {
				hql += " and ad.customCategory.id = " + costomCategory;
			}
			if (state != null && !"".equals(state)) {
				hql += " and ad.state = " + state;
			}
		}
		long count = ((Long) getSession().createQuery(hql).uniqueResult())
				.intValue();
		return count;
	}

}
