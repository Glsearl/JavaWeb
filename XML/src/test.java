import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 15:52 2019/8/21
 * @Version: $
 */
public class test {
    public static void main(String[] args) throws IOException {
        String url="https://movie.douban.com/j/chart/top_list?type=11&interval_id=100%3A90&action=&start=0&limit=20";
        Connection.Response response = Jsoup.connect(url).ignoreContentType(true).execute();

        System.out.println();
    }
}
