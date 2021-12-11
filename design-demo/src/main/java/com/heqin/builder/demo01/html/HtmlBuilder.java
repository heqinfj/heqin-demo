package com.heqin.builder.demo01.html;

import java.util.Arrays;

public class HtmlBuilder {

	//组装产品的部分
	private HeadingBuilder headingBuilder = new HeadingBuilder();

	//组装产品的部分
	private HrBuilder hrBuilder = new HrBuilder();

	//组装产品的部分
	private ParagraphBuilder paragraphBuilder = new ParagraphBuilder();

	//组装产品的部分
	private QuoteBuilder quoteBuilder = new QuoteBuilder();

	//返回产品
	public String toHtml(String markdown) {
		StringBuilder buffer = new StringBuilder();
		//java 11 语法
//		markdown.lines().forEach(line -> {
//			if (line.startsWith("#")) {
//				buffer.append(headingBuilder.buildHeading(line)).append('\n');
//			} else if (line.startsWith(">")) {
//				buffer.append(quoteBuilder.buildQuote(line)).append('\n');
//			} else if (line.startsWith("---")) {
//				buffer.append(hrBuilder.buildHr(line)).append('\n');
//			} else {
//				buffer.append(paragraphBuilder.buildParagraph(line)).append('\n');
//			}
//		});

		//替代lines()方法
		String lineTerminatorRegex = "\n|\r|\r\n";
		String[] splitMarkdownArr = markdown.split(lineTerminatorRegex);
		Arrays.stream(splitMarkdownArr).forEach(line -> {
			if (line.startsWith("#")) {
				buffer.append(headingBuilder.buildHeading(line)).append('\n');
			} else if (line.startsWith(">")) {
				buffer.append(quoteBuilder.buildQuote(line)).append('\n');
			} else if (line.startsWith("---")) {
				buffer.append(hrBuilder.buildHr(line)).append('\n');
			} else {
				buffer.append(paragraphBuilder.buildParagraph(line)).append('\n');
			}
		});
		return buffer.toString();
	}
}
