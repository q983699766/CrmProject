package com.sc.mapper;

import com.sc.bean.PurSupInfo;
import com.sc.bean.PurSupInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurSupInfoMapper {
    int countByExample(PurSupInfoExample example);

    int deleteByExample(PurSupInfoExample example);

     //删除供应商信息 通过ID
    int deleteByPrimaryKey(Integer supInfoNum);

    int insert(PurSupInfo record);

    int insertSelective(PurSupInfo record);

    List<PurSupInfo> selectByExample(PurSupInfoExample example);

    //通过id 查询供应商信息
    PurSupInfo selectByPrimaryKey(Integer supInfoNum);

    int updateByExampleSelective(@Param("record") PurSupInfo record, @Param("example") PurSupInfoExample example);

    int updateByExample(@Param("record") PurSupInfo record, @Param("example") PurSupInfoExample example);

    int updateByPrimaryKeySelective(PurSupInfo record);

     //通过id修改供应商信息
    int updateByPrimaryKey(Integer supInfoNum);
}