/**
 * 
 */
package com.xiaohoo.api.service;

/**
 * @author haojwang
 *
 */
public interface ScheduledService {

	
	public void addRunnable(Integer userId, Integer id, Runnable command);
	
	public void removeRunnable(Integer userId, Integer id);
}
