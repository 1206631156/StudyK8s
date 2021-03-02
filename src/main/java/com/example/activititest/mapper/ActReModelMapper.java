package com.example.activititest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.activititest.po.ActReModel;
import com.example.activititest.po.ActReModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActReModelMapper extends BaseMapper<ActReModel> {
    long countByExample(ActReModelExample example);

    int deleteByExample(ActReModelExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActReModel record);

    int insertSelective(ActReModel record);

    List<ActReModel> selectByExample(ActReModelExample example);

    ActReModel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActReModel record, @Param("example") ActReModelExample example);

    int updateByExample(@Param("record") ActReModel record, @Param("example") ActReModelExample example);

    int updateByPrimaryKeySelective(ActReModel record);

    int updateByPrimaryKey(ActReModel record);
}
