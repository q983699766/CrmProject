package com.sc.mapper;

import com.sc.bean.OfficeGrant;
import com.sc.bean.OfficeGrantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficeGrantMapper {
    int countByExample(OfficeGrantExample example);

    int deleteByExample(OfficeGrantExample example);

    int deleteByPrimaryKey(Long relId);

    int insert(OfficeGrant record);

    int insertSelective(OfficeGrant record);

    List<OfficeGrant> selectByExample(OfficeGrantExample example);

    OfficeGrant selectByPrimaryKey(Long relId);

    int updateByExampleSelective(@Param("record") OfficeGrant record, @Param("example") OfficeGrantExample example);

    int updateByExample(@Param("record") OfficeGrant record, @Param("example") OfficeGrantExample example);

    int updateByPrimaryKeySelective(OfficeGrant record);

    int updateByPrimaryKey(OfficeGrant record);
}