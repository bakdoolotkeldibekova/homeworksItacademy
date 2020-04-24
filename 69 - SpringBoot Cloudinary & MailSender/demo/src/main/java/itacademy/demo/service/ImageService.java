package itacademy.demo.service;

import itacademy.demo.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    Image create(MultipartFile multipartFile, Long userId);
    List<Image> getAll();
    Image getById(Long id);
    Boolean deleteByName(String name);
}
