package com.example.activititest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.activititest.mapper.MeunModelMapper;
import com.example.activititest.po.MeunModel;
import com.example.activititest.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MeunModelMapper,MeunModel> implements MenuService {

    @Resource
    private MeunModelMapper meunModelMapper;

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<MeunModel> getAllMeun() {
        return meunModelMapper.getAllMeun();
    }

    /**
     * 根据idc查询菜单
     * @param id
     * @return
     */
    @Override
    public List<MeunModel> getMeunById(Integer id) {
        return meunModelMapper.getMeunById(id);
    }

    /**
     * 查询除父菜单以外的菜单
     * @return
     */
    @Override
    public List<MeunModel> selectAllNotParent() {
        return meunModelMapper.selectAllNotParent();
    }

    @Override
    public void updateMenuById(Integer id, Integer newParentId) {
        meunModelMapper.updateMenuById(id,newParentId);
    }

    public static void main(String[] args) {
        String osName = "linux";
        System.err.println(osName.indexOf("linux"));
    }
}
