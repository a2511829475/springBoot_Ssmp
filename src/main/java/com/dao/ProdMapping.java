package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.Prod;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProdMapping extends BaseMapper<Prod> {
}
