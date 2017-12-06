/**
 * 
 */
package com.tm.imgToPdf;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 文件夹对象, 存储文件夹路径和本文件夹下文件路径
 * @author: tianmeng
 * @time: 2017年12月5日 上午9:40:23
 */
public class FolderVO {

	private String folderPath;
	private List<String> folderPathList=new ArrayList<String>();
	private List<String> filePathList=new ArrayList<String>();
	public String getFolderPath() {
		return folderPath;
	}
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	public List<String> getFolderPathList() {
		return folderPathList;
	}
	public void setFolderPathList(List<String> folderPathList) {
		this.folderPathList = folderPathList;
	}
	public List<String> getFilePathList() {
		return filePathList;
	}
	public void setFilePathList(List<String> filePathList) {
		this.filePathList = filePathList;
	}
}
