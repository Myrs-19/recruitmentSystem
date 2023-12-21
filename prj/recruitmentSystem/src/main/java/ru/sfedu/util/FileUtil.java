/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.util;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author mike
 */
public class FileUtil {
    private static final Logger log = LogManager.getLogger(FileUtil.class.getName());
    
    public static void createFolderIfNotExists(String folderPath) throws IOException {
        File file = new File(folderPath);
        if (!file.exists()) {
            boolean flag = file.mkdirs();
            log.debug("createFolderIfNotExists [1]: New folder {}, is created: {}", file.getAbsolutePath(), flag);
        } else {
            log.debug("createFolderIfNotExists [2]: Folder {} is exists", file.getAbsolutePath());
        }
    }
    
    public static void createFileIfNotExists(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
            log.debug("createFileIfNotExists [1]: New file {}, is created: {}", filePath);
        } else {
            log.debug("createFileIfNotExists [2]: File {} is exists", filePath);
        }
    }

    public static void deleteFileOrFolderIfExists(String folderPath) {
        File file = new File(folderPath);
        if (file.exists()) {
            boolean flag = file.delete();
            log.debug("deleteFileOrFolderIfExists [1]: Folder of file {}, is deleted: {}", file.getAbsolutePath(), flag);
        } else {
            log.debug("deleteFileOrFolderIfExists [2]: Folder or file {} is not exists", file.getAbsolutePath());
        }
    }
    
}
