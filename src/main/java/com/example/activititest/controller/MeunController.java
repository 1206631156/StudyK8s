package com.example.activititest.controller;

import com.example.activititest.base.ResultDTO;
import com.example.activititest.po.MeunModel;
import com.example.activititest.service.MenuService;
import com.example.activititest.utils.ResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MeunController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/meunData")
    public ResultDTO meunData(){
        List<MeunModel> resultMeun = new ArrayList<>();

        //查询父菜单
        List<MeunModel> parentmeunModels = menuService.getMeunById(0);
        //查询除父菜单以外的菜单
        List<MeunModel> meunModels = menuService.selectAllNotParent();

        for (MeunModel menu : parentmeunModels) {
            List<MeunModel> menus = getChild( menu.getId(),meunModels);
            menu.setChildren(menus);
        }
        return ResultUtils.getResultDTO(1,"查询成功",parentmeunModels);
    }

    private List<MeunModel> getChild(Integer id,List<MeunModel> meunModels){
        List<MeunModel> childtMeun = new ArrayList<>();
        for(MeunModel meunModel : meunModels){
            if(id.equals(meunModel.getParentId())){
                //递归查询当前子菜单的子菜单
                List<MeunModel> iterateMenu = getChild(meunModel.getId(),meunModels);
                meunModel.setChildren(iterateMenu);
                childtMeun.add(meunModel);
            }
        }
        return childtMeun;
    }

    @RequestMapping("/updateMenuById")
    public ResultDTO updateMenuById(Integer id,Integer newParentId){
        if(null != id && null != newParentId){
            try{
                menuService.updateMenuById(id,newParentId);
                return ResultUtils.getResultDTO(1,"修改成功",null);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return ResultUtils.getFail(null);
    }
}
