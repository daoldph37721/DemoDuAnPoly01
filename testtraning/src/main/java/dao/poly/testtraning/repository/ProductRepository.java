package dao.poly.testtraning.repository;

import dao.poly.testtraning.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product", nativeQuery = true)
    List<Product> getAllProduct();

//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO product (produce_name, color, quantity, sell_price, origin_price, description, status_id) VALUES (:produceName, :color, :quantity, :sellPrice, :originPrice, :description, :statusId)", nativeQuery = true)
//    int insertProduct(@Param("produceName") String produceName, @Param("color") String color, @Param("quantity") Long quantity, @Param("sellPrice") Double sellPrice, @Param("originPrice") Double originPrice, @Param("description") String description, @Param("statusId") Long statusId);
//
//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO product_brand (product_id, brand_id) VALUES (:productId, :brandId)", nativeQuery = true)
//    int insertBrandToProduct(@Param("productId") Long productId, @Param("brandId") Long brandId);


}
