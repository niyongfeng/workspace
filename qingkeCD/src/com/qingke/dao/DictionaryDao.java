package com.qingke.dao;

import java.util.List;

import com.qingke.pojo.Dictionary;

public interface DictionaryDao {
	int insert(Dictionary dictionary);
	List<Dictionary> selectByWord(String word);
	List<Dictionary> select();
	List<Dictionary> selectByWord1(String word);
}
