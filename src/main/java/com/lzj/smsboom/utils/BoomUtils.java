package com.lzj.smsboom.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/11/15 21:51
 */
public class BoomUtils {

    /**
     *
     * @return 带常用Header 和 空body的HttpEntity
     */
    public static HttpEntity initHttpEntity(){
        HttpHeaders requestHeaders = new HttpHeaders();
        initHttpHeaders(requestHeaders);
        Map<Object, Object> body = new LinkedMultiValueMap();
        HttpEntity httpEntity = new HttpEntity(body,requestHeaders);
        return httpEntity;
    }

    @Deprecated
    public static HttpEntity getEmptyHttpEntity(){
        HttpHeaders requestHeaders = new HttpHeaders();
        Map<Object, Object> body = new LinkedMultiValueMap();
        HttpEntity httpEntity = new HttpEntity(body,requestHeaders);
        return httpEntity;
    }

    public static void initHttpHeaders(HttpHeaders requestHeaders) {
        requestHeaders.setAccept(Arrays.asList(MediaType.ALL,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML));
        requestHeaders.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));
        requestHeaders.set(HttpHeaders.USER_AGENT,"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
        requestHeaders.set(HttpHeaders.CONNECTION,"keep-alive");
        //会引起乱码，原因待查
        //requestHeaders.set(HttpHeaders.ACCEPT_ENCODING,"gzip, deflate");
        requestHeaders.set("X-Requested-With","XMLHttpRequest");
    }

}
