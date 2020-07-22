package am.harut.springimagegallery.service;


import am.harut.springimagegallery.model.Image;
import am.harut.springimagegallery.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class ImageService {


    private final ImageRepository imageRepository;

//    public void save(Image image) {
//
//        imageRepository.save(image);
//    }


    public List<Image> imageFindByCategoryId(int id) {

        return imageRepository.findByCategoryId(id);
    }

}
