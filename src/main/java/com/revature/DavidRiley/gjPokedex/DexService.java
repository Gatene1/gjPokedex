package com.revature.DavidRiley.gjPokedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DexService extends HttpServlet {
    private DexRepository dexRepository;

    public DexService(DexRepository dexRepository){
        this.dexRepository = dexRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<!doctype html>" +
                "                 <html>" +
                "                 <head>" +
                "                   <title>com.revature.DavidRiley.gjPokedex</title>" +
                "                   <meta charset='UTF-8' />" +
                "                 </head>" +
                "                 <body>");
        // The above getWriter() statement sets the Webpage up with its header, and to accept UTF-8 characters é, etc.

        for (String pokemon : dexRepository.getPocketMonsters()){
            String prefix = "<b>";
            String suffix = "</b><br>";
            if (!pokemon.substring(0,3).equals("ID,")) {
                String completePokedexEntry = prefix + pokemon + suffix;
                resp.getWriter().println(completePokedexEntry);
            }
            // This if-statement tells if the line being written is the header. If it is, it is not printed.
        }

        resp.getWriter().println("</body>" +
                "                 </html>");
        // This getWriter() statement shows the HTML footer.
    }
}
