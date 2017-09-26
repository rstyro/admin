package com.lrs.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lrs.admin.config.DruidDBConfig;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	 @Autowired
	 private DruidDBConfig druidDBConfig;


    @Test
    public void testDruidDBConfig() throws Exception{
        System.out.println("DruidDBConfig = " + druidDBConfig.dataSource().getLoginTimeout());
    }
}
