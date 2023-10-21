package com.Strong.Tshirt_Web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.Strong.Tshirt_Web.Entity.Products;

import jakarta.transaction.Transactional;

@Transactional
@Repository
@RepositoryRestResource(path = "Products")
public interface ProductRepo extends JpaRepository<Products, Integer> {

    /* SELECTING A SPECIFIC PRODUCT WITH IT'S ID AND GETTING IAMGES */
    @Query("SELECT p FROM Products p LEFT JOIN FETCH p.images i WHERE p.product_id = :productId")
    Products findProductWithImages(@Param("productId") Integer productId);

    /* SELECTING A SPECIFIC PRODUCT WITH IT'S ID AND GETTING SINGLE IMAGE */
    @Query("SELECT new com.Strong.Tshirt_Web.Repository.ProductWithImage(p, i) FROM Products p  LEFT JOIN Images i ON p.product_id = i.product.product_id  GROUP BY p.product_id")
    List<ProductWithImage> findProductsWithImage();

}
