package com.heqin.builder.demo01.html;

public class QuoteBuilder {

	public String buildQuote(String line) {
		//strip() java 11语法 -> 使用String.trim()或正则来替代
		//https://howtodoinjava.com/java11/strip-remove-white-spaces/
		//return "<blockquote>" + line.substring(1).strip() + "</blockquote>";
		return "<blockquote>" + line.substring(1).trim() + "</blockquote>";
	}
}
