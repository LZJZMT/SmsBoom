package com.lzj.smsboom.interceptor;

import com.lzj.smsboom.utils.BoomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/11/16 11:25
 */

public class HttpRequestAndResponseInterceptor implements ClientHttpRequestInterceptor {

    private static Logger log = LoggerFactory.getLogger(HttpRequestAndResponseInterceptor.class);

    @Value("${log.request.enable}")
    private boolean isLogRequest;
    @Value("${log.request.printHeaders}")
    private boolean isPrintHeaders;
    @Value("${log.request.printBody}")
    private boolean isPrintBody;
    @Value("${log.response.enable}")
    private boolean isLogResponse;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        //拦截所有请求 添加上常用头
        HttpHeaders headers = request.getHeaders();
        BoomUtils.initHttpHeaders(headers);
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        if (isLogRequest) {
            log.info("========request begin=========");
            log.info("URI         : {}", request.getURI());
            log.info("Method      : {}", request.getMethod());
            if (isPrintHeaders) {
                log.info("Headers     : {}", request.getHeaders());
            }
            if (isPrintBody) {
                log.info("Request body: {}", new String(body, StandardCharsets.UTF_8.name()));
            }
            log.info("========request end===========");
        }
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        if (isLogResponse) {
            log.info("========response begin=========");
            log.info("Status code  : {}", response.getStatusCode());
            log.info("Response body: {}", StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8));
            log.info("========response end===========");
        }
    }
}
