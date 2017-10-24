import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.net.InetAddress;
import java.security.GeneralSecurityException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, GeneralSecurityException {

        final WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setUseInsecureSSL(true);


        HtmlPage resultPage = webClient.getPage("https://www.leboncoin.fr/telephonie/offres/rhone_alpes/rhone/?th=1&q=iphone&location=Villeurbanne%2069100&ps=8&pe=10");


        List<HtmlListItem> offres = resultPage.getByXPath("//*[@id='listingAds']/section/section/ul/li");

        if (!offres.isEmpty()) {
            for (HtmlListItem offre : offres) {
                System.out.println(offre.asText());
            }

        } else {
            System.out.println("no result");
        }


    }
}