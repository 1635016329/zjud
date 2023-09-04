package com.zjud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.exception.BusinessException;
import com.zjud.model.dto.notice.NoticePublishRequest;
import com.zjud.model.entity.Notice;
import com.zjud.response.Response;
import com.zjud.response.ResponseCode;
import com.zjud.service.NoticeService;
import com.zjud.mapper.NoticeMapper;
import com.zjud.util.ResultUtils;
import com.zjud.util.ThrowUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86178
* @description 针对表【notice(公告表)】的数据库操作Service实现
* @createDate 2023-08-30 15:18:50
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

    //用户
    @Override
    public Response<Notice> getLatestNotice() {
        QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();
        noticeQueryWrapper.orderByDesc("publish_date");
        List<Notice> list = list(noticeQueryWrapper);
        Notice notice = list.get(0);
        return ResultUtils.success(notice);
    }

    //管理员
    @Override
    public Response<List<Notice>> history() {
        QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();
        noticeQueryWrapper.orderByDesc("publish_date");
        List<Notice> list = list(noticeQueryWrapper);
        return ResultUtils.success(list);
    }

    @Override
    public Response<Boolean> publish(NoticePublishRequest noticePublishRequest) {
        Notice notice = BeanUtil.copyProperties(noticePublishRequest, Notice.class);
        boolean save = save(notice);
        ThrowUtils.throwIf(!save, new BusinessException(ResponseCode.NOTICE_PUBLISH_FAIL));
        return ResultUtils.success(ResponseCode.NOTICE_PUBLISH_SUCCESS, true);
    }

    @Override
    public Response<Boolean> removeNotice(Long id) {
        boolean remove = removeById(id);
        ThrowUtils.throwIf(!remove, ResponseCode.FAIL);
        return ResultUtils.success(true);
    }

    @Override
    public Response<Boolean> removeNoticeBatch(List<Long> ids) {
        boolean remove = removeBatchByIds(ids);
        ThrowUtils.throwIf(!remove, ResponseCode.FAIL);
        return ResultUtils.success(true);
    }

    @Override
    public Response<Notice> detail(Long id) {
        Notice notice = getById(id);
        ThrowUtils.throwIf(notice == null, new BusinessException(ResponseCode.FAIL));
        return ResultUtils.success(notice);
    }


}




