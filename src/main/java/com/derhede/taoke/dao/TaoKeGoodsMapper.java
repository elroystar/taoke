package com.derhede.taoke.dao;

import com.derhede.taoke.dto.TaoKeGoods;

public interface TaoKeGoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaoKeGoods record);

    int insertSelective(TaoKeGoods record);

    TaoKeGoods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TaoKeGoods record);

    int updateByPrimaryKey(TaoKeGoods record);
}