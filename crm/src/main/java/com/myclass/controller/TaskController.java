package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.service.TaskService;
import com.myclass.service.impl.TaskServiceImpl;

@WebServlet(urlPatterns = {"/task"})
public class TaskController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private TaskService service;
	
	public TaskController() {
		service = new TaskServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/task":
			req.setAttribute("TASKS", service.findAll());
			req.getRequestDispatcher("/WEB-INF/views/task/list.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}
	
}
