package nl.alten.j4tdemo.ShoppingcartBackend.repository;

import nl.alten.j4tdemo.ShoppingcartBackend.models.Car;
import nl.alten.j4tdemo.ShoppingcartBackend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Car repository.
 *
 * @author Robley Gori - ro6ley.github.io
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}