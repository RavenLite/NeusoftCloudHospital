package com.neuedu.hospitalbackend.service.serviceinterface.finicialservice;

import com.alibaba.fastjson.JSONObject;

/**
 * 6.4 门诊医生工作量统计
 * 应用场景：用于财务工作人员统计指定时间段的医生工作量
 * @author Raven
 */
public interface DoctorStatisticsService {

    /**
     * 操作员输入统计起始和终止时间，点击查询按钮，查询看诊人次、发票数量、各分项收入及总收入情况。
     * 通过点击导出按钮，对统计结果进行导出。（导出操作在前端完成）
     * @param object
     * @return
     */
    JSONObject doctorStatistics(JSONObject object);
}