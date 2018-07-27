package com.derhede.taoke.dao;

import com.derhede.taoke.dto.TaoKeGoods;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaoKeGoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaoKeGoods record);

    int insertSelective(TaoKeGoods record);

    TaoKeGoods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TaoKeGoods record);

    int updateByPrimaryKey(TaoKeGoods record);

    /**
     * 批量插入商品信息
     * @param goods
     * @return
     */
    int batchInsert(List<TaoKeGoods> goods);
}