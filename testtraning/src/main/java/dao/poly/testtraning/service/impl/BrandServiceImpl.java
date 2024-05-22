package dao.poly.testtraning.service.impl;

import dao.poly.testtraning.entity.Brand;
import dao.poly.testtraning.repository.BrandRepository;
import dao.poly.testtraning.service.BrandService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Transactional
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrand() {
        List<Brand> list = brandRepository.getAllBrand();
        return list;
    }

    @Override
    public String insertBrand(Brand brand) {
        int x=brandRepository.insertBrand(brand.getBrandName());
        if(x>0) return "Da them thanh cong";
        return "Da them that bai";
    }

    @Override
    public String updateBrand(Brand brand, Long id) {
        int x=brandRepository.updateBrand(brand.getBrandName(),id);
        if(x>0) return "Da cap nhat thanh cong";
        return "Da cap nhat that bai";
    }

    @Override
    public String deleteBrand(Long id) {
        int x=brandRepository.deleteBrand(id);
        if(x>0) return "Da xoa thanh cong";
        return "Da xoa that bai";
    }
}
