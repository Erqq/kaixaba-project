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
 
/**
 *
 * @author Miika
 */
// http://localhost:8080/Kaixaba_Postimerkki/showStamps
@WebServlet(urlPatterns = {"/showStamps"})
public class showStamps extends HttpServlet {
     
    @EJB
    public StampService stmp;
    /**
     * Handles the HTTP <code>GET</code> method.
     * Shows all stamps as a table.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
        try (PrintWriter out = response.getWriter()) {
             
            List stamps = stmp.getStamps();
             
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form</title>");
            out.println("</head>");
            out.println("<body>");
 
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>" + "ID" + "</th>");
            out.println("<th>" + "Asiasanat" + "</th>");
            out.println("<th>" + "Ilmestymispäivä" + "</th>");
            out.println("<th>" + "Käytön päättyminen" + "</th>");
            out.println("<th>" + "Nimellisarvo" + "</th>");
            out.println("<th>" + "Nimi" + "</th>");
            out.println("<th>" + "Väri" + "</th>");
            out.println("<th>" + "Painopaikka" + "</th>");
            out.println("<th>" + "Painosmaara" + "</th>");
            out.println("<th>" + "Taiteilija" + "</th>");
            out.println("<th>" + "Valuutta" + "</th>");
            out.println("<th>" + "Kuvan URL" + "</th>");
            out.println("</tr>");
             
            for (int i = 0; i < stamps.size(); i++) {
                Stamp temp = (Stamp) stamps.get(i);
                out.println("<tr>");
                out.println("<td>" + temp.getId()  + "</td>");
                out.println("<td>" + temp.getTags()  + "</td>");
                out.println("<td>" + temp.getReleaseDate()  + "</td>");
                out.println("<td>" + temp.getEndDate()  + "</td>");
                out.println("<td>" + temp.getValue()  + "</td>");
                out.println("<td>" + temp.getName()  + "</td>");
                out.println("<td>" + temp.getColor()  + "</td>");
                out.println("<td>" + temp.getPrintLocation()  + "</td>");
                out.println("<td>" + temp.getPrintAmount()  + "</td>");
                out.println("<td>" + temp.getArtist()  + "</td>");
                out.println("<td>" + temp.getCurrency()  + "</td>");
                out.println("<td>" + temp.getUrl()  + "</td>");
                out.println("</tr>");
            }
             
            out.println("</table>");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}