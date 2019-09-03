package com.sc.mapper;

import com.sc.bean.SysEmpuser;
import com.sc.bean.SysEmpuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysEmpuserMapper {
    int countByExample(SysEmpuserExample example);

    int deleteByExample(SysEmpuserExample example);

    int deleteByPrimaryKey(Long empId);

    int insert(SysEmpuser record);

    int insertSelective(SysEmpuser record);

    List<SysEmpuser> selectByExample(SysEmpuserExample example);

    SysEmpuser selectByPrimaryKey(Long empId);

    int updateByExampleSelective(@Param("record") SysEmpuser record, @Param("example") SysEmpuserExample example);

    int updateByExample(@Param("record") SysEmpuser record, @Param("example") SysEmpuserExample example);

    int updateByPrimaryKeySelective(SysEmpuser record);

    int updateByPrimaryKey(SysEmpuser record);
}