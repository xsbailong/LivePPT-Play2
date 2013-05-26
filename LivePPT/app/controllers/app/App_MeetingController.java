package controllers.app;

import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import com.fever.liveppt.service.MeetingService;
import com.fever.liveppt.utils.JsonResult;
import com.fever.liveppt.utils.StatusCode;
import com.google.inject.Inject;

public class App_MeetingController extends Controller {
	@Inject
	MeetingService meetingService;

	/**
	 * 获取用户所有观看的会议的列表
	 * @param userId 用户Id
	 * @return
	 */
	public Result getMyAttendingMeetings() {
		Map<String, String[]> params = request().queryString();
		
		JsonResult resultJson;
		
		//检查userId
		resultJson = checkUserId(params);
		if (!resultJson.getStatusCode().equals(StatusCode.NONE))
			return ok(resultJson);		
		
		//获取参数
		Long userId = Long.parseLong(params.get("userId")[0]);
		
		ArrayNode attendingMeetingsArrayNode = meetingService
				.getMyAttendingMeetings(userId);
		resultJson = new JsonResult(true, attendingMeetingsArrayNode);
		Logger.info(resultJson.toString());
		return ok(resultJson);
	}
	
	/**
	 * 获取用户所有自己发起的会议的列表
	 * @return
	 */
	public Result getMyFoundedMeetings(){
		Map<String, String[]> params = request().queryString();
		
		JsonResult resultJson;
		
		//检查userId
		resultJson = checkUserId(params);
		if (!resultJson.getStatusCode().equals(StatusCode.NONE))
			return ok(resultJson);		
		
		//获取参数
		Long userId = Long.parseLong(params.get("userId")[0]);
		
		ArrayNode foundedMeetingsArrayNode = meetingService
				.getMyFoundedMeetings(userId);
		resultJson = new JsonResult(true, foundedMeetingsArrayNode);
		Logger.info(resultJson.toString());
		return ok(resultJson);
	}
	

	/**
	 * 获取指定会议的信息
	 * 
	 * @return
	 */
	public Result getMeetingInfo(){
		Map<String, String[]> params = request().queryString();
		
		JsonResult resultJson;
		
		//检查userId
		resultJson = checkMeetingId(params);
		if (!resultJson.getStatusCode().equals(StatusCode.NONE))
			return ok(resultJson);
		
		Long meetingId = Long.parseLong(params.get("meetingId")[0]);
		resultJson = meetingService.getMeetingInfo(meetingId);
		Logger.info(resultJson.toString());
		return ok(resultJson);
	}
	
	/**
	 * 设置会议的直播PPT页码
	 * @param meetingId
	 * @param pageIndex
	 * @return
	 */
	public Result setMeetingPageIndex() {
		Long meetingId;
		Long pageIndex;
		// 获取POST参数
		Map<String, String[]> params = request().body().asFormUrlEncoded();
		JsonResult resultJson;
		
		resultJson = checkMeetingId(params);
		if (!resultJson.getStatusCode().equals(StatusCode.NONE))
			return ok(resultJson);
		
		resultJson = checkPageIndex(params);
		if (!resultJson.getStatusCode().equals(StatusCode.NONE))
			return ok(resultJson);
		
		meetingId = Long.valueOf(params.get("meetingId")[0]);
		pageIndex = Long.valueOf(params.get("pageIndex")[0]);
		
		resultJson = meetingService.setMeetingPageIndex(meetingId, pageIndex);
		Logger.info(resultJson.toString());
		return ok(resultJson);
	}

	//数字匹配器
	Pattern patternNumbers = Pattern.compile("^[-\\+]?[\\d]*$");
	//检查userId字段
	JsonResult checkUserId(Map<String, String[]> params)
	{
		if (!params.containsKey("userId")){
			return new JsonResult(false, StatusCode.USER_ID_ERROR, "userId字段错误");
		}
		    
	    if (! patternNumbers.matcher(params.get("userId")[0]).matches())
	    	return new JsonResult(false, StatusCode.USER_ID_ERROR, "userId字段错误");
		return new JsonResult(true);
	}
	//检查meetingId字段
	JsonResult checkMeetingId(Map<String, String[]> params)
	{
		if (!params.containsKey("meetingId")){
			return new JsonResult(false, StatusCode.MEETING_ID_ERROR, "meetingId字段错误");
		}
		if (! patternNumbers.matcher(params.get("meetingId")[0]).matches())
			return new JsonResult(false, StatusCode.MEETING_ID_ERROR, "meetingId字段错误");
		return new JsonResult(true);
	} 
	//检查pageIndex字段
	JsonResult checkPageIndex(Map<String, String[]> params)
	{
		if (!params.containsKey("pageIndex")){
			return new JsonResult(false, StatusCode.MEETING_PAGEINDEX_ERROR, "pageIndex字段错误");
		}
		if (! patternNumbers.matcher(params.get("pageIndex")[0]).matches())
			return new JsonResult(false, StatusCode.MEETING_PAGEINDEX_ERROR, "pageIndex字段错误");
		return new JsonResult(true);
	} 
}
