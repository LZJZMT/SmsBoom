package com.lzj.smsboom.utils;

import com.lzj.smsboom.bean.ProxyTargetEntry;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/11/16 13:06
 */
public class TelBoomProxy {
    public static volatile List<ProxyTargetEntry> phoneTargetEntryList = new ArrayList<>();

    private final static String tagetMobile = "18362939129";

    @PostConstruct
    public void initProxyTarget(){
        /*phoneTargetEntryList.add(new ProxyTargetEntry(httpEntity_JOB5156(),URL_JOB5156, HttpMethod.GET));
        phoneTargetEntryList.add(new ProxyTargetEntry(httpEntity_1BRC(),URL_1BRC, HttpMethod.POST));
        phoneTargetEntryList.add(new ProxyTargetEntry(httpEntity_AIRBNB(),URL_AIRBNB, HttpMethod.POST));
        phoneTargetEntryList.add(new ProxyTargetEntry(httpEntity_BOOKING(),URL_BOOKING, HttpMethod.POST));
        phoneTargetEntryList.add(new ProxyTargetEntry(httpEntity_51TALK(),URL_51TALK, HttpMethod.GET));
        phoneTargetEntryList.add(new ProxyTargetEntry(httpEntity_DOUBAN(),URL_DOUBAN, HttpMethod.POST));
        phoneTargetEntryList.add(new ProxyTargetEntry(httpEntity_KUAIDI100(),URL_KUAIDI100, HttpMethod.POST));
*/
    }


}
