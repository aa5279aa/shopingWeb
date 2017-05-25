package com.lxl.servlet.action;

import com.lxl.servlet.service.ShopService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xiangleiliu on 2017/4/26.
 */
public class InputShopServlet extends HttpServlet {

    ShopService service = new ShopService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        try {
            //存储图片
            service.saveOneShopModel(request);
            writer.write("success");
        } catch (Exception e) {
            e.printStackTrace();
            writer.write("fail");
        }
        writer.flush();
    }
}
