package com.derhede.taoke.service.task;

/**
 * @program: taoke
 * @description: 任务定时器接口层
 * @author: ziyichen
 * @create: 2018-07-27 15:34
 **/
public interface TaskTimerService {

    /**
     * 选品库数据更新
     * 每天凌晨3点触发
     */
    void favoritesUpdate();
}
