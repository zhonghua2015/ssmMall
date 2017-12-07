package com.mall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by eid on 2017/12/5.
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
