package com.derhede.taoke.service;

import java.util.Map;

import com.derhede.taoke.dto.QueryParameterDTO;
import com.derhede.taoke.dto.TbkItemGetRequestDTO;

public interface TaoKeAPIService {

	Map<String, Object> getItemTbk(TbkItemGetRequestDTO dto);

	Map<String, Object> getRecommendItemTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getInfoItemTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getShopTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getRecommendShopTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getEventUatmTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getItemEventUatmTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getItemFavoritesUatmTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getFavoritesUatmTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getTqgJuTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getSpreadTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getItemsJuTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getCouponItemDgTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getCouponTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> createTpwdTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getOrderNewuserDgTbk(QueryParameterDTO queryParameterDTO);

	Map<String, Object> getOrderNewuserScTbk(QueryParameterDTO queryParameterDTO);

}
