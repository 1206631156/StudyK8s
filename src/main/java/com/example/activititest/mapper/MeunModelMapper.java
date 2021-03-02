package com.example.activititest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.activititest.po.MeunModel;

import java.util.List;

public interface MeunModelMapper extends BaseMapper<MeunModel> {
    List<MeunModel> getAllMeun();

    List<MeunModel> getMeunById(Integer id);

    List<MeunModel> selectAllNotParent();

    void updateMenuById(Integer id, Integer newParentId);



}
