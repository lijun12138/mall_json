package com.atguigu.json;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.atguigu.bean.T_MALL_CLASS_1;
import com.atguigu.bean.T_MALL_CLASS_2;
import com.atguigu.mapper.Class1Mapper;
import com.atguigu.mapper.Class2Mapper;
import com.google.gson.Gson;

public class TestClass2 {

	public static void main(String[] args) throws Exception {
		SqlSessionFactory factory = MySqlSessionFactory.getFactory();

		Gson gson = new Gson();
		Class1Mapper class1mapper = factory.openSession().getMapper(Class1Mapper.class);
		List<T_MALL_CLASS_1> class1 = class1mapper.getClass1();
		for (T_MALL_CLASS_1 t_MALL_CLASS_1 : class1) {
			Class2Mapper class2mapper = factory.openSession().getMapper(Class2Mapper.class);
			List<T_MALL_CLASS_2> class2 = class2mapper.getClass2ById(t_MALL_CLASS_1.getId());
			String json = gson.toJson(class2);
			FileOutputStream fos = new FileOutputStream(new File("E:/商城项目/json/class_2_"+t_MALL_CLASS_1.getId()+".js"));
			fos.write(json.getBytes("utf-8"));
			fos.close();
			System.out.println(json);
		}

	}

}
