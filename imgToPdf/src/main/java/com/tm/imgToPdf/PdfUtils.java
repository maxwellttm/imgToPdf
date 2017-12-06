/**
 * 
 */
package com.tm.imgToPdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @Description: 生成pdf工具类,传入书对象
 * @author: tianmeng
 * @time: 2017年12月4日 下午3:54:25
 */
public class PdfUtils {
	public static void generatePDF(BookVO bookVO) throws Exception {
		// 创建文件
		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
		// 建立一个书写器
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(bookVO.getBookPath() + bookVO.getBookName()));

		// 打开文件
		document.open();
		// 添加内容
		// document.add(new Paragraph("1"));
		for (String pagePath : bookVO.getPagePathList()) {
			// 图片1
			Image image = Image.getInstance(pagePath);
			// 设置图片位置的x轴和y周
			image.setAbsolutePosition(0f, 0f);
			// 设置图片的宽度和高度
			image.scaleAbsolute(594, 840);
			/*
			 * Paragraph paragraph = new Paragraph(); 
			 * paragraph.setAlignment(2);
			 * Chapter chapter = new Chapter(paragraph,i++);
			 */

			Chapter chapter = new Chapter(1);
			chapter.add(image);
			// 居中
			// image1.setAlignment(Image.MIDDLE);
			// 文字绕图形
			// image1.setAlignment(Image.TEXTWRAP);

			// 将图片1添加到pdf文件中
			document.add(chapter);
		}

		// 关闭文档
		document.close();
		// 关闭书写器
		writer.close();
	}

}
