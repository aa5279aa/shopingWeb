package com.lxl.servlet.action;

import com.lxl.servlet.model.TradingModel;
import com.lxl.servlet.service.InputService;
import com.lxl.servlet.service.ShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xiangleiliu on 2017/5/4.
 */
@WebServlet(name = "InputTradingServlet")
public class InputTradingServlet extends HttpServlet {
    InputService inputService = new InputService();
    ShopService service = new ShopService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {
            TradingModel tradingModel = inputService.readTradingModel(request);
            service.saveOneTradingModel(tradingModel);
            writer.write("success");
        } catch (Exception e) {
            e.printStackTrace();
            writer.write("fail");
        }
        writer.flush();
    }
}
