/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.siren;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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

/**
 *
 * @author Erqq
 */
@WebServlet(name = "SearchStamps", urlPatterns = {"/SearchStamps"})
public class SearchStamps extends HttpServlet {

    @EJB
    public StampService stmp;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");
     
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        InputStream stream = new ByteArrayInputStream(request.getReader().readLine().getBytes(StandardCharsets.UTF_8));
        JsonReader jsonReader = Json.createReader(stream);
        JsonObject js = jsonReader.readObject();
        jsonReader.close();
         try (PrintWriter out = response.getWriter()) {
            out.println(js);
         }
    }
}
