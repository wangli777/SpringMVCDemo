package com.wl.springmvc.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/* 文件上传下载控制器*/
@Controller
public class FileController {
    
    @RequestMapping("/upload")
    public String upload(MultipartFile file,Model model){
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        String dir = "F:/test/file";

        FileOutputStream outputStream = null;
        try {
            InputStream inputStream = file.getInputStream();
            //处理文件名
            String uuid = UUID.randomUUID().toString();
            String suffix = file.getOriginalFilename().split("\\.")[1];
            String fileName = uuid+"."+suffix;
            outputStream = new FileOutputStream(new File(dir,fileName));
            IOUtils.copy(inputStream,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        return "redirect:jsp/upload.jsp";
    }

    @RequestMapping("/download")
    @ResponseBody//添加这个注解，告诉SpringMVC所有的响应由Response完成
    public void download(HttpServletResponse response){
        File file = new File("F:/图片/gtl.jpg");
        //定义输入流
        FileInputStream fis = null;
        try {
            //设置下载响应头
            response.setHeader("Content-Disposition", "attachment;filename=gtl.jpg");
            fis = new FileInputStream(file);
            ServletOutputStream outputStream = response.getOutputStream();
            IOUtils.copy(fis,outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
