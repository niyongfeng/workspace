package com.nyf.api.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.xiaohoo.api.domain.GroupMomentScroe;
import com.xiaohoo.api.service.impl.GroupMembersServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:config/spring/biz/datasource.xml"})
public class NYFTest {

	@Autowired
	private GroupMembersServiceImpl groupMembersServiceImp;

//	@Test
//	public void test() {
//		System.out.println("groupMembersServiceImp:" + groupMembersServiceImp);
//		Integer a = new Integer(1);
//		Integer b = new Integer(3);
//		System.out.println(groupMembersServiceImp.getGroupMembers(a, b));
//	}
	
	
	@Test
	public void testStatusMark() {
		System.out.println("groupMembersServiceImp" + groupMembersServiceImp);
		GroupMomentScroe groupMomentScroe = new GroupMomentScroe();
		groupMomentScroe.setScore(9);
		groupMomentScroe.setUserId(1);
		groupMomentScroe.setGroupMomentsId(1);
		boolean b = groupMembersServiceImp.statusMark(groupMomentScroe);
		System.out.println(b);
	}
	
	
//	@Test
//	public void testTipOff() {
//		TipOff tipOff = new TipOff();
//		tipOff.setDescription("11111");
//		boolean b = groupMembersServiceImp.tipOff(tipOff);
//		System.out.println(b);
//	}
	
//	@Test
//	public void testGetGroupMomentResponse() {
//		Integer a = 1;
//		List<GroupMomentResponse> list = groupMembersServiceImp.getGroupMomentResponse(a);
//		System.out.println(list.size());
//		System.out.println(list);
////		for(GroupMomentResponse g : list) {
////			System.out.println(g);
////		}
//	}
	
//	@Test
//	public void testResponseTo() {
//		GroupMomentResponse g = new GroupMomentResponse();
//		g.setGroupMomentsId(2);
//		g.setResponseBy(1);
//		g.setResponseTo(2);
//		g.setContent("1回复给2");
//		System.out.println(groupMembersServiceImp.responseTo(g));
//	}

}
