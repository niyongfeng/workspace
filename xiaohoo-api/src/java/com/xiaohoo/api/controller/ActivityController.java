/**
 * 
 */
package com.xiaohoo.api.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohoo.api.controller.base.BaseController;
import com.xiaohoo.api.domain.Activity;
import com.xiaohoo.api.domain.User;
import com.xiaohoo.api.domain.request.ActivitySearchRequest;
import com.xiaohoo.api.service.ActivityService;

/**
 * 活动
 * 
 * @author haojwang
 *
 */
@Controller
@RequestMapping("/rest/{version}/activity")
public class ActivityController extends BaseController {

	@Autowired
	ActivityService activityService;

	/**
	 * 活动详情，包括收费类型（多个）
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "活动详情", notes = "para={\"activityId\":1}.", response = Map.class)
	public Map<String, Object> detail(
			@RequestParam(value = "para", required = true) String para) {

		Integer activityId = readJsonStr2SingleNode(para, "activityId").asInt();

		Activity activity = activityService.getActivityDetail(activityId);
		Map<String, Object> map = generateNomalResult(activity);

		return map;
	}

	/**
	 * 加入活动 {"activityId":1}
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/joinin", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "参加活动", notes = "para={\"activityId\":1}.", response = Map.class)
	public Map<String, Object> joinInActivity(
			@RequestParam(value = "para", required = true) String para) {

		User user = getUserInfoFromSession();
		Integer activityId = readJsonStr2SingleNode(para, "activityId").asInt();

		if (!activityService.joinInActivity(user.getId(), activityId)) {
			return generateErrorResult("活动参加人数已满");
		}

		return generateNomalResult(activityId);
	}

	/**
	 * 活动列表
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据获得活动列表", notes = "para={\"type\":\"Recommend\",\"page\":1}. com.xiaohoo.api.domain.enums.ActivityType", response = Map.class)
	public Map<String, Object> list(
			@RequestParam(value = "para", required = true) String para) {

		User user = getUserInfoFromSession();
		String type = readJsonStr2SingleNode(para, "type").asText();
		Integer page = readJsonStr2SingleNode(para, "page").asInt();
		List<Activity> activities = activityService.getActivitiesByType(user,
				type, page);
		return generateNomalResult(activities);
	}

	/**
	 * 已参加活动列表
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/userlist", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户已参加活动", notes = "para={\"page\":1}.", response = Map.class)
	public Map<String, Object> userInList(
			@RequestParam(value = "para", required = true) String para) {

		User user = getUserInfoFromSession();
		Integer page = readJsonStr2SingleNode(para, "page").asInt();
		List<Activity> activities = activityService.getUserActivities(user,
				page);
		return generateNomalResult(activities);
	}

	/**
	 * 活动搜索
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "搜索活动列表", notes = "para={\"date\":\"2007-05-15\",\"location\":\"杭州\",\"keywords\":\"徒步\",\"page\":1}", response = Map.class)
	public Map<String, Object> search(
			@RequestParam(value = "para", required = true) String para) {

		ActivitySearchRequest search = readJsonStr2Object(para,
				ActivitySearchRequest.class);
		List<Activity> activites = activityService
				.getActivitiesBySearch(search);
		return generateNomalResult(activites);
	}

	/**
	 * 收藏活动
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/favorites", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "收藏活动", notes = "para={\"activityId\":1,\"activityName\":\"行走的意义\"}.", response = Map.class)
	public Map<String, Object> addFavorites(
			@RequestParam(value = "para", required = true) String para) {

		Integer activityId = readJsonStr2SingleNode(para, "activityId").asInt();
		String activityName = readJsonStr2SingleNode(para, "activityName")
				.asText();
		User user = getUserInfoFromSession();
		Integer favoriteId = activityService.addFavorite(activityId,
				activityName, user);
		return generateNomalResult(favoriteId);
	}

	/**
	 * 显示收藏活动列表
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/listfavorites", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "显示收藏列表", notes = "para={\"page\":1}.", response = Map.class)
	public Map<String, Object> listFavorites(
			@RequestParam(value = "para", required = true) String para) {

		Integer page = readJsonStr2SingleNode(para, "page").asInt();
		User user = getUserInfoFromSession();
		List<Activity> activites = activityService.listFavorites(user, page);
		return generateNomalResult(activites);
	}

	/**
	 * 删除收藏内容
	 * 
	 * @param para
	 * @return
	 */
	@RequestMapping(value = "/deletefavorites", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "删除收藏活动", notes = "para={\"favoritesId\":1}.", response = Map.class)
	public Map<String, Object> deleteFavorites(
			@RequestParam(value = "para", required = true) String para) {

		Integer favoritesId = readJsonStr2SingleNode(para, "favoritesId")
				.asInt();
		Integer favoriteId = activityService
				.deleteActivityInFavorites(favoritesId);
		return generateNomalResult(favoriteId);
	}
}
