package com.jxd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.bean.Request;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestMapper extends BaseMapper<Request> {
}
