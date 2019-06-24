package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName FileUtils
 * @date 2019/6/5  14:30
 */
public class FileUtils {



    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${filepath.agriculture}")
    private String filePath;

    public void download(String path, HttpServletResponse response) throws Exception {
        if (!StringUtils.isEmpty(path)) {
            filePath = path;
        }
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            String fileName = "loanAgriculture";
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String(fileName.getBytes("gb2312"), "ISO8859-1")
                    + ".xls");
            InputStream inputStream = new FileInputStream(new File(filePath));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            os.close();
            inputStream.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
