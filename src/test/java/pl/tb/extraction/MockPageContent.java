package pl.tb.extraction;

public class MockPageContent {

    static String firstPage = "<html>\n" +
            "   <head>\n" +
            "   </head>\n" +
            "   <body>\n" +
            "      <div id=\"container\">\n" +
            "         <div id=\"content\" class=\"\">\n" +
            "            <div class=\"pagination\">\n" +
            "               <span class=\"disabled prev\">«</span>\n" +
            "               <span class=\"current page\">1</span>\n" +
            "               <a href=\"?page=2\" class=\"page\">2</a>\n" +
            "               <a href=\"?page=3\" class=\"page\">3</a>\n" +
            "               ...\n" +
            "               <a href=\"?page=9\" class=\"page\">10</a>\n" +
            "               <a href=\"?page=10\" class=\"page\">9</a>\n" +
            "               <a href=\"?page=2\" class=\"next\">»</a>\n" +
            "            </div>\n" +
            "            <div id=\"d1\" class=\"q post\">\n" +
            "               <div class=\"bar\">\n" +
            "\t\t\t   <span class=\" points\" style=\"visibility: hidden;\">5</span>\n" +
            "               </div>\n" +
            "               <div class=\"quote post-content post-body\">\n" +
            "                  Test text\n" +
            "               </div>\n" +
            "            </div>\n" +
            "            <div id=\"d2\" class=\"q post\">\n" +
            "               <div class=\"bar\">\n" +
            "\t\t\t   <span class=\" points\" style=\"visibility: hidden;\">10</span>\n" +
            "               </div>\n" +
            "               <div class=\"quote post-content post-body\">\n" +
            "                  test text 2\n" +
            "               </div>\n" +
            "            </div>\n" +
            "         </div>\n" +
            "      </div>\n" +
            "   </body>\n" +
            "</html>";

    static String secoundPage = "<html>\n" +
            "   <head>\n" +
            "   </head>\n" +
            "   <body>\n" +
            "      <div id=\"container\">\n" +
            "         <div id=\"content\" class=\"\">\n" +
            "            <div class=\"pagination\">\n" +
            "               <span class=\"disabled prev\">«</span>\n" +
            "               <span class=\"current page\">2</span>\n" +
            "               <a href=\"?page=3\" class=\"page\">3</a>\n" +
            "               ...\n" +
            "               <a href=\"?page=3\" class=\"next\">»</a>\n" +
            "            </div>\n" +
            "            <div id=\"d3\" class=\"q post\">\n" +
            "               <div class=\"bar\">\n" +
            "\t\t\t   <span class=\" points\" style=\"visibility: hidden;\">5</span>\n" +
            "               </div>\n" +
            "               <div class=\"quote post-content post-body\">\n" +
            "                  Test text on page 2\n" +
            "               </div>\n" +
            "            </div>\n" +
            "            <div id=\"d4\" class=\"q post\">\n" +
            "               <div class=\"bar\">\n" +
            "\t\t\t   <span class=\" points\" style=\"visibility: hidden;\">10</span>\n" +
            "               </div>\n" +
            "               <div class=\"quote post-content post-body\">\n" +
            "                  next test text on page 2\n" +
            "               </div>\n" +
            "            </div>\n" +
            "         </div>\n" +
            "      </div>\n" +
            "   </body>\n" +
            "</html>";

    static String lastPage = "<html>\n" +
            "   <head>\n" +
            "   </head>\n" +
            "   <body>\n" +
            "      <div id=\"container\">\n" +
            "         <div id=\"content\" class=\"\">\n" +
            "            <div class=\"pagination\">\n" +
            "               <span class=\"disabled prev\">«</span>\n" +
            "               <span class=\"current page\">3</span>\n" +
            "               <a href=\"?page=2\" class=\"page\">2</a>\n" +
            "               ...\n" +
            "               <span class=\"disabled next\">»</span>\n" +
            "            </div>\n" +
            "            <div id=\"d5\" class=\"q post\">\n" +
            "               <div class=\"bar\">\n" +
            "\t\t\t   <span class=\" points\" style=\"visibility: hidden;\">15</span>\n" +
            "               </div>\n" +
            "               <div class=\"quote post-content post-body\">\n" +
            "                  Test text on last page\n" +
            "               </div>\n" +
            "            </div>\n" +
            "         </div>\n" +
            "      </div>\n" +
            "   </body>\n" +
            "</html>";

}
