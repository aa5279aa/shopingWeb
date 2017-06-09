package com.lxl.servlet.action;

import com.alibaba.fastjson.JSON;
import com.lxl.servlet.model.ImageModel;
import com.lxl.servlet.model.TradingModel;
import com.lxl.servlet.service.InputService;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by xiangleiliu on 2017/5/29.
 */
@WebServlet(name = "InputImageServlet")
public class InputImageServlet extends HttpServlet {
    InputService inputService = new InputService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        try {
            //解析请求参数
            List<FileItem> list = inputService.readAllParams(request);

            //转换为ImageModel
            ImageModel imageModel = inputService.readImageModel(list);

            //主线程保存图片信息

            //线程    保存图片
            inputService.saveImage(imageModel);

        } catch (Exception e) {
            writer.write("error");
            e.printStackTrace();
        }
        writer.write("图片上传成功");
        writer.flush();
    }
}
