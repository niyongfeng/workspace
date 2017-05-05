package com.qk.DAO;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qk.Object.Player;

public class LoginAndSignJDBCTest {
	private static String username;
	private static String password;
	private static String nickname;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		username="25648";
		password="123456";
		nickname="hello";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Player player=BesuperDao.toLogin(username, password);
		Assert.assertNotNull(player);
	}
	@Test
	public void test2(){
		Player player=BesuperDao.SignUp(nickname, username, password);
		Assert.assertNotNull(player);
	}
	@Test
	public void test3(){
		Player player=BesuperDao.searchPlayer(36);
		System.out.println(player.toString());
		Assert.assertNotNull("没有找到用户",player);
	}
	
	

}
