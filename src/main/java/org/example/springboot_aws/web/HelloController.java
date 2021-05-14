package org.example.springboot_aws.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // json을 반환해주는 컨트롤러로 만듦.
public class HelloController {

    @GetMapping("/hello") // GET 요청을 받는 API로 만듦. "/hello"로 요청이 들어오면 hello를 반환함.
    public String hello(){
        return "hello";
    }
}
