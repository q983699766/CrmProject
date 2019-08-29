package com.sc.mapper;

import com.sc.bean.OfficeChecktask;
import com.sc.bean.OfficeChecktaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficeChecktaskMapper {
    int countByExample(OfficeChecktaskExample example);

    int deleteByExample(OfficeChecktaskExample example);

    int deleteByPrimaryKey(Long taskId);

    int insert(OfficeChecktask record);

    int insertSelective(OfficeChecktask record);

    List<OfficeChecktask> selectByExample(OfficeChecktaskExample example);

    OfficeChecktask selectByPrimaryKey(Long taskId);

    int updateByExampleSelective(@Param("record") OfficeChecktask record, @Param("example") OfficeChecktaskExample example);

    int updateByExample(@Param("record") OfficeChecktask record, @Param("example") OfficeChecktaskExample example);

    int updateByPrimaryKeySelective(OfficeChecktask record);

    int updateByPrimaryKey(OfficeChecktask record);
}