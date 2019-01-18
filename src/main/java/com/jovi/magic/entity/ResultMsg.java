package com.jovi.magic.entity;

import lombok.Data;

import java.util.List;

/**
 * @author fanjiawei
 * @date Created on 2019/1/18
 */
@Data
public class ResultMsg<T> {

    private String code;
    private List<String> fields;
    private T result;
    private Integer status;
    private Long timestamp;
}
