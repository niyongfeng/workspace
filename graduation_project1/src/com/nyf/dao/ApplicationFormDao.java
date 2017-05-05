package com.nyf.dao;

import java.util.List;

import com.nyf.projo.ApplicationForm;

public interface ApplicationFormDao extends BaseDao {
	List<ApplicationForm> selectByVolunteer(ApplicationForm a);
	List<ApplicationForm> selectByVolunteer_id(int a);
}
