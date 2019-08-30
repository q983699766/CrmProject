package com.sc.mapper;

import com.sc.bean.SysDuty;
import com.sc.bean.SysDutyExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDutyMapper {
    int countByExample(SysDutyExample example);

    int deleteByExample(SysDutyExample example);

    int deleteByPrimaryKey(BigDecimal dutId);

    int insert(SysDuty record);

    int insertSelective(SysDuty record);

    List<SysDuty> selectByExample(SysDutyExample example);

    SysDuty selectByPrimaryKey(BigDecimal dutId);

    int updateByExampleSelective(@Param("record") SysDuty record, @Param("example") SysDutyExample example);

    int updateByExample(@Param("record") SysDuty record, @Param("example") SysDutyExample example);

    int updateByPrimaryKeySelective(SysDuty record);

    int updateByPrimaryKey(SysDuty record);
}