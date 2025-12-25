package home.spring_ecommerce.webapi.controllers;

import home.spring_ecommerce.application.dtos.production.CreateCategoryDto;
import home.spring_ecommerce.application.dtos.production.UpdateCategoryDto;
import home.spring_ecommerce.application.services.CategoryService;
import home.spring_ecommerce.domain.views.CategoryView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/createCategory")
    public ResponseEntity<String> createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        try {
            categoryService.createCategory(createCategoryDto);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<String> updateCategory(@RequestBody UpdateCategoryDto updateCategoryDto) {
        try {
            categoryService.updateCategory(updateCategoryDto);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<?> getAllCategories() {
        try {
            List<CategoryView> productCategoryList = categoryService.getAllCategories();
            return new ResponseEntity<>(productCategoryList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCategory")
    public ResponseEntity<String> deleteCategory(@RequestParam Long categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}