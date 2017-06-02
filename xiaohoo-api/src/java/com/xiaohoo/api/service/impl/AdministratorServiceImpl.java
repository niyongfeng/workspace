package com.xiaohoo.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaohoo.api.dao.AdministratorMapper;
import com.xiaohoo.api.domain.Administrator;
import com.xiaohoo.api.domain.AdministratorExample;
import com.xiaohoo.api.service.AdministratorService;

/**
 * 管理员接口实现
 * Created by yangyuming on 2017/4/12.
 */

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;


    /**
     * 新增管理员
     *
     * @param administrator
     * @return
     */
    @Override
    public void add(Administrator administrator) {
        administratorMapper.insertSelective(administrator);
    }

    /**
     * 管理员列表
     *
     * @param administrator
     * @return
     */
    @Override
    public List<Administrator> list(Administrator administrator) {

        AdministratorExample example = new AdministratorExample();
        example.setOrderByClause("create_time desc");// 创建时间降序排序
        example.setStartRow(administrator.getStartRow() * administrator.getPageSize());
        example.setPageSize(administrator.getPageSize());
        example.setIs_delete(0);

        List<Administrator> result = administratorMapper.selectByExample(example);

        return result;
    }

    /**
     * 删除管理员
     *
     * @param administrator
     * @return
     */
    @Override
    public void delete(Administrator administrator) {
        administrator.setIsDelete(1);
        administratorMapper.removeByPrimaryKey(administrator);
//        administratorMapper.deleteByPrimaryKey(administrator.getUid());
    }
}
