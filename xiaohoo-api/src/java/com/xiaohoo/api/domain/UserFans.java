package com.xiaohoo.api.domain;

import java.util.Date;

public class UserFans {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_fans.id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_fans.user_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_fans.fans_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Integer fansId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_fans.fans_name
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private String fansName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_fans.create_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_fans.update_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_fans.id
     *
     * @return the value of user_fans.id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_fans.id
     *
     * @param id the value for user_fans.id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_fans.user_id
     *
     * @return the value of user_fans.user_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_fans.user_id
     *
     * @param userId the value for user_fans.user_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_fans.fans_id
     *
     * @return the value of user_fans.fans_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Integer getFansId() {
        return fansId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_fans.fans_id
     *
     * @param fansId the value for user_fans.fans_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_fans.fans_name
     *
     * @return the value of user_fans.fans_name
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public String getFansName() {
        return fansName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_fans.fans_name
     *
     * @param fansName the value for user_fans.fans_name
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setFansName(String fansName) {
        this.fansName = fansName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_fans.create_time
     *
     * @return the value of user_fans.create_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_fans.create_time
     *
     * @param createTime the value for user_fans.create_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_fans.update_time
     *
     * @return the value of user_fans.update_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_fans.update_time
     *
     * @param updateTime the value for user_fans.update_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}