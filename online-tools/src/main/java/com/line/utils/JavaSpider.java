package com.line.utils;

import com.line.bean.UrlMapBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.text.SimpleDateFormat;

public class JavaSpider {

    private static String keyCode = "GBK";

    private static String PATH = "/home/care/work/jsoup/";
    public static void Save_Html(String url) {
        try {
            File dest = new File(PATH + MD5Tools.MD5(url) +".html");
            InputStream is;
            FileOutputStream fos = new FileOutputStream(dest);

            URL temp = new URL(url);
            URLConnection uc = temp.openConnection();
            uc.addRequestProperty("User-Agent", "Mozilla/5.0 (iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
            is = temp.openStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            int length;

            byte[] bytes = new byte[1024*20];
            while((length = bis.read(bytes, 0, bytes.length)) != -1){
                fos.write(bytes, 0, length);
            }

            bos.close();
            fos.close();
            bis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            try{
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)")
                        .timeout(3000)
                        .get();

                File dest = new File(PATH + MD5Tools.MD5(url) +".html");
                if(!dest.exists())
                    dest.createNewFile();
                FileOutputStream out=new FileOutputStream(dest,false);
                out.write(doc.toString().getBytes(keyCode));
                out.close();

            }catch (IOException E) {
                E.printStackTrace();
            }

        }
    }

    //解析本地的html
    public static List<UrlMapBean> Get_Localhtml(String path, String url) {
        List<UrlMapBean> beans = new ArrayList<>();
        File file = new File(path + MD5Tools.MD5(url)+".html");
        try{
            if(file.isFile()){
                Document doc = Jsoup.parse(file, keyCode);
                Elements contents = doc.getElementsByTag("body");
                Elements links = contents.get(0).getElementsByTag("a");
                for (Element link : links) {
                    String linkHref = link.attr("href");
                    String linkText = link.text();
                    if(linkText==null||linkText.equals("竞彩网")||linkText.equals("竞彩资讯")){
                        continue;
                    }
                    Save_Html(linkHref);
                    UrlMapBean urlMapBean = new UrlMapBean();
                    urlMapBean.setName(linkText);
                    urlMapBean.setUrl(linkHref);
                    urlMapBean.setInfo(Get_htmlInfo(PATH, linkHref));
                    beans.add(urlMapBean);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return beans;
    }

    //解析本地的html
    public static String Get_htmlInfo(String path, String url) {
        StringBuffer stringBuffer = new StringBuffer();
        File file = new File(path + MD5Tools.MD5(url)+".html");
        try{
            if(file.isFile()){
                Document doc = Jsoup.parse(file, keyCode);
                Elements contents = doc.getElementsByTag("body");
                if(contents.get(0).getElementsByClass("jc-article").size()<1){
                    return "";
                }
                Elements infoPs = contents.get(0).getElementsByClass("jc-article")
                        .get(0).getElementsByTag("p");
                int z = 0;
                for (Element element:infoPs){
                    z++;
                    if(z!=infoPs.size()-1&&z!=infoPs.size()-2&&z!=infoPs.size()){
                        stringBuffer.append(element.text());
                    }

                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
    public static List<UrlMapBean> resolveUrl(String url){
        Save_Html(url);
        //解析本地的网页地址
        return Get_Localhtml(PATH, url);
    }
    //main函数
    public static void main(String[] args) {
        List<UrlMapBean> urlMapBeans = resolveUrl("http://info.sporttery.cn/roll/fb_list.php?page=2&&c=%BE%BA%B2%CA%D7%A8%BC%D2");
        for (UrlMapBean urlMapBean : urlMapBeans){
            System.out.println(urlMapBean.getName()+":"+urlMapBean.getUrl()+":"+urlMapBean.getInfo());
        }
    }


}
