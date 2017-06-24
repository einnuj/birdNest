package com.silkroad.controller;

import com.silkroad.model.TracerModel;
import com.silkroad.view.TracerView;

import java.io.IOException;

/**
 * Skeleton of what may be our Servlet.
 *
 * Created by JSim on 6/24/17.
 */
@javax.servlet.annotation.WebServlet(name = "TracerServlet")
public class TracerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        TracerView view = new TracerView(new TracerModel());
    }
}
