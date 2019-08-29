package com.sc.mapper;

import com.sc.bean.OfficePersonalAgenda;
import com.sc.bean.OfficePersonalAgendaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficePersonalAgendaMapper {
    int countByExample(OfficePersonalAgendaExample example);

    int deleteByExample(OfficePersonalAgendaExample example);

    int deleteByPrimaryKey(Long scheduleId);

    int insert(OfficePersonalAgenda record);

    int insertSelective(OfficePersonalAgenda record);

    List<OfficePersonalAgenda> selectByExample(OfficePersonalAgendaExample example);

    OfficePersonalAgenda selectByPrimaryKey(Long scheduleId);

    int updateByExampleSelective(@Param("record") OfficePersonalAgenda record, @Param("example") OfficePersonalAgendaExample example);

    int updateByExample(@Param("record") OfficePersonalAgenda record, @Param("example") OfficePersonalAgendaExample example);

    int updateByPrimaryKeySelective(OfficePersonalAgenda record);

    int updateByPrimaryKey(OfficePersonalAgenda record);
}