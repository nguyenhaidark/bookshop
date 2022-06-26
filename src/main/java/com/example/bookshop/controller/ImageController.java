package com.example.bookshop.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.myfunction.DowloadFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping
public class ImageController {

	@GetMapping("/image/{fileName}")
	public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileName) throws Exception {
		Resource resource = DowloadFile.getFile(fileName);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "\"" + fileName + "\"").body(resource);
	}
}
