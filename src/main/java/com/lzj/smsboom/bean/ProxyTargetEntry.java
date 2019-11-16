package com.lzj.smsboom.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/11/16 12:51
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProxyTargetEntry {

    private HttpEntity httpEntity;

    private String url;

    private HttpMethod httpMethod;
}
