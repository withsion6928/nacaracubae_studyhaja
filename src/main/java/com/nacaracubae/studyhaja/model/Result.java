package com.nacaracubae.studyhaja.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private ErrorResponse error;
    private Object payload;
}