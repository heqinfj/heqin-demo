package com.heqin;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置类，用来读取用户的选择，作用和 @Value 一样
 */
@ConfigurationProperties(prefix = FormatProperties.HEQIN_PREFIX)
public class FormatProperties {
    public static final String HEQIN_PREFIX = "heqin.format";
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
