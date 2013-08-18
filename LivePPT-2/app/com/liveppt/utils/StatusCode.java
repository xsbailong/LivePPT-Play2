package com.liveppt.utils;

/**
 * 接口状态码信息
 * 1xxx 用户接口类错误码 
 * 2xxx PPT接口类错误码 
 * 3xxx会议接口类错误码 
 * x1xx 查询类错误
 * x2xx获取类错误
 * x3xx增加类错误
 * x4xx删除类错误
 * x5xx更改类错误
 * 9000操作成功
 * 
 * @author 黎伟杰，黄梓财
 *
 */
public class StatusCode {
	//一切正常
	public final static int ALL_IS_OK = 9000;
	//****************用户类型错误*****************
	//用户密码错误
	public final static int USER_PASSWORD_ERROR = 1100;
	//用户的Email不存在数据库中
	public final static int USER_EMAIL_NOT_EXISTED = 1101;
	//用户email字段错误
	public final static int USER_EMAIL_ERROR = 1102;
	//参数中用户Id字段不存在
	public final static int USER_ID_NOT_FOUND = 1103;
	//参数中用户昵称不存在
	public final static int USER_DISPLAY_NOT_FOUND = 1103;
    //参数中用户email不存在
    public final static int USER_EMAIL_NOT_FOUND = 1104;
    //参数中用户PASSWORD不存在
    public final static int USER_PASSWORD_NOT_FOUND = 1105;
    //参数中用户newPassword不存在
    public final static int USER_NEW_PASSWORD_NOT_FOUND = 1106;
    //参数中用户newDisplay不存在
    public final static int USER_NEW_DISPLAY_NOT_FOUND = 1107;
	//用户已存在
	public final static int USER_EMAIL_EXISTED = 1300;
    //没有登录
    public final static int USER_NO_LOGIN = 1108;

	//****************PPT类型错误*****************
	//PPT不存在
	public final static int PPT_NOT_EXISTED = 2100;
    //PPT_FILE_NOT_FOUND
    public final static int PPT_FILE_NOT_FOUND = 2103;
	//pptId错误
	public final static int PPT_ID_ERROR = 2101;
	//ppt的pageIndex字段错误
	public final static int PPT_PAGEINDEX_ERROR = 2102;
	//PPT列表为空
	public final static int PPT_LIST_NULL = 2200;
	
	//****************MEETING类型错误**************
	//meetingId字段错误
	public final static int MEETING_ID_ERROR = 3100;
	//用户不存在
	public final static int MEETING_USER_NOT_EXIST = 3101;
	//meeting的pageIndex字段错误
	public final static int MEETING_PAGEINDEX_ERROR = 3102;
	//根据meetingID查询的meeting不存在
	public final static int MEETING_NOT_EXISTED = 3200;	
	//topic字段错误
	public final static int MEETING_TOPIC_ERROR = 3300;	
	//删除会议错误
	public final static int MEETING_DELETE_MEETING_FAIL = 3400;

    //**************其他****************************
    //待补充错误
    public final static int TODO = 9999;
}
