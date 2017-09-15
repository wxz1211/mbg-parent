package com.apass.esp.mapper;

import com.apass.esp.domain.entity.ApassTxnAttr;

public interface ApassTxnAttrMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApassTxnAttr record);

    int insertSelective(ApassTxnAttr record);

    ApassTxnAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApassTxnAttr record);

    int updateByPrimaryKey(ApassTxnAttr record);
}