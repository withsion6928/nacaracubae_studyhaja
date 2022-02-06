package com.nacaracubae.studyhaja.service;

import com.nacaracubae.studyhaja.model.Board;
import com.nacaracubae.studyhaja.model.Result;

public interface BoardService {
    public Result createBoard(Board board);
    public Result retrieveBoardList();
    public Result retrieveBoard(int boardno);
    public Result updateBoard(Board board);
    public Result deleteBoard(int boardno);
}