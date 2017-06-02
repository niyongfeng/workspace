package com.xiaohoo.api.common.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service("logAspect")
@Aspect
public class LoggingAspect {
	public BizLogger logger = BizLogger.getLogger(this.getClass());

	public Object executeTime(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		logger.info(String.format(">>>>>>Start to call method::%s of class::%s", methodName, className));
		long start = System.currentTimeMillis();
		Object output = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		logger.info(String.format(">>>>>>Total time for method::%s of class::%s is:%d ms", methodName, className, elapsedTime));
		logger.info(String.format(">>>>>>End to call method::%s of class::%s", methodName, className));
		return output;
	}

}
