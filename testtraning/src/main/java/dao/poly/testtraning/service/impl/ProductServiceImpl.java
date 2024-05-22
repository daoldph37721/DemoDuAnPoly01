package dao.poly.testtraning.service.impl;


import dao.poly.testtraning.entity.Product;
import dao.poly.testtraning.repository.ProductRepository;
import dao.poly.testtraning.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public String insertProduct(Product product) {
//        int x=productRepository.insertProduct(product.getProduceName(),product.getColor(),
//                product.getQuantity(), product.getSellPrice(),product.getOriginPrice(),
//                product.getDescription(),product.getStatus().getId());
//        int y=productRepository.insertBrandToProduct(product.getId(),product.getBrands().get(0).getId());
        Product pro = productRepository.save(product);
        return "Da them thanh cong";
    }

    @Override
    public String updateProduct(Product product, Long id) {
       return null;
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(long id) {
        Optional< Product > optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " + id);
        }
        return product;
    }


}
