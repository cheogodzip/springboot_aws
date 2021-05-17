package org.example.springboot_aws.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 모든 필드에 대해 게터 메소드 생성
@RequiredArgsConstructor // final 필드가 포함된 생성자 생성.
public class HelloResponseDto {

    private final String name;
    private final int amount;

}