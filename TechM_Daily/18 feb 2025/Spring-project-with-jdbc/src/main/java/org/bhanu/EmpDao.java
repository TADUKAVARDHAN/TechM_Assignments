package org.bhanu;
import org.springframework.jdbc.core.JdbcTemplate;
public class EmpDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	public int saveEmployee(Empdetails e) {
		String s="insert into emp values('"+e.getId()+"','"+e.getName()+"','"+e.getSal()+"')";
		return jdbcTemplate.update(s);
	}
	public int updateEmployee(Empdetails e) {
		String s="update emp set name='"+e.getName()+"',sal='"+e.getSal()+"' where id='"+e.getId()+"'";
		return jdbcTemplate.update(s);
	}
	public int deleteEmployee(Empdetails e) {
		String s="delete from emp where id='"+e.getId()+"'";
		return jdbcTemplate.update(s);
	}
}
