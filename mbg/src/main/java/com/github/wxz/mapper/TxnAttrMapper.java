package com.github.wxz.mapper;

import com.github.wxz.entity.TxnAttr;

/**
 * @author xianzhi.wang
 */
public interface TxnAttrMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TxnAttr record);

    int insertSelective(TxnAttr record);

    TxnAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TxnAttr record);

    int updateByPrimaryKey(TxnAttr record);
}