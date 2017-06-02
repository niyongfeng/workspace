package com.xiaohoo.api.domain;

import java.util.Date;

public class BankType extends BaseDomain {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_type.id
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_type.name
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_type.is_delete
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    private Integer isDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_type.create_time
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bank_type.update_time
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_type.id
     *
     * @return the value of bank_type.id
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_type.id
     *
     * @param id the value for bank_type.id
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_type.name
     *
     * @return the value of bank_type.name
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_type.name
     *
     * @param name the value for bank_type.name
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_type.is_delete
     *
     * @return the value of bank_type.is_delete
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_type.is_delete
     *
     * @param isDelete the value for bank_type.is_delete
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_type.create_time
     *
     * @return the value of bank_type.create_time
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_type.create_time
     *
     * @param createTime the value for bank_type.create_time
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bank_type.update_time
     *
     * @return the value of bank_type.update_time
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bank_type.update_time
     *
     * @param updateTime the value for bank_type.update_time
     *
     * @mbggenerated Sun Mar 12 23:14:32 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}