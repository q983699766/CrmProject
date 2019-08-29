package com.sc.mapper;

import com.sc.bean.SalFeedback;
import com.sc.bean.SalFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalFeedbackMapper {
    int countByExample(SalFeedbackExample example);

    int deleteByExample(SalFeedbackExample example);

    int deleteByPrimaryKey(Long feedbackId);

    int insert(SalFeedback record);

    int insertSelective(SalFeedback record);

    List<SalFeedback> selectByExample(SalFeedbackExample example);

    SalFeedback selectByPrimaryKey(Long feedbackId);

    int updateByExampleSelective(@Param("record") SalFeedback record, @Param("example") SalFeedbackExample example);

    int updateByExample(@Param("record") SalFeedback record, @Param("example") SalFeedbackExample example);

    int updateByPrimaryKeySelective(SalFeedback record);

    int updateByPrimaryKey(SalFeedback record);
}