package com.qk.DAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qk.Object.Answer;
import com.qk.Object.Question;

public class AnswerJDBCTest {
	private static Answer answer;
	private static int player_id;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		player_id=1;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchAnswerALL() {
		List<Answer> list=new ArrayList<Answer>();
		list=BesuperDao.searchAnswerALL();
		Assert.assertNotNull(list);
	}

	@Test
	public void testSearchAnswerMINE() {
		List<Answer> list=new ArrayList<Answer>();
		list=BesuperDao.searchAnswerMINE(player_id);
		Assert.assertNotNull(list);
	}

	@Test
	public void testSearchQuestionAllAnswer() {
		int question_id=3;
		List<Answer> list=BesuperDao.searchQuestionAllAnswer(question_id);
		Assert.assertNotNull(list);
		
	}

	@Test
	public void testSearchAnswerByID() {
		int answer_id=3;
		answer=BesuperDao.searchAnswerByID(answer_id);
		Assert.assertNotNull(answer);
	}

	@Test
	public void testInsertAnswer() {
		Answer an=new Answer();
		an.setBest("n");
		an.setPlayer_id(3);
		an.setQuestion_id(3);
		an.setValue("我不是你爸爸");
		
		int i=BesuperDao.insertAnswer(an);
		Assert.assertEquals("插入失败" ,i, 1);
	}

	@Test
	public void testUpdateAnswer() {
		Answer an=new Answer();
		an.setId(5);
		an.setBest("y");
		an.setPlayer_id(3);
		an.setQuestion_id(3);
		an.setValue("你好");
		int i=BesuperDao.updateAnswer(an);
		Assert.assertEquals("更改失败" ,i, 1);	
	}

	@Test
	public void testAcceptAnswer() {
		Question qu=new Question();
		qu=BesuperDao.searchQuestionID(3);
		Answer an=new Answer();
		an=BesuperDao.searchAnswerByID(5);
		boolean f=BesuperDao.acceptAnswer(qu, an);
		Assert.assertEquals(false, f);
	}

}
