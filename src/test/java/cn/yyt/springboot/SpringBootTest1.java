package cn.yyt.springboot;

import cn.yyt.springboot.pojo.TypeInfo;
import cn.yyt.springboot.service.TypeInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootTest1 {
    @Autowired
    TypeInfoService ser;
    @Test
    public void test1(){
        ser.save(new TypeInfo("aaa"));


    }
}
