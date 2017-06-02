/**
 * 
 */
package com.xiaohoo.api.controller;

import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohoo.api.controller.base.BaseController;
import com.xiaohoo.api.domain.Group;
import com.xiaohoo.api.domain.GroupMomentResponse;
import com.xiaohoo.api.domain.GroupMoments;
import com.xiaohoo.api.domain.User;
import com.xiaohoo.api.service.GroupService;

/**
 * 社群
 * 
 * @author haojwang
 *
 */
@Controller
@RequestMapping("/rest/{version}/group")
public class GroupController extends BaseController {

	@Autowired
	GroupService groupService;

	/**
	 * 用户申请开通社群权限
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户申请开通社群权限", notes = "para={\"studentCard\":\"http://****.png\",\"studentUnionCard\":\"http://****.png\"}.", response = Map.class)
	public Map<String, Object> apply(
			@RequestParam(value = "para", required = true) String para) {

		String studentCard = readJsonStr2SingleNode(para, "studentCard")
				.asText();
		String studentUnionCard = readJsonStr2SingleNode(para,
				"studentUnionCard").asText();
		User user = getUserInfoFromSession();
		Integer nid = groupService.userApplyRole(user, studentCard,
				studentUnionCard);

		return generateNomalResult(nid);
	}

	/**
	 * 后台审批用户权限申请
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/approvalrole", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "后台审批用户权限申请", notes = "para={\"userId\":1,\"status\":\"Success\",\"comments\":\"approval\"}. "
			+ "status:com.xiaohoo.api.domain.enums.UserApplyRoleStatus", response = Map.class)
	public Map<String, Object> adminApprovalRole(
			@RequestParam(value = "para", required = true) String para) {

		Integer userId = readJsonStr2SingleNode(para, "userId").asInt();
		String status = readJsonStr2SingleNode(para, "status").asText();
		String comments = readJsonStr2SingleNode(para, "comments").asText();

		boolean result = groupService.approvalUserApplication(userId, status,
				comments);

		return generateNomalResult(result);
	}

	/**
	 * 增加社群（主办人）
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户开通社群", notes = "para={\"name\":\"旅行的意义\",\"description\":\"一起走\",\"logo\":\"http://***.png\",\"backgroundImage\":\"http://***.png\"}.", response = Map.class)
	public Map<String, Object> save(
			@RequestParam(value = "para", required = true) String para) {

		Group group = readJsonStr2Object(para, Group.class);
		User user = getUserInfoFromSession();
		if (user.getLevel() == null || user.getLevel() != 1) {
			return generateErrorResult("no permission!");
		}
		boolean result = groupService.newGroup(user, group);

		return generateNomalResult(result);
	}

	/**
	 * 删除社群（只有主办人可以）
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}

	/**
	 * 社群详情
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> detail(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}

	/**
	 * 社群列表（根据类型）
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}

	/**
	 * 搜索社群
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> search(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}

	/**
	 * 我的社群列表
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/mylist", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> myList(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}

	/**
	 * 加入社群
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "加入社群", notes = "para={\"groupId\":1}.", response = Map.class)
	public Map<String, Object> joinInGroup(
			@RequestParam(value = "para", required = true) String para) {
		Integer groupId = readJsonStr2SingleNode(para, "groupId").asInt();
		User user = getUserInfoFromSession();
		if (!groupService.joinInGroup(user.getId(), groupId)) {
			return generateErrorResult("社群人数已满");
		}
		return generateNomalResult(groupId);
	}

	/**
	 * 退出社群
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/quit", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> quitGroup(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}

	/**
	 * 打分
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/score", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> score(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}

	/**
	 * 发布社群状态
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/newreocrd", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户发布社群状态", notes = "para={\"groupId\":1,\"content\":\"出去走走\",\"image0\":\"http://**image0\",\"image1\":\"http://**image1\",\"image2\":\"http://**image2\",\"image3\":\"http://**image3\",\"image4\":\"\",\"image5\":\"\",\"image6\":\"\",\"image7\":\"\",\"image8\":\"\",\"image9\":\"\"}.", response = Map.class)
	public Map<String, Object> newRecord(
			@RequestParam(value = "para", required = true) String para) {

		GroupMoments moments = readJsonStr2Object(para, GroupMoments.class);
		User user = getUserInfoFromSession();
		boolean result = groupService.newMoments(user, moments);
		return generateNomalResult(result);
	}

	/**
	 * 回复社群状态
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/newreocrdresponse", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "回复社群状态", notes = "para={\"groupMomentsId\":\"1\",\"content\":\"一起走\",\"responseTo\",\"1\"}.", response = Map.class)
	public Map<String, Object> newRecordResponse(
			@RequestParam(value = "para", required = true) String para) {

		User user = getUserInfoFromSession();
		GroupMomentResponse mResponse = readJsonStr2Object(para,
				GroupMomentResponse.class);

		boolean result = groupService.newMomentsResponse(user, mResponse);
		return generateNomalResult(result);
	}

	/**
	 * 删除社群记录（管理员，发布者）
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/deletereocrd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteRecord(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}

	/**
	 * 社群参与人员列表
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> users(
			@RequestParam(value = "para", required = true) String para) {

		Map<String, Object> result = new HashMap<String, Object>();
		// TODO
		return result;
	}
}
