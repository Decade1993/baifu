package com.baifu.erp.api.v1.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baifu.erp.constant.ResultCode;
import com.baifu.erp.constant.ResultMsg;
import com.baifu.erp.web.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.ArrayList;

@Api(value = "文件API", description = "文件API")
@RestController
@RequestMapping("/v1/file")
@CrossOrigin
public class FileController {

  @Value("${file_upload_location}")
  private String fileUploadLocation;

  @Value("${file_download_prefix}")
  private String fileDownloadPrefix;


  @ApiOperation(value = "上传文件")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "file", value = "file", required = true, paramType = "body", dataType = "file")
  })
  @PostMapping("")
  public ResponseBean upload(@ApiIgnore @RequestParam("file") MultipartFile[] multipartFiles) {
    ArrayList<String> urlList = new ArrayList<>();
    try {
      for (MultipartFile multipartFile : multipartFiles) {
        if (multipartFile.isEmpty()) {
          continue;
        }
        String md5Hex = DigestUtil.md5Hex(multipartFile.getInputStream());
        String fileName = multipartFile.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = md5Hex + suffixName;
        String fileLocation = fileUploadLocation + "/" + newFileName;
        if (!FileUtil.exist(fileLocation)) {
          FileUtil.writeBytes(multipartFile.getBytes(), fileLocation);
        }
        urlList.add(fileDownloadPrefix + "/" + newFileName);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ResponseBean(ResultCode.OK, ResultMsg.OK, urlList);
  }


}
