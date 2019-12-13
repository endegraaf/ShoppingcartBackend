package nl.alten.j4tdemo.ShoppingcartBackend;

import nl.alten.j4tdemo.ShoppingcartBackend.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CarsApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ShoppingcartBackendApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private CarRepository repository;

	@Test
	void firstTest() throws Exception {
		HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		mvc.perform(get("/")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is5xxServerError());
	}


}
