package com.xiaohoo.api.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ActivityPayment extends ActivityPaymentKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_payment.title
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_payment.amount
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_payment.status
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_payment.create_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_payment.update_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_payment.title
     *
     * @return the value of activity_payment.title
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_payment.title
     *
     * @param title the value for activity_payment.title
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_payment.amount
     *
     * @return the value of activity_payment.amount
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_payment.amount
     *
     * @param amount the value for activity_payment.amount
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_payment.status
     *
     * @return the value of activity_payment.status
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_payment.status
     *
     * @param status the value for activity_payment.status
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_payment.create_time
     *
     * @return the value of activity_payment.create_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_payment.create_time
     *
     * @param createTime the value for activity_payment.create_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_payment.update_time
     *
     * @return the value of activity_payment.update_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_payment.update_time
     *
     * @param updateTime the value for activity_payment.update_time
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}