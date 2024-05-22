package dao.poly.testtraning.repository;

import dao.poly.testtraning.entity.Brand;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query(value = "select * from brand", nativeQuery = true)
    List<Brand> getAllBrand();

    @Modifying
    @Transactional
    @Query(value = "insert into brand(brand_name) values(:brandName)", nativeQuery = true)
    int insertBrand(@Param("brandName") String brandName);

    @Modifying
    @Transactional
    @Query(value = "update brand set brand_name = :brandName where id = :id ", nativeQuery = true)
    int updateBrand(@Param("brandName") String brandName,@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from brand where id = :id", nativeQuery = true)
    int deleteBrand(@Param("id") Long id);
}
