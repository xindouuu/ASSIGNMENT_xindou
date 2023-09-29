package com.jxd.controller;

import com.jxd.bean.Client;
import com.jxd.mapper.ClientMapper;
import com.jxd.service.ClientService;
import com.jxd.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class ClientController {
    @Resource
    private ClientService clientService;
    @Resource
    private ClientMapper clientMapper;

//  Add client
    @PostMapping("/saveClient")
    //to receive JSON data
    public Result save(@RequestBody Client client){
        clientService.save(client);
        return Result.success();
    }

//  Delete client
    @DeleteMapping("/del/{id}")
    public Result delete(@PathVariable Integer id){
        clientService.removeById(id);
        return Result.success();
    }

//  Retrieve client by id
    @GetMapping("/getClientByID/{id}")
    public Result getClientByID(@PathVariable Integer id){
        Client client = clientService.getById(id);
        return Result.success(client);
    }

//  Retrieve all clients
    @RequestMapping("/listClients")
    public Result listClients(){
        List<Client> clients = clientService.list();
        return Result.success(clients);
    }

//  Update client
    @PutMapping("/updateClient")
    public Result update(@RequestBody Client client){
        clientService.updateById(client);
        return Result.success();
    }
}
