/**
 * 
 */
package com.tm.imgToPdf;

import java.io.File;

/**
 * @Description: 封装输入文件夹 下属的子文件和子文件夹
 * @author: tianmeng
 * @time: 2017年12月5日 上午9:31:01
 */
public class FileUtils {
	
	/**
	 * @Description: 由文件夹返回子文件夹和文件路径
	 * @param folderPath
	 * @return
	 * @return: String
	 */
	public static void getPackageFolder(FolderVO folderVO){
		File f = new File(folderVO.getFolderPath());
		
		if(!f.exists()){
			return;
		}
		
		File[] listFiles = f.listFiles();
		if(listFiles==null||listFiles.length==0){
			return;
		}
		
		for (File file : listFiles) {
			if(file.isDirectory()){
				folderVO.getFolderPathList().add(file.getAbsolutePath());
			}else if(file.isFile()){
				folderVO.getFilePathList().add(file.getAbsolutePath());
			}
		}
	}
}
