package com.exe.springmybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CustomDAO {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	Connection conn = null;
	
	public int insertDate(CustomDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			conn = dataSource.getConnection();
			sql = "insert into custom (id,name,age)";
			sql +="values(?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	public int updateData(CustomDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			conn = dataSource.getConnection();
			sql = "update custom set name=?, age=? where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(3, dto.getId());
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	public List<CustomDTO> getLists(){
		
		List<CustomDTO> lists = new ArrayList<CustomDTO>();
		
		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		
		try {
			
			conn = dataSource.getConnection();
			
			sql = "select id,name,age from custom";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			
			
			while(rs.next()) {
				
				CustomDTO dto = new CustomDTO();
				
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				
				lists.add(dto);
			}
		
			rs.close();
			conn.close();
			pstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	
	public CustomDTO getReadData(int id){
		
		CustomDTO dto = null;
		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		
		try {
			
			conn = dataSource.getConnection();
			
			sql = "select id,name,age from custom where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			
			
			while(rs.next()) {
				
				dto = new CustomDTO();
				
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
			}
		
			rs.close();
			conn.close();
			pstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		return dto;
	}
	
	
	public int deleteData(int id) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			
			conn = dataSource.getConnection();
			
			sql = "delete from custom where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	
	
	
	
	
	
}
