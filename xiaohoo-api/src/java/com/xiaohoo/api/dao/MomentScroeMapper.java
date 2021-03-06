package com.xiaohoo.api.dao;

import com.xiaohoo.api.domain.MomentScroe;
import com.xiaohoo.api.domain.MomentScroeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MomentScroeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int countByExample(MomentScroeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int deleteByExample(MomentScroeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int insert(MomentScroe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int insertSelective(MomentScroe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    List<MomentScroe> selectByExample(MomentScroeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    MomentScroe selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByExampleSelective(@Param("record") MomentScroe record, @Param("example") MomentScroeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByExample(@Param("record") MomentScroe record, @Param("example") MomentScroeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByPrimaryKeySelective(MomentScroe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment_scroe
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByPrimaryKey(MomentScroe record);
}