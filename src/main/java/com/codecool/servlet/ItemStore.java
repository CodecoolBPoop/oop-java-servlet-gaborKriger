package com.codecool.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ItemStore {

    private List<Item> items = new ArrayList<>();


    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext(); ) {
            Item cartItem = iterator.next();
            if (cartItem.getName().equals(item.getName())) {
                iterator.remove();
                break;
            }
        }
    }

    public Item findItem(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                System.out.println(item.getName());
                return item;
            }
        }
        return null;
    }


    public String init() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table style=\"width:75%\">");
        for (Item item : items) {
            sb.append("<tr>");
            sb.append("<td>" + item.getName() + "</td>");
            sb.append("<td>" + item.getPrice() + "</td>");
            sb.append("<form action=\"/webshop\" method=\"get\">");
            sb.append("<td><button type=\"submit\" value=\"" + item.getId() + "\" name=\"add\">Add</button></td>");
            sb.append("<td><button type=\"submit\" value=\"" +  item.getId() + "\" name=\"remove\">Remove</button></td>");
            sb.append("</form>");
            sb.append("</tr>");
        }
        sb.append("</table");
        sb.append("<form>" +
                    "<input type=\"button\" value=\"Cart\" onclick=\"window.location.href='/cart'\"/>" +
                 "</form>");
        return sb.toString();
    }


    public String getCart() {
        double price = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<table style=\"width:75%\">");
        for (Item item : items) {
            sb.append("<tr>");
            sb.append("<td>" + item.getName() + "</td>");
            sb.append("<td>" + item.getPrice() + "</td>");
            sb.append("<form action=\"/webshop\" method=\"get\">");
            sb.append("</form>");
            sb.append("</tr>");
            price += item.getPrice();
        }
        sb.append("</table");
        sb.append("<form>" +
                "<input type=\"button\" value=\"Webshop\" onclick=\"window.location.href='/webshop'\"/>" +
                "</form>");
        sb.append("<h1>$ " + price + "</h1>");
        return sb.toString();
    }
}
