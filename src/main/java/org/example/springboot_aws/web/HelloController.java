package org.example.springboot_aws.web;

import org.example.springboot_aws.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // json을 반환해주는 컨트롤러로 만듦.
public class HelloController {

    @GetMapping("/hello") // GET 요청을 받는 API로 만듦. "/hello"로 요청이 들어오면 hello를 반환함.
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        // @RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        // name, amount는 API를 호출한 곳에 넘겨줌.
        return new HelloResponseDto(name, amount);
    }
}
