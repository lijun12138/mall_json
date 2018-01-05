package com.atguigu.json;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.atguigu.bean.T_MALL_CLASS_1;
import com.atguigu.bean.T_MALL_TRADE_MARK;
import com.atguigu.mapper.Class1Mapper;
import com.atguigu.mapper.TradMarkMapper;
import com.google.gson.Gson;

public class TestTradMark {

	public static void main(String[] args) throws Exception {
		SqlSessionFactory factory = MySqlSessionFactory.getFactory();

		Gson gson = new Gson();
		
		Class1Mapper class1mapper = factory.openSession().getMapper(Class1Mapper.class);
		List<T_MALL_CLASS_1> class1 = class1mapper.getClass1();
		for (T_MALL_CLASS_1 t_MALL_CLASS_1 : class1) {
			TradMarkMapper mapper = factory.openSession().getMapper(TradMarkMapper.class);
			List<T_MALL_TRADE_MARK> tradMark = mapper.getTradMarkById(t_MALL_CLASS_1.getId());
			
			
			String json = gson.toJson(tradMark);
			FileOutputStream fos = new FileOutputStream(new File("E:/商城项目/json/tm_class_1_"+t_MALL_CLASS_1.getId()+".js"));
			
			fos.write(json.getBytes("utf-8"));
			fos.close();
			System.out.println(json);
		}
		

		


	}

}
