package com.home;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class ImgUploadAction {
	private File upload; // 鏂囦欢
	private String uploadContentType; // 鏂囦欢绫诲瀷
	private String uploadFileName; // 鏂囦欢鍚�

	/**
	 * 鍥剧墖涓婁紶
	 * 
	 * @return
	 * @throws IOException
	 */
	public String imgUpload() throws IOException {

		// 鑾峰緱response,request
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();

		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// CKEditor鎻愪氦鐨勫緢閲嶈鐨勪竴涓弬鏁�
		String callback = request.getParameter("CKEditorFuncNum");
		String expandedName = ""; // 鏂囦欢鎵╁睍鍚�
		if (uploadContentType.equals("image/pjpeg")
				|| uploadContentType.equals("image/jpeg")) {
			// IE6涓婁紶jpg鍥剧墖鐨刪eadimageContentType鏄痠mage/pjpeg锛岃�IE9浠ュ強鐏嫄涓婁紶鐨刯pg鍥剧墖鏄痠mage/jpeg
			expandedName = ".jpg";
		} else if (uploadContentType.equals("image/png")
				|| uploadContentType.equals("image/x-png")) {
			// IE6涓婁紶鐨刾ng鍥剧墖鐨刪eadimageContentType鏄�image/x-png"
			expandedName = ".png";
		} else if (uploadContentType.equals("image/gif")) {
			expandedName = ".gif";
		} else if (uploadContentType.equals("image/bmp")) {
			expandedName = ".bmp";
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",''," + "'鏂囦欢鏍煎紡涓嶆纭紙蹇呴』涓�jpg/.gif/.bmp/.png鏂囦欢锛�);");
			out.println("</script>");
			return null;
		}
		if (upload.length() > 600 * 1024) {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",''," + "'鏂囦欢澶у皬涓嶅緱澶т簬600k');");
			out.println("</script>");
			return null;
		}

		InputStream is = new FileInputStream(upload);
		//鍥剧墖涓婁紶璺緞
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/img/uploadImg");
		String fileName = java.util.UUID.randomUUID().toString(); // 閲囩敤鏃堕棿+UUID鐨勬柟寮忛殢鍗冲懡鍚�
		fileName += expandedName;
		File file = new File(uploadPath);
		if (!file.exists()) { // 濡傛灉璺緞涓嶅瓨鍦紝鍒涘缓
			file.mkdirs();
		}
		File toFile = new File(uploadPath, fileName);
		OutputStream os = new FileOutputStream(toFile);
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();

		// 杩斿洖"鍥惧儚"閫夐」鍗″苟鏄剧ず鍥剧墖  request.getContextPath()涓簑eb椤圭洰鍚�
		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
				+ ",'" + request.getContextPath() + "/img/uploadImg/" + fileName + "','')");
		out.println("</script>");
		return null;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
}
