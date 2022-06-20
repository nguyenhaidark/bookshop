package com.example.bookshop.myfunction;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class DowloadFile {
	static Path foundFile;

	public static Resource getFile(String fileName) throws Exception {
		Path store = Paths.get("Files-Upload");
		Files.list(store).forEach(file -> {
			if (file.getFileName().toString().startsWith(fileName)) {
				foundFile = file;
				return;
			}
		});
		if (foundFile != null) {
			return new UrlResource(foundFile.toUri());
		}
		return null;
	}
}
