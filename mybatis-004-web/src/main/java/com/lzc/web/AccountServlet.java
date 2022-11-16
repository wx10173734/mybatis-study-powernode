package com.lzc.web;

import com.lzc.exceptions.MoneyNotEnoughException;
import com.lzc.exceptions.TransferException;
import com.lzc.service.AccountService;
import com.lzc.service.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @title: AccountServlet
 * @Author luozouchen
 * @Date: 2022/11/16 20:25
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));
        //调用service的转账方法完成转账（转业务层）
        try {
            accountService.transfer(fromActno, toActno, money);
            //程序走到这里，表示转账一定成功了。
            //调用view完成展示结果
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath() + "/error1.html");

        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath() + "/error2.html");

        }catch (Exception e){
            response.sendRedirect(request.getContextPath() + "/error2.html");

        }

    }
}
