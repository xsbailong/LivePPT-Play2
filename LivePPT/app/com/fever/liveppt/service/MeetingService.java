package com.fever.liveppt.service;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

import com.fever.liveppt.models.Ppt;
import com.fever.liveppt.models.User;

public interface MeetingService {
	
	/**
	 * 新建会议
	 * @param founder
	 * @param ppt
	 * @param topic
	 */
	public void foundNewMeeting(Long founderId, Long pptId, String topic);
	
	/**
	 * 删除会议
	 * @param meetingId
	 */
	public void deleteMeeting(Long meetingId);
	
	/**
	 * 获取用户观看的会议
	 * @param userId
	 */
	public ArrayNode getAttendingMeetingsList(Long userId);

}
