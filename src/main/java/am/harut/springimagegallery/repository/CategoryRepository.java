package am.harut.springimagegallery.repository;

import am.harut.springimagegallery.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
