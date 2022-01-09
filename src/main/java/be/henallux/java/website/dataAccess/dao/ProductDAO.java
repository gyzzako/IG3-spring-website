package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.repository.ProductRepository;
import be.henallux.java.website.dataAccess.utils.ProviderConverter;
import be.henallux.java.website.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO implements ProductDataAccess{
    private ProductRepository productRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public ProductDAO(ProductRepository productRepository, ProviderConverter providerConverter){
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<ProductEntity> getAllProducts() {
        List<be.henallux.java.website.dataAccess.entity.ProductEntity> productEntities = productRepository.findAll();
        ArrayList<ProductEntity> products = new ArrayList<>();
        for (be.henallux.java.website.dataAccess.entity.ProductEntity entity : productEntities) {
            ProductEntity product = providerConverter.productEntityToProductModel(entity);
            products.add(product);
        }
        return products;
    }

    public ArrayList<ProductEntity> getAllProductByCategoryId(Integer categoryId){
        List<be.henallux.java.website.dataAccess.entity.ProductEntity> productEntities = productRepository.findByCategoryCategoryId(categoryId);
        ArrayList<ProductEntity> products = new ArrayList<>();
        for (be.henallux.java.website.dataAccess.entity.ProductEntity entity : productEntities) {
            ProductEntity product = providerConverter.productEntityToProductModel(entity);
            products.add(product);
        }
        return products;
    }

    public ProductEntity getProductById(Integer id){
        be.henallux.java.website.dataAccess.entity.ProductEntity productEntity = productRepository.findById(id).orElse(null);
        if(productEntity != null){
            ProductEntity product = providerConverter.productEntityToProductModel(productEntity);
            return product;
        }
        return null;
    }
}
