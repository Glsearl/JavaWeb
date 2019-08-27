import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 11:05 2019/8/21
 * @Version: $
 * 豆瓣电影 Top 250
 */
public class DouBan_Demo2 {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i <= 250; ) {
            String url = "https://movie.douban.com/top250?start=" + i + "&filter=";
            Document document = Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36").get();
            Elements lis = document.getElementsByTag("li");
            for (Element li : lis) {
                Elements imgs = li.getElementsByTag("img");
                for (Element img : imgs) {
                    String name = img.attr("alt");
                    String src = img.attr("src");
                    String photoName = name + ".jpg";
                    downloadImage(src, "D:/top250", photoName);
                    //获取电影评分
                    Elements element = li.select("[class='rating_num']");
                    String score = element.text();
                    //获取演员信息
                    Elements ps = li.select("div > p:first-child");
                    String cast = ps.text();
                    System.out.println(name + "_" + score + "_" + cast + src);
                }
            }
            i += 25;
        }
        System.out.println("下载完成");

    }

    /**
     * 下载图片
     *
     * @param src       图片地址
     * @param path      本地存放地址
     * @param photoName 图片名字
     * @throws IOException
     */
    public static void downloadImage(String src, String path, String photoName) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir + File.separator + photoName);
        if (!file.exists()) {
            file.createNewFile();
        }
        URL url = new URL(src);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setConnectTimeout(10000);
        InputStream inputStream = urlConnection.getInputStream();
        BufferedOutputStream but = new BufferedOutputStream(new FileOutputStream(file));
        byte[] byt = new byte[1024];
        int len;
        while ((len = inputStream.read(byt)) != -1) {
            but.write(byt, 0, len);
        }
        but.close();
        inputStream.close();
    }
}
