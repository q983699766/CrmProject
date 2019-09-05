package com.sc.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.bean.SysDuty;
import com.sc.bean.SysDutyExample;

public interface SysDutyMapper {
    int countByExample(SysDutyExample example);

    int deleteByExample(SysDutyExample example);

    int deleteByPrimaryKey(Long dutId);

    int insert(SysDuty record);

    int insertSelective(SysDuty record);

    List<SysDuty> selectByExample(SysDutyExample example);

    SysDuty selectByPrimaryKey(Long dutId);

    int updateByExampleSelective(@Param("record") SysDuty record, @Param("example") SysDutyExample example);

    int updateByExample(@Param("record") SysDuty record, @Param("example") SysDutyExample example);

    int updateByPrimaryKeySelective(SysDuty record);

    int updateByPrimaryKey(SysDuty record);
    
	List<SysDuty> findByNames(@Param("dutName") String dutName,@Param("lastTime")Date lastTime);
}