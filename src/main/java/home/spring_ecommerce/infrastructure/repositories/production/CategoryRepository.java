package home.spring_ecommerce.infrastructure.repositories.production;

import home.spring_ecommerce.domain.entities.production.ProductCategory;
import home.spring_ecommerce.domain.views.CategoryView;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CategoryRepository extends JpaRepository<ProductCategory,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE ProductCategory c SET c.name = :#{#category.name} WHERE c.id = :#{#category.id}")
    void updateCategory(@Param("category") ProductCategory category);

    @Query("SELECT new home.spring_ecommerce.domain.views.CategoryView(c.id, c.name) " +
            "FROM ProductCategory c")
    List<CategoryView> getCategories();
}
