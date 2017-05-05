package com.qk.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qk.Object.Question;

public class QuestionJDBCTest {
	private static Question question;
	private static int  player_id;
	private static int id;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		question=new Question();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		player_id=1;
		id=1;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearcheAll() {
		List<Question> list=BesuperDao.searchQuestionALL();
		Assert.assertEquals("ddddd", 9, list.size());
	}
	
	@Test
	public void testSearcheMine() {
		List<Question> list=BesuperDao.searchQuestionMINE(player_id);
		Assert.assertEquals("ddddd", 7, list.size());
	}
	
	@Test
	public void testSearcheByID() {
		question=BesuperDao.searchQuestionID(id);
		Assert.assertNotNull("为空", question);
	}
	
	@Test
	public void testInsert() {
		question.setValue("你到底是谁");
		question.setIsOpen("y");
		question.setPlayer_id(3);
		question.setCredit(20);
		int i=BesuperDao.insertQuestion(question);
		Assert.assertEquals("插入失败",1, i);
	}
	
	@Test
	public void testUpdate() {
		question.setValue("我为什么这么帅");
		question.setIsOpen("y");
		question.setCredit(100);
		question.setId(3);
		int i=BesuperDao.updateQuestion(question);
		Assert.assertEquals("更改失败",1, i);
	}
	

}
