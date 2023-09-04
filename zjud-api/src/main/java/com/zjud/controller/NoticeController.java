package com.zjud.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zjud.model.dto.notice.NoticePublishRequest;
import com.zjud.model.dto.user.UserRegisterRequest;
import com.zjud.model.entity.Notice;
import com.zjud.response.Response;
import com.zjud.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/30 15:24
 * @description 公告Controller
 */
@RestController
@RequestMapping("/notice")
@Api(tags = {"公告接口"})
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    // 用户
    @GetMapping("/latest")
    @ApiOperation("获取最新公告(无需登录)")
    public Response<Notice> getLatestNotice() {
        return noticeService.getLatestNotice();
    }
    // 管理员
    @GetMapping("/admin/history")
    @ApiOperation("获取历史公告列表")
    public Response<List<Notice>> history() {
        return noticeService.history();
    }

    @PostMapping("/admin/publish")
    @ApiOperation("发布公告")
    public Response<Boolean> publish(@Validated @RequestBody NoticePublishRequest noticePublishRequest) {
        return noticeService.publish(noticePublishRequest);
    }

    @DeleteMapping("/admin/remove/{id}")
    @ApiOperation("根据id删除公告")
    public Response<Boolean> removeNotice(@PathVariable Long id) {
        return noticeService.removeNotice(id);
    }

    @DeleteMapping("/admin/remove")
    @ApiOperation("批量删除公告")
    public Response<Boolean> removeNoticeBatch(@RequestBody List<Long> ids) {
        return noticeService.removeNoticeBatch(ids);
    }

    @GetMapping("/admin/{id}")
    @ApiOperation("根据id获取公告")
    public Response<Notice> detail(@PathVariable Long id) {
        return noticeService.detail(id);
    }



}
