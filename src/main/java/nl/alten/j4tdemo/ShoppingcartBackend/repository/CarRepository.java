package nl.alten.j4tdemo.ShoppingcartBackend.repository;

import nl.alten.j4tdemo.ShoppingcartBackend.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Car repository.
 *
 * @author Robley Gori - ro6ley.github.io
 */
public interface CarRepository extends JpaRepository<Car, Long> {

}