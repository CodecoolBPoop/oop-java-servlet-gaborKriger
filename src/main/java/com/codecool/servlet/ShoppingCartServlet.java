package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.codecool.servlet.WebShopServlet.cart;

@WebServlet(name = "ShoppingCart", urlPatterns = {"/cart"}, loadOnStartup = 1)
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();

        out.println(
            "<html>" +
                "<head>" +

                "</head>" +
                "<body>" +
                    cart.getCart() +
                "</body>" +
            "</html>"
        );

    }
}
