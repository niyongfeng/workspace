package com.xiaohoo.api.common.constant;

import java.math.BigInteger;
import java.security.SecureRandom;

public class PingppConstant {
	
	  /**
     * Pingpp 管理平台对应的 API Key，api_key 获取方式：登录 [Dashboard](https://dashboard.pingxx.com)->点击管理平台右上角公司名称->开发信息-> Secret Key
     */
	//public final static String apiKey = "sk_test_HKSuX14iDu1GfTuLSOeDKW1O";
	public final static String apiKey = "sk_live_4CW1K0rz9iv5qPuXbLyb1SSG";

    /**
     * Pingpp 管理平台对应的应用 ID，app_id 获取方式：登录 [Dashboard](https://dashboard.pingxx.com)->点击你创建的应用->应用首页->应用 ID(App ID)
     */
   // public final static String appId = "app_1Gqj58ynP0mHeX1q";
	public final static String appId = "app_qfLOmDzX1SaPOCyf";

    /**
     * 设置请求签名密钥，密钥对需要你自己用 openssl 工具生成，如何生成可以参考帮助中心：https://help.pingxx.com/article/123161；
     * 生成密钥后，需要在代码中设置请求签名的私钥(rsa_private_key.pem)；
     * 然后登录 [Dashboard](https://dashboard.pingxx.com)->点击右上角公司名称->开发信息->商户公钥（用于商户身份验证）
     * 将你的公钥复制粘贴进去并且保存->先启用 Test 模式进行测试->测试通过后启用 Live 模式
     */
    // 你生成的私钥路径
   public final static String privateKeyFilePath = "res/your_rsa_private_key.pem";
 
    public static SecureRandom random = new SecureRandom();

    public static String randomString(int length) {
        String str = new BigInteger(130, random).toString(32);
        return str.substring(0, length);
    }

    /**
     * 读取文件, 部署 web 程序的时候, 签名和验签内容需要从 request 中获得
     * @param filePath
     * @return
     * @throws Exception
     */
    public static String getStringFromFile(String filePath) throws Exception {
    	String pathStr = PingppConstant.class.getClassLoader().getResource("").getPath();
    	System.out.println(pathStr);
    	System.out.println(pathStr + filePath);
    	return pathStr + filePath;
    }
}
