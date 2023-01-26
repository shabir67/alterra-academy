package com.Configure.SwaggerApi;

import com.Configure.SwaggerApi.entitiy.Product;
import com.Configure.SwaggerApi.entitiy.ResponseMessage;
import com.Configure.SwaggerApi.repository.ProductRepository;
import com.Configure.SwaggerApi.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
@SpringBootTest(classes = {ProductService.class})
public class TestMockitoProductService {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ResponseMessage responseMessage;
    @InjectMocks
    private ProductService productService;

    @Test
    public void getProductsWithDataExistTblExistDbExist_WillCallRepositoryFindAllAndReturnAllProducts () {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(Long.valueOf(911), "Porsche 911", "GT3RS", 911, Long.valueOf(120000)));
        productList.add(new Product(Long.valueOf(720), "Mc-Larren Senna", "JDM Version", 720, Long.valueOf(300000)));
        given(productRepository.findAll()).willReturn(productList);

        List<Product> actualProductList = productService.getProducts();

        assertEquals(productList, actualProductList);
        assertEquals(productList.size(), actualProductList.size());
        then(productRepository).should(times(1)).findAll();
    }

    @Test
    public void getProductsWithIdWithDataExistTblExistDbExist_WillCallRepositoryFindAllAndReturnAllProducts () {
        int productId = 86;
        Product product = new Product(Long.valueOf(productId), "Toyota AE-86", "Takumi Version", 86, Long.valueOf(86000));
        given(productRepository.findById(Long.valueOf(productId))).willReturn(Optional.of(product));

        Product actualProduct = productService.getProductById(Long.valueOf(86));

        assertEquals(product, actualProduct);
        then(productRepository).should(times(1)).findById(Long.valueOf(productId));
        then(productRepository).should(times(0)).findById(Long.valueOf(2));
    }

    @Test
    public void addProductWithProductNotExistDataExistTblExistDbExist_WillCallRepositoryFindAllAndReturnAllProducts () {
        Product product = new Product();
        product.setId(2L);
        product.setName("Dodge Hellcat");
        product.setDescription("Red Anniversary");
        product.setStock(50);
        product.setPrice(Long.valueOf(90000));

        int productId = 1;
        Product expectedProduct = new Product(Long.valueOf(productId), product.getName(), product.getDescription(), product.getStock(), product.getPrice());
        given(productRepository.count()).willReturn(Long.valueOf(productId));
        given(productRepository.findById(anyLong())).willReturn(Optional.of(expectedProduct));

        Product actualProduct = productService.createProduct(product);

        then(productRepository).should(times(1)).count();
        then(productRepository).should(times(1)).save(any(Product.class));
        then(productRepository).should(atLeast(1)).findById(anyLong());
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void updateProductWithProductExistDataExistTblExistDbExist_WillCallRepositoryFindAllAndReturnAllProducts () {
        int id = 8;
        Product product = new Product(Long.valueOf(id), "BMW", "M8-CS", 8, Long.valueOf(1800000));
        given(productRepository.findById(Long.valueOf(id))).willReturn(Optional.of(product));

        Product actualProduct = productService.updateProduct(product);

        then(productRepository).should(times(1)).save(product);
        then(productRepository).should(times(1)).findById(product.getId());
        assertEquals(product,actualProduct);
    }

    @Test
    public void deleteProductWithProductExistDataExistTblExistDbExist_willCallRepositoryFindAllAndReturnAllProduct () {
        int id = 666;
        Product product = new Product(Long.valueOf(id), "Lexus LFA", "V10 powaaa", 3, Long.valueOf(1000000));
        given(productRepository.findById(Long.valueOf(id))).willReturn(Optional.of(product));

        ResponseMessage actualResponseMessage = productService.deleteProduct(Long.valueOf(id));

        then(productRepository).should(times(1)).deleteById(Long.valueOf(id));
        assertEquals(new ResponseMessage("Product deleted successfully").getMsg(), actualResponseMessage.getMsg());
    }
}

