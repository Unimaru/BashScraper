package pl.tb.extraction;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;

public class ExtractService {

    public void extractData() throws IOException {
        URL uri = new URL("http://bash.org.pl/latest/");
        System.out.println(Jsoup.parse(uri, 5000).body().getElementById("d4862980").getElementsByClass("quote post-content post-body").html());
    }
}
