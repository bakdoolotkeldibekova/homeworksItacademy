package kg.itacademy.filesystem.service;

import kg.itacademy.filesystem.entity.FileEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileEntityService {

    FileEntity create(MultipartFile multipartFile);
    Boolean deleteByName(String name);
    Resource get(String name);
    byte[] downloadByName(String name);
}
