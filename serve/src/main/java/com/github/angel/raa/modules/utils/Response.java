package com.github.angel.raa.modules.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Response implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private String message;
    private int code;
    private boolean error;
}
