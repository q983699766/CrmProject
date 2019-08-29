package com.sc.mapper;

import com.sc.bean.SalBleed;
import com.sc.bean.SalBleedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalBleedMapper {
    int countByExample(SalBleedExample example);

    int deleteByExample(SalBleedExample example);

    int deleteByPrimaryKey(Long churnId);

    int insert(SalBleed record);

    int insertSelective(SalBleed record);

    List<SalBleed> selectByExample(SalBleedExample example);

    SalBleed selectByPrimaryKey(Long churnId);

    int updateByExampleSelective(@Param("record") SalBleed record, @Param("example") SalBleedExample example);

    int updateByExample(@Param("record") SalBleed record, @Param("example") SalBleedExample example);

    int updateByPrimaryKeySelective(SalBleed record);

    int updateByPrimaryKey(SalBleed record);
}