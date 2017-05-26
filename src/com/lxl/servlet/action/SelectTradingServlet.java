package com.lxl.servlet.action;

import com.lxl.servlet.model.ShopModel;
import com.lxl.servlet.service.InputService;
import com.lxl.servlet.service.ShopService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xiangleiliu on 2017/5/25.
 */
public class SelectTradingServlet extends HttpServlet {

    ShopService service = new ShopService();
    InputService inputService = new InputService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        try {
            //转化获取ShopModel
            ShopModel shopModel = inputService.readShopModel(request);
            service.saveOneShopModel(shopModel);
        } catch (Exception e) {
            writer.write("error");
            e.printStackTrace();
        }
        writer.write("success");
        writer.flush();
    }
}
