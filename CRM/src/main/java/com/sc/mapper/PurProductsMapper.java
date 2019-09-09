package com.sc.mapper;

import com.sc.bean.PurProducts;
import com.sc.bean.PurProductsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurProductsMapper {
    int countByExample(PurProductsExample example);

    int deleteByExample(PurProductsExample example);

    int deleteByPrimaryKey(Long proId);

    int insert(PurProducts record);

    int insertSelective(PurProducts record);

    List<PurProducts> selectByExample(PurProductsExample example);
    
    List<PurProducts> selectByExamplel(PurProductsExample example);

    PurProducts selectByPrimaryKey(Long proId);

    int updateByExampleSelective(@Param("record") PurProducts record, @Param("example") PurProductsExample example);

    int updateByExample(@Param("record") PurProducts record, @Param("example") PurProductsExample example);

    int updateByPrimaryKeySelective(PurProducts record);

    int updateByPrimaryKey(PurProducts record);
    
    PurProducts selectByid(Long productid);
    
}