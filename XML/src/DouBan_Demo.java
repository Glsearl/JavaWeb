import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 11:28 2019/8/19
 * @Version: $
 * 豆瓣电影新片榜
 */
public class DouBan_Demo {
    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("https://movie.douban.com/chart");
        Document document = connect.get();
        Elements tables= document.getElementsByTag("table");
        Elements spans=null;
        for (Element table : tables) {
            Elements imgs = table.getElementsByTag("img");
           spans = table.getElementsByTag("span");
            for (Element span : spans) {
              if (span.hasClass("rating_nums")) {
                  String text = span.text();
                  float f= Float.parseFloat(text);
                  //只爬取8.0以上的电影
                  if (f>=8.0) {
                      for (Element img : imgs) {
                          String src = img.attr("src");
                          String name = img.attr("alt");
                          String photoName = name + ".jpg";
                          downloadImage(src, "d://reptile", photoName);
                      }
                  }
              }
            }
        }
    }
    public  static void downloadImage(String src,String path,String photoName) throws IOException {
        File dir=new File(path);
        if (!dir.exists()){
            dir.mkdir();
        }
        File file=new File(dir+File.separator+photoName);
        if (!file.exists()){
            file.createNewFile();
        }
        URL url=new URL(src);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setConnectTimeout(10000);
        InputStream inputStream = urlConnection.getInputStream();
        BufferedOutputStream but=new BufferedOutputStream(new FileOutputStream(file));
        byte[] byt=new byte[1024];
        int len;
        while ((len=inputStream.read(byt))!=-1){
            but.write(byt,0,len);
        }
        but.close();
        inputStream.close();
    }
}
