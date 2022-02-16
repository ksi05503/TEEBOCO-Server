package com.teeboco.demo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public TestDTO getTestString(){
        return new TestDTO("hello");
    }
}
