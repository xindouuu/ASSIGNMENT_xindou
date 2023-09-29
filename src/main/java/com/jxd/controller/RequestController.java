package com.jxd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jxd.bean.Request;
import com.jxd.mapper.RequestMapper;
import com.jxd.service.RequestService;
import com.jxd.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RequestController {
    @Resource
    private RequestMapper requestMapper;
    @Resource
    private RequestService requestService;

//    Create case
    @PostMapping("/saveCase")
    //to receive JSON data
    public Result save(@RequestBody Request request){
        requestService.save(request);
        return Result.success();
    }
//  Retrieve cases raised by a client
    @RequestMapping("/getCasesByClientId/{id}")
    public Result getCasesByClientId(@PathVariable Integer id){
        QueryWrapper<Request> queryWrapper = Wrappers.query();
        QueryWrapper<Request> cases = queryWrapper.eq("client_id",id);
        List<Request> cases1 = requestMapper.selectList(cases);
        return Result.success(cases1);
    }

//  Retrieve all completed cases
    @RequestMapping("/getCompletedCases")
    public Result getCompletedCases(){
        String search = "Completed";
        QueryWrapper<Request> queryWrapper = Wrappers.query();
        QueryWrapper<Request> cases = queryWrapper.like("current_status", search);
        List<Request> cases1 = requestMapper.selectList(cases);
        return Result.success(cases1);
    }

//  Retrieve outstanding cases (Not completed yet)
    @RequestMapping("/getOutstandingCases")
    public Result getOutstandingCases(){
        String search = "In progress";
        QueryWrapper<Request> queryWrapper = Wrappers.query();
        QueryWrapper<Request> cases = queryWrapper.like("current_status", search);
        List<Request> cases1 = requestMapper.selectList(cases);
        for(Request c: cases1){
            System.out.println(c);
        }
        return Result.success(cases1);
    }

//  Retrieve all cases handled by a particular staff of Ascendant Solutions
    @RequestMapping("/getCasesbyStaffName")
    public Result getCasesbyStaffName(@RequestParam String name){
        QueryWrapper<Request> queryWrapper = Wrappers.query();
        QueryWrapper<Request> cases = queryWrapper.like("assigned_to", name);
        List<Request> cases1 = requestMapper.selectList(cases);
        return Result.success(cases1);
    }
//  Update a case
    @PutMapping("/updateCases")
    public Result update(@RequestBody Request request1){
        requestService.updateById(request1);
        return Result.success();
    }
}
