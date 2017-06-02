package com.xiaohoo.api.common.exception;

/**
 * 
 * @author hzlihonglin
 *
 */
@SuppressWarnings("serial")
public class SysException extends BaseException
{

	public SysException()
	{
		super();
	}

	public SysException(Exception exception)
	{
		super(exception);
	}

	public SysException(String msg)
	{
		super(msg);
	}

	public SysException(String msg, Exception e)
	{
		super(msg, e);
	}
}