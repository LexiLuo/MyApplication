package com.example.luoxuechun.myapplication.utils;
import java.io.*;
import java.net.*;
/**
 * Created by luoxuechun on 2017/5/19.
 */
public class LinkToServer {
    /**
     * 向指定URL发送GET方法的请求
     * @param url  发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        //TODO 未来部署的服务器链接头
        String header="http://localhost:8080";
        StringBuffer json=new StringBuffer();
        try {
            param = URLEncoder.encode(param, "utf-8");
            // 如有中文一定要加上，在接收方用相应字符转码即可
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            String urlString = header+ url;
            if(param!="") {
                urlString = header + url + "?" + param;
            }

            URL realUrl = new URL(new String(urlString.getBytes(),"utf-8"));
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
//            connection.addRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
//            connection.setRequestProperty("Content-type", "text/html");
//            connection.setRequestProperty("Accept-Charset", "utf-8");
//            connection.setRequestProperty("contentType", "utf-8");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            /*
             * Map<String, List<String>> map = connection.getHeaderFields(); //
             * 遍历所有的响应头字段 for (String key : map.keySet()) {
             * System.out.println(key + "--->" + map.get(key)); }
             */
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        //TODO 未来部署的服务器链接头
        String header="http://localhost:8080";

        StringBuffer json=new StringBuffer();
        PrintWriter out = null;

        try {
            String urlString = header+ url;
            URL realUrl = new URL(urlString);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("POST");

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(param);
            wr.flush();
            wr.close();
//            conn.setDoInput(true);
//            // 获取URLConnection对象对应的输出流
//            out = new PrintWriter(conn.getOutputStream());
//            // 发送请求参数
//            out.print(param);
//            // flush输出流的缓冲
//            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        }  catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public static void main(String args[]){
        LinkToServer link = new LinkToServer();
        String login="/login/result";
//        String userName="userName=aaa&password=11111";
//        System.out.print(link.sendGet(login,userName));
        String modifyPw = "/modifyPassword";
        System.out.print(link.sendPost(modifyPw,"username=aaa&newpw=12345"));
    }

}
