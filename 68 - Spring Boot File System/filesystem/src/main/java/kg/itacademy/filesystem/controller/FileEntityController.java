package kg.itacademy.filesystem.controller;

import kg.itacademy.filesystem.entity.FileEntity;
import kg.itacademy.filesystem.service.FileEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileEntityController {

    @Autowired
    private FileEntityService fileEntityService;

    @PostMapping
    public FileEntity create(@RequestParam("file") MultipartFile multipartFile){
        return fileEntityService.create(multipartFile);
    }

    @GetMapping(value = "/byte/{name}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] downloadByName(@PathVariable("name") String name){
        return fileEntityService.downloadByName(name);
    }

    @GetMapping(value = "/{name}",produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource getByName(@PathVariable("name") String name){
        return fileEntityService.get(name);
    }

    @DeleteMapping("/{name}")
    Boolean deleteByName(@PathVariable String name){
        return fileEntityService.deleteByName(name);
    }



}
