package com.sc.mapper;

import com.sc.bean.SalConper;
import com.sc.bean.SalConperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalConperMapper {
    int countByExample(SalConperExample example);

    int deleteByExample(SalConperExample example);

    int deleteByPrimaryKey(Long conperId);

    int insert(SalConper record);

    int insertSelective(SalConper record);

    List<SalConper> selectByExample(SalConperExample example);

    SalConper selectByPrimaryKey(Long conperId);

    int updateByExampleSelective(@Param("record") SalConper record, @Param("example") SalConperExample example);

    int updateByExample(@Param("record") SalConper record, @Param("example") SalConperExample example);

    int updateByPrimaryKeySelective(SalConper record);

    int updateByPrimaryKey(SalConper record);
}