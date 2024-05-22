package dao.poly.testtraning.controller;

import dao.poly.testtraning.entity.Brand;
import dao.poly.testtraning.entity.Product;
import dao.poly.testtraning.service.BrandService;
import dao.poly.testtraning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService serviceProduct;

    @Autowired
    private BrandService serviceBrand;


    @GetMapping("/viewList")
    public String viewList(Model model) {
        model.addAttribute("listProducts", serviceProduct.getAllProduct());
        return "product";
    }

    @GetMapping("/viewCreate")
    public String viewCreate(Model model) {
        Product product = new Product();
        List<Brand> listBrand = serviceBrand.getAllBrand();
        model.addAttribute("product", product);
        model.addAttribute("listBrand", listBrand);
        model.addAttribute("successMessage", "Sản phẩm đã được tạo thành công.");
        return "create-product";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("product") Product product) {
        String check = serviceProduct.insertProduct(product);
        return "redirect:/product/viewList";
    }

    @GetMapping("/viewUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        List<Brand> listBrand = serviceBrand.getAllBrand();
        Product product = serviceProduct.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("listBrand", listBrand);
        return "update-product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        serviceProduct.deleteProductById(id);
        return "redirect:/product/viewList";
    }
//
//    @PutMapping("/updateProduct")
//    public String updateProduct(@ModelAttribute("product") Product product, Model model) {
//        String check = serviceProduct.insertProduct(product);
//        model.addAttribute("Message", "Da cap nhat thanh cong");
//        return "update-product";
//    }
}
