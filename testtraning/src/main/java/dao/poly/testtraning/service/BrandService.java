package dao.poly.testtraning.service;

import dao.poly.testtraning.entity.Brand;

import java.util.List;

public interface BrandService {

    public List<Brand> getAllBrand();

    public String insertBrand(Brand brand);

    public String updateBrand(Brand brand, Long id);

    public String deleteBrand( Long id);

}
