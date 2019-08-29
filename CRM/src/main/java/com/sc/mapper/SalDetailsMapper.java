package com.sc.mapper;

import com.sc.bean.SalDetails;
import com.sc.bean.SalDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalDetailsMapper {
    int countByExample(SalDetailsExample example);

    int deleteByExample(SalDetailsExample example);

    int deleteByPrimaryKey(Long detailsId);

    int insert(SalDetails record);

    int insertSelective(SalDetails record);

    List<SalDetails> selectByExample(SalDetailsExample example);

    SalDetails selectByPrimaryKey(Long detailsId);

    int updateByExampleSelective(@Param("record") SalDetails record, @Param("example") SalDetailsExample example);

    int updateByExample(@Param("record") SalDetails record, @Param("example") SalDetailsExample example);

    int updateByPrimaryKeySelective(SalDetails record);

    int updateByPrimaryKey(SalDetails record);
}