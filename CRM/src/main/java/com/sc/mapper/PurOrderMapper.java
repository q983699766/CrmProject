package com.sc.mapper;

import com.sc.bean.PurOrder;
import com.sc.bean.PurOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurOrderMapper {
    int countByExample(PurOrderExample example);

    int deleteByExample(PurOrderExample example);

    int deleteByPrimaryKey(Long purNumber);

    int insert(PurOrder record);

    int insertSelective(PurOrder record);

    List<PurOrder> selectByExample(PurOrderExample example);

    PurOrder selectByPrimaryKey(Long purNumber);

    int updateByExampleSelective(@Param("record") PurOrder record, @Param("example") PurOrderExample example);

    int updateByExample(@Param("record") PurOrder record, @Param("example") PurOrderExample example);

    int updateByPrimaryKeySelective(PurOrder record);

    int updateByPrimaryKey(PurOrder record);
}