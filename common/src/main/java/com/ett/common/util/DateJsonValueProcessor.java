package com.ett.common.util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.log4j.Logger;

/**
 * @auhtor Lingo
 * @since 2007-08-02
 */
public class DateJsonValueProcessor implements JsonValueProcessor {
    /** * logger. */
  
    
	 private static Logger logger = Logger.getLogger(DateJsonValueProcessor.class);

    /** * 榛樿鐨勬棩鏈熻浆鎹㈡牸寮�. */
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /** * 鏃ユ湡杞崲鍣�. */
    private DateFormat dateFormat;

    /**
     * 鏋勯�犳柟娉�.
     *
     * @param datePattern 鏃ユ湡鏍煎紡
     */
    public DateJsonValueProcessor(String datePattern) {
        try {
            dateFormat = new SimpleDateFormat(datePattern);
        } catch (Exception ex) {
            logger.info(ex);
            dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        }
    }

    /**
     * 杞崲鏁扮粍锛�.
     *
     * @param value Object
     * @param jsonConfig 閰嶇疆
     * @return Object
     */
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    /**
     * 杞崲瀵硅薄.
     *
     * @param key String
     * @param value Object
     * @param jsonConfig 閰嶇疆
     * @return Object
     */
    public Object processObjectValue(String key, Object value,
        JsonConfig jsonConfig) {
        return process(value);
    }

    /**
     * 鏍煎紡鍖栨棩鏈�.
     *
     * @param value Object
     * @return Object
     */
    private Object process(Object value) {
        try {
            return dateFormat.format((Date) value);
        } catch (Exception ex) {
            return null;
        }
    }
}
