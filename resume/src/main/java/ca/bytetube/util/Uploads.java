package ca.bytetube.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Uploads {
    public static final String DIR = "upload";
    public static final String IMG_DIR = DIR + "/img";


    public static Map<String, Object> getParams(HttpServletRequest request) throws Exception {
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        upload.setHeaderEncoding("UTF-8");
        List<FileItem> items = upload.parseRequest(request);
        Map<String, Object> params = new HashMap<>();
        for (FileItem item : items) {
            if (item.isFormField()) {//non file
                params.put(item.getFieldName(), item.getString("UTF-8"));
            } else {//file
                params.put(item.getFieldName(), item);
            }
        }

        return params;
    }

    public static String uploadImage(FileItem item, HttpServletRequest request, String oldPath) throws Exception {
        if (item == null) return oldPath;

        InputStream is = item.getInputStream();
        if (is == null || is.available() == 0) return oldPath;
        //新的文件路径
        String extension = FilenameUtils.getExtension(item.getName());
        String path = IMG_DIR + "/" + UUID.randomUUID() + "." + extension;
        //全路径
        String filePath = request.getServletContext().getRealPath(path);

        //写入文件内容
        FileUtils.copyInputStreamToFile(is,new File(filePath));

        //删除旧文件
        if (oldPath != null && oldPath.length() > 0) {
            String oldFilePath = request.getServletContext().getRealPath(oldPath);
            FileUtils.deleteQuietly(new File(oldFilePath));
        }

        return path;
    }
}
