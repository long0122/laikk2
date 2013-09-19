package com.lkk.web.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class FileTools {
	private static final int BUFFER_SIZE = 16 * 1024;
	public static void copy(File src, File dst) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src),BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst),
                    BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public static File createFile(String dir,String fileName) {
		//若路径不存在，则自动创建
		File file = new File(dir);
		if(!file.exists()){ 
			file.mkdirs(); 
		} 
		String dirFull = dir+fileName;
		File file2 = new File(dirFull);
		if(file2.exists()){
			file2.delete();
		}
		return file2;
    }
	
	/**
	 * used by action
	 * @param request
	 * @param baseUrl  like : "uploadFile/";
	 * @param file
	 * @param fileFileName
	 * @return
	 */
	public static String getFilePath(HttpServletRequest request,String baseUrl,File file,String fileFileName) {
		if(file==null) return null;
		baseUrl += Tools.getCurrentDateSortNoTime() + "/";
		String picUrl = request.getSession().getServletContext()
				.getRealPath("/").replace("\\", "/")
				+ baseUrl;
		String fileName = new Date().getTime()+Tools.getExtention(fileFileName);
		File dstFile = FileTools.createFile(picUrl, fileName);
		FileTools.copy(file, dstFile);
		return baseUrl + fileName;
	}
	

}
