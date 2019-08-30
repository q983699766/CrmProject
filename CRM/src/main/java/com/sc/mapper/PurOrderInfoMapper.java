package com.sc.mapper;

import com.sc.bean.PurOrderInfo;
import com.sc.bean.PurOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurOrderInfoMapper {
    int countByExample(PurOrderInfoExample example);

    int deleteByExample(PurOrderInfoExample example);

    int deleteByPrimaryKey(Long purInfoNumber);

    int insert(PurOrderInfo record);

    int insertSelective(PurOrderInfo record);

    List<PurOrderInfo> selectByExample(PurOrderInfoExample example);

    PurOrderInfo selectByPrimaryKey(Long purInfoNumber);

    int updateByExampleSelective(@Param("record") PurOrderInfo record, @Param("example") PurOrderInfoExample example);

    int updateByExample(@Param("record") PurOrderInfo record, @Param("example") PurOrderInfoExample example);

    int updateByPrimaryKeySelective(PurOrderInfo record);

    int updateByPrimaryKey(PurOrderInfo record);
}