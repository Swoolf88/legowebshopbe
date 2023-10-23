package com.swoolf.lego.utils;

import java.io.*;
import java.nio.file.*;

import org.springframework.web.multipart.MultipartFile;
public class FileUploadUtil {

    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile image) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = image.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }
}
