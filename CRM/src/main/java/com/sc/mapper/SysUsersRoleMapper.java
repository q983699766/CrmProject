package com.sc.mapper;

import com.sc.bean.SysUsersRole;
import com.sc.bean.SysUsersRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUsersRoleMapper {
    int countByExample(SysUsersRoleExample example);

    int deleteByExample(SysUsersRoleExample example);

    int deleteByPrimaryKey(Long userRoleId);

    int insert(SysUsersRole record);

    int insertSelective(SysUsersRole record);

    List<SysUsersRole> selectByExample(SysUsersRoleExample example);

    SysUsersRole selectByPrimaryKey(Long userRoleId);

    int updateByExampleSelective(@Param("record") SysUsersRole record, @Param("example") SysUsersRoleExample example);

    int updateByExample(@Param("record") SysUsersRole record, @Param("example") SysUsersRoleExample example);

    int updateByPrimaryKeySelective(SysUsersRole record);

    int updateByPrimaryKey(SysUsersRole record);
}