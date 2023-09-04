package com.zjud.service;

import com.zjud.model.dto.notice.NoticePublishRequest;
import com.zjud.model.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjud.response.Response;

import java.util.List;

/**
* @author 86178
* @description 针对表【notice(公告表)】的数据库操作Service
* @createDate 2023-08-30 15:18:50
*/
public interface NoticeService extends IService<Notice> {

    /**
     * 获取最新发布公告
     * @return
     */
    Response<Notice> getLatestNotice();


    /**
     * 获取历史公告列表，根据时间排序
     * @return
     */
    Response<List<Notice>> history();

    /**
     * 发布公告
     * @param noticePublishRequest
     * @return
     */
    Response<Boolean> publish(NoticePublishRequest noticePublishRequest);

    /**
     * 删除公告
     * @param id
     * @return
     */
    Response<Boolean> removeNotice(Long id);

    /**
     * 根据id获取公告详情
     * @param id
     * @return
     */
    Response<Notice> detail(Long id);

    /**
     * 批量删除公告
     * @param ids
     * @return
     */
    Response<Boolean> removeNoticeBatch(List<Long> ids);
}
