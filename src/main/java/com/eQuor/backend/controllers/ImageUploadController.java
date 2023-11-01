package com.eQuor.backend.controllers;

import com.eQuor.backend.utils.FileUploadUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@RequestMapping("/api/v1/img")
@RestController
public class ImageUploadController {
    @PostMapping("/upload")
    public void saveImage(@RequestParam("userImages") MultipartFile[] userImages){
        String uploadDir = "ProfileImages";
        Arrays.asList(userImages).stream().forEach(userImage->{
            String Name = StringUtils.cleanPath(Objects.requireNonNull(userImage.getOriginalFilename()));
            String fileName = "Propic"+Name;
            System.out.println(fileName);
            try{
                byte[] bytes = userImage.getBytes();
                System.out.println(bytes);
            }catch (IOException ioException){

            }
        });

    }


}
