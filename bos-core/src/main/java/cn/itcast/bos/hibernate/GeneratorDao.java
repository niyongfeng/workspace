package cn.itcast.bos.hibernate;
/**
 * 主键生成器接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月17日 下午4:12:04
 * @version 1.0
 */
public interface GeneratorDao extends HibernateDao {
	/**
	 * 生成主键值的方法
	 * @param clazz 持久化类
	 * @param field 主键列对应的属性
	 * @param parentCode 父级编号
	 * @param codeLen 位数
	 * @return 主键值
	 */
	String generatorCode(Class<?> clazz, String field,
				String parentCode, int codeLen);

}
