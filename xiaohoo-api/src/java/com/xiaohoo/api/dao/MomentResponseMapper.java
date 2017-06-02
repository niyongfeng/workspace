package com.xiaohoo.api.dao;

import com.xiaohoo.api.domain.MomentResponse;
import com.xiaohoo.api.domain.MomentResponseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MomentResponseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int countByExample(MomentResponseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int deleteByExample(MomentResponseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int insert(MomentResponse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int insertSelective(MomentResponse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    List<MomentResponse> selectByExample(MomentResponseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    MomentResponse selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByExampleSelective(@Param("record") MomentResponse record, @Param("example") MomentResponseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByExample(@Param("record") MomentResponse record, @Param("example") MomentResponseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByPrimaryKeySelective(MomentResponse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_response
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByPrimaryKey(MomentResponse record);
}