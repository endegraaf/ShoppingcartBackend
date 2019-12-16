package nl.alten.j4tdemo.ShoppingcartBackend.models;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "product_name", nullable = false)
    private String productName;

    /**
     * Our getters and setters for the attributes above
     */
    @ApiModelProperty(name = "id",
            value = "The id of the product",
            example = "1")
    public long getId() {
        return id;
    }
    public void setId(long value) {
        this.id = value;
    }

    @ApiModelProperty(name = "productName",
            value = "The name of the product to be saved",
            example = "Pills",
            required = true)
    public String getProductName() {
        return productName;
    }
    public void setProductName(String value) {

        System.out.println("PRODUCTNAME: " + value);
        this.productName = value;
    }

    @ApiModelProperty(name = "price",
            value = "The price of the product",
            example = "100",
            required = true)
    public long getPrice() {
        return price;
    }
    public void setPrice(int value) {
        System.out.println("PRODUCTPRICE: " + value);
        this.price = value;
    }

}