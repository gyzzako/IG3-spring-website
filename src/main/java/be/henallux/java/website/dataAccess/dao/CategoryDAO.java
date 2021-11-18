package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.entity.CategoryEntity;
import be.henallux.java.website.dataAccess.repository.CategoryRepository;
import be.henallux.java.website.dataAccess.utils.ProviderConverter;
import be.henallux.java.website.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryDAO implements CategoryDataAccess{
    private CategoryRepository categoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, ProviderConverter providerConverter){
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Category> getAllCategories(){
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        ArrayList<Category> categories = new ArrayList<>();
        for(CategoryEntity entity : categoryEntities){
            Category category = providerConverter.categoryEntityToCategoryModel(entity);
            categories.add(category);
        }
        return categories;
    }

}
