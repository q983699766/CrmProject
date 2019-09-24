package com.sc.mapper;

import com.sc.bean.OfficeDetailSms;
import com.sc.bean.OfficeDetailSmsExample;
import com.sc.bean.OfficeSms;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficeDetailSmsMapper {
    int countByExample(OfficeDetailSmsExample example);

    int deleteByExample(OfficeDetailSmsExample example);

    int deleteByPrimaryKey(Long detailId);

    int insert(OfficeDetailSms record);

    int insertSelective(OfficeDetailSms record);

    List<OfficeDetailSms> selectByExample(OfficeDetailSmsExample example);

    OfficeDetailSms selectByPrimaryKey(Long detailId);

    int updateByExampleSelective(@Param("record") OfficeDetailSms record, @Param("example") OfficeDetailSmsExample example);

    int updateByExample(@Param("record") OfficeDetailSms record, @Param("example") OfficeDetailSmsExample example);

    int updateByPrimaryKeySelective(OfficeDetailSms record);

    int updateByPrimaryKey(OfficeDetailSms record);
    
    int updatestaByKey(OfficeDetailSms record) ;
    
    
    List<OfficeDetailSms> selectdetailsmsAndsms(OfficeSms officeSms);
    
    List<OfficeDetailSms> selectdetailsmsAndmysms(OfficeSms officeSms);
    
    List<OfficeDetailSms> selectdetailsmsAnduser(Long userId);
    
    List<OfficeDetailSms> selectdetailsmsAndall(Long userId);
    
    List<OfficeDetailSms> selectdetailread(OfficeSms officeSms);
    
    List<OfficeDetailSms> selectdetailread1(OfficeSms officeSms);
}