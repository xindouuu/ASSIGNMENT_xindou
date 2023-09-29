package com.jxd;

import com.jxd.bean.Client;
import com.jxd.mapper.ClientMapper;
import com.jxd.mapper.RequestMapper;
import com.jxd.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ApplicationTest {
    @Resource
    private ClientMapper clientMapper;
    @Resource
    private RequestMapper requestMapper;
    @Resource
    private ClientService clientService;

    @Test
    public void testClientMapper(){
        System.out.println("clientMapper--"+clientMapper.getClass());
        Client client = clientMapper.selectById(1);
        System.out.println(client);
    }
    @Test
    public void testRequestMapper(){

    }
    @Test
    public void testClientService(){
        List<Client> clients = clientService.list();
        for(Client client: clients){
            System.out.println(client);
        }
    }
}
