package am.harut.springimagegallery.repository;

import am.harut.springimagegallery.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Integer> {
     List<Image> findByCategoryId(int id);

}
