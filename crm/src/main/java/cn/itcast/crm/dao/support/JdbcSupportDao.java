package cn.itcast.crm.dao.support;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Spring的jdbc支撑类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 上午9:14:01
 * @version 1.0
 */
public abstract class JdbcSupportDao {
	@Resource
	protected JdbcTemplate jdbcTemplate;
}
