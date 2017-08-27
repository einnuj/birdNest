package com.silkroad.controller;

import com.silkroad.model.TracerModel;
import com.silkroad.view.TracerView;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Skeleton of what may be our Servlet.
 *
 * Created by JSim on 6/24/17.
 */
@WebServlet(name = "TracerServlet")
public class TracerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        TracerView view = new TracerView(new TracerModel());
    }
}
