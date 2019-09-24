package com.sc.mapper;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Ccspxxb;
import com.sc.bean.CcspxxbExample;
import com.sc.bean.SalOrder;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcspxxbMapper {
    int countByExample(CcspxxbExample example);

    int deleteByExample(CcspxxbExample example);

    int deleteByPrimaryKey(Long productId);

    int insert(Ccspxxb record);

    int insertSelective(Ccspxxb record);

    List<Ccspxxb> selectByExample(CcspxxbExample example);

    Ccspxxb selectByPrimaryKey(Long productId);

    int updateByExampleSelective(@Param("record") Ccspxxb record, @Param("example") CcspxxbExample example);

    int updateByExample(@Param("record") Ccspxxb record, @Param("example") CcspxxbExample example);

    int updateByPrimaryKeySelective(Ccspxxb record);

    int updateByPrimaryKey(Ccspxxb record);
    
    
    List<Ccspxxb> selectByExamplel( Ccspxxb ccspxx);
    
}