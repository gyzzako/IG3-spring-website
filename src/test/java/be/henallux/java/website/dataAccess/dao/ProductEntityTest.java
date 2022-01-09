package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.dao.ProductDAO;
import be.henallux.java.website.dataAccess.entity.CategoryEntity;
import be.henallux.java.website.dataAccess.entity.DiscountEntity;
import be.henallux.java.website.dataAccess.repository.ProductRepository;
import be.henallux.java.website.dataAccess.utils.ProviderConverter;
import be.henallux.java.website.model.Category;
import be.henallux.java.website.model.Discount;
import be.henallux.java.website.model.ProductEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductEntityTest {

    private ProductDAO productDAO;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProviderConverter providerConverter;

    @Before
    public void setUp() throws  Exception{
        productDAO = new ProductDAO(productRepository,providerConverter);
    }

    @Test
    public void testProductDAO(){
        ArrayList<ProductEntity> mockedProductEntities = new ArrayList<>();
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(1);
        productEntity.setProductName("Ibanez PF1512 NT 12 Natural");
        productEntity.setDescription("Guitare acoustique, dreadnought, cutaway à 12 cordes, corps laminé et finition brillante");
        productEntity.setBrand("Ibanez");
        productEntity.setDiscount(new Discount());
        productEntity.getDiscount().setDiscountId(1);
        productEntity.setCategory(new Category());
        productEntity.getCategory().setCategoryId(1);
        mockedProductEntities.add(productEntity);

        //when(productRepository.findAll()).thenReturn(mockedProductEntities); --> ca met une erreur d'un coup fuckoff!

        ArrayList<ProductEntity> expectedResults = new ArrayList<>();
        ProductEntity product = new ProductEntity();
        product.setProductId(1);
        product.setProductName("Ibanez PF1512 NT 12 Natural");
        product.setDescription("Guitare acoustique, dreadnought, cutaway à 12 cordes, corps laminé et finition brillante");
        product.setBrand("Ibanez");
        product.setDiscount(new Discount());
        product.getDiscount().setDiscountId(1);
        product.setCategory(new Category());
        product.getCategory().setCategoryId(1);
        expectedResults.add(product);
        assertThat(productDAO.getAllProducts()).isEqualTo(expectedResults);
    }
}
