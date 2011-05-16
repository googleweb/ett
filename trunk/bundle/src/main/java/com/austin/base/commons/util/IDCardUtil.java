/**
 * IDCardUtil.java create by chen at 2008-12-17 ,下午03:53:10
 * lineup by ft.comp
 */
package com.austin.base.commons.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 身份证处理工兄1�7
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public class IDCardUtil {
	protected static  Log log = LogFactory.getLog(IDCardUtil.class);
	
	/**
     * 15位身份证号码转化丄1�7位的身份证�1�7�如果是18位的身份证则直接返回，不作任何变化�1�7�1�7
     * @param idCard,15位的有效身份证号砄1�7
     * @return idCard18 返回18位的有效身份评1�7
     */
    public String IdCard15to18(String idCard){
        idCard = idCard.trim();
        StringBuffer idCard18 = new StringBuffer(idCard);
        //加权因子
        //int[] weight = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        //校验码�1�7�1�7
        char[] checkBit = {'1','0','X','9','8','7','6','5','4','3','2'};
        int sum = 0;
        //15位的身份评1�7
        if(idCard != null && idCard.length()==15){
            idCard18.insert(6, "19");
            for(int index=0;index<idCard18.length();index++){
                char c = idCard18.charAt(index);
                int ai = Integer.parseInt(new Character(c).toString());
                log.debug("IdCard15to18,数："+new Integer(ai));
                //sum = sum+ai*weight[index];
                //加权因子的算泄1�7
                int Wi = ((int)Math.pow(2, idCard18.length()-index))%11;
                sum = sum+ai*Wi;
            }
            int indexOfCheckBit = sum%11; //取模
            idCard18.append(checkBit[indexOfCheckBit]);
        }
        log.debug("18位号码为＄1�7"+idCard18);
        return idCard18.toString();
    }
    
    /** *//**
     * 转化18位身份证佄1�7位身份证。如果输入的昄1�7位的身份证则不做任何转化，直接返回�1�7�1�7
     * @param idCard 18位身份证号码
     * @return idCard15
     */
    public String IdCard18to15(String idCard){
        idCard = idCard.trim();
        StringBuffer idCard15 = new StringBuffer(idCard);
        if(idCard!=null && idCard.length()==18){
            idCard15.delete(17, 18);
            idCard15.delete(6, 8);
        }
        log.debug("15位身份证号码为："+idCard15);
        return idCard15.toString();
        
    }
    
    /**
     * 校验是否是一个有效的身份证�1�7�如果是18的身份证，则校验18位的身份证�1�7�1�7位的身份证不校验，也无法校验
     * @param idCart
     * @return
     */
    public boolean checkIDCard(String idCard){
        boolean isIDCard = false;
        Pattern pattern = Pattern.compile("\\d{15}|\\d{17}[x,X,0-9]");
        Matcher matcher = pattern.matcher(idCard);
        if(matcher.matches()){//可能是一个身份证
            isIDCard = true;
            if(idCard.length()==18){//如果昄1�7的身份证，则校验18位的身份证�1�7�1�7位的身份证暂不校骄1�7
                String IdCard15 = IdCard18to15(idCard);
                String IdCard18 = IdCard15to18(IdCard15);
                if(!idCard.equals(IdCard18)){
                    isIDCard = false;
                }
            }else if(idCard.length()==15){
                isIDCard = true;
            }else{
                isIDCard = false;
            }
        }
        log.debug("验证身份证结果："+new Boolean(isIDCard));
        return isIDCard;
    }

}
