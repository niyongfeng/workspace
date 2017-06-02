/**
 * 
 */
package com.xiaohoo.api.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author haibhu
 *
 */
public class SmsCodeUtil {
	
	public static String templateurl = "https://api.netease.im/sms/sendtemplate.action";
	public static String smsurl = "https://api.netease.im/sms/sendcode.action";
	public static String verifyurl = "https://api.netease.im/sms/verifycode.action";
	
	public static String appKey = "ed3ea5ef498d0cbf95a77847947cfd10";
	public static String appSecret = "c00e46e31821";
	public static String nonce =  "12345";
	
	public static String sendSms(String mobileNo) throws Exception {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(smsurl);

        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("mobile", mobileNo));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        String strSmsRes = EntityUtils.toString(response.getEntity(), "utf-8");

		// 打印执行结果
		System.out.println(strSmsRes);
		return strSmsRes;
    
	}
	
	public static String sendSmsVerifyCodeTemplate(String mobileNo) throws Exception {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(smsurl);

        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("mobile", mobileNo));
        nvps.add(new BasicNameValuePair("templateid", "3064219"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        String strSmsRes = EntityUtils.toString(response.getEntity(), "utf-8");

		// 打印执行结果
		System.out.println(strSmsRes);
		return strSmsRes;
    
	}
	
	public static String sendTemplate(String mobileNo) throws Exception {
				DefaultHttpClient httpClient = new DefaultHttpClient();
		        HttpPost httpPost = new HttpPost(templateurl);
		        
		        String curTime = String.valueOf((new Date()).getTime() / 1000L);//time
		        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考计算CheckSum的java代码

		        // 设置请求的header
		        httpPost.addHeader("AppKey", appKey);
		        httpPost.addHeader("Nonce", nonce);
		        httpPost.addHeader("CurTime", curTime);
		        httpPost.addHeader("CheckSum", checkSum);
		        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		        
		        //设置请求的的参数
		        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		        //								模板id			
				nvps.add(new BasicNameValuePair("templateid", "3064219"));
				//								参数			jsonArray形式
				nvps.add(new BasicNameValuePair("mobiles", "['"+mobileNo+"']"));
				
				nvps.add(new BasicNameValuePair("params", "['0000']"));
		        
		        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		        
		        // 执行请求
		        HttpResponse response = httpClient.execute(httpPost);
		        
		        String strSmsRes = EntityUtils.toString(response.getEntity(), "utf-8");

				// 打印执行结果
				System.out.println(strSmsRes);
				return strSmsRes;
		       
		    }
	
	public static String verifyCode(String mobileNo,String code) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		
		HttpPost httpPost = new HttpPost(verifyurl);

		String curTime = String.valueOf((new Date()).getTime() / 1000L);// time
		String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);// 参考计算CheckSum的java代码

		// 设置请求的header
		httpPost.addHeader("AppKey", appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求的的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// 									参数 jsonArray形式
		nvps.add(new BasicNameValuePair("mobile", mobileNo));
		// 									参数
		nvps.add(new BasicNameValuePair("code", code));

		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		
		String strSmsRes = EntityUtils.toString(response.getEntity(), "utf-8");

		// 打印执行结果
		System.out.println(strSmsRes);
		return strSmsRes;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String mobileNo = "13606706704";
		String code="8667";
		try {
			
			//----------------send normal sms
			String strSmsRes = SmsCodeUtil.sendSmsVerifyCodeTemplate(mobileNo);
			System.out.println("strSmsRes="+strSmsRes);
			
			//----------------send template sms
//			String strSmsRes = SmsCodeUtil.sendTemplate(mobileNo);
//			System.out.println("strSmsRes="+strSmsRes);
			
			
			//----------------Verify Code
//			String strSmsRes = SmsCodeUtil.verifyCode(mobileNo, code);
//			JSONObject jsonObj = JSONObject.fromObject(strSmsRes);
//			System.out.println(jsonObj);
//			System.out.println(jsonObj.get("code"));
			
			//Send SMS, obj is the code returned from API
			//{"code":200,"msg":"2","obj":"4104"}
			
			//VeifyCode
			//{"code":200}
			//{"code":413,"msg":"verify err","obj":1}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
