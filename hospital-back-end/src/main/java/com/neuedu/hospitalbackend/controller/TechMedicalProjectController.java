package com.neuedu.hospitalbackend.controller;

import com.neuedu.hospitalbackend.model.vo.ProjectParam;
import com.neuedu.hospitalbackend.model.vo.PatientParam;
import com.neuedu.hospitalbackend.service.serviceimplementation.medicaltechstationservice.TechMedicalProjectServiceImpl;
import com.neuedu.hospitalbackend.util.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/techproject")
@CrossOrigin
public class TechMedicalProjectController {

    @Resource
    private TechMedicalProjectServiceImpl techMedicalProjectServiceImpl;

    @ApiOperation("（根据病历号或患者姓名）获取所有待登记患者列表")
    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public CommonResult listPatientByCaseIdOrName(PatientParam patientParam)
    {
        return techMedicalProjectServiceImpl.listPreparedPatientsByCaseIdOrName(patientParam);
    }

    @ApiOperation("选中患者，查看已申请的检查/检验项目详情")
    @RequestMapping(value = "/patient-projects", method = RequestMethod.GET)
    public CommonResult listAppliedProjectsByCaseId(PatientParam patientParam){
        return techMedicalProjectServiceImpl.listAppliedProjectsByCaseId(patientParam);
    }

    @ApiOperation("选中项目登记")
    @RequestMapping(value = "/project-checkin", method = RequestMethod.PUT)
    public CommonResult checkInProject(@RequestBody ProjectParam projectParam){
        return techMedicalProjectServiceImpl.checkInProject(projectParam);
        // 后端再次确认项目状态 为 已缴费且未登记
    }

    @ApiOperation("选中项目取消登记")
    @RequestMapping(value = "/project-cancel", method = RequestMethod.PUT)
    public CommonResult cancelProject(@RequestBody ProjectParam projectParam){
        return techMedicalProjectServiceImpl.cancelProject(projectParam);
        // 后端再次确认项目状态 为 已缴费且未登记
    }

    @ApiOperation("根据病历号，获取所有未录入结果项目列表")
    @RequestMapping(value = "/noresult", method = RequestMethod.GET)
    public CommonResult listCheckedInButNotRecordedProject(PatientParam patientParam){
        return techMedicalProjectServiceImpl.listCheckedInButNotRecordedProject(patientParam);
        // 后端再次确认项目状态 为 已缴费且未登记
    }

    @ApiOperation("录入项目结果")
    @RequestMapping(value = "/resultinput/{caseId}", method = RequestMethod.PUT)
    public CommonResult recordResult(@RequestBody ProjectParam projectParam){
        return techMedicalProjectServiceImpl.recordResult(projectParam);
        // 后端再次确认项目状态 为 已缴费且未登记
    }

}