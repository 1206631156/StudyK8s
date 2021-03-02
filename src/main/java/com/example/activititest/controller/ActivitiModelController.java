package com.example.activititest.controller;

import com.example.activititest.base.ResultDTO;
import com.example.activititest.po.ActReModel;
import com.example.activititest.service.ActivitiModelService;
import com.example.activititest.utils.ResultUtils;
import org.activiti.engine.repository.Model;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ActivitiModelController
 * 流程定义模型管理
 * 对流程的部署 有两种方式1.可以通过事先画好的流程图 进行部署。
 * 2.通过创建模型 ，并且通过官方提供的模型制作界面画出流程图 进行部署
 * 说明：第一种 可以通过convertToModel方法 转化成第二种方法
 */
@RestController
@RequestMapping("model")
public class ActivitiModelController  {

    @Autowired
    private ActivitiModelService activitiModelService;

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return RestResponse
     */
    @RequestMapping("/list")
    public ResultDTO list(String modelName,Integer startPage,Integer pageSize) {
        Map<String,Object> param = new HashMap<>();
        if(StringUtils.isNotEmpty(modelName)){
            param.put("modelName",modelName);
        }else if(null == startPage || null ==pageSize){
            param.put("startPage",1);
            param.put("pageSize",10);
        }else{
            param.put("modelName",modelName);
            param.put("startPage",1);
            param.put("pageSize",10);
        }
        return activitiModelService.queryPage(param);
    }

    /**
     * 新增模型
     *
     * @param actReModel actReModel
     * @return RestResponse
     */
    @RequestMapping("/save")
    public ResultDTO save(@RequestBody ActReModel actReModel) {
        Model model = null;
        try {
            model = activitiModelService.add(actReModel);
        } catch (Exception e) {
            ResultUtils.getFail(e.getMessage());
        }
        return ResultUtils.getResultDTO(1,"新增成功",model);
    }

    /**
     * 根据Model部署流程文件
     *
     * @param id 标识
     * @return RestResponse
     */
    @RequestMapping("/deploy")
    public ResultDTO deploy(String id) {
        String msg = activitiModelService.deploy(id);
        return ResultUtils.getSuccess(msg);
    }

    /**
     * 导出model的xml文件
     *
     * @param id       model标识
     * @param response 响应
     */
    @RequestMapping(value = "export")
    public void export(String id, HttpServletResponse response) {
        activitiModelService.export(id, response);
    }

    /**
     * 根据主键删除
     *
     * @param id id
     * @return RestResponse
     */
    @RequestMapping("/delete")
    public ResultDTO delete(@RequestBody String id) {
        activitiModelService.delete(id);
        return ResultUtils.getSuccess(null);
    }

    /**
     * 根据主键批量删除
     *
     * @param ids ids
     * @return RestResponse
     */
    @RequestMapping("/batchDelete")
    public ResultDTO batchDelete(@RequestBody String[] ids) {
        activitiModelService.deleteBatch(ids);
        return ResultUtils.getSuccess(null);
    }



}
