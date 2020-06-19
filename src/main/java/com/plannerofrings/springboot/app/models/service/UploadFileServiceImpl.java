package com.plannerofrings.springboot.app.models.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

	private final static String UPLOAD_FOLDER = "uploads";

	@Override
	public String copy(MultipartFile bridePhoto) throws IOException {
		/*
		 * assign a unique name and concatenate the original name of the file to prevent
		 * files with the same name
		 */
		String uniqueFilename = UUID.randomUUID().toString() + "_" + bridePhoto.getOriginalFilename();

		// Save the absolute path of the file
		Path rootPath = getPath(uniqueFilename);

		// capture the possible errors that can occur with the file upload

		/*
		 * With copy -> copy the file in the indicated path / Get the input stream of
		 * the file that contains all the information necessary to save the file in the
		 * absolute path where the uploads directory is located
		 */
		Files.copy(bridePhoto.getInputStream(), rootPath);

		return uniqueFilename;
	}

	/*
	 * Method to get the absolute path of the file generate the uploads directory at
	 * the root of our project and use resolve to concatenate to path the unique
	 * file name
	 */
	public Path getPath(String filename) {
		return Paths.get(UPLOAD_FOLDER).resolve(filename).toAbsolutePath();
	}

}
