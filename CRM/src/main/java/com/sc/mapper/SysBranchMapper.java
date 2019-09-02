package com.sc.mapper;

import com.sc.bean.SysBranch;
import com.sc.bean.SysBranchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysBranchMapper {
    int countByExample(SysBranchExample example);

    int deleteByExample(SysBranchExample example);

    int deleteByPrimaryKey(Long secId);

    int insert(SysBranch record);

    int insertSelective(SysBranch record);

    List<SysBranch> selectByExample(SysBranchExample example);

    SysBranch selectByPrimaryKey(Long secId);

    int updateByExampleSelective(@Param("record") SysBranch record, @Param("example") SysBranchExample example);

    int updateByExample(@Param("record") SysBranch record, @Param("example") SysBranchExample example);

    int updateByPrimaryKeySelective(SysBranch record);

    int updateByPrimaryKey(SysBranch record);
}