package com.giri.springdata.product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.giri.springdata.product.entities.Product;
import com.giri.springdata.product.repos.ProductRepository;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;

@SpringBootTest
class ProductdataApplicationTests {

    @Autowired
    ProductRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreate() {
        Product product = new Product();
        product.setId(1);
        product.setName("Pixel7");
        product.setDesc("Great camera");
        product.setPrice(60000.00);

        repository.save(product);

    }

    @Test
    void testRead() {
        Optional<Product> product = repository.findById(1);
        Assertions.assertNotNull(product);
        Assertions.assertEquals(1, product.get().getId());
        Assertions.assertEquals("Pixel7", product.get().getName());
        Assertions.assertEquals(60000.00, product.get().getPrice());

    }

    @Test
    void testUpdate() {
        Product product = repository.findById(1).get();
        product.setDesc("Best pixel till date");
        repository.save(product);

    }

    @Test
    void testDelete() {
        if (repository.existsById(1)) {
            repository.deleteById(1);
        }

    }

    @Test
    void testCount() {
        System.out.println("Count of products: " + repository.count());
    }


    @Test
    void testFindByName(){
        List<Product> product = repository.findByName("Pixel 7");
        Assertions.assertEquals("Pixel 7",product.get(0).getName());
        product.forEach(p-> System.out.println(p.getName()));
    }
    
    @Test
    void testFindByNameAndDesc(){
        List<Product> product = repository.findByNameAndDesc("Noise fusion", "Noise Inc");
        Assertions.assertEquals("Noise fusion",product.get(0).getName());
        product.forEach(p-> System.out.println(p.getName()));
    }

    @Test
    void testFindByPriceGreaterThan(){
        List<Product> products = repository.findByPriceGreaterThan(7000.00);
//        Assertions.assertEquals("Noise fusion",product.get(0).getName());
        Assertions.assertEquals(3,products.size());
        products.forEach(p-> System.out.println(p.getName()));
    }

    @Test
    void testFindByDescContains(){
        List<Product> products = repository.findByDescContains("ll");
        Assertions.assertEquals(1,products.size());
        products.forEach(p-> System.out.println(p.getName()));
    }
    
    @Test
    void testFindByPriceBetween(){
        List<Product> products = repository.findByPriceBetween(10000.00, 80000.00);
        Assertions.assertEquals(3,products.size());
        products.forEach(p-> System.out.println(p.getName()));
    }
    
    @Test
    void testFindByDescLike(){
        List<Product> products = repository.findByDescLike("%ll%");
        Assertions.assertEquals(1,products.size());
        products.forEach(p-> System.out.println(p.getName()));
    }
    
    @Test
    void testFindByIdsIn(){
        Pageable pageable = PageRequest.of(0,2);
        List<Product> products = repository.findByIdIn(Arrays.asList(1,2,3, 4), pageable);
        Assertions.assertEquals(2,products.size());
        products.forEach(p-> System.out.println(p.getName()));
    }

    @Test
    void testFindAllPaging(){
        Pageable pageable = PageRequest.of(1,2);
        Page<Product> results = repository.findAll(pageable);
        results.forEach(r-> System.out.println(r.getName()));
    }

    @Test
    void testFindAllSorting(){
        repository.findAll(Sort.by(Sort.Direction.DESC,"name")).forEach(p-> System.out.println(p.getName()+":"+p.getPrice()));
        repository.findAll(Sort.by(Sort.Direction.DESC,"name", "price")).forEach(p-> System.out.println(p.getName()+":"+p.getPrice()));
    }

    @Test
    void testFindAllPagingAndSorting(){

        Pageable pageable = PageRequest.of(0,2, Sort.Direction.DESC,"price");
        Page<Product> results = repository.findAll(pageable);
        for (Product result : results) {
            System.out.println(result.getName());
        }
    }
}
