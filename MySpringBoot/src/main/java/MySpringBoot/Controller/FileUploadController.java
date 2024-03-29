package MySpringBoot.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import MySpringBoot.Service.FileUploadService;

@RestController
public class FileUploadController {
	
	@Autowired
	FileUploadService fileUploadService;
	
	@PostMapping
	public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException { 
		fileUploadService.uploadFile(file);
	}
}
