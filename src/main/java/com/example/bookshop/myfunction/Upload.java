package com.example.bookshop.myfunction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class Upload {

	public static String UploadImage(MultipartFile multipartFile) {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		Path store = Paths.get("Files-Upload");
		Path filePath = store.resolve(fileName);
		try {
			Files.copy(multipartFile.getInputStream(), filePath);
		} catch (IOException e) {
		}
		return fileName;
	}
}
