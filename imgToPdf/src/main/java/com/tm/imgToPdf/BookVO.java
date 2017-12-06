/**
 * 
 */
package com.tm.imgToPdf;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 书对象
 * @author: tianmeng
 * @time: 2017年12月5日 上午9:50:11
 */
public class BookVO {
	//生成的书所在文件夹
	private String bookPath;
	//书名
	private String bookName;
	//书页图片所在路径
	private List<String> pagePathList=new ArrayList<String>();
	
	public String getBookPath() {
		return bookPath;
	}
	public void setBookPath(String bookPath) {
		this.bookPath = bookPath;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public List<String> getPagePathList() {
		return pagePathList;
	}
	public void setPagePathList(List<String> pagePathList) {
		this.pagePathList = pagePathList;
	}
	
}
