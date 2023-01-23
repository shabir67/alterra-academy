package com.Configure.SwaggerApi;

import com.Configure.SwaggerApi.repository.ProductRepository;
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
        productList.add(new Product(Long.valueOf(1), "Kipas", "Warna Kuning", 10, Long.valueOf(5000)));
        productList.add(new Product(Long.valueOf(2), "Kaca", "Warna Hitam", 5, Long.valueOf(10000)));
        given(productRepository.findAll()).willReturn(productList);

        List<Product> actualProductList = productService.getProducts();

        assertEquals(productList, actualProductList);
        assertEquals(productList.size(), actualProductList.size());
        then(productRepository).should(times(1)).findAll();
    }

    @Test
    public void getProductsWithIdWithDataExistTblExistDbExist_WillCallRepositoryFindAllAndReturnAllProducts () {
        int productId = 1;
        Product product = new Product(Long.valueOf(productId), "Kipas", "Warna Kuning", 10, Long.valueOf(5000));
        given(productRepository.findById(Long.valueOf(productId))).willReturn(Optional.of(product));

        Product actualProduct = productService.getProductById(Long.valueOf(1));

        assertEquals(product, actualProduct);
        then(productRepository).should(times(1)).findById(Long.valueOf(productId));
        then(productRepository).should(times(0)).findById(Long.valueOf(2));
    }

    @Test
    public void addProductWithProductNotExistDataExistTblExistDbExist_WillCallRepositoryFindAllAndReturnAllProducts () {
        Product product = new Product();
        product.setName("Sisir");
        product.setDescription("Warna Hijau");
        product.setStock(15);
        product.setPrice(Long.valueOf(7000));

        int productId = 1;
        Product expectedProduct = new Product(Long.valueOf(productId), product.getName(), product.getDescription(), product.getStock(), product.getPrice());
        given(productRepository.count()).willReturn(Long.valueOf(productId));
        given(productRepository.findById(anyLong())).willReturn(Optional.of(expectedProduct));

        Product actualProduct = productService.addProduct(product);

        then(productRepository).should(times(1)).count();
        then(productRepository).should(times(1)).save(any(Product.class));
        then(productRepository).should(atLeast(1)).findById(anyLong());
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void updateProductWithProductExistDataExistTblExistDbExist_WillCallRepositoryFindAllAndReturnAllProducts () {
        int id = 1;
        Product product = new Product(Long.valueOf(id), "Sepatu", "Sepatu Sekolah", 5, Long.valueOf(100000));
        given(productRepository.findById(Long.valueOf(id))).willReturn(Optional.of(product));

        Product actualProduct = productService.updateProduct(product);

        then(productRepository).should(times(1)).save(product);
        then(productRepository).should(times(1)).findById(product.getId());
        assertEquals(product,actualProduct);
    }

    @Test
    public void deleteProductWithProductExistDataExistTblExistDbExist_willCallRepositoryFindAllAndReturnAllProduct () {
        int id = 1;
        Product product = new Product(Long.valueOf(id), "Kertas", "Size A4", 100, Long.valueOf(5000));
        given(productRepository.findById(Long.valueOf(id))).willReturn(Optional.of(product));

        ResponseMessage actualResponseMessage = productService.deleteProduct(Long.valueOf(id));

        then(productRepository).should(times(1)).deleteById(Long.valueOf(id));
        assertEquals(new ResponseMessage("Product Deleted").getMsg(), actualResponseMessage.getMsg());
    }
}

