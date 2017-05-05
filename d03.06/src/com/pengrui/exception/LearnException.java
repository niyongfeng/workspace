package com.pengrui.exception;

import java.io.IOException;

public class LearnException {
	public static void main(String[] args) {
		//1、异常Exception的处理-处理不正常情况，更好的沟通方式，更好的分离正常代码和错误代码；
		int total = 300;
		int count = 0;
		int average = total / count;
		System.out.println(average);
		//2、异常的种类：运行时异常（UncheckedException）,非运行时异常（CheckedException）
		//doSomething();
		//多个catch的情况下，应该把具体的Exception放在上面；
		//try {
			//正常业务逻辑代码
//			doSomething1();
//			doSomething3();
		//	doSomething4(4);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			//异常处理
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
		//} catch (DDDDDDException e) {
		//	e.printStackTrace();
		//} finally {
			//最终的清理工作，不管是否抛出异常，finally的代码都会被执行到
		//}
		
		/**
		 * try {
		 * 		doSomething1();
		 * 		try {
		 * 			doSomething3();
		 * 		} catch (InterruptedException e) {
		 * 			e.printStackTrace();
		 * 		}
		 * } catch (IOException e) {
		 * 		e.printStackTrace();
		 * }
		 */
		
		/**
		 * try {
		 * 		doSomething1();
		 * 		doSomething3();
		 * } catch (IOException | InterruptedException e) {
		 * 		e.printStackTrace();
		 * }
		 */

	}
	
	public static void doSomething() {
		throw new RuntimeException("运行时异常");
	}
	
	public static void doSomething1() throws IOException {
		throw new IOException("输入输出异常");
	}
	
	public static void doSomething3() throws InterruptedException {
		throw new InterruptedException("被终止异常");
	}
	
	public static void doSomething4(int a) throws DDDDDDException{
		if(a == 4) {
			throw new DDDDDDException("数字为4异常！");
		}
	}
}

class DDDDDDException extends Exception{

	private static final long serialVersionUID = 2L;

	public DDDDDDException(String s) {
		super(s);
	}
}
