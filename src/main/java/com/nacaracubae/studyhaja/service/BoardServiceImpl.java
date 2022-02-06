package com.nacaracubae.studyhaja.service;

import java.util.List;
import java.util.Optional;

import com.nacaracubae.studyhaja.enumpkg.ServiceResult;
import com.nacaracubae.studyhaja.model.Board;
import com.nacaracubae.studyhaja.model.ErrorResponse;
import com.nacaracubae.studyhaja.model.Result;
import com.nacaracubae.studyhaja.repositories.BoardRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService{

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(BoardServiceImpl.class);

    @Autowired
    BoardRepository repository;

    public Result updateBoard(Board board) {
        Optional<Board> search = repository.findById(board.getBoardno());
        Result result = new Result();
        if(search.isPresent()) {
            board = repository.save(board);
            result.setPayload(board);
        }else {
            result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
        }
        return result;
    }

    public Result deleteBoard(int boardno) {
        Result result = new Result();
        boolean isPresent = repository.findById(boardno).isPresent();
        if(!isPresent) {
            result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
        }else {
            repository.deleteById(boardno);
        }
        return result;
    }

    @Override
    public Result createBoard(Board board) {
        board = repository.save(board);
        Result result = new Result();
        result.setPayload(board);
        return result;
    }

    @Override
    public Result retrieveBoardList() {
        List<Board> list = repository.findAllByOrderByBoardnoDesc();
        Result result = new Result();
        result.setPayload(list);
        return result;
    }

    @Override
    public Result retrieveBoard(int boardno) {
        Optional<Board> optionalBoard = repository.findById(boardno);
        Result result = new Result();
        if(optionalBoard.isPresent()) {
            result.setPayload(optionalBoard.get());
        }else {
            result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
        }
        return result;
    }

}