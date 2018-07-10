package com.derhede.taoke.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.derhede.taoke.dto.QueryParameterDTO;
import com.derhede.taoke.dto.TbkItemGetRequestDTO;
import com.derhede.taoke.service.TaoKeAPIService;

@RestController
@RequestMapping(value = "/taokeAPI")
public class TaoKeAPIController {

	@Autowired
	private TaoKeAPIService taoKeAPIService;
	
	/**
	 * taobao.tbk.item.get (淘宝客商品查询)
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/getItemTbk", method = RequestMethod.POST)
	public Map<String, Object> getItemTbk(@RequestBody TbkItemGetRequestDTO dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getItemTbk(dto);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.item.recommend.get (淘宝客商品关联推荐查询)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getRecommendItemTbk", method = RequestMethod.POST)
	public Map<String, Object> getRecommendItemTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getRecommendItemTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.item.info.get (淘宝客商品详情（简版）)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getInfoItemTbk", method = RequestMethod.POST)
	public Map<String, Object> getInfoItemTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getInfoItemTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.shop.get (淘宝客店铺查询)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getShopTbk", method = RequestMethod.POST)
	public Map<String, Object> getShopTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getShopTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.shop.recommend.get (淘宝客店铺关联推荐查询)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getRecommendShopTbk", method = RequestMethod.POST)
	public Map<String, Object> getRecommendShopTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getRecommendShopTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.uatm.event.get (枚举正在进行中的定向招商的活动列表)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getEventUatmTbk", method = RequestMethod.POST)
	public Map<String, Object> getEventUatmTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getEventUatmTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.uatm.event.item.get (获取淘宝联盟定向招商的宝贝信息)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getItemEventUatmTbk", method = RequestMethod.POST)
	public Map<String, Object> getItemEventUatmTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getItemEventUatmTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.uatm.favorites.item.get (获取淘宝联盟选品库的宝贝信息)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getItemFavoritesUatmTbk", method = RequestMethod.POST)
	public Map<String, Object> getItemFavoritesUatmTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getItemFavoritesUatmTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.uatm.favorites.get (获取淘宝联盟选品库列表)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getFavoritesUatmTbk", method = RequestMethod.POST)
	public Map<String, Object> getFavoritesUatmTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getFavoritesUatmTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.ju.tqg.get (淘抢购api)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getTqgJuTbk", method = RequestMethod.POST)
	public Map<String, Object> getTqgJuTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getTqgJuTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.spread.get (物料传播方式获取)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getSpreadTbk", method = RequestMethod.POST)
	public Map<String, Object> getSpreadTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getSpreadTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}
	
	/**
	 * taobao.ju.items.search (聚划算商品搜索接口)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getItemsJuTbk", method = RequestMethod.POST)
	public Map<String, Object> getItemsJuTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getItemsJuTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.dg.item.coupon.get (好券清单API【导购】)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getCouponItemDgTbk", method = RequestMethod.POST)
	public Map<String, Object> getCouponItemDgTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getCouponItemDgTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.coupon.get (阿里妈妈推广券信息查询)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getCouponTbk", method = RequestMethod.POST)
	public Map<String, Object> getCouponTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getCouponTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.tpwd.create (淘宝客淘口令)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/createTpwdTbk", method = RequestMethod.POST)
	public Map<String, Object> createTpwdTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.createTpwdTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.dg.newuser.order.get (淘宝客新用户订单API--导购)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getOrderNewuserDgTbk", method = RequestMethod.POST)
	public Map<String, Object> getOrderNewuserDgTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getOrderNewuserDgTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}

	/**
	 * taobao.tbk.sc.newuser.order.get (淘宝客新用户订单API--社交)
	 * @param queryParameterDTO
	 * @return
	 */
	@RequestMapping(value = "/getOrderNewuserScTbk", method = RequestMethod.POST)
	public Map<String, Object> getOrderNewuserScTbk(@RequestBody QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result = taoKeAPIService.getOrderNewuserScTbk(queryParameterDTO);
		
		System.out.println(result);
		
		return result;
	}
}
