package ex22110678910;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Ex16Controller {
   Ex17ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
}
