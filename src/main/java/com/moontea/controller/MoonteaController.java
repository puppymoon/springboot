package com.moontea.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.moontea.dto.FormWrapper;
import com.moontea.dto.UploadRequest;
import com.moontea.dto.UploadResponse;

@Controller
public class MoonteaController { // !!請自行修正：GreetingController是這支程式的檔名

	@RequestMapping(value = "/hello") // 對應的網址
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name); // 讓HTML中的Thymeleaf語法{name}取得屬性值
		return "hello.html"; // !!請自行修正：剛才建立的HTML檔案名稱
	}

//	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public UploadResponse upload(
//			@PathVariable(name = "bucket-uuid", required = true) String bucketUUId,
//			@PathVariable(name = "folder", required = false) String folder, 
//			@Payload  UploadRequest uploadRequest) {
			@ModelAttribute UploadRequest uploadRequest) {

		MultipartFile[] files = uploadRequest.getFiles();
//		MultipartFile[] files = uploadfiles;

		// D:\test
		for (MultipartFile multipartFile : files) {

			String fileName = multipartFile.getOriginalFilename();

			try (OutputStream os = new FileOutputStream("D:\\test\\" + fileName)) {

				os.write(multipartFile.getBytes());
				os.flush();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		String data = uploadRequest.getData();
		UploadResponse uploadResponse = new UploadResponse();
		uploadResponse.setData(data);
		uploadResponse.setFiles(files);
		return uploadResponse;

	}
	
	
	@PostMapping("/test")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute FormWrapper model) {
        try {
            saveUploadedFile(model.getImage());
//            formRepo.save(mode.getTitle(),model.getDescription()); //Save as you want as per requirement 
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }
	
	private void saveUploadedFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("D:\\test\\" + file.getOriginalFilename());
            Files.write(path, bytes);
        }
    }

}