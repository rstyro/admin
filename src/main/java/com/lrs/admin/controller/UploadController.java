package com.lrs.admin.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lrs.admin.util.DateUtil;
import com.lrs.admin.util.ImgUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private final ResourceLoader resourceLoader;  
	
	@Value("${upload.root.folder}")
	public String root_fold;
	
	@Value("${img.folder}")
	public String img_fold;
	
	@Value("${user.folder}")
	public String user_folder;
	
	
    @Autowired 
    public UploadController(ResourceLoader resourceLoader) {  
        this.resourceLoader = resourceLoader;  
    }  
	
	@RequestMapping(value = "/img" ,method = RequestMethod.POST)
	@ResponseBody
	public String imgUpload(@RequestParam(value = "file") MultipartFile file){
		if (file.isEmpty()) {
            return null;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = root_fold+img_fold+DateUtil.getDays()+"/";
        System.out.println("upload_img_folder="+root_fold);
        System.out.println("upload_folder_root="+img_fold);
        System.out.println("filePath="+filePath);
        ImgUtil.createFile(filePath, fileName);
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            System.out.println("upload  success");
        }catch (IOException e) {
            e.printStackTrace();
            return "failed";
        }
		return filePath+fileName;
	}
	
	/**
     * 显示上传根目录的图片或文件
     * @param filename
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/show/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(root_fold, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * 显示上传的图片
     * @param folderName
     * @param date
     * @param filename
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/show/{folderName}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getImg(@PathVariable("folderName") String folderName,@PathVariable("filename") String filename) {
    	try {
    		return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(root_fold+"/"+folderName, filename).toString()));
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
    }
}
