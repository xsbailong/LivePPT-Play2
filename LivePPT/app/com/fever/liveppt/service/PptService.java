package com.fever.liveppt.service;

import com.fever.liveppt.exception.common.InternalErrorException;
import com.fever.liveppt.exception.common.InvalidParamsException;
import com.fever.liveppt.exception.ppt.PptNotConvertedException;
import com.fever.liveppt.exception.ppt.PptNotExistedException;
import com.fever.liveppt.exception.ppt.PptNotSelfOwnException;
import com.fever.liveppt.exception.ppt.PptPageOutOfRangeException;
import com.fever.liveppt.models.Ppt;
import com.fever.liveppt.models.User;
import com.fever.liveppt.utils.JsonResult;
import org.codehaus.jackson.JsonNode;

import java.io.File;
import java.util.List;

/**
 * PPT服务
 *
 * @author 梁博文
 */
public interface PptService {

    public byte[] getPptPage(Long pptId, Long pageId) throws PptNotExistedException, PptNotConvertedException, PptPageOutOfRangeException, InternalErrorException;

    public void updatePptConvertedStatus(JsonNode messageJson);

    /**
     * 获取指定PPT信息
     *
     * @param pptId
     * @return
     */
    public JsonResult getPptInfo(Long pptId);

    /**
     * 获取用户PPT信息列表
     *
     * @param userId
     * @return JSON格式PPT信息列表
     */
    public JsonResult getPptList(Long userId);

    /**
     * 获取用户PPT信息列表
     *
     * @param userEmail
     * @return JSON格式PPT信息列表
     */
    public List<Ppt> getPptList(String userEmail) throws InvalidParamsException;

    /**
     * 根据指定ID获取PPT信息
     *
     * @param pptId
     * @return
     */
    public Ppt getPpt(long pptId);

    /**
     * 上传PPT到S3并发送消息到SQS
     *
     * @param user
     * @param file
     * @param title
     * @param filesize
     */
    public void uploadPptToS3(User user, File file, String title, long filesize) throws InternalErrorException;

    /**
     * 删除PPT及其相关的会议和参与关系
     *
     * @param user
     * @param pptId
     */
    public void deletePpt(User user, long pptId) throws InternalErrorException, PptNotSelfOwnException;

    /*
    public byte[] getPptPageAsMid(Long pptId, Long pageId);

    public byte[] getPptPageAsBig(Long pptId, Long pageId);

    public byte[] getPptPageAsSmall(Long pptId, Long pageId);
    */
}