package com.example.activititest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.activititest.po.ActReProcDef;
import com.example.activititest.po.ActReProcDefExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActReProcDefMapper extends BaseMapper<ActReProcDef> {
    long countByExample(ActReProcDefExample example);

    int deleteByExample(ActReProcDefExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActReProcDef record);

    int insertSelective(ActReProcDef record);

    List<ActReProcDef> selectByExample(ActReProcDefExample example);

    ActReProcDef selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActReProcDef record, @Param("example") ActReProcDefExample example);

    int updateByExample(@Param("record") ActReProcDef record, @Param("example") ActReProcDefExample example);

    int updateByPrimaryKeySelective(ActReProcDef record);

    int updateByPrimaryKey(ActReProcDef record);
}
