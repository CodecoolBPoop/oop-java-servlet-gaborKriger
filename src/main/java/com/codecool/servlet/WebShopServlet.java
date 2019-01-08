package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WebShop", urlPatterns = {"/webshop"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {

    static ItemStore cart = new ItemStore();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();

        String title = "Webshop";


        out.println(
            "<html>" +
                    "<head>" +
                        "<title>" + title + "</title>" +
                    "<title>" + title + "</title></head>\n" +
                    "</head>" +
                    "<body>" +
                        "<h1> Hello Servlet </h1>" +
                        Stock.stock.init() +
                    "</body>" +
            "</html>"
        );

        String add = request.getParameter("add");
        String remove = request.getParameter("remove");

        if (add != null) {
            cart.add(Stock.stock.findItem(Integer.parseInt(add)));
        }

        if (remove != null) {
            cart.remove(Stock.stock.findItem(Integer.parseInt(remove)));
        }

        out.flush();
        out.close();
    }
}
