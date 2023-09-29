package com.jxd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.bean.Request;
import com.jxd.mapper.RequestMapper;
import com.jxd.service.RequestService;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl extends ServiceImpl<RequestMapper, Request> implements RequestService {
}
