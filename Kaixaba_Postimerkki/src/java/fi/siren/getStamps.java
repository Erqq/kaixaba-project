package fi.siren;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "getStamps", urlPatterns = {"/getStamps"})
public class getStamps extends HttpServlet {
    
    @EJB
    public StampService stmp;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        fixHeaders(response);
        
        int amountToGet = 12;
        
        try (PrintWriter out = response.getWriter()) {
             
            List<Stamp> stamps = stmp.getStamps();
            
            out.println("[");
             
            for (int i = 0; i < amountToGet; i++) {
                out.println(stamps.get(i).toJson());
                if (i+1 < amountToGet) {
                    out.println(", "); 
                }
            }

            out.println("]");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void fixHeaders(HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
    response.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, OPTIONS, DELETE");
    response.addHeader("Access-Control-Allow-Headers", "Content-Type");
    response.addHeader("Access-Control-Max-Age", "86400");
}
    
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    fixHeaders(response);
}

}
