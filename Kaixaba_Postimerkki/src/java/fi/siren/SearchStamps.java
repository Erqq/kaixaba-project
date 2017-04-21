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
import javax.ws.rs.core.Response;

/**
 * Searches the stamps.
 *
 * @author Erqq
 */
@WebServlet(name = "SearchStamps", urlPatterns = {"/SearchStamps"})
public class SearchStamps extends HttpServlet {

    @EJB
    public StampService stmp;

    public SearchStamps() {
        super();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchStamps</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchStamps at "
                    + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method. Gets the stamps that are
     * searched with the form.
     *
     * @param request servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        InputStream stream = new ByteArrayInputStream(request.getReader().readLine()
                .getBytes(StandardCharsets.UTF_8));
        JsonReader jsonReader = Json.createReader(stream);
        JsonObject js = jsonReader.readObject();
        jsonReader.close();
        fixHeaders(response);
        List<Stamp> stamps;
        List<Stamp> temp = new ArrayList<>();

        try (PrintWriter out = response.getWriter()) {
            stamps = stmp.getStamps();

            for (int i = 0; i < stamps.size(); i++) {
                if (stamps.get(i).getArtist().toLowerCase().replace(" ", "")
                        .contains(js.getString("artist").toLowerCase()
                                .replace(" ", ""))
                        && stamps.get(i).getCurrency()
                                .toLowerCase().replace(" ", "")
                                .contains(js.getString("currency")
                                        .toLowerCase().replace(" ", ""))
                        && stamps.get(i).getEndDate().replace(" ", "")
                                .contains(js.getString("endDate")
                                        .replace(" ", ""))
                        && stamps.get(i).getReleaseDate().replace(" ", "")
                                .contains(js.getString("releaseDate")
                                        .replace(" ", ""))
                        && stamps.get(i).getValue().replace(" ", "")
                                .contains(js.getString("value")
                                        .replace(" ", ""))
                        && stamps.get(i).getName().replace(" ", "").toLowerCase()
                                .contains(js.getString("name").toLowerCase()
                                        .replace(" ", ""))
                        && stamps.get(i).getPrintLocation().replace(" ", "")
                                .toLowerCase()
                                .contains(js.getString("printLocation")
                                        .toLowerCase()
                                        .replace(" ", ""))
                        && stamps.get(i).getPrintAmount().replace(" ", "")
                                .contains(js.getString("printAmount")
                                        .replace(" ", ""))
                        && stamps.get(i).getColor().replace(" ", "")
                                .contains(js.getString("color")
                                        .replace(" ", ""))) {
                    temp.add(stamps.get(i));
                }
            }
            out.println("[");

            for (int i = 0; i < temp.size(); i++) {

                out.println(temp.get(i).toJson());
                if (i + 1 < temp.size()) {
                    out.println(", ");
                }
            }
            out.println("]");

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Fixes the headers
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    protected void doOptions(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        fixHeaders(response);
    }

    /**
     * Fixes the headers.
     *
     * @param response servlet response
     */
    private void fixHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods",
                "GET, PUT, POST, OPTIONS, DELETE");
        response.addHeader("Access-Control-Allow-Headers", "*");
        response.addHeader("Access-Control-Max-Age", "86400");
    }

}
