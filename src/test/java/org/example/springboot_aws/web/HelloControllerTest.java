package org.example.springboot_aws.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class) // Web 테스트에 집중할 수 있는 어노테이션. @Controller, @ControllerAdvice 등이 포함됨.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입
    private MockMvc mvc; // 웹 API를 테스트할 때 사용. MVC 테스트.

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 get 요청
                .andExpect(status().isOk()) // 검증
                .andExpect(content().string(hello)); // 검증
    }
}
