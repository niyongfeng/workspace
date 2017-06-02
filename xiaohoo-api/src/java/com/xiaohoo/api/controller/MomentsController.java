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
 * 朋友圈
 * @author haojwang
 *
 */
@Controller
@RequestMapping("/rest/{version}/moments")
public class MomentsController {

	/**
	 * 新增朋友圈记录
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
	 * 删除朋友圈记录（id）
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
	 * 删除朋友圈回复记录（id）
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/deletereply", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteReply(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
	
	/**
	 * 朋友圈列表
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
	
	/**
	 * 某人的朋友圈列表
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/listbyperson", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listByPerson(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
	
	/**
	 * 详情
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> detail(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
	
	/**
	 * 朋友圈回复
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> reply(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
	
	
	/**
	 * 朋友圈点赞
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/thumbup", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> thumbup(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
}
