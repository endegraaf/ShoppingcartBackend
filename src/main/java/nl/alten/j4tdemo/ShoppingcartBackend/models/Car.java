package nl.alten.j4tdemo.ShoppingcartBackend.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@EntityListeners(AuditingEntityListener.class)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "car_name", nullable = false)
    private String carName;

    @Column(name = "doors", nullable = false)
    private int doors;

    /**
     * Our getters and setters for the attributes above
     */
    @ApiModelProperty(name = "id",
            value = "The id of the car",
            example = "1")
    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    @ApiModelProperty(name = "carName",
            value = "The name of the car to be saved",
            example = "Bugatti",
            required = true)
    public String getCarName() {
        return carName;
    }

    public void setCarName(String value) {
        this.carName = value;
    }

    @ApiModelProperty(name = "doors",
            value = "The number of doors that the car has",
            example = "2",
            required = true)
    public int getDoors() {
        return doors;
    }

    public void setDoors(int value) {
        this.doors = value;
    }

}