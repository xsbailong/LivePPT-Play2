package com.fever.liveppt.utils;

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
 * @author 黎伟杰
 */
public class StatusCode {
    //一切正常
    public final static int SUCCESS = 0;
    public final static String SUCCESS_MESSAGE = "success";

    //****************通用***********************
    //缺少参数或参数格式有误
    public final static int INVALID_PARAMS = -101;
    public final static String INVALID_PARAMS_MESSAGE = "invalid params";
    //服务器内部错误
    public final static int INTERNAL_ERROR = -102;
    public final static String INTERNAL_ERROR_MESSAGE = "internal error";
    //Token 无效或过期
    public final static int INVALID_TOKEN = -103;
    public final static String INVALID_TOKEN_MESSAGE = "invalid token";
    //未知错误
    public final static int UNKONWN_ERROR = -999;
    public final static String UNKONWN_ERROR_MESSAGE  = "unknown error";
    //****************用户类型错误*****************
    //用户已存在
    public final static int USER_EXISTED = -201;
    public final static String USER_EXISTED_MESSAGE = "same user email existed";
    //该email用户未注册
    public final static int USER_NOT_EXISTED = -202;
    public final static String USER_NOT_EXISTED_MESSAGE = "no such user email existed";
    //用户的账号密码配对失败
    public final static int PASSWORD_NOT_MATCH = -203;
    public final static String PASSWORD_NOT_MATCH_MESSAGE = "user email and password not match";
    //*******************PPT类型错误*****************
    //PPT不存在
    public final static int PPT_NOT_EXISTED = -301;
    public final static String PPT_NOT_EXISTED_MESSAGE = "no such ppt";
    //PPT页码超出范围
    public final static int PPT_PAGE_OUT_OF_RANGE = -302;
    public final static String PPT_PAGE_OUT_OF_RANGE_MESSAGE = "page out of range";
    //PPT未转换
    public final static int PPT_NOT_CONVERTED = -303;
    public final static String PPT_NOT_CONVERTED_MESSAGE = "ppt not converted";
    //PPT文件类型不正确
    // 文件并非PPT或PPTX（ContentType不是"application/vnd.ms-powerpoint"或” application/vnd.openxmlformats-officedocument.presentationml.presentation”），或文件名结尾并非以“.ppt”或“.pptx”结束
    public final static int PPT_FILE_INVALID_TYPE = -304;
    public final static String PPT_FILE_INVALID_TYPE_MESSAGE = "file not ppt or pptx";

    //用户密码错误
    public final static int USER_PASSWORD_ERROR = 1100;
    //用户不存在
    //public final static int USER_NOT_EXISTED = 1101;
    //用户email字段错误
    public final static int USER_EMAIL_ERROR = 1102;
    //用户Id字段错误
    public final static int USER_ID_ERROR = 1103;
    //用户昵称错误
    public final static int USER_DISPLAYNAME_ERROR = 1103;


    //****************PPT类型错误*****************
    //PPT不存在
    //public final static int PPT_NOT_EXISTED = 2100;
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
}
