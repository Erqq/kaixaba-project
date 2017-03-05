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
        
        try (PrintWriter out = response.getWriter()) {
             
            List stamps = stmp.getStamps();
            
            out.println("[");
             
            for (int i = 0; i < stamps.size(); i++) {
                out.println(stamps.get(i));
                if (i+1 < stamps.size()) {
                    out.println(", "); 
                }
            }

            out.println("]");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
