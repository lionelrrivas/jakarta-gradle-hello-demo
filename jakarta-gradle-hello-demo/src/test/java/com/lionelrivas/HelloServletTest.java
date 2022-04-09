package com.lionelrivas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

class HelloServletTest {
    
    @Mock
    private HttpServletRequest request;
    
    @Mock
    private HttpServletResponse response;
    
    @Mock
    private RequestDispatcher requestDispatcher;
    
    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void helloServlet_doPostWithUsername_displaysSuccessfully() throws Exception {
        when(request.getParameter("username")).thenReturn("lionel");
        when(request.getRequestDispatcher("hello.jsp")).thenReturn(requestDispatcher);
        new HelloServlet().doPost(request, response);
        verify(requestDispatcher).forward(request, response);
        verify(request).setAttribute("username", "lionel");
    }
    
}
