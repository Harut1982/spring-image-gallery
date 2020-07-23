package am.harut.springimagegallery.controller;


import am.harut.springimagegallery.model.Category;
import am.harut.springimagegallery.model.Image;
import am.harut.springimagegallery.repository.CategoryRepository;
import am.harut.springimagegallery.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class MainController {
    @Value("${file.upload.dir}")
    private String uploadDir;

    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;


    @GetMapping("/")
    public String homePage(ModelMap modelMap) {

        List<Category> categories = categoryRepository.findAll();
        List<Image> images = imageRepository.findAll();
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("images", images);

        return "index";
    }

    @GetMapping("/adminPage")
    public String adminPage(ModelMap modelMap, @RequestParam(name = "msg", required = false, defaultValue = "Welcome Admin Page") String msg) {//deletic u addic ekac message @ndunelu hamar kgrenq @RequestParam(name="msg",required = false)

        List<Category> categories = categoryRepository.findAll();
        List<Image> images = imageRepository.findAll();
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("msg", msg);
        modelMap.addAttribute("images", images);

        return "adminPage";
    }




    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute Category category, @RequestParam("image") MultipartFile file) throws IOException {
        String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File image = new File(uploadDir, name);
        category.setPicUrl(name);
        file.transferTo(image);
        categoryRepository.save(category);

        return "redirect:/adminPage?msg=Category was added";

    }

    @PostMapping("/addImage")
    public String addImage(@ModelAttribute Image image, @RequestParam("image") MultipartFile file) throws IOException {

        String imagename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File images = new File(uploadDir, imagename);
        image.setPicUrl(imagename);
        file.transferTo(images);
        image.setUploadDate(LocalDateTime.now());
        imageRepository.save(image);


        return "redirect:/adminPage?msg=Image was added Successfully";
    }

    @GetMapping(
            value = "/image",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    @ResponseBody
    byte[] getImage(@RequestParam("name") String imageName) throws IOException {
        InputStream in = new FileInputStream(uploadDir + File.separator + imageName);
        return IOUtils.toByteArray(in);

    }

}
