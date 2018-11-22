package com.jovi.magic.controller;

import com.jovi.magic.util.ExampleEventUserModel;
import com.jovi.magic.util.ExcelParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author fanjiawei
 * @date Created on 2018/11/21
 */
@Controller
public class ExcelController {

    @Autowired
    private ExcelParser excelParser;

    @Autowired
    private ExampleEventUserModel exampleEventUserModel;

    @Value("${excel.file.path}")
    private String excelPath;

    @GetMapping("readExcel")
    @ResponseBody
    public String readExcel() {
        if (StringUtils.isBlank(excelPath))
            return "Empty";
        try {
            ExcelParser parse;

            parse = excelParser.parse(excelPath, 24);
            List<String[]> datas = parse.getDatas();

            System.out.println(">>>>>>>>>>> " + datas.size());

//            exampleEventUserModel.processOneSheet(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
        return "OK";
    }
}
