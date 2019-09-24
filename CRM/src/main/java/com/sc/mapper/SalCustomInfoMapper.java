package com.sc.mapper;

import com.sc.bean.SalConper;
import com.sc.bean.SalConperExample;
import com.sc.bean.SalCustomInfo;
import com.sc.bean.SalCustomInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalCustomInfoMapper {
    int countByExample(SalCustomInfoExample example);

    int deleteByExample(SalCustomInfoExample example);

    int deleteByPrimaryKey(Long customId);

    int insert(SalCustomInfo record);

    int insertSelective(SalCustomInfo record);

    List<SalCustomInfo> selectByExample(SalCustomInfoExample example);

    SalCustomInfo selectByPrimaryKey(Long customId);

    int updateByExampleSelective(@Param("record") SalCustomInfo record, @Param("example") SalCustomInfoExample example);

    int updateByExample(@Param("record") SalCustomInfo record, @Param("example") SalCustomInfoExample example);

    int updateByPrimaryKeySelective(SalCustomInfo record);

    int updateByPrimaryKey(SalCustomInfo record);
    
  //通过客户ID找出最后下单时间的所有客户
    List<SalCustomInfo> selectByOrderId(SalCustomInfoExample example);
  
    
}