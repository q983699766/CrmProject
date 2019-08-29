package com.sc.mapper;

import com.sc.bean.SalRecord;
import com.sc.bean.SalRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalRecordMapper {
    int countByExample(SalRecordExample example);

    int deleteByExample(SalRecordExample example);

    int deleteByPrimaryKey(Long recordId);

    int insert(SalRecord record);

    int insertSelective(SalRecord record);

    List<SalRecord> selectByExample(SalRecordExample example);

    SalRecord selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") SalRecord record, @Param("example") SalRecordExample example);

    int updateByExample(@Param("record") SalRecord record, @Param("example") SalRecordExample example);

    int updateByPrimaryKeySelective(SalRecord record);

    int updateByPrimaryKey(SalRecord record);
}