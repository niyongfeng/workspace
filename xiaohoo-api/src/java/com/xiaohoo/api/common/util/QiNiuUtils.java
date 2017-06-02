package com.xiaohoo.api.common.util;
import com.qiniu.util.Auth;

import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;

public class QiNiuUtils {
  //设置好账号的ACCESS_KEY和SECRET_KEY
  String ACCESS_KEY = "k2G7xNyQbiQ21So8PVn5dVd7xcXCS7LQfEOXCQ9s";
  String SECRET_KEY = "o40t9PHYri-4-keD80qlSBtWNyomKTYGHZiPCKYL";
  //要上传的空间
  String bucketname = "xiaohooapi";
  //上传到七牛后保存的文件名
  String key = "xiaohoologo4.png";
  //上传文件的路径
  String FilePath = "D:\\temp\\jztlogo4.png";

  //密钥配置
  Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
  //创建上传对象
  Configuration cfg = new Configuration(Zone.zone0());
  UploadManager uploadManager = new UploadManager(cfg);

  //简单上传，使用默认策略，只需要设置上传的空间名就可以了
  public String getUpToken(){
      return auth.uploadToken(bucketname);
  }

  public void upload() throws IOException{
    try {
      //调用put方法上传
      Response res = uploadManager.put(FilePath, key, getUpToken());
      //打印返回的信息
      System.out.println(res.bodyString()); 
      } catch (QiniuException e) {
          Response r = e.response;
          // 请求失败时打印的异常的信息
          System.out.println(r.toString());
          try {
              //响应的文本信息
            System.out.println(r.bodyString());
          } catch (QiniuException e1) {
              //ignore
          }
      }       
  }

  public void uploadFile(String strFilePath, String strFileName) throws IOException{
	    try {
	      //调用put方法上传
	      Response res = uploadManager.put(strFilePath, strFileName, getUpToken());
	      //打印返回的信息
	      System.out.println(res.bodyString()); 
	      } catch (QiniuException e) {
	          Response r = e.response;
	          // 请求失败时打印的异常的信息
	          System.out.println(r.toString());
	          try {
	              //响应的文本信息
	            System.out.println(r.bodyString());
	          } catch (QiniuException e1) {
	              //ignore
	          }
	      }       
	  }
  public static void main(String args[]) throws IOException{  
    new QiNiuUtils().upload();
//	  System.out.println(new QiNiuUtils().getUpToken());
    //{"hash":"FggQk4OzUa9UeHSBX4I5n_2w-Q6W","key":"jztlogo4.png"}
  }

}
