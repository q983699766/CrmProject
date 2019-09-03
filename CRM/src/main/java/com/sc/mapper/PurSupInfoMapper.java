package com.sc.mapper;

import com.sc.bean.PurSupInfo;
import com.sc.bean.PurSupInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurSupInfoMapper {
    int countByExample(PurSupInfoExample example);

    int deleteByExample(PurSupInfoExample example);

    //通过id删除
    int deleteByPrimaryKey(Long supInfoNum);

     //添加
    int insert(PurSupInfo pursupinfo);

    int insertSelective(PurSupInfo record);

     //查询所有
    List<PurSupInfo> selectByExample(PurSupInfoExample example);

     //通过id查询
    PurSupInfo selectByPrimaryKey(Long supInfoNum);

    int updateByExampleSelective(@Param("record") PurSupInfo record, @Param("example") PurSupInfoExample example);

    int updateByExample(@Param("record") PurSupInfo record, @Param("example") PurSupInfoExample example);

    int updateByPrimaryKeySelective(PurSupInfo record);

     //通过id更新
    int updateByPrimaryKey(Long supinfonum);


	
}