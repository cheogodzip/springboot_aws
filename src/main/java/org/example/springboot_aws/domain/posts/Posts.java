package org.example.springboot_aws.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // jpa 어노테이션. 테이블과 연결된 클래스
public class Posts { // 카멜케이스 -> 테이블에서 언더스코어네이밍.

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙. auto_increment
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼. 옵션 붙일 수 있음.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}