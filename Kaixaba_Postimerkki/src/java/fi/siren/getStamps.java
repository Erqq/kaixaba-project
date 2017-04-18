package fi.siren;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
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
             
            for (int i = 0; i < stamps.size(); i++) {
                out.println(stamps.get(i).toJson());
                if (i+1 < stamps.size()) {
                    out.println(", "); 
                }
            }

            out.println("]");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    InputStream stream = new ByteArrayInputStream(request.getReader().readLine().getBytes(StandardCharsets.UTF_8));
    JsonReader jsonReader = Json.createReader(stream);
    JsonObject js = jsonReader.readObject();
    jsonReader.close();
    fixHeaders(response);
    List<Stamp> stamps;
    List<Stamp> temp=new ArrayList<>();
        try (PrintWriter out = response.getWriter()) {
            stamps = stmp.getStamps();
            for(int i = 0; i< stamps.size();i++){
                if(stamps.get(i).getTags().toLowerCase().replace(" ","")
                        .contains(js.getString("tags").toLowerCase()
                                .replace(" ",""))){
                    temp.add(stamps.get(i));
                }   
             }
            out.println("[");
             
            for(int i = 0; i< temp.size();i++){
                    
                   
                    out.println(temp.get(i).toJson());
                    if (i +1< temp.size()) {
                    out.println(", "); 
                    }
               
                  
             }
            out.println("]");    
              
            out.close();
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
