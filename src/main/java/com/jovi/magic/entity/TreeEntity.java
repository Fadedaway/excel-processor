package com.jovi.magic.entity;

import java.util.List;

/**
 * @author fanjiawei
 * @date Created on 2019/1/17
 */
public interface TreeEntity<E> {
    public String getId();
    public String getParentId();
    public void setChildList(List<E> childList);

}
