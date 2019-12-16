package nl.alten.j4tdemo.ShoppingcartBackend.controller;

import io.swagger.annotations.ApiOperation;
import nl.alten.j4tdemo.ShoppingcartBackend.models.Product;
import nl.alten.j4tdemo.ShoppingcartBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ShoppingcartController {

    @Autowired
    private ProductRepository productRepository;

    @ApiOperation(value = "Fetches all products in the database.", response = Product.class)
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Create Product
     *
     * @param product the car
     * @return the product
     */
    @ApiOperation(value = "Handles the creation of a Product.", response = Product.class)
    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        System.out.println("Call save on product repository " +
                product.getProductName() + " " + product.getPrice());
        return productRepository.save(product);
    }



}
