package dao.poly.testtraning.controller;

import dao.poly.testtraning.entity.Brand;
import dao.poly.testtraning.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService service;

    @GetMapping("")
    public ResponseEntity<?> getAllBrand(){
        List<Brand> list = service.getAllBrand();
        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    public ResponseEntity<?> insertBrand(@RequestBody Brand brand){
        String kq=service.insertBrand(brand);
        return  ResponseEntity.ok(kq);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updateBrand(@RequestBody Brand brand, @PathVariable Long id){
        String kq=service.updateBrand(brand,id);
        return  ResponseEntity.ok(kq);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id){
        String kq=service.deleteBrand(id);
        return  ResponseEntity.ok(kq);
    }
}
