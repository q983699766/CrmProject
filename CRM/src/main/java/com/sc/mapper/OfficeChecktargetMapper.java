package com.sc.mapper;

import com.sc.bean.OfficeChecktarget;
import com.sc.bean.OfficeChecktargetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficeChecktargetMapper {
    int countByExample(OfficeChecktargetExample example);

    int deleteByExample(OfficeChecktargetExample example);

    int deleteByPrimaryKey(Long targetId);

    int insert(OfficeChecktarget record);

    int insertSelective(OfficeChecktarget record);

    List<OfficeChecktarget> selectByExample(OfficeChecktargetExample example);

    OfficeChecktarget selectByPrimaryKey(Long targetId);

    int updateByExampleSelective(@Param("record") OfficeChecktarget record, @Param("example") OfficeChecktargetExample example);

    int updateByExample(@Param("record") OfficeChecktarget record, @Param("example") OfficeChecktargetExample example);

    int updateByPrimaryKeySelective(OfficeChecktarget record);

    int updateByPrimaryKey(OfficeChecktarget record);
}