package com.macfu.common;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: liming
 * @Date: 2018/11/17 13:46
 * @Description: 通用mapper
 */
public interface CustomerMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {

}