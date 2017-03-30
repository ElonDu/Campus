package  com.huifu.auth.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CPublic extends java.lang.Object {

	public static char[] DigitalMap = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z' };

	public static char[] DigitalMap1 = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9' };

	public static final String DATE_NUMBER_PATTERN = "yyyyMMdd";
	
	public static final String DATETIME_NUMBER_PATTERN = "yyyyMMddHHmmss";

	public static final String DOWNLOAD_SECURITY_KEY = "chinapnr-pms";
	
	/** �ƻ�������-�������� */
	public static final String[] SPECIAL_CITY = { "2102", "3302", "3502",
			"3702", "4402" };
	
	/** �û��Ự���� */
	public static Map<String, Object> sessions = new HashMap<String, Object>();

	public static String replaceSubString(String orgString,
			String resSubString, String replaceString) {
		String sPreString = "";
		String sSufString = "";
		int iBlkStart = 0;
		if ((iBlkStart = orgString.indexOf(resSubString, 0)) == -1) {
			return orgString;
		} else {
			sPreString = orgString.substring(0, iBlkStart);
			sSufString = orgString.substring(sPreString.length()
					+ resSubString.length());
			return sPreString + replaceString + sSufString;
		}
	}

	public static String i2a(int x, int len, int base) {
		char s[] = new char[len];
		int i;
		for (i = len - 1; i >= 0; i--) {
			s[i] = DigitalMap[x % base];
			x = x / base;
		}
		return new String(s);
	}

	public static String gb2Unicode(String str) {
		if (str == null)
			return null;

		try {
			byte[] b = (str.trim()).getBytes("GB2312");
			String rstr = new String(b);

			return rstr;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public static String unicode2Gb(String str) {
		if (str == null)
			return null;

		try {
			byte[] b = str.getBytes();
			String rstr = new String(b, "GB2312");

			return rstr;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public static String d2a(double x, int len, int dic) throws Exception {
		int i;
		char[] buf = new char[len];
		if (dic > len - 1)
			throw new Exception(
					"the length of digital is longer than total length.");

		int dp = len - dic - 1;
		buf[dp] = '.';

		double dicCorrect = 0.5;
		for (i = 0; i < dic; i++) {
			dicCorrect /= 10;
		}
		x += dicCorrect;

		double intPart = Math.floor(x);
		double digPart = x - (int) x;

		int intDig;
		for (i = dp + 1; i < len; i++) {
			digPart = digPart * 10;
			intDig = (int) digPart;
			buf[i] = (char) ('0' + intDig);
			digPart = digPart - intDig;
		}

		double y = 0;
		for (i = dp - 1; i >= 0; i--) {
			y = Math.floor(intPart / 10);
			intDig = (int) (intPart - y * 10);
			if (intPart == 0) {
				buf[i] = ' ';
			} else {
				buf[i] = (char) ('0' + intDig);
			}
			intPart = y;
		}
		if (y > 9)
			System.out.println("lost dicision!");
		return new String(buf);
	}

	/**
	 * ����ָ�����ȵ��ַ���(StringBufferʵ��).
	 * 
	 * @param str
	 * @param len
	 * @param ch
	 * @return
	 */
	public static String leftPad(String str, int len, char ch) {
		StringBuffer nstr = new StringBuffer(len);

		int p = len - str.length();

		for (int i = 0; i < len; i++) {
			if (i < p)
				nstr.append(ch);
			else
				nstr.append(str.charAt(i - p));
		}
		return new String(nstr);
	}
	
	/**
	 * ����ָ�����ȵ��ַ���(byteʵ��).
	 * 
	 * @param str
	 * @param len
	 * @param ch
	 * @return
	 */
	public static String leftPadb(String str, int len, char ch) {
		byte[] ret_byte_arr = new byte[len];
		byte[] tmp_byte_arr = str.getBytes();

		int p = len - tmp_byte_arr.length;

		for (int i = 0; i < len; i++) {
			if (i < p)
				ret_byte_arr[i] = (byte) ch;
			else
				ret_byte_arr[i] = tmp_byte_arr[i - p];
		}
		return new String(ret_byte_arr);
	}
	
	/**
	 * �Ҳ���ָ�����ȵ��ַ���.
	 * 
	 * @param str
	 * @param len
	 * @param ch
	 * @return
	 */
	public static String rightPad(String str, int len, char ch) {
		byte[] byteStr = str.getBytes();
		int p = len - byteStr.length;
		String nstr = "";

		for (int i = 0; i < p; i++) {
			nstr = nstr + ch;
		}
		nstr = str + nstr;

		return nstr;
	}
	
	/**
	 * ��ȡ��ǰ����(��ʽ��yyyyMMdd).
	 * 
	 * @see gms.CPublic.getDate()
	 * 
	 * @return Current Date String.
	 */
	@Deprecated
	public static String getDateFormat1() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		java.util.Date current = new java.util.Date();
		String currentStr = formatter.format(current);
		return currentStr;
	}

	/**
	 * ��ȡ��ǰ����(��ʽ��yyyy-MM-dd).
	 *
	 * @see gms.CPublic.getDate2()
	 * 
	 * @return Current Date String.
	 */
	@Deprecated
	public static String getDateFormat2() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date current = new java.util.Date();
		String currentStr = formatter.format(current);
		return currentStr;
	}

	public static String getDateFormatMoring(String days) {
		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		int day2 = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, day2 + Integer.parseInt(days));
		String date = dft.format(cal.getTime());
		return date;
	}

	/**
	 * ��ȡ��ǰ����(��ʽ��yyyyMMdd).
	 * 
	 * @return Current Date String.
	 */
	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		java.util.Date dateCurrent = new java.util.Date();
		String currentStr = formatter.format(dateCurrent);
		return currentStr;
	}
	
	/**
	 * ��ȡ��ǰ����(��ʽ��yyMMdd).
	 * 
	 * @return Current Date String.
	 */
	public static String getDateEight() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
		java.util.Date dateCurrent = new java.util.Date();
		String currentStr = formatter.format(dateCurrent);
		return currentStr;
	}
	
	/**
	 * ��ȡ��ǰ����(��ʽ��yyyy-MM-dd).
	 * 
	 * @return Current Date String.
	 */
	public static String getDate2() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dateCurrent = new java.util.Date();
		String currentStr = formatter.format(dateCurrent);
		return currentStr;
	}
	
	/**
	 * ��ȡ��ǰʱ��(��ʽ��HHmmss).
	 * 
	 * @return Current Time String.
	 */
	public static String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
		java.util.Date current = new java.util.Date();
		String currentStr = formatter.format(current);
		return currentStr;
	}
	
	/**
	 * ��ȡ��ǰʱ��(��ʽ��HH:mm:ss).
	 * 
	 * @return Current Time String.
	 */
	public static String getTime2(){
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		java.util.Date current = new java.util.Date();
		String currentStr = formatter.format(current);
		return currentStr;
	}
	
	/**
	 * ��ȡ��ǰʱ��(��ʽ��yyyyMMddHHmmss).
	 * 
	 * @return Current Time String.
	 */
	public static String getDateAndTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		java.util.Date current = new java.util.Date();
		String currentStr = formatter.format(current);
		return currentStr;
	}
	
	/**
	 * ��ȡ���ָ��������ʱ��(��ʽ��yyyyMMddHHmmss).
	 * 
	 * @param days
	 *            - ָ��������������磺-1��ʾǰһ��
	 * @return Time String.
	 */
	public static String getDateAndTime(int days) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		java.util.Date dateCurrent = new java.util.Date();
		String currentTime = formatter.format(new Date(dateCurrent.getTime()
				+ (long) days * 24 * 60 * 60 * 1000));
		return currentTime;
	}
	
	/**
	 * ��ȡ��ǰʱ��(��ʽ��yyyyMMddHHmmss).
	 * 
	 * @return Current Time String.
	 */
	public static String getDateAndTimeAndMS() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS");
		java.util.Date current = new java.util.Date();
		String currentStr = formatter.format(current);
		return currentStr;
	}


	/**
	 * ��ȡ���ָ��������ʱ��(��ʽ��yyyyMMddHHmmss).
	 * 
	 * @see gms.CPublic.getDateAndTime(int)
	 * 
	 * @param days
	 *            - ָ��������������磺-1��ʾǰһ��
	 * @return
	 */
	@Deprecated
	public static String get24HTime(int i) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		java.util.Date dateCurrent = new java.util.Date();
		String strCurrentTime = formatter.format(new Date(dateCurrent.getTime()
				+ (long) i * 24 * 60 * 60 * 1000));

		return strCurrentTime;
	}


	public static String getDateAndTime2() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date dateCurrent = new java.util.Date();

		String strCurrentTime = formatter.format(dateCurrent);

		return strCurrentTime;
	}

	/**
	 * ������ֹ�պ��������������ʼ��
	 * 
	 * @param endDate
	 * @param days
	 * @return
	 */
	public static Date getStartDateByDays(Date endDate, int days) {

		Calendar calendarEndDate = Calendar.getInstance();
		calendarEndDate.setTime(endDate);
		calendarEndDate.add(Calendar.DAY_OF_YEAR, 0 - days);

		return calendarEndDate.getTime();
	}

	/**
	 * ������ֹ�պ��������������ʼ��
	 * 
	 * @param endDate
	 * @param days
	 * @return
	 * @throws ParseException
	 */
	public static String getStartDateByDays(String endDate, int days)
			throws ParseException {
		return dateToNumber(getStartDateByDays(stringToDate(endDate), days));
	}


	/**
	 * ������ʼ�պ��������������ֹ��
	 * 
	 * @param endDate
	 * @param days
	 * @return
	 */
	public static Date getEndDateByDays(Date startDate, int days) {

		Calendar calendarEndDate = Calendar.getInstance();
		calendarEndDate.setTime(startDate);
		calendarEndDate.add(Calendar.DAY_OF_YEAR, days);

		return calendarEndDate.getTime();
	}

	/**
	 * ������ʼ�պ��������������ֹ��
	 * 
	 * @param endDate
	 * @param days
	 * @return
	 * @throws ParseException
	 */
	public static String getEndDateByDays(String startDate, int days)
			throws ParseException {
		return dateToNumber(getEndDateByDays(stringToDate(startDate), days));
	}

	/**
	 * ��yyyyMMdd��ʽ���ַ�����������
	 * 
	 * @param date
	 * @return
	 */
	public static Date stringToDate(String string) throws ParseException {

		if (string == null)
			return null;

		if (string.trim().length() == 0)
			return null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				DATE_NUMBER_PATTERN);

		return simpleDateFormat.parse(string);
	}

	/**
	 * /** �����ڷ���yyyyMMdd��ʽ���ַ���
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToNumber(Date date) {

		if (date == null)
			return null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				DATE_NUMBER_PATTERN);

		return simpleDateFormat.format(date);
	}

	/**
	 * ��ȡ��������֮�������
	 * 
	 * @param s_date1
	 *            ��ʼ����
	 * @param s_date2
	 *            ��������
	 * @return
	 */
	public static int getDayBetween(String s_date1, String s_date2) {
		int year1, year2, month1, month2, day1, day2;
		year1 = Integer.parseInt(s_date1.substring(0, 4));
		month1 = Integer.parseInt(s_date1.substring(4, 6)) - 1;
		day1 = Integer.parseInt(s_date1.substring(6, 8));
		year2 = Integer.parseInt(s_date2.substring(0, 4));
		month2 = Integer.parseInt(s_date2.substring(4, 6)) - 1;
		day2 = Integer.parseInt(s_date2.substring(6, 8));

		java.util.Calendar calender = java.util.Calendar.getInstance();

		calender.set(year1, month1, day1);
		long t1 = calender.getTimeInMillis();

		calender.set(year2, month2, day2);
		long t2 = calender.getTimeInMillis();

		long ll = 86400000l;

		return ((int) ((t1 - t2) / ll));

	}
	
	/**
	 * ��ȡ����ʱ��֮��ķ�����
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws ParseException
	 */
	public static long getMinuteBetween(String beginTime, String endTime)
			throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat(
				DATETIME_NUMBER_PATTERN);

		Date beginDate = formatter.parse(beginTime);
		Date endDate = formatter.parse(endTime);

		// �ֱ�õ�����ʱ��ĺ�����
		long begin = beginDate.getTime();
		long end = endDate.getTime();

		long ei = end - begin;

		// ���ݺ�����������������
		return ei / (1000 * 60);
	}

	/*************************************************************
	 * function: add bar to a card no. , such as if the card no. is
	 * "9566123456789000" , the return string is "9566-1234-5678-9000" input :
	 * card no. as "9566123456789000" output : card no. as "9566-1234-5678-9000"
	 * note : scottie xu
	 *********************************************************/
	public static String addBarToCardNo(String cardNo) {
		String retStr = "";

		if (cardNo == null || cardNo.length() < 12) {
			return cardNo;
		}

		retStr = cardNo.substring(0, 4) + "-" + cardNo.substring(4, 8) + "-"
				+ cardNo.substring(8, 12) + "-" + cardNo.substring(12);

		return retStr;

	}

	/*************************************************************
	 * function: add bar to a date string , such as if the date string is
	 * "20060912" , the return string is "2006-09-12" input : date string as
	 * "20060912" output : date string as "2006-09-12" note : scottie xu
	 *********************************************************/
	public static String addBarToDateString(String dateStr) {
		String retDateStr = "";

		if (dateStr == null || dateStr.trim().length() != 8) {
			return dateStr;
		}

		retDateStr = dateStr.substring(0, 4) + "-" + dateStr.substring(4, 6)
				+ "-" + dateStr.substring(6);

		return retDateStr;

	}

	/*************************************************************
	 * function: add Chinese to a date string , such as if the date string is
	 * "20060912" , the return string is "2006��09��12��" input : date string as
	 * "20060912" output : date string as "2006��09��12��" note : man wu
	 *********************************************************/
	public static String addChineseToDateString(String dateStr) {
		String retDateStr = "";

		if (dateStr == null || dateStr.length() != 8) {
			return dateStr;
		}

		retDateStr = dateStr.substring(0, 4) + "��" + dateStr.substring(4, 6)
				+ "��" + dateStr.substring(6) + "��";

		return retDateStr;

	}

	/*************************************************************
	 * function: add bar to a date string , such as if the date string is
	 * "090807" , the return string is "09ʱ08��07��" input : date string as
	 * "090807" output : date string as "09ʱ08��07��" note : scottie xu
	 *********************************************************/
	public static String addChineseToTimeString(String timeStr) {
		String retDateStr = "";

		if (timeStr == null || timeStr.length() != 6) {
			return timeStr;
		}

		retDateStr = timeStr.substring(0, 2) + "ʱ" + timeStr.substring(2, 4)
				+ "��" + timeStr.substring(4) + "��";

		return retDateStr;

	}

	/*************************************************************
	 * function: add bar to a date string , such as if the date string is
	 * "090807" , the return string is "09:08:07" input : date string as
	 * "090807" output : date string as "09:08:07" note : scottie xu
	 *********************************************************/
	public static String addColonToTimeString(String timeStr) {
		String retDateStr = "";

		if (timeStr == null || timeStr.length() != 6) {
			return timeStr;
		}

		retDateStr = timeStr.substring(0, 2) + ":" + timeStr.substring(2, 4)
				+ ":" + timeStr.substring(4);

		return retDateStr;

	}

	/*************************************************************
	 * - function: add bar to a date string , such as if the date string is "0908", the return string is "09:08"
	 * - input : date string as "0908" 
	 * - output : date string as "09:08" 
	 * - note : given cao
	 *********************************************************/
	public static String addColonToHourMinuteString(String timeStr) {
		String retDateStr = "";

		if (timeStr == null || timeStr.length() != 4) {
			return timeStr;
		}

		retDateStr = timeStr.substring(0, 2) + ":" + timeStr.substring(2, 4);

		return retDateStr;

	}

	/*************************************************************
	 * - function: add bar to a date string , such as if the date string is "20060912090807" , the return string is "2006-09-12 09:08:07" 
	 * - input : date string as "20060912090807" 
	 * - output : date string as "2006-09-12 09:08:07" 
	 * - note : scottie xu
	 *********************************************************/
	public static String addBarAndColonToDateString(String dateStr) {
		String retDateStr = "";

		if (dateStr == null || dateStr.length() != 14) {
			return dateStr;
		}

		retDateStr = dateStr.substring(0, 4) + "-" + dateStr.substring(4, 6)
				+ "-" + dateStr.substring(6, 8) + " "
				+ dateStr.substring(8, 10) + ":" + dateStr.substring(10, 12)
				+ ":" + dateStr.substring(12);

		return retDateStr;

	}

	/*************************************************************
	 * - function: remove the bar from a date string , such as if the date string is "2006-09-12" , the return string is "20060912" . 
	 * - input : date string as "20060912" 
	 * - output : date string as "2006-09-12" 
	 * - note : scottie xu
	 *********************************************************/
	public static String removeBarFromDateString(String dateStr) {
		String retDateStr = "";

		if (dateStr == null || dateStr.length() != 10) {
			return dateStr;
		}

		retDateStr = dateStr.substring(0, 4) + dateStr.substring(5, 7)
				+ dateStr.substring(8);

		return retDateStr;

	}

	/*************************************************************
	 * function: remove the bar from a date string , such as if the date string
	 * is "09:08:07" , the return string is "090807" . input : date string as
	 * "09:08:07" output : date string as "090807" note : scottie xu
	 *********************************************************/
	public static String removeColonFromTimeString(String timeStr) {
		String retDateStr = "";

		if (timeStr == null || timeStr.length() != 8) {
			return timeStr;
		}

		retDateStr = timeStr.substring(0, 2) + timeStr.substring(3, 5)
				+ timeStr.substring(6);

		return retDateStr;

	}

	/*************************************************************
	 * function: remove the bar from a date string , such as if the date string
	 * is "09:08" , the return string is "0908" . input : date string as "09:08"
	 * output : date string as "0908" note : scottie xu
	 *********************************************************/
	public static String removeColonFormHourMinuteString(String timeStr) {
		String retDateStr = "";

		if (timeStr == null || timeStr.length() != 5) {
			return timeStr;
		}

		retDateStr = timeStr.substring(0, 2) + timeStr.substring(3, 5);

		return retDateStr;

	}

	public static String genRandom(int len) {
		String result = "";
		Random ran = new Random();

		String sValue = String.valueOf(Math.abs(ran.nextLong()));
		if (sValue.length() >= len)
			result = sValue.substring(0, len);
		else
			result = rightPad(sValue, len, '0');

		return (result);
	}

	/*****************************
	 * ȡ��ĳ�µ�һ������
	 * 
	 * Format :YYYY-MM-DD
	 * 
	 * @return Format Date lei.wang
	 *****************************/
	public static String getDateFormat4() {

		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int mon = now.get(Calendar.MONTH);
		if ((mon + 1) < 10) {
			return year + "-0" + (mon + 1) + "-" + "01";
		} else {
			return year + "-" + (mon + 1) + "-" + "01";
		}

	}

	/**
	 * 
	 * �õ���ʼ�к�
	 * 
	 * @author given�ܾ���
	 * @time 2008-12-29
	 * @param perPage
	 * @param startPage
	 * @return
	 */
	public static int getBeginRow(int perPage, int startPage) {
		return perPage * (startPage - 1) + 1;
	}

	/**
	 * 
	 * �õ������к�
	 * 
	 * @author given�ܾ���
	 * @time 2008-12-29
	 * @param perPage
	 * @param startPage
	 * @param count
	 * @return
	 */
	public static int getEndRow(int perPage, int startPage, int count) {
		return perPage * startPage > count ? count : perPage * startPage;
	}

	/**
	 * 
	 * ���Ҹ�ʽ������1234567.00 ת����Ϊ1,234,567.00 ���������ʽ�������֣���ԭ������
	 * 
	 * @author kenny���ĺ�
	 * @time 2009-09-04
	 * @param curry
	 * @return
	 */
	public static String getCurrencyFormt(String curry) {
		if (curry == null || "".equals(curry) || "-".equals(curry)) {
			return curry;
		}
		curry = curry.replaceAll(",", "");
		DecimalFormat dmf = new DecimalFormat("###,##0.00");

		return dmf.format(new Double(curry));

	}

	public static String getNumberFormt(String curry) {
		if (curry == null || "".equals(curry)) {
			return curry;
		}
		String s = curry.replaceAll(",", "");
		return s;

	}

	/**
	 * 
	 * ���Ҹ�ʽ����double �� 1.2815421939999998E7 ת����Ϊ1,234,567.00
	 * 
	 * @author pierre
	 * @time 2009-09-16
	 * @param curry
	 * @return
	 */
	public static String getCurrencyFormt(double curry) {

		DecimalFormat dmf = new DecimalFormat("###,##0.00");

		return dmf.format(curry);

	}

	/**
	 * 
	 * ���Ҹ�ʽ����Double �� 1.2815421939999998E7 ת����Ϊ1,234,567.00
	 * 
	 * @author pierre
	 * @time 2009-09-16
	 * @param curry
	 * @return
	 */
	public static String getCurrencyFormt(Double curry) {

		if (curry == null) {
			return "";
		}
		DecimalFormat dmf = new DecimalFormat("###,##0.00");

		return dmf.format(curry);

	}

	/**
	 * 
	 * Email��ʽ������123@123.com ���������ʽ����email��ʽ������false
	 * 
	 * @author kenny���ĺ�
	 * @time 2009-09-15
	 * @param email
	 * @return
	 */
	public static boolean checkEmailFormat(String email) {
		if (email == null || "".equals(email)) {
			return false;
		}
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern pattern = Pattern.compile(regex);
		if (pattern.matcher(email).matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��ȡ��ǰϵͳ���ڣ� ����Ϊ���ڸ�ʽ
	 * 
	 * @author kenny���ĺ�
	 * @time 2009-09-15
	 * @param DateFormat
	 * @return
	 */
	public static String getNowTime(String dateformat) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);
		String date = dateFormat.format(now);
		return date;
	}

	/**
	 * ����ʱ��㣨1970 �� 1 �� 1 �գ�00:00:00 GMT��֮��ĺ�������ʾlongֵ��Ϊ��������������ʽ������
	 * 
	 * @param modifiedtime
	 * @return
	 */
	public static String getLastModifiedTime(long modifiedtime) {
		Date now = new Date(modifiedtime);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String date = dateFormat.format(now);
		return date;
	}

	/**
	 * ��ȡ2�������������� ����Ϊ���ڸ�ʽyyyy-MM-dd
	 * 
	 * @author kenny���ĺ�
	 * @time 2009-09-15
	 * @param DateFormat
	 * @return
	 */
	public static long getDays(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// ת��Ϊ��׼ʱ��
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.util.Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	public static String getX(int i) {
		if (i < 10)
			return "0" + i;
		else
			return i + "";

	}

	public static String getHHMMSSsss() {

		Calendar calendar = Calendar.getInstance();
		StringBuffer gen = new StringBuffer();
		SimpleDateFormat myFormatter = new SimpleDateFormat("HHmmss");
		gen.append(myFormatter.format(new Date()));
		gen.append(getX(calendar.get(Calendar.MILLISECOND)));

		return gen.toString();

	}

	public static String getRandomName() {
		return getHHMMSSsss() + getLenRandom1(6);
	}

	public static String getLenRandom1(int len) {
		char s[] = new char[len];
		for (int i = len - 1; i >= 0; i--) {
			int x = (int) (Math.random() * 10);
			s[i] = DigitalMap[x];
		}
		return new String(s);
	}

	public static String getLenRandom(int len) {
		char s[] = new char[len];
		for (int i = len - 1; i >= 0; i--) {
			int x = (int) (Math.random() * 36);
			s[i] = DigitalMap[x];
		}
		return new String(s);
	}

	public static String getLastDayOfMonth() {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);// ��һ����
		cal.set(Calendar.DATE, 1);// �գ���Ϊһ��
		cal.add(Calendar.DATE, -1);// ��һ���¼�һΪ�������һ��

		return myFormatter.format(cal.getTime());
	}

	/**
	 * 
	 * �����ָ�ʽת���������֣���String �� 1.2815421939999998E7 ת����Ϊ1234567.00
	 * 
	 * @author pierre
	 * @time 2009-09-16
	 * @param curry
	 * @return
	 */
	public static String getNumberString(String curry) {

		if (curry == null) {
			return "";
		}
		DecimalFormat dmf = new DecimalFormat("#####0.00");

		return dmf.format(new Double(getCurrencyFormt(new Double(curry))
				.replaceAll(",", "")));

	}

	/**
	 * 
	 * ������ǰ������λ������ʾ������λ��*�Ŵ���
	 * 
	 * @author eric.xu
	 * @time 2011-08-01
	 * @param cardNo
	 * @return
	 */
	public static String toHiddenCardNo(String cardNo) {
		String card = cardNo.trim();
		if (card.length() <= 10) {
			return card;
		}
		String cardNoBegin = card.substring(0, 6);
		String cardNoEnd = card.substring(card.length() - 4);
		StringBuffer cardNoDtl = new StringBuffer();
		cardNoDtl.append(cardNoBegin);

		for (int i = 6; i < card.length() - 4; i++) {
			cardNoDtl.append("*");
		}
		cardNoDtl.append(cardNoEnd);
		return cardNoDtl.toString();
	}

	/*************************************************************
	 * function: add bar to a date string , such as if the date string is
	 * "20060912090807" , the return string is "2006/09/12 09:08:07" input :
	 * date string as "20060912090807" output : date string as
	 * "2006/09/12 09:08:07" note : dayo wang
	 *********************************************************/
	public static String addSlashAndColonToDateString(String dateStr) {
		String retDateStr = "";

		if (dateStr == null || dateStr.length() != 14) {
			return dateStr;
		}

		retDateStr = dateStr.substring(0, 4) + "/" + dateStr.substring(4, 6)
				+ "/" + dateStr.substring(6, 8) + " "
				+ dateStr.substring(8, 10) + ":" + dateStr.substring(10, 12)
				+ ":" + dateStr.substring(12);

		return retDateStr;

	}

	/**
	 * 
	 * ��������ʾǰ4λ���6λ��*�Ŵ���
	 * 
	 * @author dayo.wang
	 * @time 2011-08-15
	 * @param cardNo
	 * @return
	 */
	public static String toHiddenSixCardNo(String cardNo) {
		String card = cardNo.trim();
		if (card.length() <= 12) {
			return card;
		}
		String cardNoBegin = card.substring(0, 6);
		String cardNoEnd = card.substring(12);
		StringBuffer cardNoDtl = new StringBuffer();
		cardNoDtl.append(cardNoBegin);
		for (int i = 0; i < 6; i++) {
			cardNoDtl.append("*");
		}
		cardNoDtl.append(cardNoEnd);
		return cardNoDtl.toString();
	}

	/**
	 * 
	 * ��������ʾǰ4λ�ͺ��3λ���м���*�Ŵ��棬�磺5187********113
	 * 
	 * @author dayo.wang
	 * @time 2011-08-15
	 * @param cardNo
	 * @return
	 */
	public static String toHiddenSixCardNo1(String cardNo) {

		String card = cardNo.trim();
		if (card.length() <= 12) {
			return cardNo;
		}
		int card_1 = cardNo.length();
		String cardNoBegin = card.substring(0, 4);
		String cardNoEnd = card.substring(card_1 - 3, card_1);
		StringBuffer cardNoDtl = new StringBuffer();
		cardNoDtl.append(cardNoBegin);
		for (int i = 0; i < 8; i++) {
			cardNoDtl.append("*");
		}
		cardNoDtl.append(cardNoEnd);
		return cardNoDtl.toString();
	}

	/**
	 * 
	 * @author eric.xu
	 * @time 2011-08-11
	 * @param start
	 *            - ��ʼ�� �� end - ������
	 * @return
	 */
	public static int getRandom(int start, int end) {

		if (start > end || start < 0 || end < 0) {

			return -1;

		}

		return (int) (Math.random() * (end - start + 1)) + start;

	}

	public static String amtFormat(Double obj) {
		// ��ʽ������ʽ
		DecimalFormat df = new DecimalFormat("0.00");

		return df.format(obj);
	}

	public static String amtFormat(BigDecimal obj) {
		// ��ʽ������ʽ
		DecimalFormat df = new DecimalFormat("0.00");

		return df.format(obj);
	}

	public static String amtSub(String v1, String v2) {

		BigDecimal b1 = new BigDecimal(v1);

		BigDecimal b2 = new BigDecimal(v2);

		return b1.subtract(b2).toString();

	}

	public static String amtAdd(String v1, String v2) {

		BigDecimal b1 = new BigDecimal(v1);

		BigDecimal b2 = new BigDecimal(v2);

		return b1.add(b2).toString();

	}

	// �жϼ�����ĳ��������
	public static String addDays(String nowDate, int days)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse(nowDate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(c.getTime());
	}

	/**
	 * ���ǩԼ�����ѹ�ʽ
	 * <P>
	 * AMT*0.009
	 * </P>
	 * <P>
	 * MTM(0,50,AMT*0.009)
	 * </P>
	 * <P>
	 * MIN(50,AMT*0.009)
	 * </P>
	 * 
	 * @param conRate
	 * @return ����������ʽ��0.009,50 �� 0.009,0
	 */
	public static String splitCalcMode(String conRate) {
		String result = " ";

		conRate = conRate.trim();

		String regex = "\\d+(\\.\\d+)?";
		List<String> calcList = new ArrayList<String>();

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(conRate);

		for (int i = 0; i < 3; i++) {
			if (m.find()) {
				calcList.add(m.group());
			}
		}
		if (calcList.size() == 1) {
			result = calcList.get(0) + "," + "0";
		} else if (calcList.size() == 3) {
			result = calcList.get(2) + "," + calcList.get(1);
		} else if (calcList.size() == 2) {
			result = calcList.get(1) + "," + calcList.get(0);
		}

		return result;
	}


	/**
	 * Luhn�㷨 ���ݿ��Ż�ȡУ��λ
	 * 
	 * @param cardNumber
	 * @return
	 */
	public static int getCheckNumber(String cardNumber) {
		int totalNumber = 0;
		int lastNumber = 0;
		for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
			int tmpNumber = calculate(Integer.parseInt(String
					.valueOf(cardNumber.charAt(i))) * 2);
			if (i == 0) {
				totalNumber += tmpNumber;
			} else {
				totalNumber += tmpNumber
						+ Integer.parseInt(String.valueOf(cardNumber
								.charAt(i - 1)));
			}

		}
		if (totalNumber >= 0 && totalNumber < 9) {
			return (10 - totalNumber);
		} else {
			String str = String.valueOf(totalNumber);
			if (Integer.parseInt(String.valueOf(str.charAt(str.length() - 1))) == 0) {
				return 0;
			} else {
				return (10 - Integer.parseInt(String.valueOf(str.charAt(str
						.length() - 1))));
			}
		}

	}

	/**
	 * �������ָ�λ��
	 * 
	 * @param number
	 * @return
	 */
	public static int calculate(int number) {
		String str = String.valueOf(number);
		int total = 0;
		for (int i = 0; i < str.length(); i++) {
			total += Integer.valueOf(Integer.parseInt(String.valueOf(str
					.charAt(i))));
		}
		return total;
	}

	
	
	/**
	 * ���ص�ǰ���ڵĴ���1��
	 * 
	 * @return
	 */
	public static String getDataNextMonth() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
	}
	
	/**
	 * ����ָ�����ڵĴ���1��
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getDataNextMonth(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
	}
	
	public static String getDataCurrent() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	public static String getModifyFeeRatio(String eventValue) {
		String[] eventV = eventValue.split("[|]");
		if (eventV.length < 3) {
			return null;
		} else
			return eventV[1];
	}

	public static String getModifyDate(String eventValue) {
		String[] eventV = eventValue.split("[|]");
		if (eventV.length < 3) {
			return null;
		} else
			return eventV[2];
	}
	
	public static String getDataYYYYMMDD(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat spFmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dates = spFmt.format(date);
		return dates;
	}

	/**
	 * ��ʽת��
	 * @param dateTime - Input ��20160324131646
	 * @return Output ��2016-03-24 13:16:46
	 */
	public static String getDateAndTime(String dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = null;
		try {
			date = sdf1.parse(dateTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dt = sdf.format(date);
		return dt;
	}

	/**
	 * ��ʽת��
	 * 
	 * @param dateTime
	 *            - �����ַ���
	 * @param from
	 *            - ��������ڸ�ʽ���ο� gms.CONSTANTS
	 * @param to
	 *            - ��������ڸ�ʽ���ο� gms.CONSTANTS
	 * @return ���ָ�����ڸ�ʽ���ַ���
	 */
	public static String convertDttm(String dateTime, String from, String to) {
		SimpleDateFormat fromSDF = new SimpleDateFormat(from);
		SimpleDateFormat toSDF = new SimpleDateFormat(to);
		Date date = null;
		try {
			date = fromSDF.parse(dateTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toSDF.format(date);
	}
	
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null)
			return true;
		if ("".equals(str.trim()))
			return true;
		return false;
	}

	/**
	 * �ж������Ƿ��ѹ���/��������
	 * 
	 * e.g. С�ڵ�ǰ���ڣ���ʾΪ���ѹ��� С�ڵ��ڵ�ǰ����+90�죬��ʾΪ����������
	 * 
	 * @param dateStr
	 *            - ���ж������ڣ���ʽ��yyyyMMdd.
	 * @return String
	 */
	public static String getExpiredTips(String dateStr) throws ParseException {
		int flag = getExpiredFlag(dateStr);
		if (flag == 2) {
			return "�ѹ���";
		} else if (flag == 1) {
			return "��������";
		}
		return " ";
	}
	
	/**
	 * �ж������Ƿ��ѹ���/��������
	 * 
	 * e.g. С�ڵ�ǰ���ڣ����أ�2-�ѹ��� С�ڵ��ڵ�ǰ����+90�죬���أ�1-��������
	 * 
	 * @param dateStr
	 *            - ���ж������ڣ���ʽ��yyyyMMdd.
	 * @return
	 */
	public static int getExpiredFlag(String dateStr)
			throws ParseException {
		int flag = 0;
		String currDate = CPublic.getDate();
		String dlineDate = CPublic.getEndDateByDays(currDate, 90);
		if (dateStr == null || "".equals(dateStr.trim())) {
			return flag;
		}

		if (Integer.parseInt(dateStr) < Integer.parseInt(currDate)) {
			flag = 2; // �ѹ���
		} else if (Integer.parseInt(dateStr) <= Integer.parseInt(dlineDate)) {
			flag = 1; // ��������
		}
		return flag;
	}
	
	
	
	/**
	 * �Ƚ���������(yyyyMMdd)�Ĵ�С
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int dateCompare(String str1, String str2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			Date d1 = df.parse(str1);
			Date d2 = df.parse(str2);
			if (d1.getTime() < d2.getTime()) {
				return 1;
			} else if (d1.getTime() > d2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * �Ƚ���������(yyyyMMddHHmmss)�Ĵ�С
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int dateCompare2(String str1, String str2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			Date d1 = df.parse(str1);
			Date d2 = df.parse(str2);
			if (d1.getTime() < d2.getTime()) {
				return 1;
			} else if (d1.getTime() > d2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * ���غ��ж�����
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isGateid(String str) {
		if (str != null && str.indexOf('U') == 0 && str.trim().length() == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * �ж��ַ����Ƿ�Ϊ��ֵ��������Null��Empty���ո�
	 * 
	 * @param input
	 *            - �ַ���
	 * @return
	 */
	public static boolean isNull(String input) {
		if (input == null || input.trim().length() == 0)
			return true;

		return false;
	}

	/**
	 * ����ָ���ַ�����ֵ�����ָ���ַ���ΪNull��ո��򷵻�Ĭ��ֵ��
	 * 
	 * @param value
	 *            - ָ���ַ���
	 * @param defValue
	 *            - Ĭ��ֵ
	 * @return ���� trim(value)
	 */
	public static String getStringByDefValue(String value, String defValue) {
		if (value == null || "".equals(value.trim())) {
			return defValue;
		}
		return value.trim();
	}
	
	/**
	 * ����У��λ������pos�����̺ţ�
	 */
	public static String getLastBit(String seqno) {
		StringBuffer sbCustId = new StringBuffer(seqno);

		// �õ���һλУ��λ
		int len = sbCustId.length(), a = 0, b = 0;
		for (int i = 0; i < len; i++) {
			// ż��λ
			if ((i % 2) != 0) {
				b = 2 * Character.digit(sbCustId.charAt(i), 10);
				// ����10ʱ����Ҫ����λ���ֺ�ʮλ�������
				if (b >= 10) {
					b = b / 10 + (b - b / 10 * 10);
				}
			} else {
				b = Character.digit(sbCustId.charAt(i), 10);
			}
			a += b;
		}
		// �õ�У��λ
		if ((a % 10) == 0) {
			b = 0;
		} else {
			b = (a / 10 + 1) * 10 - a;
		}
		return String.valueOf(b);
	}
	
	/**
	 * �ж�ָ�����������Ƿ�Ϊ�����۸��·�������
	 * 
	 * @return
	 */
	public static Boolean isFeeCalcChanged(String type) {
		if (CPublic.isNull(type)) {
			return Boolean.FALSE;
		}
		if ("F".equals(type) || "G".equals(type) || "H".equals(type) || "I".equals(type)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	/**
	 * ����ָ���ָ��������ַ���ת��Ϊ�ַ�������
	 * 
	 * @param input - �ַ���
	 * @param splitChar - �ָ���
	 * @return
	 */
	public static List<String> convertStringToList(String input, String splitChar) {
		List<String> list = new ArrayList<String>();
		String[] arrays = input.split(splitChar);
		for (int i = 0; i < arrays.length; i++) {
			list.add(arrays[i]);
		}
		return list;
	}
	
	/**
	 * ת���ն˳���ʾ  
	 *     true-��
	 *     false-��
	 * @param str
	 * @return
	 */
	public static String changeDisplayIsInTerm(boolean str) {
		//�ǿգ����Բ����ն˳�
		if (str == true)
			return "��";
		//�ǿգ��������ն˳�
		else 
			return "��";
	}
	
	/**
	 * �Ƿ�Ϊ�ػ��̻�
	 * 
	 * @param flag
	 * @return
	 */
	public static boolean isSpMerch(String flag) {
		if (flag != null && "1".equals(flag.trim())) {
			return true;
		} else {
			return false;
		}
	}
	
	

}
