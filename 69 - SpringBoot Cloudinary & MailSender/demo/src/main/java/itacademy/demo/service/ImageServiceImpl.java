package itacademy.demo.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import itacademy.demo.entity.Image;
import itacademy.demo.entity.User;
import itacademy.demo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private UserService userService;

    @Override
    public Image create(MultipartFile multipartFile, Long userId) {
        User user = userService.getById(userId);
        if(user == null) return null;

        final String urlKey = "cloudinary://119264965729773:1qhca12iztxCm0Df0nSBYtsIRF4@bagdash/"; //в конце добавляем '/'
        Image image = new Image();
        File file;
        try{
            file = Files.createTempFile(System.currentTimeMillis() + "",
                    multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().length()-4)) // .jpg
                    .toFile();
            multipartFile.transferTo(file);

            Cloudinary cloudinary = new Cloudinary(urlKey);
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            image.setName((String) uploadResult.get("public_id"));
            image.setUrl((String) uploadResult.get("url"));
            image.setFormat((String) uploadResult.get("format"));
            image.setUser(user);

            return imageRepository.save(image);
        }catch (IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image getById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteByName(String name) {
        final String urlKey = "cloudinary://119264965729773:1qhca12iztxCm0Df0nSBYtsIRF4@bagdash/";

        try{
            Cloudinary cloudinary = new Cloudinary(urlKey);
            Map result = cloudinary.uploader().destroy(name, ObjectUtils.emptyMap());
            return (result.toString()).equals("{result=ok}");
        }catch (IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
