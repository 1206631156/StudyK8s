package com.example.activititest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.activititest.po.MeunModel;

import java.util.List;

public interface MenuService extends IService<MeunModel> {

    List<MeunModel> getAllMeun();

    List<MeunModel> getMeunById(Integer id);

    List<MeunModel> selectAllNotParent();

    void updateMenuById(Integer id, Integer newParentId);
}
