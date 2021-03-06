package demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CorsFilterConfiguration implements Filter {
    
   @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

       final HttpServletResponse response = (HttpServletResponse) res;
       System.out.println("CORS FILTER WORKING IN GATEWAY:::");


       /* response.setHeader("Access-Control-Allow-Origin", "*");
       response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE,OPTIONS");
       response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type,x-requested-with");
       response.setHeader("Access-Control-Max-Age", "3600");*/
       if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
    	   System.out.println("OPTIONS");
           response.setStatus(HttpServletResponse.SC_OK);
           return;
       } else {
    	   System.out.println("dasds");
           chain.doFilter(req, res);
       }
   }

   @Override
   public void destroy() {
   }

   @Override
   public void init(FilterConfig config) throws ServletException {
   }
}
