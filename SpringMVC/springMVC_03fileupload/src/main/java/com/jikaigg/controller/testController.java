package com.jikaigg.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传的controller
 */
@Controller
@RequestMapping("user")
public class testController {
    /**
     * 传统方式上传文件
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("fileupload1")
    public String fileUpLoad1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传。。。");

        //使用fileUpLoad组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建文件夹
            file.mkdirs();
        }
        //解析request对象，获取上传的文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //判断当前item对象是否是上传文件项
            if (item.isFormField()) {
                //说明普通表单项
            } else {
                //说明上传文件项
                //获取上传文件的名称
                String name = item.getName();
                //完成文件上传
                item.write(new File(path, name));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("fileupload2")
    public String fileUpLoad2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传。。。");

        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建文件夹
            file.mkdirs();
        }
        //获取文件名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path, filename));


        return "success";
    }

}
