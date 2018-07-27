package com.derhede.taoke.dao;

import com.derhede.taoke.dto.TaoKeFavorites;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaoKeFavoritesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaoKeFavorites record);

    int insertSelective(TaoKeFavorites record);

    TaoKeFavorites selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaoKeFavorites record);

    int updateByPrimaryKey(TaoKeFavorites record);

    /**
     * 获取所有有效的选品库数据
     * @return
     */
    List<TaoKeFavorites> getAllValidFavorites();
}