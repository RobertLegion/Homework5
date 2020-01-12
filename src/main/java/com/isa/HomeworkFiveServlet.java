package com.isa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@WebServlet("/infoShareAcademy")
public class HomeworkFiveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<p>Robert Ślęzak</p>");
        writer.println("<p>jjdd8-HighFive</p>");
        writer.println("<p>" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html><head></head><body>");
        request.getParameterMap().entrySet().stream()
                .flatMap(parameter -> Arrays.stream(parameter.getValue())
                        .map(paramValue -> parameter.getKey() + "=" + paramValue))
                .forEach(s -> writer.println("<p>" + s + "</p>"));
        writer.println("</body></html>");
    }
}

