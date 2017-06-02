/**
 * 
 */
package com.xiaohoo.api.controller.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohoo.api.common.exception.ParameterWrongException;

/**
 * @author haojwang
 *
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(ParameterWrongException.class)
	@ResponseBody
	public Map<String, Object> handleAccessDeniedException(
			HttpServletRequest request, Exception ex) {
		logger.info("ParameterWrongException", ex);
		return generateErrorResult("Parameter is wrong!");
	}
}
