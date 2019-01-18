package com.jovi.magic.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author fanjiawei
 * @date Created on 2019/1/17
 */
@Data
@Accessors(chain = true)
public class Menu {
    public String id;
    public String name;
    public String parentId;
    private String path;
    private String originId;
    private String code;
    public List<Menu> childList;
}
