package DataAPI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Sijan Bhandari
 */
public class Scrapper {

    private static Document page;
    private static Element table;
    public static Elements head, company, row;

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nepalipaisa.com/StockLive.aspx");
            page = Jsoup.parse(url, 10000);
            table = page.getElementById("tbl_LiveStock");
            row = page.getElementsByTag("tr");
            String[] data = new String[row.size() - 1];
            for (int i = 1; i < row.size(); i++) {
                data[i - 1] = row.get(i).getElementsByTag("td").get(0).text();
            }
            for (String sym : data) {
                displayCompany(sym);
            }
            
            System.out.println();
            System.out.println("Positive: "+positive);
            System.out.println("Negative: "+negative);
            System.out.println("Neutral: "+neutral);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Scrapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Scrapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Scrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static int positive = 0;
    static int negative = 0;
    static int neutral = 0;

    static void displayCompany(String sym) throws ParseException {
        String[] data = new String[10];
        for (int i = 1; i < row.size(); i++) {
            if (row.get(i).getElementsByTag("td").get(0).text().toLowerCase().equals(sym.toLowerCase())) {
                data[0] = row.get(i).getElementsByTag("td").get(0).text();
                data[1] = row.get(i).getElementsByTag("td").get(1).text();
                data[2] = row.get(i).getElementsByTag("td").get(2).text();
                data[3] = row.get(i).getElementsByTag("td").get(3).text();
                data[4] = row.get(i).getElementsByTag("td").get(4).text();
                data[5] = row.get(i).getElementsByTag("td").get(5).text();
                data[6] = row.get(i).getElementsByTag("td").get(6).text();
                data[7] = row.get(i).getElementsByTag("td").get(7).text();
                data[8] = row.get(i).getElementsByTag("td").get(8).text();
                data[9] = row.get(i).getElementsByTag("td").get(9).text();
            }

        }
        if (NumberFormat.getNumberInstance(java.util.Locale.US).parse(data[9]).doubleValue() > 0) {
            positive++;
        } else if (NumberFormat.getNumberInstance(java.util.Locale.US).parse(data[9]).doubleValue() < 0) {
            negative++;
        } else {
            neutral++;
        }
        System.out.println("-----------------------");
        System.out.println("Symbol:" + data[0]);
        System.out.println("Closing Price:" + data[1]);
        System.out.println("LTV:" + data[2]);
        System.out.println("%Change:" + data[3]);
        System.out.println("Max Price:" + data[4]);
        System.out.println("Min Price:" + data[5]);
        System.out.println("Opening Price:" + data[6]);
        System.out.println("Quantity:" + data[7]);
        System.out.println("No of Transaction:" + data[8]);
        System.out.println("Difference Rs.:" + data[9]);
        System.out.println("-----------------------");
    }
}
