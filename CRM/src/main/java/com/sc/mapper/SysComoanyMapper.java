package com.sc.mapper;

import com.sc.bean.SysComoany;
import com.sc.bean.SysComoanyExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysComoanyMapper {
    int countByExample(SysComoanyExample example);

    int deleteByExample(SysComoanyExample example);

    int deleteByPrimaryKey(BigDecimal comId);

    int insert(SysComoany record);

    int insertSelective(SysComoany record);

    List<SysComoany> selectByExample(SysComoanyExample example);

    SysComoany selectByPrimaryKey(Long comId);

    int updateByExampleSelective(@Param("record") SysComoany record, @Param("example") SysComoanyExample example);

    int updateByExample(@Param("record") SysComoany record, @Param("example") SysComoanyExample example);

    int updateByPrimaryKeySelective(SysComoany record);

    int updateByPrimaryKey(SysComoany record);
}