package com.qyt.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.qyt.pojo.User;
import com.qyt.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:mybatis_spring.xml"})
public class UserServiceTest {
	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
	private	User user = new User();
	@Resource
	private UserService us;
	@Test
	public void login() {
		user.setLogin_name("qieyanteng");
		user.setPassword("123456");
		List<User> u = us.selectIsLogin1(user);
		if(u.size() != 0) { 
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	
	@Test 
	public void addUsre() {
		User u = new User();
		u.setLogin_name("");
	}
 }
