package pl.tb.extraction;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;

public class WebExtractor implements Extractor<WebData> {

    @Override
    public WebData extractDataFrom() {
        URL uri = null;
        try {
            uri = new URL("http://bash.org.pl/latest/");
            System.out.println(Jsoup.parse(uri, 5000).body().getElementById("d4862980").getElementsByClass("quote post-content post-body").html());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
