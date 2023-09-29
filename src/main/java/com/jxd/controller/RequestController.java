package com.jxd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jxd.bean.Case;
import com.jxd.mapper.CaseMapper;
import com.jxd.service.CaseService;
import com.jxd.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CaseController {
    @Resource
    private CaseMapper caseMapper;
    @Resource
    private CaseService caseService;

//    Create case
    @PostMapping("/saveCase")
    //to receive JSON data
    public Result save(@RequestBody Case case1){
        caseService.save(case1);
        return Result.success();
    }
//  Retrieve cases raised by a client
    @RequestMapping("/getCasesByClientId/{id}")
    public Result getCasesByClientId(@PathVariable int id){
        QueryWrapper<Case> queryWrapper = Wrappers.query();
        QueryWrapper<Case> cases = queryWrapper.eq("client_id",id);
        List<Case> cases1 = caseMapper.selectList(cases);
        for(Case c:cases1){
            System.out.println(c);
        }
        return Result.success(cases1);
    }

//  Retrieve all completed cases
    @RequestMapping("/getCompletedCases")
    public Result getCompletedCases(){
        String search = "Completed";
        QueryWrapper<Case> queryWrapper = Wrappers.query();
        QueryWrapper<Case> cases = queryWrapper.like("current_status", search);
        List<Case> cases1 = caseMapper.selectList(cases);
        return Result.success(cases1);
    }

//  Retrieve outstanding cases (Not completed yet)
    @RequestMapping("/getOutstandingCases")
    public Result getOutstandingCases(){
        String search = "In progress";
        QueryWrapper<Case> queryWrapper = Wrappers.query();
        QueryWrapper<Case> cases = queryWrapper.like("current_status", search);
        List<Case> cases1 = caseMapper.selectList(cases);
        for(Case c: cases1){
            System.out.println(c);
        }
        return Result.success(cases1);
    }

//  Retrieve all cases handled by a particular staff of Ascendant Solutions
    @RequestMapping("/getCasesbyStaffName")
    public Result getCasesbyStaffName(@RequestParam String name){
        QueryWrapper<Case> queryWrapper = Wrappers.query();
        QueryWrapper<Case> cases = queryWrapper.like("assigned_to", name);
        List<Case> cases1 = caseMapper.selectList(cases);
        return Result.success(cases1);
    }
//  Update a case
    @PutMapping("/updateCases")
    public Result update(@RequestBody Case case1){
        caseService.updateById(case1);
        return Result.success();
    }
}
