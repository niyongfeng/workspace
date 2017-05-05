package cn.itcast.bos.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.itcast.bos.hibernate.GeneratorDao;

/**
 * 主键生成器接口实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月17日 下午4:12:46
 * @version 1.0
 */
public class GeneratorDaoImpl extends HibernateDaoImpl implements GeneratorDao {
	/**
	 * 生成主键值的方法
	 * @param clazz 持久化类
	 * @param field 主键列对应的属性
	 * @param parentCode 父级编号
	 * @param codeLen 位数
	 * @return 主键值
	 */
	public String generatorCode(Class<?> clazz, String field,
				String parentCode, int codeLen){
		// select MAX(code) from bos_id_resource where length(code) = 4 // 没有传父级code，查询四位最大的code
		// select MAX(code) from bos_id_resource where length(code) = 8 and code like '0001%' // 传父级code 0001
		StringBuilder hql = new StringBuilder();
		hql.append("select max("+ field +") from " + clazz.getSimpleName())
		   .append(" where length("+ field +") = ?");
		List<Object> params = new ArrayList<>();
		/** 判断父级code */
		if (!StringUtils.isEmpty(parentCode)){
			hql.append(" and " + field + " like ?");
			params.add(parentCode.length() + codeLen);
			params.add(parentCode + "%");
		}else{
			params.add(codeLen);
		}
		String maxCode = this.findUniqueEntity(hql.toString(), params.toArray());
		parentCode  = StringUtils.isEmpty(parentCode) ? "" : parentCode;
		if (StringUtils.isEmpty(maxCode)){
			// 0001
			// 0004 00040001
			String prefix = "";
			for (int i = 1 ; i < codeLen; i++){
				prefix += "0";
			}
			return parentCode + prefix + 1; // 0001
		}else{
			// 0003 -> 0004
			// 00010005 --> 00010006
			/** 
			 * 截取最后四位
			 * 0003 -->  0003
			 * 00010005 --> 0005
			 */
			String tempCode = maxCode.substring(maxCode.length() - codeLen, maxCode.length());
			/**
			 * 0003 -> 4
			 * 0009 --> 10
			 */
			String suffix = String.valueOf(Integer.valueOf(tempCode) + 1);
			/** 判断主键值是否越界 */
			if (suffix.length() > codeLen){
				throw new RuntimeException("生成主键值已越界! ");
			}
			return parentCode + tempCode.substring(0, tempCode.length() - suffix.length()) + suffix;
		}
	}
}