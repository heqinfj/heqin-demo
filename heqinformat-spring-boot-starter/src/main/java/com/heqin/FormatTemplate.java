package com.heqin;

/**
 * 序列化实现类，这个就是提供给用户用来序列化用的，看名字 Template 大家也能知道，
 * 比如我们常用的 RedisTemplate、JdbcTemplate，构造函数的时候直接传入具体的实现。
 */
public class FormatTemplate {

    private FormatProcessor formatProcessor;

    public FormatTemplate(FormatProcessor formatProcessor) {
        this.formatProcessor = formatProcessor;
    }

    public <T> String doFormat(T obj) {
        return formatProcessor.format(obj);
    }
}
