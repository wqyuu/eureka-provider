
package cn.wqy.eureka.provider.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <strong>Title : Strings </strong>. <br>
 * <strong>Description : 字符串处理工具类.</strong> <br>
 * <strong>Create on : May 20, 2015 5:32:38 PM </strong>. <br>
 * <p>
 * <strong>Copyright (C) AlexHo Co.,Ltd.</strong> <br>
 * </p>
 * @author k2 <br>
 * @version <strong>base-platform-0.1.0</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public class Stringer {
	
	private static Logger log = LoggerFactory.getLogger(Stringer.class);
	
	public static final String SPECIAL_CHAR = "[\\\\`~!@#$%^&*+=|{}',:;\"[url=file://\\[\\].<]\\[\\].<>/[/url]?～！＠＃￥％……＆×（）——＋｜｛｝【】［］‘；：＂。，、．＜＞／？]";
	
	/**
	 * 判断某字符串是否为空，如果为空，则返回一个空串.
	 *  
	 * @author by K2 Aug 21, 2015
	 *
	 * @param string
	 * @return
	 */
	public static String nullToEmpty(String string) {
		return isNullOrEmpty(string) ? "" : string;
	}

	/**
	 * 判断某字符串是否为空，如果为空，则返回一个null空对象.
	 *  
	 * @author by K2 Aug 21, 2015
	 *
	 * @param string
	 * @return
	 */
	public static String emptyToNull(String string) {
		return isNullOrEmpty(string) ? null : string;
	}

	/**
	 * 判断某对象(String,Collection,Map,obj)是否为空.
	 *  
	 * @author by K2 Aug 21, 2015
	 *
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {

		boolean result = true;
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			result = (obj.toString().trim().length() == 0) || obj.toString().trim().equals("null");
		} else if (obj instanceof Collection) {
			result = ((Collection<?>) obj).size() == 0;
		} else if (obj instanceof Map) {
			result = ((Map<?,?>) obj).isEmpty();
		}else {
			result = ((obj == null) || (obj.toString().trim().length() < 1)) ? true : false;
		}
		return result;
	}
	
	

    /**
     * 处理读取InputStream数据流.
     *  
     * @author by K2 Aug 21, 2015
     *
     * @param in
     * @return 输出二进制数据
     * @throws IOException
     */
    public static byte[] readInStream(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
        return out.toByteArray();
    }
    
    /**
     * InputStream数据流转换成字符串.
     *  
     * @author by K2 Aug 21, 2015
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static String toInStream(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }
    
    /**
     * 将字符串转成InputStream流.
     *  
     * @author by K2 Aug 21, 2015
     *
     * @param sInputString
     * @return
     */
    public static InputStream toInStream(String sInputString) {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
        }
        return tInputStringStream;
    }
    
	
	/**
	 * 小数点数据字符串转成保留两位小数的float数据类型.
	 *  
	 * @author by K2 Aug 18, 2015
	 *
	 * @param f
	 * @return
	 */
	public static float toFloat(String string) {
		float f = Float.parseFloat(string);
		BigDecimal b = new BigDecimal(f);
		float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		return f1;
	}
	
	/**
	 * 浮点型数据转换成两位小数点的字符串.
	 *  
	 * @author by K2 Aug 18, 2015
	 *
	 * @param f
	 * @return
	 */
	public static String toFloat(float f) {
		DecimalFormat decimalFormat = new DecimalFormat(".00");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
		String p = decimalFormat.format(f);// format 返回的是字符串
		return p;
	}
	
	
	/**
	 * 双精度数据转换成两位小数点的字符串.
	 *  
	 * @author by K2 Aug 19, 2015
	 *
	 * @param string
	 * @return
	 */
	public static Double toDouble(String string) {
		float f = Float.parseFloat(string);
		BigDecimal b = new BigDecimal(f);
		Double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}
	
	/**
	 * 双精度数据转换成两位小数点的字符串.
	 *  
	 * @author by K2 Aug 19, 2015
	 *
	 * @param string
	 * @return
	 */
	public static String toDouble(Double dd) {
		return String.format("%.2f", dd);
	}
	
	
	/**
	 * 替换特殊字符(全角&半角)..
	 *  
	 * @author by K2 Aug 21, 2015
	 *
	 * @param srcString 原字符串
	 * @param regEx 替换的正则表达式，如果为空则使用默认的正则表达式，变量=SPECIAL_CHAR
	 * @return 
	 * @throws PatternSyntaxException
	 */
	public static String filterString(String srcString, String regEx) throws PatternSyntaxException {
		if(isNullOrEmpty(srcString)){
			return "";
		}
		if(isNullOrEmpty(regEx)){
			regEx = SPECIAL_CHAR;
		}
		return Pattern.compile(regEx).matcher(srcString).replaceAll("").replaceAll("[url=]\\\\[/url]", "").trim();
	}

	/**
	 * 检查指定字符串中是否包含特殊字符
	 *  
	 * @author by K2 Aug 21, 2015
	 * 
	 * 
	 * @param srcString 原字符串
	 * @param regEx 替换的正则表达式，如果为空则使用默认的正则表达式，变量=SPECIAL_CHAR
	 * @return 如果有返回true
	 */
	public static boolean existSpecialChar(String srcString, String regEx) {
		if(isNullOrEmpty(regEx)){
			regEx = SPECIAL_CHAR;
		}
		Matcher m = Pattern.compile(regEx).matcher(srcString);
		return m.find();
	}
	
	
	/**
     * 通过反射的方式遍历对象的属性和属性值，方便调试
     *
     * @param o 要遍历的对象
     * @throws Exception
     */
    public static void reflect(Object o) throws Exception {
        Class<?> cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            log.debug(""+f.getName() + " -> " + f.get(o));
        }
    }
    
    
    
    /**
     * 格式化用时，返回时、分、秒，保留3位小数
     * 
     * @author by K2 Jul 4, 2016
     * @param startMillis 开始的毫秒时间
     * @return 
     */
    public static String fmtElapsedTime(long startMillis){
    	long millis = System.currentTimeMillis() - startMillis;
		BigDecimal second = new BigDecimal(millis+"").divide(new BigDecimal(1000+""),3,RoundingMode.HALF_UP);
		BigDecimal minute = second.divide(new BigDecimal(60+""),3,RoundingMode.HALF_UP);
		BigDecimal hours = minute.divide(new BigDecimal(60+""),3,RoundingMode.HALF_UP);
		String info = hours.intValue() + " hours, " + minute.intValue() + " minutes, " 
				+ second.intValue()+ " seconds, " 	+ (millis%1000) + " millis";
		return info;
    }
    
    
}


