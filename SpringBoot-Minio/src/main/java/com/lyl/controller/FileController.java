package com.lyl.controller;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/23
 */

@RestController
@CrossOrigin("*")    //解决跨域问题
public class FileController {
	@Value("${minio.bucketName}")
	private String bucketName;
	@Value("${minio.endpoint}")
	private String endpoint;
	@Value("${minio.port}")
	private Integer port;
	@Value("${minio.secure}")
	private Boolean secure;
	@Value("${minio.accessKey}")
	private String accessKey;
	@Value("${minio.secretKey}")
	private String secretKey;

	@PostMapping("/upload")
	public String upload(MultipartFile file) {
		MinioClient minioClient = MinioClient.builder().endpoint(endpoint, port, secure).credentials(accessKey,
																									 secretKey).build();
		String objectUrl = "";
		try {
			boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
			if (exists) {
				System.out.println("bucket is already exist");
			} else {
				//程序创建桶
				minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
			}

			//设计一个存储对象
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String fileName = file.getOriginalFilename();
			String objectName = dateFormat.format(new Date()) + "/" + fileName;

			//用于存储文件对象   file---->minio服务器
			minioClient.putObject(
					PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(file.getInputStream(),
																						 file.getSize(), -1).build());

			//获取文件在minio服务器上的完整访问路径
			objectUrl = minioClient.getObjectUrl(bucketName, objectName);
			System.out.println("文件路径：" + objectUrl);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectUrl;
	}
}
