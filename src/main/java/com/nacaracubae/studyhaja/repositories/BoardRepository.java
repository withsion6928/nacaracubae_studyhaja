package com.nacaracubae.studyhaja.repositories;

import java.util.List;

import com.nacaracubae.studyhaja.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    public List<Board> findAllByOrderByBoardnoDesc();

}