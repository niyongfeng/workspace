package com.xiaohoo.api.controller;

/**
 * Created by yangyuming on 2017/4/12.
 */

import com.xiaohoo.api.controller.base.BaseController;
import com.xiaohoo.api.domain.Administrator;
import com.xiaohoo.api.service.AdministratorService;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 管理员接口
 * xiaohoo-web后台 增删改查
 */

@Controller
@RequestMapping("/rest/{version}/administrator")
public class AdministratorController extends BaseController {

    @Autowired
    private AdministratorService administratorService;


    /***
     * 新增管理员
     *
     * @param para
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public Map<String, Object> add(@RequestParam(value = "para", required = true) String para) {
        JSONObject jsStr = JSONObject.fromObject(para);
        Administrator dto = (Administrator) JSONObject.toBean(jsStr, Administrator.class);
        Map<String, Object> result = new HashMap<String, Object>();

        try {
            Map<String, Object> data = new HashMap<String, Object>();
            administratorService.add(dto);

            //  data.put("platform", list);
            result.put("data", data);
            result.put("res", "0");
            result.put("message", "Success");
        } catch (Exception e) {
            result.put("res", "1");
            result.put("message", "Error-" + e.getMessage());
        }

        return result;
    }


    /***
     * 管理员列表
     *
     * @param startRow 起始页码
     * @param pageSize 显示多少结果
     * @return
     */
    @RequestMapping(value = "/list/{startRow}/{pageSize}")
    @ResponseBody
    public Map<String, Object> list(@PathVariable(value = "startRow") int startRow,
                                    @PathVariable(value = "pageSize") int pageSize) {

        Map<String, Object> result = new HashMap<String, Object>();

        try {
            Map<String, Object> data = new HashMap<String, Object>();
            Administrator administrator = new Administrator();
            administrator.setStartRow(startRow);
            administrator.setPageSize(pageSize);
            List<Administrator> list = administratorService.list(administrator);

            data.put("administrator", list);
            result.put("data", data);
            result.put("res", "0");
            result.put("message", "Success");
        } catch (Exception e) {
            result.put("res", "1");
            result.put("message", "Error-" + e.getMessage());
        }

        return result;
    }

    /***
     * 删除管理员
     *
     * @param uid 管理员id
     * @return
     */
    @RequestMapping(value = "/delete/{uid}")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable(value = "uid") int uid) {

        Map<String, Object> result = new HashMap<String, Object>();

        try {
            Map<String, Object> data = new HashMap<String, Object>();
            Administrator administrator = new Administrator();
            administrator.setUid(uid);
            administratorService.delete(administrator);

            result.put("data", data);
            result.put("res", "0");
            result.put("message", "Success");
        } catch (Exception e) {
            result.put("res", "1");
            result.put("message", "Error-" + e.getMessage());
        }

        return result;
    }
}

