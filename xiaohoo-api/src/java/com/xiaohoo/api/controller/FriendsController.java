/**
 * 
 */
package com.xiaohoo.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 好友
 * @author haojwang
 *
 */
@Controller
@RequestMapping("/rest/{version}/friends")
public class FriendsController {

	/**
	 * 新增好友
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
	
	/**
	 * 删除好友
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
	
	/**
	 * 设置好友备注信息
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/mark", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> mark(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
	
	
}
