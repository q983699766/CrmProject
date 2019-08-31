package com.sc.mapper;

import com.sc.bean.SysPermissionColumn;
import com.sc.bean.SysPermissionColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionColumnMapper {
    int countByExample(SysPermissionColumnExample example);

    int deleteByExample(SysPermissionColumnExample example);

    int deleteByPrimaryKey(Long columnId);

    int insert(SysPermissionColumn record);

    int insertSelective(SysPermissionColumn record);

    List<SysPermissionColumn> selectByExample(SysPermissionColumnExample example);

    SysPermissionColumn selectByPrimaryKey(Long columnId);

    int updateByExampleSelective(@Param("record") SysPermissionColumn record, @Param("example") SysPermissionColumnExample example);

    int updateByExample(@Param("record") SysPermissionColumn record, @Param("example") SysPermissionColumnExample example);

    int updateByPrimaryKeySelective(SysPermissionColumn record);

    int updateByPrimaryKey(SysPermissionColumn record);
}