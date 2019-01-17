package com.jovi.magic.service;

import java.text.ParseException;
import java.util.List;

/**
 * @author fanjiawei
 * @date Created on 2018/11/22
 */
public interface PersonInfoService {

    void analysePersonData(List<String[]> dataList);

    void installData(String[] data) throws ParseException;

    void fixData();
}
