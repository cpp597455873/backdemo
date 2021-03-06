package com.cpp.core;

import com.cpp.core.annotation.RequestLimit;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class TestController {
    public TestController() {
        System.out.println("hello");
    }

    @RequestLimit(4)
    @GetMapping(value = "/hello")
    public Map<String, String> testHello() {
        return ImmutableMap.of("k1", "v1");
    }

    @GetMapping("/hello1")
    public String testHello1() {
        return "hello1";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }
}
