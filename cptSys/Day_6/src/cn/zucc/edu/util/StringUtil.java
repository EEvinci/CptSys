package cn.zucc.edu.util;

public class StringUtil {

	/**
	 * judge if Empty
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str)
	{
		if(str == null || "".equals(str.trim()))//trim()函数过滤空格，过滤之后若为空串则可判定该字符串过滤前全为空格
			return true;
		else
			return false;
	}
	
}
