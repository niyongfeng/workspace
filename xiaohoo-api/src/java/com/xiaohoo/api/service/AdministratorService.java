package com.xiaohoo.api.service;

import com.xiaohoo.api.domain.Administrator;

import java.util.List;

/**
 * Created by yangyuming on 2017/4/12.
 */
public interface AdministratorService {

    /**
     * 新增新闻
     * @param administrstor
     * @return
     */
    void add(Administrator administrator);

    /**
     * 管理员列表
     * @param administrator
     * @return
     */
    List<Administrator> list(Administrator administrator);

    /**
     * 删除管理员
     * @param administrator
     * @return
     */
    void delete(Administrator administrator);
}
