package com.lkk.web.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.lkk.web.context.GlobalConstants;
import com.lkk.web.model.User;

/**
 * 工具类
 * 
 * @author yup
 * 
 *         2012-2-1
 */
public class Tools {
	/**
	 * 获得当前时间并格式化：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getCurrentTimeSort() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDate = sdf.format(new Date());
		return currentDate;
	}

	/**
	 * 获得当前时间并格式化：HH:mm:ss
	 * 
	 * @return
	 */
	public static String getCurrentTimeNoDate() {

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String currentDate = sdf.format(new Date());
		return currentDate;
	}

	/**
	 * 获得当前时间并格式化：yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getCurrentDateSort() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDate = sdf.format(new Date());
		return currentDate;
	}

	/**
	 * 获得当前时间并格式化：yyyyMMdd
	 * 
	 * @return
	 */
	public static String getCurrentDateSortNoTime() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String currentDate = sdf.format(new Date());
		return currentDate;
	}

	/**
	 * 将20101202时间格式化为2010-12-02
	 * 
	 * @param DateString
	 *            时间格式:yyyyMMdd
	 * @return
	 */
	public static String getDateForWebStyleNoTime(String DateString) {

		StringBuilder sb = new StringBuilder();
		sb.append(DateString.substring(0, 4)).append("-").append(
				DateString.subSequence(4, 6)).append("-").append(
				DateString.substring(6, 8));
		return sb.toString();
	}

	/**
	 * 将20101202101423时间格式化为2010-12-02 10:14:23
	 * 
	 * @param DateString
	 *            时间格式:yyyyMMddHHmmss
	 * @return
	 */
	public static String getDateForWebStyle(String DateString) {

		StringBuilder sb = new StringBuilder();
		sb.append(DateString.substring(0, 4)).append("-").append(
				DateString.subSequence(4, 6)).append("-").append(
				DateString.substring(6, 8)).append(" ").append(
				DateString.substring(8, 10)).append(":").append(
				DateString.substring(10, 12)).append(":").append(
				DateString.substring(12));
		return sb.toString();
	}

	/**
	 * 将20101202(101423)时间格式 获得年份
	 * 
	 * @param DateString
	 *            时间格式:yyyyMMdd(HHmmss)
	 * @return
	 */
	public static String getYear(String DateString) {

		return DateString.substring(0, 4);
	}

	/**
	 * 将20101202(101423)时间格式 获得月份
	 * 
	 * @param DateString
	 *            时间格式:yyyyMMdd(HHmmss)
	 * @return
	 */
	public static String getMonth(String DateString) {

		return DateString.substring(4, 6);
	}

	/**
	 * 将20101202时间格式 获得日期
	 * 
	 * @param DateString
	 *            时间格式:yyyyMMdd
	 * @return
	 */
	public static String getDayNoTime(String DateString) {

		return DateString.substring(6);
	}

	/**
	 * 把界面输入的时间转为间凑的时间字符串 将2010-12-02 10:14:23时间格式化为20101202101423
	 * 
	 * @param LongDateString
	 *            String
	 * @return String
	 */
	public static String getShortString(String LongDateString) {
		StringBuffer ret = new StringBuffer();
		try {
			ret.append(LongDateString.substring(0, 4));
			ret.append(LongDateString.substring(5, 7));
			ret.append(LongDateString.substring(8, 10));
			ret.append(LongDateString.substring(11, 13));
			ret.append(LongDateString.substring(14, 16));
			ret.append(LongDateString.substring(17, 19));
		} catch (Exception ex) {
			// 如果字串不够长度，则返回前面的部分
		}
		return ret.toString();
	}

	/**
	 * 时间字符串传时间
	 * 
	 * @param DateString
	 * @return
	 * @throws Exception
	 */
	public static Date getStringToDate(String DateString) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(DateString);
		return date;
	}

	/**
	 * 时间字符串传时间
	 * 
	 * @param DateString
	 * @return
	 * @throws Exception
	 */
	public static Date getStringToTime(String DateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date = null;
		try {
			date = sdf.parse(DateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 增加日期
	 * @param format
	 * @param StrDate
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static String calculateDate(String format, String StrDate, int year,
			int month, int day) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sFmt = new SimpleDateFormat(format);
		cal.setTime(sFmt.parse((StrDate), new ParsePosition(0)));

		if (day != 0) {
			cal.add(cal.DATE, day);
		}
		if (month != 0) {
			cal.add(cal.MONTH, month);
		}
		if (year != 0) {
			cal.add(cal.YEAR, year);

		}
		return sFmt.format(cal.getTime());
	}

	/**
	 * 获取文件的后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtention(String fileName) {
		if(fileName==null){
			return ".jpg";
		}else{
			int pos = fileName.lastIndexOf(".");
			return fileName.substring(pos);
		}
		
	}

	/**
	 * 获得页面全路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getFullUrl(HttpServletRequest request) {

		StringBuffer url = new StringBuffer();
		String scheme = request.getScheme();
		int port = request.getServerPort();
		if (port < 0)
			port = 80; // Work around java.net.URL bug

		url.append(scheme);
		url.append("://");
		url.append(request.getServerName());
		if ((scheme.equals("http") && (port != 80))
				|| (scheme.equals("https") && (port != 443))) {
			url.append(':');
			url.append(port);
		}
		url.append(request.getRequestURI());

		String queryString = request.getQueryString();

		if (queryString != null)
			url.append('?').append(queryString);

		return url.toString();
	}

	public static String getHostUrl(HttpServletRequest request) {
		StringBuffer url = new StringBuffer();
		String scheme = request.getScheme();
		int port = request.getServerPort();
		if (port < 0)
			port = 80; // Work around java.net.URL bug

		url.append(scheme);
		url.append("://");
		url.append(request.getServerName());
		if ((scheme.equals("http") && (port != 80))
				|| (scheme.equals("https") && (port != 443))) {
			url.append(':');
			url.append(port);
		}
		String contextPath = request.getContextPath();
		
		if(contextPath!=null&&!"".equals(contextPath)){
			url.append("/");
			url.append(contextPath);
		}
		url.append("/");
		return url.toString();
	}
	public static String getCityId(HttpServletRequest request){
		String cityId = "";
//		Object user = request.getSession().getAttribute(
//				GlobalConstants.SESSION_USER_INDEX);
//		if (user != null) {
//			User u = (User) user;
//			cityId = u.getCity().getCityId();
//		} else {
//			cityId = GlobalConstants.INDEX_DEFAULT_CITY_ID;
//		}
		Object cityCode = request.getSession().getAttribute(
				GlobalConstants.SESSION_CITY_CODE);
//		System.out.println("cityCode===="+cityCode);
		if(cityCode==null){
			Cookie cityIdCookie = CookieUtil.getCookie(request, GlobalConstants.INDEX_COOKIE_CITY_ID);
//			System.out.println("cityIdCookie===="+cityIdCookie);
			if(cityIdCookie==null){
				cityId = GlobalConstants.INDEX_DEFAULT_CITY_ID;
			}else{
				cityId = cityIdCookie.getValue();
			}
		}else{
			cityId = cityCode.toString();
		}
		return cityId;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(Tools.getCurrentTimeNoDate());
		System.out.println(Tools.getStringToTime("20:00"));
		System.out.println(Tools.calculateDate("yyyyMMdd", Tools.getCurrentDateSortNoTime(), 0, 1, 0));

	}
}
