package com.example.activititest.test;


import com.example.activititest.ActivitiTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ActivitiTestApplication.class)
public class ListTest {

    @Test
    public void Java8ListStream(){
        List<Integer> list = new ArrayList<>();
        Random random = new Random(100);
        for(int i = 0;i<100;i++){
            list.add(random.nextInt(100));
        }
        list.stream().sorted().collect(Collectors.toList()).forEach(item -> {
            System.err.println(item);
        });

    }
}
