package kg.itacademy.filesystem.service;

import kg.itacademy.filesystem.entity.FileEntity;
import kg.itacademy.filesystem.repository.FileEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class FileEntityServiceImpl implements FileEntityService {
    final private String basePath = "C:\\Users\\Bakdoolot\\Downloads\\";

    @Autowired
    private FileEntityRepository fileEntityRepository;

    @Override
    public FileEntity create(MultipartFile multipartFile) {

        String name = String.valueOf(System.currentTimeMillis());
        String extension =
                multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().toString().lastIndexOf('.'));
        try {
            name = name+extension;
            Files.copy(multipartFile.getInputStream(), Paths.get(basePath+name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileEntity fileEntity = new FileEntity().setOriginalName(multipartFile.getOriginalFilename())
                .setName(name)
                .setExtension(extension)
                .setPath(basePath+name)
                .setSize(multipartFile.getSize());

       return fileEntityRepository.save(fileEntity);
    }

    @Override
    public Boolean deleteByName(String name) {
        FileEntity fileEntity = fileEntityRepository.findFirstByName(name);
        if(fileEntity == null){
            return false;
        }
        fileEntityRepository.deleteById(fileEntity.getId());
        return true;
    }

    @Override
    public Resource get(String name) {
        FileEntity fileEntity = fileEntityRepository.findFirstByName(name);

        String path = fileEntity.getPath();
        Resource resource = null;
        try {
            resource = new UrlResource(Paths.get(path).toUri());
            return resource;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] downloadByName(String name) {
        FileEntity fileEntity = fileEntityRepository.findFirstByName(name);
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(fileEntity.getPath()));
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
