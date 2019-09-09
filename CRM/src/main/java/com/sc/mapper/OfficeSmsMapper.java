package com.sc.mapper;

import com.sc.bean.OfficeSms;
import com.sc.bean.OfficeSmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficeSmsMapper {
    int countByExample(OfficeSmsExample example);

    int deleteByExample(OfficeSmsExample example);

    int deleteByPrimaryKey(Long smsId);

    int insert(OfficeSms record);

    int insertSelective(OfficeSms record);

    List<OfficeSms> selectByExample(OfficeSmsExample example);

    OfficeSms selectByPrimaryKey(Long smsId);

    int updateByExampleSelective(@Param("record") OfficeSms record, @Param("example") OfficeSmsExample example);

    int updateByExample(@Param("record") OfficeSms record, @Param("example") OfficeSmsExample example);

    int updateByPrimaryKeySelective(OfficeSms record);

    int updateByPrimaryKey(OfficeSms record);
    
    public List<OfficeSms> selectall();
}