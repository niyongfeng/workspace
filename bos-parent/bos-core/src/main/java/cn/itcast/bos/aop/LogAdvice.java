package cn.itcast.bos.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

/**
 * 日志切面类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月13日 上午11:19:56
 * @version 1.0
 */
public class LogAdvice {
	
	/** 定义日志记录器对象 */
	private Logger logger = Logger.getLogger(LogAdvice.class);
	
	/** 在业务层方法，出现异常时，记录异常日志 */
	public void error(JoinPoint joinPoint, Throwable ex){
		logger.error("调用【"+ joinPoint.getSignature().getName() +"】方法出现了异常，异常消息为：" + ex.getMessage());
		logger.error("异常跟踪栈中的信息为：", ex);
	}
}
