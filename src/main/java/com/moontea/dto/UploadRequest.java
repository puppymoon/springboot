package com.moontea.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadRequest implements Serializable {

	@JsonProperty("data")
	private String data;

	@JsonProperty("files")
	private MultipartFile[] files;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

}
