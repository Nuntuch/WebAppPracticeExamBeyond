/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nuntuch Thongyoo
 */
public class CalculatorFilter implements Filter {
FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { //ทำตอนเรียกใช้ filter
            this.config = filterConfig;// เอา filter confic ที่รับมา ส่งไปเก็บใน ตัวแปร confic ที่เราตั้งขึ้น
                
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpSession session = ((HttpServletRequest)request).getSession(false);
        
    long beforetime = System.currentTimeMillis();
    
    chain.doFilter(request, response);// ส่งต่อให้ไปทำ servlet หรือ filter อันต่อไป
    
   

    }

    @Override
    public void destroy() {

    }
    
}
