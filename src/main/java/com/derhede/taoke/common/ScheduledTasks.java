package com.derhede.taoke.common;

import com.derhede.taoke.service.task.TaskTimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器任务类
 * @author ziyichen
 *
 */
@Component
public class ScheduledTasks extends BaseLogUtil {

	@Autowired
	private TaskTimerService taskTimerService;

	/**
	 * 选品库数据更新
	 * 每天凌晨3点触发
	 */
	@Scheduled(cron="0 0/5 * * * ?")
	public void favoritesUpdate() {

		logger.info("==========>>> 选品库数据更新开始~！！！");

		final long start = System.currentTimeMillis();

		taskTimerService.favoritesUpdate();

		long end = System.currentTimeMillis();

		logger.info("<<<========== 选品库数据更新结束，耗时：{}", end - start);

	}
}
