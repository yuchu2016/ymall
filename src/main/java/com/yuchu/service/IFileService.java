package com.yuchu.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: yuchu
 * @Description:
 * @Date: Create in 7:15 PM  10/10/2017
 * @Modified By:
 */
public interface IFileService {

    String upload(MultipartFile file, String path);

}
