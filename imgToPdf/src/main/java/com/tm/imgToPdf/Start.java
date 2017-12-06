/**
 * 
 */
package com.tm.imgToPdf;

import java.util.List;

/**
 * @Description: 开始程序
 * @author: tianmeng
 * @time: 2017年12月5日 上午9:47:09
 */
public class Start {

	public static void main(String[] args) {
		/*
		 * 获取子文件夹或文件
		 */
		FolderVO folderVO = new FolderVO();
		folderVO.setFolderPath(Constants.inputFolderPath);
		FileUtils.getPackageFolder(folderVO);
		
		//将子文件夹的文件生成pdf
		multiFolder(folderVO);
		//将本文件夹文件生成 pdf
		oneFolder(folderVO);
		System.out.println("运行结束");
	}

	/**
	 * @Description: 取输入文件夹中图片生成pdf
	 * @return: void
	 */
	private static void oneFolder(FolderVO folderVO) {

		List<String> filePathList = folderVO.getFilePathList();

		/*
		 * 封装书
		 */
		BookVO bookVO = new BookVO();
		bookVO.setBookPath(Constants.outputFolderPath);
		bookVO.setBookName(Constants.bookName + ".pdf");

		// 封装书
		bookVO.getPagePathList().addAll(filePathList);

		try {
			// 生成书
			PdfUtils.generatePDF(bookVO);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	/**
	 * @Description: 取输入文件夹的 子文件夹生成book,每 多少个子文件夹的文件合并一起
	 * @return: void
	 */
	public static void multiFolder(FolderVO folderVO) {

		List<String> folderPathList = folderVO.getFolderPathList();
		int size = folderPathList.size();
		int n = size / Constants.folderNumPerBook;

		for (int i = 0; i < n; i++) {
			List<String> subList = folderPathList.subList(i * Constants.folderNumPerBook,
					(i + 1) * Constants.folderNumPerBook);

			/*
			 * 封装书
			 */
			BookVO bookVO = new BookVO();
			bookVO.setBookPath(Constants.outputFolderPath);
			bookVO.setBookName(Constants.bookName + i + ".pdf");

			/*
			 * 获取子文件夹下文件
			 */
			for (String subFolderPath : subList) {
				FolderVO subFolderVO = new FolderVO();
				subFolderVO.setFolderPath(subFolderPath);

				FileUtils.getPackageFolder(subFolderVO);

				List<String> filePathList = subFolderVO.getFilePathList();

				// 封装书
				bookVO.getPagePathList().addAll(filePathList);

			}

			try {
				// 生成书
				PdfUtils.generatePDF(bookVO);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}

		}
	}
}
