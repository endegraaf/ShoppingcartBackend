package nl.alten.j4tdemo.ShoppingcartBackend;

import nl.alten.j4tdemo.ShoppingcartBackend.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ShoppingcartApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MockingTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CarRepository repository;

    @Test
    void isMockWorking() throws Exception {

        mvc.perform(get("/api/v1/cars")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getHelloWorldFromMock() throws Exception {

        System.out.println(mvc.perform(post("/api/v1/cars")
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "\t\"carName\": \"Lightyear One\",\n" +
                        "\t\"doors\": 2\n" +
                        "}")
        ).andExpect(jsonPath(".carName").exists()));

    }
}
