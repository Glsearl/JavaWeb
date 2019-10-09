package reptile;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 8:58 2019/9/2
 * @Version: $
 */
public class DownloadFile {
    private static String fileName =null;
    public static void main(String[] args) throws Exception {
        int pageNumber=5;
        String cookieValue="7osfg3r5fan7vvpoob1isrltp3";
        for(int i=1;i<=pageNumber;i++) {
            Connection connect = Jsoup.connect("https://www.zhengtou.com/member/loanlist.html?"+"page="+pageNumber+"&"+"type=2");
            connect.cookie("PHPSESSID", cookieValue);
            Document document = connect.get();
            Elements tables = document.getElementsByTag("table");
            Element table = tables.get(0);
            Elements trs = table.getElementsByTag("tr");
            for (Element tr : trs) { //全部列表
                Elements as = tr.select("tr>td>a");
                for (Element a : as) {
                    String href = a.attr("href");
                    String url = "https://www.zhengtou.com" + href;
                    Connection connect1 = Jsoup.connect(url);
                    connect1.cookie("PHPSESSID", cookieValue);
                    Document document1 = connect1.get();
                    Elements as1 = document1.select("body > div.wapper > ul > li.right.checkContract_box > div > a");
                    Elements right_ckbqh_mms = document1.getElementsByClass("right ckbqh_mm");
                    for (Element right_ckbqh_mm : right_ckbqh_mms) {
                        fileName = right_ckbqh_mm.text();
                    }
                    for (Element a1 : as1) {
                        String data_url = a1.attr("data-url");

                        String[] split = data_url.split("&");
                        String s = split[0];
                        String replace = s.replace("http://cdp.easysign.cn/bqserver/check?", "https://cdp.easysign.cn/bqserver/external/download/allFile?");
                        String timeStamp = split[1];
                        String abstarct = split[2];
                        String ciphertext = split[3];
                        String downloadUrl = replace + "&" + timeStamp + "&" + abstarct + "&" + ciphertext;
                        download(downloadUrl, "D:\\downloadFile", fileName + ".zip");
                        System.out.println(fileName);
                        System.out.println("下载完成");
                    }
                }
            }
        }

    }
    public static void download(String urlPath, String path, String photoName) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir + File.separator + photoName);
        if (!file.exists()) {
            file.createNewFile();
        }
        URL url = new URL(urlPath);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setConnectTimeout(10000);
        InputStream inputStream = urlConnection.getInputStream();
        BufferedOutputStream but = new BufferedOutputStream(new FileOutputStream(file));
        byte[] byt = new byte[1024*10];
        int len;
        while ((len = inputStream.read(byt)) != -1) {
            but.write(byt, 0, len);
        }
        but.close();
        inputStream.close();
    }
}
