package com.example.demo.domain.controller;

import com.example.demo.domain.entity.Board;
import com.example.demo.domain.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String postTemplete(){
        return "PostFormat";
    }

    @PostMapping("/board/writepro")
    public String postService(Board board){

        boardService.write(board);
        return "index";
    }
}