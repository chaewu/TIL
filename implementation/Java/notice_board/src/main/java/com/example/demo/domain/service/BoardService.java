package com.example.demo.domain.service;


import com.example.demo.domain.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    /*
     * Field Injection의 경우, Spring DI container과 강한 결합을 발생시켜 사용을 지양하는게 좋다.
     */
    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
        System.out.println(boardRepository.findById(1));

    }
}
