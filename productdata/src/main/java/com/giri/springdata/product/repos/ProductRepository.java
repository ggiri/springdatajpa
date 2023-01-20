package com.giri.springdata.product.repos;

import com.giri.springdata.product.entities.Product;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

 
    List<Product> findByName(String name);
    
    List<Product> findByNameAndDesc(String name, String desc);
    
    List<Product> findByPriceGreaterThan(Double price);
    
    List<Product> findByPriceBetween(Double price1, Double price2);
    
    List<Product> findByDescLike(String s);
    
    List<Product> findByIdIn(List<Integer> ids, Pageable pageable);
    
    List<Product> findByDescContains(String s);

    @Query(value = "CALL GetAllProducts", nativeQuery = true)
    List<Product> findAllProducts();

    @Query(value = "CALL GetAllProductsByPrice (:price_in)", nativeQuery = true)
    List<Product> findProductsByPrice(double price_in);

    @Query(value = "CALL GetAllProductsCountByPrice (:price_in)", nativeQuery = true)
    int findProductsCountByPrice(double price_in);
}
