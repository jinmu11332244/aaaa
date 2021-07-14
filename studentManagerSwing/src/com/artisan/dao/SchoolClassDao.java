package com.artisan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.artisan.model.SchoolClass;
import com.artisan.util.StringUtil;


/**
 * 班级Dao类
 * @author Administrator
 *
 */
public class SchoolClassDao {

	/**
	 * 班级添加
	 * @param con
	 * @param schoolClass
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,SchoolClass schoolClass)throws Exception{
		String sql="insert into t_school_class values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, schoolClass.getClassName());
		System.out.println(schoolClass.getClassName());
		pstmt.setString(2, schoolClass.getCalssDesc());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询班级集合
	 * @param con
	 * @param schoolClass
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,SchoolClass schoolClass)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_school_class");
		if(StringUtil.isNotEmpty(schoolClass.getClassName())){
			sb.append(" and className like '%"+schoolClass.getClassName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 删除班级
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_school_class where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新班级
	 * @param con
	 * @param schoolClass
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,SchoolClass schoolClass)throws Exception{
		String sql="update t_school_class set className=?,classDesc=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, schoolClass.getClassName());
		pstmt.setString(2, schoolClass.getCalssDesc());
		pstmt.setInt(3, schoolClass.getId());
		return pstmt.executeUpdate();
	}
}
