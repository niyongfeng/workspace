package com.xiaohoo.api.domain;

import java.util.Date;

public class Major extends BaseDomain {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column major.id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column major.name
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column major.collage_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Integer collageId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column major.description
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column major.create_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column major.update_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column major.id
     *
     * @return the value of major.id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column major.id
     *
     * @param id the value for major.id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column major.name
     *
     * @return the value of major.name
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column major.name
     *
     * @param name the value for major.name
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column major.collage_id
     *
     * @return the value of major.collage_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Integer getCollageId() {
        return collageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column major.collage_id
     *
     * @param collageId the value for major.collage_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setCollageId(Integer collageId) {
        this.collageId = collageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column major.description
     *
     * @return the value of major.description
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column major.description
     *
     * @param description the value for major.description
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column major.create_time
     *
     * @return the value of major.create_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column major.create_time
     *
     * @param createTime the value for major.create_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column major.update_time
     *
     * @return the value of major.update_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column major.update_time
     *
     * @param updateTime the value for major.update_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}