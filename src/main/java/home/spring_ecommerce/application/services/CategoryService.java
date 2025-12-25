package home.spring_ecommerce.application.services;

import home.spring_ecommerce.application.dtos.production.CreateCategoryDto;
import home.spring_ecommerce.application.dtos.production.UpdateCategoryDto;
import home.spring_ecommerce.domain.entities.production.ProductCategory;
import home.spring_ecommerce.domain.views.CategoryView;
import home.spring_ecommerce.infrastructure.repositories.production.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(CreateCategoryDto createCategoryDto) {
        ProductCategory category = modelMapper.map(createCategoryDto, ProductCategory.class);
        categoryRepository.save(category);
    }

    public void updateCategory(UpdateCategoryDto updateCategoryDto) {
        ProductCategory productCategory = modelMapper.map(updateCategoryDto, ProductCategory.class);
        categoryRepository.updateCategory(productCategory);
    }

    public List<CategoryView> getAllCategories() {
        return categoryRepository.getCategories();
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
