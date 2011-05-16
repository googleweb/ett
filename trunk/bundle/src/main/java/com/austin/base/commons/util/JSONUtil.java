package com.austin.base.commons.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.JSONUtils;

import org.apache.log4j.Logger;

public class JSONUtil {
	/** * logger. */
	protected static Logger logger = Logger.getLogger(JSONUtil.class);
//    private static Log logger = LogFactory.getLog(JSONUtils.class);
	
	
    public static final String[] DEFAULT_EXCLUDES = new String[]{
    	"this",
    	"deleted",
    	"isDeleted",
    	"callback",
    	"createIp"
    };
    public static final String DEFAULT_DATEPATTERN = "yyyy-mm-dd HH:mm:ss";

    /** * 工具类需要的保护构�1�7�方泄1�7. */
    protected JSONUtil() {
    }
    /**
     * 配置json-lib霄1�7要的excludes和datePattern.
     *
     * @param excludes 不需要转换的属�1�7�数组1�7
     * @param datePattern 日期转换模式
     * @return JsonConfig 根据excludes和dataPattern生成的jsonConfig，用于write
     */
    public static JsonConfig configJson(String[] excludes, String datePattern) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(excludes);
        jsonConfig.setIgnoreDefaultExcludes(false);
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        jsonConfig.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor(datePattern));      //date2json  
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{//json2date
        		DEFAULT_DATEPATTERN,
                "yyyy-MM-dd HH:mm",
                "yyyy-MM-dd"
        })); 
        return jsonConfig;
    }
    /**
     * write.
     *
     * @param bean obj
     * @param writer 输出浄1�7
     * @param excludes 不转换的属�1�7�数组1�7
     * @param datePattern date到string转换的模弄1�7
     * @throws Exception 写入数据可能出现异常
     */
    public static JSON bean2Json(Object bean,String[] excludes, String datePattern) throws Exception {
        JsonConfig jsonConfig = configJson(excludes, datePattern);
        JSON json = JSONSerializer.toJSON(bean, jsonConfig);
        return json;
    }
    /**
     * data={"id":"1"}用json的数据创建指定的pojo.
     *
     * @param <T> Object
     * @param data json字符丄1�7
     * @param clazz 霄1�7要转换成bean的具体类垄1�7
     * @param excludes 不需要转换的属�1�7�数组1�7
     * @param datePattern 日期转换模式
     * @return T
     * @throws Exception java.lang.InstantiationException,
     *                   java.beans.IntrospectionException,
     *                   java.lang.IllegalAccessException
     */
    public static <T extends Object> T json2Bean(String data,
        Class<T> clazz, String[] excludes, String datePattern)
        throws Exception {       
        T entity = clazz.newInstance();
        return json2Bean(data, entity, excludes, datePattern);
    }

    /**
     * data={"id":"1"}用json里的数据，填充指定的pojo.
     *
     * @param <T> Object
     * @param data json字符丄1�7
     * @param entity 霄1�7要填充数据的bean
     * @param excludes 不需要转换的属�1�7�数组1�7
     * @param datePattern 日期转换模式
     * @return T
     * @throws Exception java.lang.InstantiationException,
     *                   java.beans.IntrospectionException,
     *                   java.lang.IllegalAccessException
     */
    public static <T extends Object> T json2Bean(String data, T entity,
        String[] excludes, String datePattern) throws Exception {      
        JSONObject jsonObject = JSONObject.fromObject(data);
        return json2Bean(jsonObject, entity, excludes, datePattern);
    }

    /**
     * 根据Class生成entity，再把JSONObject中的数据填充进去.
     *
     * @param <T> Object
     * @param jsonObject json对象
     * @param clazz 霄1�7要转换成bean的具体类垄1�7
     * @param excludes 不需要转换的属�1�7�数组1�7
     * @param datePattern 日期转换模式
     * @return T
     * @throws Exception java.lang.InstantiationException,
     *                   java.beans.IntrospectionException,
     *                   java.lang.IllegalAccessException
     */
    public static <T extends Object> T json2Bean(JSONObject jsonObject,
        Class<T> clazz, String[] excludes, String datePattern)
        throws Exception {
        // JsonUtils.configJson(excludes, datePattern);
        T entity = clazz.newInstance();

        return json2Bean(jsonObject, entity, excludes, datePattern);
    }

    /**
     * 把JSONObject中的数据填充到entity丄1�7.
     *
     * @param <T> Object
     * @param jsonObject json对象
     * @param entity 霄1�7要填充数据的node
     * @param excludes 不需要转换的属�1�7�数组1�7
     * @param datePattern 日期转换模式
     * @return T
     * @throws Exception java.lang.InstantiationException,
     *                   java.beans.IntrospectionException,
     *                   java.lang.IllegalAccessException
     */
    public static <T extends Object> T json2Bean(JSONObject jsonObject,
        T entity, String[] excludes, String datePattern)
        throws Exception {
        // JsonUtils.configJson(excludes, datePattern);
        Set<String> excludeSet = new HashSet<String>();

        for (String exclude : excludes) {
            excludeSet.add(exclude);
        }

        for (Object object : jsonObject.entrySet()) {
            Map.Entry entry = (Map.Entry) object;
            String propertyName = entry.getKey().toString();

            if (excludeSet.contains(propertyName)) {
                continue;
            }

            String propertyValue = entry.getValue().toString();

            try {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName,entity.getClass());
                Class propertyType = propertyDescriptor.getPropertyType();
                Method writeMethod = propertyDescriptor.getWriteMethod();
                if (propertyType == String.class) {
                    writeMethod.invoke(entity, propertyValue);
                } else if ((propertyType == Byte.class)
                        || (propertyType == byte.class)) {
                    writeMethod.invoke(entity,
                        Byte.parseByte(propertyValue));
                } else if ((propertyType == Short.class)
                        || (propertyType == short.class)) {
                    writeMethod.invoke(entity,
                        Short.parseShort(propertyValue));
                } else if ((propertyType == Integer.class)
                        || (propertyType == int.class)) {
                    writeMethod.invoke(entity,
                        Integer.parseInt(propertyValue));
                } else if ((propertyType == Long.class)
                        || (propertyType == long.class)) {
                    writeMethod.invoke(entity,
                        Long.parseLong(propertyValue));
                } else if ((propertyType == Float.class)
                        || (propertyType == float.class)) {
                    writeMethod.invoke(entity,
                        Float.parseFloat(propertyValue));
                } else if ((propertyType == Double.class)
                        || (propertyType == double.class)) {
                    writeMethod.invoke(entity,
                        Double.parseDouble(propertyValue));
                } else if ((propertyType == Boolean.class)
                        || (propertyType == boolean.class)) {
                    writeMethod.invoke(entity,
                        Boolean.parseBoolean(propertyValue));
                } else if ((propertyType == Character.class)
                        || (propertyType == char.class)) {
                    writeMethod.invoke(entity, propertyValue.charAt(0));
                } else if (propertyType == Date.class) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
                    writeMethod.invoke(entity,
                        dateFormat.parse(propertyValue));
                }
            } catch (IntrospectionException ex) {
                logger.info(ex);
                continue;
            }
        }

        return entity;
    }

    /**
     * data=[{"id":"1"},{"id":2}]用json里的数据，创建pojo队列.
     *
     * @param <T> Object
     * @param data json字符丄1�7
     * @param clazz 霄1�7要转换成node的具体类垄1�7
     * @param excludes 不需要转换的属�1�7�数组1�7
     * @param datePattern 日期转换模式
     * @return List
     * @throws Exception java.lang.InstantiationException,
     *                   java.beans.IntrospectionException,
     *                   java.lang.IllegalAccessException
     */
    public static <T extends Object> List<T> json2List(String data,
        Class<T> clazz, String[] excludes, String datePattern)
        throws Exception {
        JSONArray jsonArray = JSONArray.fromObject(data);

        return json2List(jsonArray, clazz, excludes, datePattern);
    }

    /**
     * data=[{"id":"1"},{"id":2}]用json里的数据，创建pojo队列.
     *
     * @param <T> Object
     * @param jsonArray JSONArray
     * @param clazz 霄1�7要转换成node的具体类垄1�7
     * @param excludes 不需要转换的属�1�7�数组1�7
     * @param datePattern 日期转换模式
     * @return List
     * @throws Exception java.lang.InstantiationException,
     *                   java.beans.IntrospectionException,
     *                   java.lang.IllegalAccessException
     */
    public static <T extends Object> List<T> json2List(
        JSONArray jsonArray, Class<T> clazz, String[] excludes,
        String datePattern) throws Exception {
        List<T> list = new ArrayList<T>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            T node = json2Bean(jsonObject, clazz, excludes, datePattern);
            list.add(node);
        }

        return list;
    }

}
