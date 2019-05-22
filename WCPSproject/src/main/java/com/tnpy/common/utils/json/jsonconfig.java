package com.tnpy.common.utils.json;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: LLS
 * @Date: 2018/12/26 14:24
 */
@Configuration
public class jsonconfig  extends WebMvcConfigurationSupport   {
    /**
     * 使用阿里 fastjson 作为JSON MessageConverter
     *
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        System.out.println("json初始化");
        config.setSerializerFeatures(
                //保留map空的字段
                SerializerFeature.WriteMapNullValue,
                // 将String类型的NULL转化为""
                SerializerFeature.WriteNullStringAsEmpty,
                // 将Number类型的NULL转化为0
                SerializerFeature.WriteNullNumberAsZero,
                // 将List类型的NULL转成[]
                SerializerFeature.WriteNullListAsEmpty,
                // 将Boolean类型的NULL转化为false
                SerializerFeature.WriteNullBooleanAsFalse,
                // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect);
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        List<MediaType> mediaTypeList = new ArrayList<>();
        // 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);
        converters.add(converter);
    }

}

