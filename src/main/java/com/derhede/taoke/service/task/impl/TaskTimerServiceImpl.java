package com.derhede.taoke.service.task.impl;

import com.derhede.taoke.common.BaseLogUtil;
import com.derhede.taoke.dao.TaoKeFavoritesMapper;
import com.derhede.taoke.dao.TaoKeGoodsMapper;
import com.derhede.taoke.dto.TaoKeFavorites;
import com.derhede.taoke.dto.TaoKeGoods;
import com.derhede.taoke.service.api.TaoKeAPIService;
import com.derhede.taoke.service.task.TaskTimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: taoke
 * @description: 任务定时器实现层
 * @author: ziyichen
 * @create: 2018-07-27 15:36
 **/
@Service
public class TaskTimerServiceImpl extends BaseLogUtil implements TaskTimerService {

    @Autowired
    private TaoKeFavoritesMapper taoKeFavoritesMapper;

    @Autowired
    private TaoKeGoodsMapper taoKeGoodsMapper;

    @Autowired
    private TaoKeAPIService taoKeAPIService;

    /**
     * 选品库数据更新
     * 每天凌晨3点触发
     */
    @Override
    public void favoritesUpdate() {
        logger.info("=====1.获取所有有效的选品库数据 =====");
        List<TaoKeFavorites> favorites = taoKeFavoritesMapper.getAllValidFavorites();
        if (!favorites.isEmpty()){
            for (TaoKeFavorites taoKeFavorites : favorites) {
                List<TaoKeGoods> goods = taoKeAPIService.getItemFavoritesUatmTbk(taoKeFavorites);
                taoKeGoodsMapper.batchInsert(goods);
            }
        } else {
            logger.info("=====无效的选品库数据 =====");
        }

    }
}
