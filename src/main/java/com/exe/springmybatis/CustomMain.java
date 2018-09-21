package com.exe.springmybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("app-context.xml");

		CustomDAO dao = (CustomDAO)context.getBean("customDAO");
		
		CustomDTO dto;
		
		//insert
		dto = new CustomDTO();
		dto.setId(222);
		dto.setName("bbb");
		dto.setAge(25);
		
		dao.insertDate(dto);
		
		
		System.out.println("insert success!");
		
		/*
		//select
		List<CustomDTO> lists = dao.getLists();
		for(CustomDTO dto1 :lists){
			System.out.printf("%d %s %d\n",dto1.getId(),dto1.getName(),dto1.getAge());
		}
		if(lists!=null){
			System.out.println("select success!");
		}*/
		
		
		/*//OneSelect
		dto = dao.getReadData(777);
		if(dto!=null) {
			System.out.printf("%d %s %d\n",dto.getId(),dto.getName(),dto.getAge());
			System.out.println("select success!");
		}*/
		
		/*//update
		dto = new CustomDTO();
		dto.setId(777);
		dto.setName("¹è¼öÁö");
		dto.setAge(21);
		
		dao.updateData(dto);
		
		System.out.println("update success");
		*/
		
		//delete
		/*
		dao.deleteData(111);
		
		List<CustomDTO> lists = dao.getLists();
		for(CustomDTO dto1 :lists){
			System.out.printf("%d %s %d\n",dto1.getId(),dto1.getName(),dto1.getAge());
		}
		if(lists!=null){
			System.out.println("select success!");
		}*/
		
	}

}










