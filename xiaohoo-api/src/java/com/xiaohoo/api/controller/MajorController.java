package com.xiaohoo.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohoo.api.controller.base.BaseController;
import com.xiaohoo.api.domain.Major;
import com.xiaohoo.api.service.MajorService;

/**
 * Desc: MajorController
 * 
 * @author Kavin
 * @since  2017-5-20 
 */
@Api(value = "/major", description = "major APIs")
@Controller
@RequestMapping("/rest/{version}/major")
public class MajorController extends BaseController {
	
	@Autowired
	private MajorService majorService;
	
	/**  
	* @Title: save  
	* @Description: save
	* @param @param para
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/save", method=RequestMethod.POST )
	@ResponseBody
	@ApiOperation(value="保存 major",notes="Notes：保存 major.需要传参数： para={\"xxx\": \"xxx\", \"yyyy\": \"yyyy\" }. Post请求.",position=1,response=Map.class)
	public Map<String, Object> save(@RequestParam(value="para", required=true) String para){
		Major record;
		try {
			record = readJsonStr2Object(para,Major.class);
		} catch (Exception e1) {
			return generateErrorResult("Parameter is wrong!");
		}
		System.out.println(record);
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			result = majorService.save(record);
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}

	
	
	/**  
	* @Title: saveOrUpdate  
	* @Description: saveOrUpdate
	* @param @param para
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/saveOrUpdate", method=RequestMethod.POST )
	@ResponseBody
	@ApiOperation(value="更新 major",notes="Notes：更新 major.需要传参数： para={\"id\": \"123\", \"xxx\": \"xxx\", \"yyyy\": \"yyyy\" }. Post请求.",position=2,response=Map.class)
	public Map<String, Object> saveOrUpdate(@RequestParam(value="para", required=true) String para){
		Major record;
		try {
			record = readJsonStr2Object(para,Major.class);
		} catch (Exception e1) {
			return generateErrorResult("Parameter is wrong!");
		}
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			result = majorService.saveOrUpdate(record);
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}
	
	/**  
	* @Title: delete  
	* @Description: delete 
	* @param @param para
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/delete", method=RequestMethod.POST )
	@ResponseBody
	@ApiOperation(value="按照id进行POST传参删除数据",notes="按照id进行POST传参删除数据.需要传参数： para={\"id\": \"123\"} 指定id...Post请求.",response=Map.class)
	public Map<String, Object> delete(@RequestParam(value="para", required=true) String para){
		Major record;
		try {
			record = readJsonStr2Object(para,Major.class);
		} catch (Exception e1) {
			return generateErrorResult("Parameter is wrong!");
		}
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			result = majorService.delete(record);
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}
	
	/**  
	* @Title: query  
	* @Description: query 
	* @param @param para
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/query", method=RequestMethod.POST )
	@ResponseBody
	@ApiOperation(value="分页查询列表",notes="分页查询列表，需要传参数： para={\"startPage\": \"1\", \"pageSize\": \"2\" }. Post请求.",response=Map.class)
	public Map<String, Object> query(@RequestParam(value="para", required=true) String para){
		Major record;
		try {
			record = readJsonStr2Object(para,Major.class);
		} catch (Exception e1) {
			return generateErrorResult("Parameter is wrong!");
		}
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			result = majorService.selectOneByPrimaryKey(record.getId());
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}
	
	/**  
	* @Title: queryListByPage  
	* @Description: queryListByPage 
	* @param @param para
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/queryListByPage",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="分页查询列表",notes="分页查询列表，需要传参数： para={\"startPage\": \"1\", \"pageSize\": \"2\" }. Post请求.",response=Map.class)
	public Map<String, Object> queryListByPage(@RequestParam(value="para", required=true) String para){
		Major record;
		try {
			record = readJsonStr2Object(para,Major.class);
		} catch (Exception e1) {
			return generateErrorResult("Parameter is wrong!");
		}
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			result = majorService.queryListByPage(record);
		} catch (Exception e) {
			result = generateErrorResult(e);
		}
		return result;
	}
	

	/**  
	* @Title: list  
	* @Description: list 
	* @param @param startPage 1,2,3...
	* @param @param pageSize
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	@RequestMapping(value="/list/{startPage}/{pageSize}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="按照startPage和pageSize分页查询列表",notes="分页查询列表，无需传参数，指定 startPage和pageSize;// startPage: 1,2,3...1st page, 2nd page, 3rd page.... Get请求.",response=Map.class)
	public Map<String, Object> list(@PathVariable(value="startPage")int startPage,@PathVariable(value="pageSize")int pageSize)
	{
		Map<String, Object> result = new HashMap<String, Object>();

		// 分页处理开始
        HttpServletRequest request = getRequest();
        // 分页flag
        String draw = request.getParameter("draw");
        // 分页起始位置
        String start = request.getParameter("start");
        // 页数
        String length =  request.getParameter("length");
        // draw不为空说明是页面请求
        if (draw != null) {
        	//这种情况是给后台管理调用。使用table的默认参数 draw,start,length。
            // 处理起始页数
        	startPage = (Integer.valueOf(start)/Integer.valueOf(length))+1;
            // 页数
        	pageSize = Integer.valueOf(length);
        	try {
        		result = majorService.queryListByPage(startPage,pageSize);
        	} catch (Exception e) {
        		result.put("res", "1");
        		result.put("message", "Error-"+e.getMessage());
        	}
        }else{
        	//这种情况是给API调用。
        	try {
        		result = majorService.queryListByPage(startPage,pageSize);
        	} catch (Exception e) {
        		result.put("res", "1");
        		result.put("message", "Error-"+e.getMessage());
        	}
        }

        return result;
	}

	/**  
	* @Title: detail  
	* @Description: detail 
	* @param @param id 主键id
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据id查询",notes="根据id查询，传参数id。 Get请求.",response=Map.class)
	public Map<String, Object> detail(@PathVariable(value="id")int id)
	{
		Map<String, Object> result = majorService.selectOneByPrimaryKey(id);
        return result;
	}
	
	
	/**  
	* @Title: deleteById  
	* @Description: deleteById 
	* @param @param id
	* @param @return    设定文件  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/deleteById/{id}",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="按照id删除数据",notes="按照id删除数据，无需传参数，指定id...Post请求.",response=Map.class)
	public Map<String, Object> deleteById(@PathVariable(value="id") int id)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		try 
		{
			Major record = new Major();
			record.setId(id);
			result = majorService.delete(record);
			
		} catch (Exception e){
			result = generateErrorResult(e);
		}
		return result;

	}
	
}
