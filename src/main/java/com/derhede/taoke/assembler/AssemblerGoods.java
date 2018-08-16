package com.derhede.taoke.assembler;

import com.alibaba.fastjson.JSONArray;
import com.derhede.taoke.dto.TaoKeFavorites;
import com.derhede.taoke.dto.TaoKeGoods;
import com.derhede.taoke.utils.BeanMapUtil;
import com.taobao.api.domain.UatmTbkItem;
import com.taobao.api.response.TbkUatmFavoritesItemGetResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: taoke
 * @description: 商品转行类型
 * @author: ziyichen
 * @create: 2018-08-16 17:06
 **/
public class AssemblerGoods {

    /**
     * 选品库数据转换
     * @param rsp
     * @param taoKeFavorites
     * @return
     */
    public static List<TaoKeGoods> toGoodsList(TbkUatmFavoritesItemGetResponse rsp, TaoKeFavorites taoKeFavorites) {
        try {
            List<TaoKeGoods> result = new ArrayList<>();
            List<UatmTbkItem> uatmTbkItems = rsp.getResults();
            if (!uatmTbkItems.isEmpty()) {
                for (UatmTbkItem item : uatmTbkItems) {
                    TaoKeGoods goods = new TaoKeGoods();
                    Map<String, Object> itemMap = (Map<String, Object>) JSONArray.toJSON(item);
                    goods = (TaoKeGoods) BeanMapUtil.convertMap2Bean(TaoKeGoods.class, itemMap);
                    goods.setFavoritesId(taoKeFavorites.getId());
                    result.add(goods);
                }
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
