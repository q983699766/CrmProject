package com.sc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.bean.SysCOMPANY;
import com.sc.bean.SysCOMPANYExample;

public interface SysCOMPANYMapper {
    int countByExample(SysCOMPANYExample example);

    int deleteByExample(SysCOMPANYExample example);

    int deleteByPrimaryKey(Long comId);

    int insert(SysCOMPANY record);

    int insertSelective(SysCOMPANY record);

    List<SysCOMPANY> selectByExample(SysCOMPANYExample example);

    SysCOMPANY selectByPrimaryKey(Long comId);

    int updateByExampleSelective(@Param("record") SysCOMPANY record, @Param("example") SysCOMPANYExample example);

    int updateByExample(@Param("record") SysCOMPANY record, @Param("example") SysCOMPANYExample example);

    int updateByPrimaryKeySelective(SysCOMPANY record);

    int updateByPrimaryKey(SysCOMPANY record);
}