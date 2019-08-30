package com.sc.mapper;

import com.sc.bean.OfficeTaskdetail;
import com.sc.bean.OfficeTaskdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficeTaskdetailMapper {
    int countByExample(OfficeTaskdetailExample example);

    int deleteByExample(OfficeTaskdetailExample example);

    int deleteByPrimaryKey(Long idd);

    int insert(OfficeTaskdetail record);

    int insertSelective(OfficeTaskdetail record);

    List<OfficeTaskdetail> selectByExample(OfficeTaskdetailExample example);

    OfficeTaskdetail selectByPrimaryKey(Long idd);

    int updateByExampleSelective(@Param("record") OfficeTaskdetail record, @Param("example") OfficeTaskdetailExample example);

    int updateByExample(@Param("record") OfficeTaskdetail record, @Param("example") OfficeTaskdetailExample example);

    int updateByPrimaryKeySelective(OfficeTaskdetail record);

    int updateByPrimaryKey(OfficeTaskdetail record);
}