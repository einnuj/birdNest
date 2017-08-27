package com.silkroad.controller;

import com.silkroad.model.TracerModel;
import com.silkroad.view.TracerView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Concrete Servlet. This is the functional equivalent of a "Controller" in that its an entry point into our backend.
 * This does not mean we cannot implement a separate Controller for the directive logic.
 *
 * Created by JSim on 6/24/17.
 */
@WebServlet(name = "TracerServlet")
public class TracerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TracerView view = new TracerView(new TracerModel());
    }
}
