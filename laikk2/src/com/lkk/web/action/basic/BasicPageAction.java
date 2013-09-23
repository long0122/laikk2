package com.lkk.web.action.basic;

import com.lkk.web.context.GlobalConstants;
import com.lkk.web.vo.Pager;
/**
 * 需要分页的action 继承此类
 * @author Warren
 *
 */
public class BasicPageAction extends BasicAction {
	// 分页
	protected int pageSize = GlobalConstants.PAGE_SIZE;
	protected String pageNo = "1";
	protected String pageNoSelect = "1";// 跳转传过来的pageNo
	protected String isTo = "0";// 判断是否为跳转的
	protected Pager pager;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getPageNoSelect() {
		return pageNoSelect;
	}
	public void setPageNoSelect(String pageNoSelect) {
		this.pageNoSelect = pageNoSelect;
	}
	public String getIsTo() {
		return isTo;
	}
	public void setIsTo(String isTo) {
		this.isTo = isTo;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
}
