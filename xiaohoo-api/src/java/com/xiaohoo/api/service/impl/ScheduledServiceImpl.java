/**
 * 
 */
package com.xiaohoo.api.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.xiaohoo.api.service.ScheduledService;

/**
 * @author haojwang
 *
 */
@Service
public class ScheduledServiceImpl implements ScheduledService {

	private static Integer CorePoolSize = 3;

	@SuppressWarnings("rawtypes")
	private static Map<String, Future> map = new HashMap<String, Future>(100);

	private static String KEY = "%d-%d";

	private static ScheduledExecutorService schedule = Executors
			.newScheduledThreadPool(CorePoolSize);

	@Override
	public void addRunnable(Integer userId, Integer id, Runnable command) {
		@SuppressWarnings("rawtypes")
		Future f = schedule.schedule(command, 30, TimeUnit.MINUTES);
		String key = String.format(KEY, userId, id);
		map.put(key, f);
	}

	@Override
	public void removeRunnable(Integer userId, Integer id) {
		String key = String.format(KEY, userId, id);
		@SuppressWarnings("rawtypes")
		Future f = map.get(key);
		map.remove(key);
		f.cancel(false);
	}
}
