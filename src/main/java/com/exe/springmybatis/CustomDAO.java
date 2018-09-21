package com.exe.springmybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class CustomDAO {
	
	private SqlSessionTemplate sessionTemplate;
	
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}


	Connection conn = null;
	
	public void insertDate(CustomDTO dto) {
		
		sessionTemplate.insert("com.exe.mapper.insert", dto);
		
	}
	
	
	public List<CustomDTO> getLists(){
		
		List<CustomDTO> lists = 
				sessionTemplate.selectList("com.exe.mapper.list");
		
		return lists;
	}
	
	public void updateData(CustomDTO dto) {
		sessionTemplate.update("com.exe.mapper.update", dto);
	}
	
	
	public CustomDTO getReadData(int id){
		
		CustomDTO dto = sessionTemplate.selectOne("com.exe.mapper.list1", id);
		
		return dto;
	}
	
	
	public void deleteData(int id) {
		sessionTemplate.delete("com.exe.mapper.delete", id);
	}
	
	
	
	
	
	
	
}
