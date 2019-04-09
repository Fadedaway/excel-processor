package com.jovi.magic.controller;

import com.jovi.magic.service.PersonInfoService;
import com.jovi.magic.util.ExampleEventUserModel;
import com.jovi.magic.util.ExcelParser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private PersonInfoService personInfoService;

    @Value("${excel.file.path}")
    private String excelPath;

    @Value("${excel.person.file.path}")
    private String personFilePath;

    @GetMapping("readExcel")
    @ResponseBody
    public String readExcel() {
        if (StringUtils.isBlank(excelPath))
            return "Empty";
        try {
            ExcelParser parse;

            parse = excelParser.parse(excelPath, 24);
            List<String[]> datas = parse.getDatas(true);

            System.out.println(">>>>>>>>>>> " + datas.size());

            if (CollectionUtils.isNotEmpty(datas)) {        //
                personInfoService.analysePersonData(datas);
            }
//            exampleEventUserModel.processOneSheet(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
        return "OK";
    }

    @GetMapping("fixData")
    @ResponseBody
    public String fixData() {
        try {
            personInfoService.fixData();
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    @GetMapping("testProxyApi")
    @ResponseBody
    public String testProxyApi() {
        try {
            System.out.println(">>>>>>>>>>>>>>>>>>> in time : " + new Date().getTime());
            Thread.sleep(9000);
            System.out.println(">>>>>>>>>>>>>>>>>>> out time : " + new Date().getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @PostMapping("fileUploadhh")
    @ResponseBody
    public void fileUpload(@RequestParam(name = "file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "F://temp/"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "readPersonInfo")
    @ResponseBody
    public String readPersonInfoExcel() {
        if (StringUtils.isBlank(personFilePath))
            return "Empty";

        try {
            ExcelParser parse;

            parse = excelParser.parse(personFilePath, 2);
            List<String[]> datas = parse.getDatas(false);

            System.out.println(">>>>>>>>>>> " + datas.size());

            if (CollectionUtils.isNotEmpty(datas)) {        //
                personInfoService.processPersonData(datas);
            }
//            exampleEventUserModel.processOneSheet(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
        return "OK";
    }
}
