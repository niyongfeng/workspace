package com.xiaohoo.api.controller.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaohoo.api.common.exception.ParameterWrongException;
import com.xiaohoo.api.common.util.BizLogger;
import com.xiaohoo.api.domain.User;

public class BaseController {
	public BizLogger logger = BizLogger.getLogger(this.getClass());

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

	@Autowired
	protected RestTemplate restTemplate;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getRemoteIp() {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		ip = ip.split(",")[0];
		return ip;
	}

	/**
	 * @param record
	 * @param data
	 */
	public Map<String, Object> generateNomalResult(Object record) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("record", record);
		result.put("data", data);
		result.put("res", "0");
		result.put("message", "Success");
		return result;
	}

	/**
	 * @param record
	 * @param data
	 */
	public Map<String, Object> generateNoDataResult(Object record) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("record", record);
		result.put("res", "1");
		result.put("message", "No Data Found");
		result.put("data", data);

		return result;
	}

	/**
	 * get user from session in each request
	 * 
	 * @return
	 */
	protected User getUserInfoFromSession() {
		// TODO
		User user = new User();
		user.setId(1);
		user.setPhone("15088888888");
		user.setPassword("1111111");
		return user;
	}

	/**
	 * @param e
	 */
	public Map<String, Object> generateErrorResult(Exception e) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		result.put("data", data);
		result.put("res", "1");
		result.put("message", "Error-" + e.getMessage());
		return result;
	}

	/**
	 * @param msg
	 */
	public Map<String, Object> generateErrorResult(String msg) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		result.put("data", data);
		result.put("res", "1");
		result.put("message", msg);
		return result;
	}

	/**
	 * @Title: readJsonStr2Object
	 * @Description: readJsonStr2Object
	 * @param @param para
	 * @param @return 设定文件
	 * @return BankType 返回类型
	 * @throws
	 */
	protected <T> T readJsonStr2Object(String para, Class<T> clazz) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			T record = (T) mapper.readValue(para, clazz);
			return record;
		} catch (Exception e) {
			logger.error(
					"parse json to object failed with parameter:{},clazz:{}",
					para, clazz);
			throw new ParameterWrongException(e);
		}

	}

	protected JsonNode readJsonStr2SingleNode(String para, String field) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(para);
			JsonNode f = node.get(field);
			if (f == null) {
				logger.error("field empty with parameter:{},field:{}", para,
						field);
				throw new ParameterWrongException("field empty");
			}
			return f;
		} catch (Exception e) {
			logger.error(
					"parse json to jsonnode failed with parameter:{},field:{}",
					para, field);
			throw new ParameterWrongException(e);
		}

	}

	/**
	 * get version information
	 * 
	 * @param version
	 * @param model
	 */
	@ModelAttribute
	public void getVersion(@PathVariable String version, Model model) {
		// get version from the path
	}
}
