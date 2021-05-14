package org.example.springboot_aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 이 어노테이션이 있어야 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정해줌.
public class Application { // 이 어노테이션이 있는 위치부터 설정을 읽어 가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야 한다.
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); // 내장 WAS를 실행함.
    }
}
