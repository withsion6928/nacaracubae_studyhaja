package com.nacaracubae.studyhaja.web;

import com.nacaracubae.studyhaja.service.PostsService;
import com.nacaracubae.studyhaja.web.dto.PostsResponseDto;
import com.nacaracubae.studyhaja.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postService.save(requestDto);

    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequets requestDto){
        return postService.update(id, requestDto);


    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }
}
