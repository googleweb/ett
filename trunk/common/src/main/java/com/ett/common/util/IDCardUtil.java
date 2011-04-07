/**
 * IDCardUtil.java create by chen at 2008-12-17 ,涓嬪崍03:53:10
 * lineup by ft.comp
 */
package com.ett.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 韬唤璇佸鐞嗗伐鍏�
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public class IDCardUtil {
	protected static  Log log = LogFactory.getLog(IDCardUtil.class);
	
	/**
     * 15浣嶈韩浠借瘉鍙风爜杞寲涓�浣嶇殑韬唤璇併�傚鏋滄槸18浣嶇殑韬唤璇佸垯鐩存帴杩斿洖锛屼笉浣滀换浣曞彉鍖栥��
     * @param idCard,15浣嶇殑鏈夋晥韬唤璇佸彿鐮�
     * @return idCard18 杩斿洖18浣嶇殑鏈夋晥韬唤璇�
     */
    public String IdCard15to18(String idCard){
        idCard = idCard.trim();
        StringBuffer idCard18 = new StringBuffer(idCard);
        //鍔犳潈鍥犲瓙
        //int[] weight = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        //鏍￠獙鐮佸��
        char[] checkBit = {'1','0','X','9','8','7','6','5','4','3','2'};
        int sum = 0;
        //15浣嶇殑韬唤璇�
        if(idCard != null && idCard.length()==15){
            idCard18.insert(6, "19");
            for(int index=0;index<idCard18.length();index++){
                char c = idCard18.charAt(index);
                int ai = Integer.parseInt(new Character(c).toString());
                log.debug("IdCard15to18,鏁帮細"+new Integer(ai));
                //sum = sum+ai*weight[index];
                //鍔犳潈鍥犲瓙鐨勭畻娉�
                int Wi = ((int)Math.pow(2, idCard18.length()-index))%11;
                sum = sum+ai*Wi;
            }
            int indexOfCheckBit = sum%11; //鍙栨ā
            idCard18.append(checkBit[indexOfCheckBit]);
        }
        log.debug("18浣嶅彿鐮佷负锛�"+idCard18);
        return idCard18.toString();
    }
    
    /** *//**
     * 杞寲18浣嶈韩浠借瘉浣�浣嶈韩浠借瘉銆傚鏋滆緭鍏ョ殑鏄�浣嶇殑韬唤璇佸垯涓嶅仛浠讳綍杞寲锛岀洿鎺ヨ繑鍥炪��
     * @param idCard 18浣嶈韩浠借瘉鍙风爜
     * @return idCard15
     */
    public String IdCard18to15(String idCard){
        idCard = idCard.trim();
        StringBuffer idCard15 = new StringBuffer(idCard);
        if(idCard!=null && idCard.length()==18){
            idCard15.delete(17, 18);
            idCard15.delete(6, 8);
        }
        log.debug("15浣嶈韩浠借瘉鍙风爜涓猴細"+idCard15);
        return idCard15.toString();
        
    }
    
    /**
     * 鏍￠獙鏄惁鏄竴涓湁鏁堢殑韬唤璇併�傚鏋滄槸18鐨勮韩浠借瘉锛屽垯鏍￠獙18浣嶇殑韬唤璇併��浣嶇殑韬唤璇佷笉鏍￠獙锛屼篃鏃犳硶鏍￠獙
     * @param idCart
     * @return
     */
    public boolean checkIDCard(String idCard){
        boolean isIDCard = false;
        Pattern pattern = Pattern.compile("\\d{15}|\\d{17}[x,X,0-9]");
        Matcher matcher = pattern.matcher(idCard);
        if(matcher.matches()){//鍙兘鏄竴涓韩浠借瘉
            isIDCard = true;
            if(idCard.length()==18){//濡傛灉鏄�鐨勮韩浠借瘉锛屽垯鏍￠獙18浣嶇殑韬唤璇併��浣嶇殑韬唤璇佹殏涓嶆牎楠�
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
        log.debug("楠岃瘉韬唤璇佺粨鏋滐細"+new Boolean(isIDCard));
        return isIDCard;
    }

}
