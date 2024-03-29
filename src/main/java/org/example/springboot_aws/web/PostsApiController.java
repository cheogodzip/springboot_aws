package org.example.springboot_aws.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot_aws.service.PostsService;
import org.example.springboot_aws.web.dto.PostsResponseDto;
import org.example.springboot_aws.web.dto.PostsSaveRequestDto;
import org.example.springboot_aws.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") // 등록
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") // 수정
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}") // 읽기
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
