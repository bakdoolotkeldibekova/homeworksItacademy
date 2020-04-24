package itacademy.demo.controller;

import itacademy.demo.entity.Image;
import itacademy.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/image") //localhost:8080/image
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/{userId}")
    public Image create(@RequestParam(name = "file")MultipartFile multipartFile,  //больше одного RequestParam нельзя, когда MultipartFile
                        @PathVariable Long userId){
        return imageService.create(multipartFile, userId);
    }
    @PostMapping("/destroy/{name}") //localhost:8080/image/destroy/{name}
    public Boolean deleteByName(@PathVariable String name){
        return imageService.deleteByName(name);
    }

    @GetMapping
    public List<Image> getAll(){
        return imageService.getAll();
    }

    @GetMapping("/{id}")
    public Image getById(@PathVariable Long id){
        return imageService.getById(id);
    }

}
