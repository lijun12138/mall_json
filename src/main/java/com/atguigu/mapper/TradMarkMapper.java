package com.atguigu.mapper;

import java.util.List;

import com.atguigu.bean.T_MALL_TRADE_MARK;

public interface TradMarkMapper {

	public List<T_MALL_TRADE_MARK> getTradMark();
	
	public List<T_MALL_TRADE_MARK> getTradMarkById(Integer id);

}
