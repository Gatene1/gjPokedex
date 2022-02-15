package com.revature.DavidRiley.gjPokedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DexService extends HttpServlet {
    private DexRepository dexRepository;
    private String[] pokemonData;

    public DexService(DexRepository dexRepository, String[] selectedPokemon){
        this.dexRepository = dexRepository;
        this.pokemonData = selectedPokemon;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeEmblem = null;
        resp.getWriter().println("<!doctype html>" +
                "                 <html>" +
                "                 <head>" +
                "                   <title>com.revature.DavidRiley.gjPokedex</title>" +
                "                   <meta charset='UTF-8' />" +
                "                 </head>" +
                "                 <body>" +
                                    "<img src='http://serebii.net/swordshield/pokemon/"+ this.pokemonData[0] + ".png' align='left'>" +
                "                   <font face = 'Verdana' size = '16pt'><b><u>" + this.pokemonData[1] + "&nbsp;#"+ this.pokemonData[0] + "</u></b></font><br>");
                for (int i=1; i <= 2; i++) {
                    if (i == 1) typeEmblem = this.pokemonData[2];
                    if (i == 2) typeEmblem = this.pokemonData[3];
                    switch (typeEmblem) {
                        case "Bug":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/bug.gif' height = '36px' width = '96px'>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Dragon":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/dragon.gif' height = '36px' width = '96px'>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Electric":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/electric.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Fighting":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/fighting.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Fire":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/fire.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Flying":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/flying.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Ghost":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/ghost.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Grass":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/grass.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Ground":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/ground.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Ice":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/ice.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Normal":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/normal.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Poison":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/poison.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Psychic":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/psychic.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Rock":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/rock.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        case "Water":
                            resp.getWriter().println(("<img src='http://serebii.net/attackdex-bw/type/water.gif' height=36px width=96px>&nbsp;&nbsp;&nbsp;"));
                            break;
                        default:
                            break;
                    }
                }
                            resp.getWriter().println("<br><font face = 'Verdana' size = '5pt'><i>" + this.pokemonData[10] + "</i></font><br><br>" +
                                                     "<br><font face = 'Verdana' size = '5pt'>Height: " + this.pokemonData[11] + "<br>Weight: " + this.pokemonData[12] + "<br><br clear=all>" +
                                                     "<table cols = 6 rows = 2 border = 2>" +
                                    "                   <tr bgcolor = #c7c7c7 align = center>" +
                                    "                       <td width=75>HP</td>" +
                                    "                       <td width=75>Atk</td>" +
                                    "                       <td width=75>Def</td>" +
                                    "                       <td width=75>SAtk</td>" +
                                    "                       <td width=75>SDef</td>" +
                                    "                       <td width=75>Spd</td>" +
                                    "                   </tr><tr align = center>" +
                                    "                       <td>" + this.pokemonData[4] + "</td>" +
                                    "                       <td>" + this.pokemonData[5] + "</td>" +
                                    "                       <td>" + this.pokemonData[6] + "</td>" +
                                    "                       <td>" + this.pokemonData[7] + "</td>" +
                                    "                       <td>" + this.pokemonData[8] + "</td>" +
                                    "                       <td>" + this.pokemonData[9] + "</td>");
        // The above getWriter() statement sets the Webpage up with its header, and to accept UTF-8 characters é, etc.

//        for (String pokemon : dexRepository.getPocketMonsters()){
//            String prefix = "<b>";
//            String suffix = "</b><br>";
//            if (!pokemon.substring(0,3).equals("ID,")) {
//                String completePokedexEntry = prefix + pokemon + suffix;
//                resp.getWriter().println(completePokedexEntry);
//            }
//            // This if-statement tells if the line being written is the header. If it is, it is not printed.
//        }

        resp.getWriter().println("</body>" +
                "                 </html>");
        // This getWriter() statement shows the HTML footer.

    }
}
