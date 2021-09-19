package com.heqin.javabase;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * @Author heqin
 * @Date 2021/9/18 20:11
 */
public class StringTokenizerExample {

    /**
     * Constructs a string tokenizer for the specified string. The tokenizer uses the default delimiter set, which is <code>"&nbsp;&#92;t&#92;n&#92;r&#92;f"</code>:
     * the space character, the tab character, the newline character, the carriage-return character, and the form-feed character. Delimiter characters themselves will not be treated as tokens.
     * Params:
     * str – a string to be parsed.
     * Throws:
     * NullPointerException – if str is null
     *
     * 为指定的字符串构造一个字符串标记器。 分词器使用默认的定界符集，即" \t\n\r\f" ：空格字符、制表符、换行符、回车符和换页符。 分隔符本身不会被视为标记。
     * 参数：
     * str – 要解析的字符串。
     * 抛出：
     * NullPointerException – 如果 str 为null
     */
    @Test
    public void stringTokenizer(){
        String str = "this is a     test";
        //StringTokenizer st = new StringTokenizer(str);
        StringTokenizer st = new StringTokenizer(str, " \t\n\r\f", true);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
