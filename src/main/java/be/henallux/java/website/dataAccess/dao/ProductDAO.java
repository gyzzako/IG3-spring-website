package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.entity.ProductEntity;
import be.henallux.java.website.dataAccess.repository.ProductRepository;
import be.henallux.java.website.dataAccess.utils.ProviderConverter;
import be.henallux.java.website.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDAO implements ProductDataAccess{
    private ProductRepository productRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public ProductDAO(ProductRepository productRepository, ProviderConverter providerConverter){
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        ArrayList<Product> products = new ArrayList<>();
        for (ProductEntity entity : productEntities) {
            Product product = providerConverter.productEntityToProductModel(entity);
            products.add(product);
        }
        return products;
    }

    public ArrayList<Product> getAllProductByCategoryId(Integer categoryId){
        List<ProductEntity> productEntities = productRepository.findByCategory_fkCategory_id(categoryId);
        ArrayList<Product> products = new ArrayList<>();
        for (ProductEntity entity : productEntities) {
            Product product = providerConverter.productEntityToProductModel(entity);
            products.add(product);
        }
        return products;
    }

    public Product getProductById(Integer id){
        ProductEntity productEntity = productRepository.findById(id).orElse(null);
        if(productEntity != null){
            Product product = providerConverter.productEntityToProductModel(productEntity);
            return product;
        }
        return null;
    }
}
