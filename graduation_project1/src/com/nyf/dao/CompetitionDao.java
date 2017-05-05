package com.nyf.dao;

import java.util.List;

import com.nyf.projo.Competition;

public interface CompetitionDao extends BaseDao {
	List<Competition> selectByLogin_id(int id);
}
