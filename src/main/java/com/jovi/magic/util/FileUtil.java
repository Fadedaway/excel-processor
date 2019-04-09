package com.jovi.magic.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * @author fanjiawei
 * @date Created on 2019/4/8
 */
public class FileUtil {

    public static void writeToFile(String filePath, String content, boolean append) {
        writeToFile(filePath, content.getBytes(), append);
    }

    public static void writeToFile(String filePath, byte[] data, boolean append) {
        FileOutputStream fileOutputStream = null;
        File file;

        if (StringUtils.isEmpty(filePath))
            throw new RuntimeException("file path is empty.");

        if (Objects.isNull(data) || data.length == 0)
            throw new RuntimeException("no data to be written.");

        try {
            file = new File(filePath);
            fileOutputStream = new FileOutputStream(file, append);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            fileOutputStream.write(data);
            fileOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(fileOutputStream)) {
                    fileOutputStream.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
