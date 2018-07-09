package com.derhede.taoke.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.derhede.taoke.dto.QueryParameterDTO;
import com.derhede.taoke.dto.TbkItemGetRequestDTO;
import com.derhede.taoke.enums.TaokeAPIUrlConstant;
import com.derhede.taoke.service.TaoKeAPIService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.request.JuItemsSearchRequest;
import com.taobao.api.request.JuItemsSearchRequest.TopItemQuery;
import com.taobao.api.request.TbkAdzoneCreateRequest;
import com.taobao.api.request.TbkCouponGetRequest;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.request.TbkDgNewuserOrderGetRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkItemRecommendGetRequest;
import com.taobao.api.request.TbkJuTqgGetRequest;
import com.taobao.api.request.TbkScNewuserOrderGetRequest;
import com.taobao.api.request.TbkShopGetRequest;
import com.taobao.api.request.TbkShopRecommendGetRequest;
import com.taobao.api.request.TbkSpreadGetRequest;
import com.taobao.api.request.TbkSpreadGetRequest.TbkSpreadRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.request.TbkUatmEventGetRequest;
import com.taobao.api.request.TbkUatmEventItemGetRequest;
import com.taobao.api.request.TbkUatmFavoritesGetRequest;
import com.taobao.api.request.TbkUatmFavoritesItemGetRequest;
import com.taobao.api.response.JuItemsSearchResponse;
import com.taobao.api.response.TbkAdzoneCreateResponse;
import com.taobao.api.response.TbkCouponGetResponse;
import com.taobao.api.response.TbkDgItemCouponGetResponse;
import com.taobao.api.response.TbkDgNewuserOrderGetResponse;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkItemRecommendGetResponse;
import com.taobao.api.response.TbkJuTqgGetResponse;
import com.taobao.api.response.TbkScNewuserOrderGetResponse;
import com.taobao.api.response.TbkShopGetResponse;
import com.taobao.api.response.TbkShopRecommendGetResponse;
import com.taobao.api.response.TbkSpreadGetResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;
import com.taobao.api.response.TbkUatmEventGetResponse;
import com.taobao.api.response.TbkUatmEventItemGetResponse;
import com.taobao.api.response.TbkUatmFavoritesGetResponse;
import com.taobao.api.response.TbkUatmFavoritesItemGetResponse;

@Service
public class TaoKeAPIServiceImpl implements TaoKeAPIService {
	
	@Value("${taobao.taoke.appkey}")
	private String appkey;
	
	@Value("${taobao.taoke.secret}")
	private String secret;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemTbk(TbkItemGetRequestDTO dto) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		dto.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		dto.setQ("女装");
		dto.setCat("16,18");
		dto.setItemloc("杭州");
		dto.setSort("tk_rate_des");
		dto.setIsTmall(false);
		dto.setIsOverseas(false);
		dto.setPageNo(0L);
		dto.setPageSize(5L);
		TbkItemGetResponse rsp;
		try {
			rsp = client.execute(dto);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getRecommendItemTbk(QueryParameterDTO queryParameterDTO) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkItemRecommendGetRequest req = new TbkItemRecommendGetRequest();
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
		req.setNumIid(123L);
		req.setCount(20L);
		req.setPlatform(1L);
		TbkItemRecommendGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getInfoItemTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
		req.setPlatform(1L);
		req.setNumIids("123,456");
		TbkItemInfoGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getShopTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkShopGetRequest req = new TbkShopGetRequest();
		req.setFields("user_id,shop_title,shop_type,seller_nick,pict_url,shop_url");
		req.setQ("女装");
		req.setSort("commission_rate_des");
		req.setIsTmall(false);
		req.setStartCredit(1L);
		req.setEndCredit(20L);
		req.setStartCommissionRate(2000L);
		req.setEndCommissionRate(123L);
		req.setStartTotalAction(1L);
		req.setEndTotalAction(100L);
		req.setStartAuctionCount(123L);
		req.setEndAuctionCount(200L);
		req.setPlatform(1L);
		req.setPageNo(1L);
		req.setPageSize(20L);
		TbkShopGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getRecommendShopTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkShopRecommendGetRequest req = new TbkShopRecommendGetRequest();
		req.setFields("user_id,shop_title,shop_type,seller_nick,pict_url,shop_url");
		req.setUserId(123L);
		req.setCount(20L);
		req.setPlatform(1L);
		TbkShopRecommendGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getEventUatmTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkUatmEventGetRequest req = new TbkUatmEventGetRequest();
		req.setPageNo(1L);
		req.setPageSize(20L);
		req.setFields("event_id,event_title,start_time,end_time");
		TbkUatmEventGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemEventUatmTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkUatmEventItemGetRequest req = new TbkUatmEventItemGetRequest();
		req.setPlatform(1L);
		req.setPageSize(20L);
		req.setAdzoneId(34567L);
		req.setUnid("3456");
		req.setEventId(123456L);
		req.setPageNo(1L);
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick,shop_title,zk_final_price_wap,event_start_time,event_end_time,tk_rate,type,status");
		TbkUatmEventItemGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemFavoritesUatmTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkUatmFavoritesItemGetRequest req = new TbkUatmFavoritesItemGetRequest();
		req.setPlatform(1L);
		req.setPageSize(20L);
		req.setAdzoneId(34567L);
		req.setUnid("3456");
		req.setFavoritesId(10010L);
		req.setPageNo(2L);
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick,shop_title,zk_final_price_wap,event_start_time,event_end_time,tk_rate,status,type");
		TbkUatmFavoritesItemGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getFavoritesUatmTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkUatmFavoritesGetRequest req = new TbkUatmFavoritesGetRequest();
		req.setPageNo(1L);
		req.setPageSize(20L);
		req.setFields("favorites_title,favorites_id,type");
		req.setType(1L);
		TbkUatmFavoritesGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getTqgJuTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkJuTqgGetRequest req = new TbkJuTqgGetRequest();
		req.setAdzoneId(123L);
		req.setFields("click_url,pic_url,reserve_price,zk_final_price,total_amount,sold_num,title,category_name,start_time,end_time");
		req.setStartTime(StringUtils.parseDateTime("2016-08-09 09:00:00"));
		req.setEndTime(StringUtils.parseDateTime("2016-08-09 16:00:00"));
		req.setPageNo(1L);
		req.setPageSize(40L);
		TbkJuTqgGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getSpreadTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkSpreadGetRequest req = new TbkSpreadGetRequest();
		List<TbkSpreadRequest> list2 = new ArrayList<TbkSpreadRequest>();
		TbkSpreadRequest obj3 = new TbkSpreadRequest();
		list2.add(obj3);
		obj3.setUrl("http://temai.taobao.com");
		req.setRequests(list2);
		TbkSpreadGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemsJuTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		JuItemsSearchRequest req = new JuItemsSearchRequest();
		TopItemQuery obj1 = new TopItemQuery();
		obj1.setCurrentPage(1L);
		obj1.setPageSize(20L);
		obj1.setPid("-");
		obj1.setPostage(true);
		obj1.setStatus(2L);
		obj1.setTaobaoCategoryId(1000L);
		obj1.setWord("test");
		req.setParamTopItemQuery(obj1);
		JuItemsSearchResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getCouponItemDgTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
		req.setAdzoneId(123L);
		req.setPlatform(1L);
		req.setCat("16,18");
		req.setPageSize(1L);
		req.setQ("女装");
		req.setPageNo(1L);
		TbkDgItemCouponGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getCouponTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkCouponGetRequest req = new TbkCouponGetRequest();
		req.setMe("nfr%2BYTo2k1PX18gaNN%2BIPkIG2PadNYbBnwEsv6mRavWieOoOE3L9OdmbDSSyHbGxBAXjHpLKvZbL1320ML%2BCF5FRtW7N7yJ056Lgym4X01A%3D");
		req.setItemId(123L);
		req.setActivityId("sdfwe3eefsdf");
		TbkCouponGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> createTpwdTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
		req.setUserId("123");
		req.setText("长度大于5个字符");
		req.setUrl("https://uland.taobao.com/");
		req.setLogo("https://uland.taobao.com/");
		req.setExt("{}");
		TbkTpwdCreateResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> createAdzoneTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkAdzoneCreateRequest req = new TbkAdzoneCreateRequest();
		req.setSiteId(123456L);
		req.setAdzoneName("广告位");
		TbkAdzoneCreateResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getOrderNewuserDgTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkDgNewuserOrderGetRequest req = new TbkDgNewuserOrderGetRequest();
		req.setPageSize(20L);
		req.setAdzoneId(123L);
		req.setPageNo(1L);
		TbkDgNewuserOrderGetResponse rsp;
		try {
			rsp = client.execute(req);
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getOrderNewuserScTbk(QueryParameterDTO queryParameterDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		TaobaoClient client = new DefaultTaobaoClient(TaokeAPIUrlConstant.TAOBAO_GET_HTTP, appkey, secret);
		TbkScNewuserOrderGetRequest req = new TbkScNewuserOrderGetRequest();
		req.setPageSize(20L);
		req.setAdzoneId(123L);
		req.setPageNo(1L);
		req.setSiteId(123L);
		TbkScNewuserOrderGetResponse rsp;
		try {
			rsp = client.execute(req, "");
			result = (Map<String, Object>) JSONObject.parse(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}

}
