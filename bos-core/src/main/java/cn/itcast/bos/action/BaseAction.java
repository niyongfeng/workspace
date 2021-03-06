package cn.itcast.bos.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.itcast.bos.pojo.PageModel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础的控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年2月11日 下午4:54:05
 * @version 1.0
 */
public class BaseAction extends ActionSupport {
	
	private static final long serialVersionUID = -9129813475361758486L;
	/** 定义分页实体 */
	protected PageModel pageModel = new PageModel();
	/** 定义Map集合返回响应数据 */
	private Map<String,Object> responseData = new HashMap<>();
	
	/** 向浏览器输出响应数据(datagrid数据表格分页) */
	public void writeResponseDataPage(List<?> data, String ... fields){
		/** 封装datagrid组件需要的分页数据 */
		if (pageModel.getRecordCount() > 0){
			responseData.put("total", pageModel.getRecordCount());
		}
		responseData.put("rows", data);
		/** 定义过滤器 */
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		/** 添加不需要序列化的属性 */
		filter.getExcludes().addAll(Arrays.asList(fields));
		/** 
		 * 把Map集合解析成json格式字符串 
		 * SerializerFeature.DisableCircularReferenceDetect: 禁止产生循环引用$ref
		 * SerializerFeature.WriteDateUseDateFormat: 用日期格式器 yyyy-MM-dd HH:mm:ss
		 * */
		String jsonData = JSON.toJSONString(responseData, filter, 
					SerializerFeature.DisableCircularReferenceDetect,
					SerializerFeature.WriteDateUseDateFormat);
		writeResponseDataStr(jsonData);
	}
	
	/** 向浏览器输出响应数据 */
	public void writeResponseDataObject(List<?> data){
		/** 把Map集合解析成json格式字符串  */
		String jsonData = JSON.toJSONString(data);
		writeResponseDataStr(jsonData);
	}
	
	
	/** 向浏览器输出响应数据(输出字符串) */
	public void writeResponseDataStr(String data){
		System.out.println("jsonData: " + data);
		/** 获取响应对象 */
		HttpServletResponse response = ServletActionContext.getResponse();
		/** 设置响应内容类型 */
		response.setContentType("text/html;charset=utf-8");
		try {
			/** 告诉浏览器，服务器响应的数据是用GZIP压缩的 */
			response.setHeader("Content-Encoding", "gzip");
			/** 创建输出流的容器 */
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			/** 创建GZIP压缩对象 */
			GZIPOutputStream gzip = new GZIPOutputStream(bos);
			/** 进行压缩 */
			gzip.write(data.getBytes("utf-8"));
			gzip.flush();
			gzip.close();
			/** 向浏览器输出响应数据 */
			response.getOutputStream().write(bos.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** setter and getter method */
    /** 当前页码 */
    public void setPage(int page){
    	pageModel.setPageIndex(page);
    }
    /** 每页显示的记录条数 */
    public void setRows(int rows){
    	pageModel.setPageSize(rows);
    }
}
