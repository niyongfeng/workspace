package cn.itcast.crm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.dao.support.JdbcSupportDao;
import cn.itcast.crm.domain.Customer;

/**
 * 客户数据访问接口的实现类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 上午9:15:05
 * @version 1.0
 */
@Repository("customerDao")
public class CustomerDaoImpl extends JdbcSupportDao implements CustomerDao {
	/**
	 * 根据定区id查询客户 
	 * @param id 定区的id
	 * @return 客户集合
	 */
	public List<Customer> getCustomerByFixedArea(long id){
		String sql = "select * from customer where fixedarea_id = ?";
		return jdbcTemplate.query(sql, new RowMapper<Customer>(){
			@Override
			public Customer mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setFixedAreaId(rs.getLong("fixedarea_id"));
				customer.setPhone(rs.getString("phone"));
				customer.setStation(rs.getString("station"));
				return customer;
			}
		}, id);
	}
	/**
	 * 解除关联的客户
	 * @param id
	 */
	public void deleteCustomer(int id){
		String sql = "update customer set FIXEDAREA_ID = ? where id = ?";
		jdbcTemplate.update(sql, null, id);
	}
	/**
	 * 统计查询
	 * @return 总记录条数
	 */
	public int count(){
		String sql = "SELECT COUNT(*) FROM customer WHERE fixedarea_id IS NULL";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	/**
	 * 分页查询客户
	 * @param pageIndex 当前页码
	 * @param pageSize 每页显示的记录条数
	 * @return 客户的集合
	 */
	public List<Customer> getRelationCustomerByPage(int pageIndex, int pageSize){
		String sql = "SELECT * FROM customer WHERE fixedarea_id IS NULL limit ?,?";
		return jdbcTemplate.query(sql, new RowMapper<Customer>(){
			@Override
			public Customer mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setFixedAreaId(rs.getLong("fixedarea_id"));
				customer.setPhone(rs.getString("phone"));
				customer.setStation(rs.getString("station"));
				return customer;
			}
		}, (pageIndex - 1) * pageSize, pageSize);
	}
	/**
	 * 修改用户
	 * @param ids
	 * @param fixedAreaId
	 */
	public void updateCustomer(String ids, long fixedAreaId){
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE customer SET FIXEDAREA_ID = ? WHERE id IN(");
		String[] idArr = ids.split(",");
		List<Object> params = new ArrayList<>();
		params.add(fixedAreaId);
		for (int i = 0; i < idArr.length; i++){
			sql.append( i == 0 ? "?" : ",?");
			params.add(Integer.parseInt(idArr[i]));
		}
		sql.append(")");
		jdbcTemplate.update(sql.toString(), params.toArray());
		
	}
	/**
	 * 添加客户信息
	 * @param customer 客户
	 */
	public void save(Customer customer){
		String sql = "insert into customer(name,phone,address) values(?,?,?)";
		jdbcTemplate.update(sql, customer.getName(),customer.getPhone(),customer.getAddress());
	}
	
	
	
	
}