package com.xiaohoo.api.dao;

import com.xiaohoo.api.domain.Friends;
import com.xiaohoo.api.domain.FriendsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int countByExample(FriendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int deleteByExample(FriendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int insert(Friends record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int insertSelective(Friends record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    List<Friends> selectByExample(FriendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    Friends selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByExampleSelective(@Param("record") Friends record, @Param("example") FriendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByExample(@Param("record") Friends record, @Param("example") FriendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByPrimaryKeySelective(Friends record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByPrimaryKey(Friends record);

}