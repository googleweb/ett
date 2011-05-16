package com.austin.base.commons.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author jianfeng008cn
 */

public class JsonUnMarshaller {	
	
	protected Logger log = Logger.getLogger(this.getClass());
	
//	protected static Log log = LogFactory.getLog(JsonUnMarshaller.class);	
	
	public Object parse(String str){
		return parse(str,0);
	}	
	
	public Object parse(String str,int index){
		str = str.trim();
		try{
			char c = str.charAt(index); 
			if(c == '['){
				List list = new ArrayList();
				this.parseArray(str,index,list);
				return list;
			}else if(c == '{'){
				Map map = new HashMap();
				this.parseMap(str,index,map);
				return map;
			}else
				return null;
		}catch(Exception e){
			log.error("Parser.parse(String str,int index)失败＄1�7",e);
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	protected int parseArray(String str,int index,List list) throws Exception{
		char c = str.charAt(index); 
		index ++;  //跳过第一丄1�7'['
		while(true){
			c = str.charAt(index);
			if(c==']'){
				return index+1;
			}else if(c==',' || c==' '){
				index++;
			}else if(c=='n' || c=='N'){
				String tmp = str.substring(index,index+4);
				if(!(tmp.equalsIgnoreCase("null"))){
					String context = str.substring(index-10,index+10);
					throw new Exception("unkown char when parse a object ,the context is:'"+ context +"'");
				}
				index = index + 4;
				list.add(null);
			}else if(c=='"'){
				StringBuffer s = new StringBuffer();
				index = this.parseString(str,index,s);
				list.add(s.toString());
			}else if(c=='\''){
				StringBuffer s = new StringBuffer();
				index = this.parseString(str,index,s);
				list.add(s.toString());
			}else if((c>='0' && c<='9') || c=='-'){
				Object[] objs = new Object[1];
				index = this.parseNumber(str,index,objs);
				list.add(objs[0]);
			}else if(c=='{'){
				Map obj = new HashMap();
				index = this.parseMap(str,index,obj);
				list.add(obj);
			}else if(c=='t' || c=='T' || c=='F' || c=='f'){
				Boolean[] b = new Boolean[1];
				index = this.parseBoolean(str,index,b);
				list.add(b[0]);
			}else if(c=='['){
				List arr = new ArrayList();
				index = this.parseArray(str,index,arr);
				list.add(arr);
			}else{
				int s = index -20;
				if(s<0) 
					s = 0;
				int e = index +20;
				if(e>str.length())
					e = str.length();
				String context = str.substring(s,e);
				throw new Exception("unkown char when parse a object ,the context is:'"+ context +"'");
			}
		}
	}
	

	
	@SuppressWarnings("unchecked")
	protected int parseMap(String str,int index,Map obj) throws Exception{
		StringBuffer pname = new StringBuffer();
		char c = str.charAt(index); 
		index ++; //跳过第一丄1�7'{'
		while(true){
			c = str.charAt(index);
			if(c=='}'){
				return index+1;
			}else if(c==','){
				index ++;
			}else if(c==':'){
				Object pvalue = null;
				index++;
				c = str.charAt(index);
				if((c>='0' && c<='9')||(c=='-')){
					Object[] value = new Object[1];
					index = parseNumber(str,index,value);
					pvalue = value[0];
				}else if(c=='\''){
					StringBuffer s = new StringBuffer();
					index = this.parseString(str,index,s);
					pvalue = s.toString();
				}else if(c=='"'){
					StringBuffer s = new StringBuffer();
					index = this.parseString(str,index,s);
					pvalue = s.toString();
				}else if(c=='{'){
					Map childObj = new HashMap();
					index = this.parseMap(str,index,childObj);
					pvalue = childObj;
				}else if(c=='['){
					List arr = new ArrayList();
					index = this.parseArray(str,index,arr);
					pvalue = arr;
				}else if(c=='t' || c=='T' || c=='F' || c=='f'){
					Boolean[] b = new Boolean[1];
					index = this.parseBoolean(str,index,b);
					pvalue = b[0];
				}else if(c=='N' || c=='n'){
					String tmp = str.substring(index,index+4);
					if(!(tmp.equalsIgnoreCase("null"))){
						String context = str.substring(index-10,index+10);
						throw new Exception("unkown char when parse a object ,the context is:'"+ context +"'");
					}
					index = index + 4;
					pvalue = null;
				}else{
					String context = str.substring(index-10,index+10);
					throw new Exception("unkown char when parse a object ,the context is:'"+ context +"'");
				}
				obj.put(pname.toString(),pvalue);
				pname.delete(0,pname.length());
			}else{
				pname.append(c);
				index ++;
			}
		}
	}
	
	protected int parseNumber(String str,int index,Object[] r){
		StringBuffer tmp = new StringBuffer();
		while(true){
			
			char c = str.charAt(index);
			if(c==',' || c ==']' || c=='}'){
				break;
			}else{
				tmp.append(c);
			}
			index ++;
			if(index==str.length())
				break;
		}
		String numStr = tmp.toString();
		if(numStr.indexOf('.')>=0){
			Float f = Float.valueOf(numStr);
			r[0] = f;
		}else{
			Long l = Long.valueOf(numStr);
			r[0] = l;
		}
		return index;
	}
	
	protected int parseBoolean(String str,int index,Boolean[] value){
		StringBuffer tmp = new StringBuffer();
		while(true){
			char c = str.charAt(index);
			if(c==',' || c=='}' || c==']'){
				String s = tmp.toString();
				s = s.trim();
				value[0] = Boolean.valueOf(s);
				return index;
			}else if(index==str.length()-1){
				tmp.append(c);
				String s = tmp.toString();
				s = s.trim();
				value[0] = Boolean.valueOf(s);
				return index;
			}else{
				tmp.append(c);
			}
			index ++;
		}
	}
	
	protected int parseString(String str,int index,StringBuffer result){
		char mark = str.charAt(index);
		index ++;
		while(true){
			char c = str.charAt(index); 
			if(c==mark){
				if(str.charAt(index-1)=='\\'){
					result.append(c);
				}else 
					return index+1;				
			}else{
				result.append(c);
			}
			index ++;
		}
	}
}
