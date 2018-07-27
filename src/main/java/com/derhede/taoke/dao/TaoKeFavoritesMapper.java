package com.derhede.taoke.dao;

import com.derhede.taoke.dto.TaoKeFavorites;

public interface TaoKeFavoritesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaoKeFavorites record);

    int insertSelective(TaoKeFavorites record);

    TaoKeFavorites selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaoKeFavorites record);

    int updateByPrimaryKey(TaoKeFavorites record);
}