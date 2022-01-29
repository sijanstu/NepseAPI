//By Sijan Bhandari
package DataAPI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class NepseAPI {
    //static final Constants
    private static final int TIMEOUT = 10000;
    private static final String URL = "https://www.nepalipaisa.com/StockLive.aspx";
    //static variables
    private static Document page;
    private static Element table;
    public static Elements head, company, row;

    public boolean isMarketOpen() {
        String closed = page.getElementsByClass("marketclose").get(0).text();
        return !closed.equals("Market Closed");
    }

    public String[] getHeader() {
        String[] data = new String[10];
        head = table.select("th");
        for (int i = 0; i < head.size(); i++) {
            data[i] = head.get(i).text();
        }
        return data;
    }

    public void startPage() throws MalformedURLException, IOException {
        page = Jsoup.parse(new URL(URL), TIMEOUT);
        table = page.getElementById("tbl_LiveStock");
        row = page.getElementsByTag("tr");
        // System.out.println(row);
    }
    public String[] getAllcompany(){
        String[] data = new String[row.size()-1];
        for (int i = 1; i < row.size(); i++) {
        data[i-1] = row.get(i).getElementsByTag("td").get(0).text();
        }
        return data;
    }
//    public String[] getAll() {
//        String[] data = new String[10];
//        for (int i = 1; i < row.size(); i++) {
//            data[0] = row.get(i).getElementsByTag("td").get(0).text();
//            data[1] = row.get(i).getElementsByTag("td").get(1).text();
//            data[2] = row.get(i).getElementsByTag("td").get(2).text();
//            data[3] = row.get(i).getElementsByTag("td").get(3).text();
//            data[4] = row.get(i).getElementsByTag("td").get(4).text();
//            data[5] = row.get(i).getElementsByTag("td").get(5).text();
//            data[6] = row.get(i).getElementsByTag("td").get(6).text();
//            data[7] = row.get(i).getElementsByTag("td").get(7).text();
//            data[8] = row.get(i).getElementsByTag("td").get(8).text();
//            data[9] = row.get(i).getElementsByTag("td").get(9).text();
//            System.out.println("-----------------------");
//            System.out.println("Symbol:" + data[0]);
//            System.out.println("Closing Price:" + data[1]);
//            System.out.println("LTV:" + data[2]);
//            System.out.println("%Change:" + data[3]);
//            System.out.println("Max Price:" + data[4]);
//            System.out.println("Min Price:" + data[5]);
//            System.out.println("Opening Price:" + data[6]);
//            System.out.println("Quantity:" + data[7]);
//            System.out.println("No of Transaction:" + data[8]);
//            System.out.println("Difference Rs.:" + data[9]);
//            System.out.println("-----------------------");
//            
//        }
//        return data;
//    }

    public String[] getBySymbol(String sym, boolean gui) {
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
        return data;

    }
}
