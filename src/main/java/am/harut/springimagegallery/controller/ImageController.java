package am.harut.springimagegallery.controller;


import am.harut.springimagegallery.model.Category;

import am.harut.springimagegallery.service.CategoryService;
import am.harut.springimagegallery.service.ImageService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class ImageController {




    private final ImageService imageService;
    private final CategoryService categoryService;



@GetMapping("/categoryImages")
public String categoryImg(@RequestParam("id") int id, ModelMap modelMap) {
    Optional<Category> one = categoryService.findById(id);
    if (!one.isPresent()) {
        return "redirect:/";
    }
    modelMap.addAttribute("category", one.get());
    modelMap.addAttribute("images", imageService.imageFindByCategoryId(id));
    return "categoryImages";
}


}
