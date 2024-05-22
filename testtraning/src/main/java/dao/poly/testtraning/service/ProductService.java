package dao.poly.testtraning.service;

import dao.poly.testtraning.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProduct();

    public String insertProduct(Product product);

    public String updateProduct(Product product, Long id);

    public void deleteProductById(long id);

    public Product getProductById(long id);

}
