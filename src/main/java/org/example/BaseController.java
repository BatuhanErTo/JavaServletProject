package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet("/employee/*")
public class BaseController extends HttpServlet {
    private static final String GET_EMPLOYEE_URI = "/employeeList";

    private final EmployeeRepositoryImpl employeeRepository;
    private final ObjectMapper objectMapper;

    public BaseController() {
        this.employeeRepository = EmployeeRepositoryImpl.createInstance();
        this.objectMapper = new ObjectMapper();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if (path.equals(GET_EMPLOYEE_URI)) {
            resp.setContentType("application/json");
            String json = objectMapper.writeValueAsString(employeeRepository.getAllEmployees());
            resp.getWriter().write(json);
        }
    }
}
