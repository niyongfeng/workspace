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
 * 举报
 * @author haojwang
 *
 */
@Controller
@RequestMapping("/rest/{version}/tipoff")
public class TipOffController {

	
	/**
	 * 新增举报
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
	 * 删除举报
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
	 * 举报历史
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/history", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> history(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
	
	/**
	 * 编辑举报信息
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modify(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
}
