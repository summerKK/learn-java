package com.summer;

import com.summer.service.IPerson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestPerson {

    @Autowired
    private IPerson person;

    @Test
    public void TestSleep() {
        person.sleep(1);
    }

    @Test
    public void TestWork() {
        person.work();
    }
}
