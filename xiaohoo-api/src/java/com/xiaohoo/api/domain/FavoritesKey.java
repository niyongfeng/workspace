package com.xiaohoo.api.domain;

public class FavoritesKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column favorites.id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column favorites.user_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column favorites.id
     *
     * @return the value of favorites.id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column favorites.id
     *
     * @param id the value for favorites.id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column favorites.user_id
     *
     * @return the value of favorites.user_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column favorites.user_id
     *
     * @param userId the value for favorites.user_id
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}