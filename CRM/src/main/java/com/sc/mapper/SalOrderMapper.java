package com.sc.mapper;

import com.sc.bean.SalOrder;
import com.sc.bean.SalOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalOrderMapper {
    int countByExample(SalOrderExample example);

    int deleteByExample(SalOrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(SalOrder record);

    int insertSelective(SalOrder record);

    List<SalOrder> selectByExample(SalOrderExample example);

    SalOrder selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") SalOrder record, @Param("example") SalOrderExample example);

    int updateByExample(@Param("record") SalOrder record, @Param("example") SalOrderExample example);

    int updateByPrimaryKeySelective(SalOrder record);

    int updateByPrimaryKey(SalOrder record);
}