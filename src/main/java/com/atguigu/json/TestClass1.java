package com.atguigu.json;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.atguigu.bean.T_MALL_CLASS_1;
import com.atguigu.mapper.Class1Mapper;
import com.google.gson.Gson;

public class TestClass1 {

	public static void main(String[] args) throws Exception {
		SqlSessionFactory factory = MySqlSessionFactory.getFactory();
		
		Class1Mapper mapper = factory.openSession().getMapper(Class1Mapper.class);
		List<T_MALL_CLASS_1> class1 = mapper.getClass1();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(class1);
		
		FileOutputStream fos = new FileOutputStream(new File("E:/商城项目/json/class_1.js"));
		
		fos.write(json.getBytes("utf-8"));
		
		fos.close();
		
		System.out.println(json);
	}
	
}
