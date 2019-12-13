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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CarsApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MockingTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CarRepository repository;

    @Test
    void isMockWorking() throws Exception {

        mvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getHelloWorldFromMock() throws Exception {

        ResultMatcher expect = MockMvcResultMatchers.content().string("Hello World!");

        mvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(expect);
    }


}
