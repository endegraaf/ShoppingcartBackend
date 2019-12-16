package nl.alten.j4tdemo.ShoppingcartBackend;

import nl.alten.j4tdemo.ShoppingcartBackend.models.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingcartApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/";
    }


    /**
     * Here we test that we can get all the products in the database
     * using the GET method
     */
    @Test
    public void testGetAllProducts() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/products",
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }

    /**
     * Here we test that we can fetch a single product using its id
     */
    @Test
    public void testGetProductById() {
        Product product = restTemplate.getForObject(getRootUrl() + "/products/1", Product.class);
    }
    /**
     * Here we test that we can create a product using the POST method
     */
    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setProductName("Prius");
        product.setPrice(100);

        ResponseEntity<Product> postResponse = restTemplate.postForEntity(getRootUrl() + "/products", product, Product.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    /**
     * Here we test that we can update a product's information using the PUT method
     */
    @Test
    public void testUpdateProduct() {
        int id = 1;
        Product product = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
        product.setProductName("Nike Air Max 2000");
        product.setPrice(75);

        restTemplate.put(getRootUrl() + "/products/" + id, product);

        Product updatedProduct = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
        Assert.assertNotNull(updatedProduct);
    }

    /**
     * Here we test that we can delete a product by using the DELETE method,
     * then we verify that it no longer exists in the database
     */
    @Test
    public void testDeleteProduct() {
        int id = 2;
        Product product = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
        Assert.assertNotNull(product);

        restTemplate.delete(getRootUrl() + "/products/" + id);

        try {
            product = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}
