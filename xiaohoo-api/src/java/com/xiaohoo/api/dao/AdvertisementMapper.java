package com.xiaohoo.api.dao;

import com.xiaohoo.api.domain.Advertisement;
import com.xiaohoo.api.domain.AdvertisementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertisementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int countByExample(AdvertisementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int deleteByExample(AdvertisementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int insert(Advertisement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int insertSelective(Advertisement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    List<Advertisement> selectByExample(AdvertisementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    Advertisement selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByExampleSelective(@Param("record") Advertisement record, @Param("example") AdvertisementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByExample(@Param("record") Advertisement record, @Param("example") AdvertisementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByPrimaryKeySelective(Advertisement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertisement
     *
     * @mbggenerated Thu May 04 20:51:39 CST 2017
     */
    int updateByPrimaryKey(Advertisement record);
}