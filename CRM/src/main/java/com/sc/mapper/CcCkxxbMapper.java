package com.sc.mapper;

import com.sc.bean.CcCkxxb;
import com.sc.bean.CcCkxxbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcCkxxbMapper {
    int countByExample(CcCkxxbExample example);

    int deleteByExample(CcCkxxbExample example);

    int deleteByPrimaryKey(Long ckBh);

    int insert(CcCkxxb record);

    int insertSelective(CcCkxxb record);

    List<CcCkxxb> selectByExample(CcCkxxbExample example);

    CcCkxxb selectByPrimaryKey(Long ckBh);

    int updateByExampleSelective(@Param("record") CcCkxxb record, @Param("example") CcCkxxbExample example);

    int updateByExample(@Param("record") CcCkxxb record, @Param("example") CcCkxxbExample example);

    int updateByPrimaryKeySelective(CcCkxxb record);

    int updateByPrimaryKey(CcCkxxb record);
}