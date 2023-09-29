package com.jxd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.bean.Case;
import com.jxd.mapper.CaseMapper;
import com.jxd.service.CaseService;
import org.springframework.stereotype.Service;

@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case> implements CaseService {
}
