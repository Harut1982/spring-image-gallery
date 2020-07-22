package am.harut.springimagegallery.service;


import am.harut.springimagegallery.model.Category;
import am.harut.springimagegallery.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;


    public void save(Category category){
        categoryRepository.save(category);
    }
//    public List<Category> categoryFindAll() {
//        return categoryRepository.findAll();
//    }

    public Optional<Category> findById(int id){
        return categoryRepository.findById(id);

    }


}
