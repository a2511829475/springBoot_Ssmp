package com.serviceTest;

import com.SpringBootSmpApplication;
import com.dao.ProdMapping;
import com.service.IProdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringBootSmpApplication.class)
public class ProdServiceTest {
    @Autowired
    private IProdService prodService;
    @Test
    void testGetAll(){
        prodService.list();
    }
}
