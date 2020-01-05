package demo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigServerApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@LocalServerPort
	int port;

	@Test
	public void configurationAvailable() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + port + "/app/cloud", Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test @Ignore
	public void envPostAvailable() {
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = new TestRestTemplate().postForEntity(
				"http://localhost:" + port + "/admin/env", form, Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

}
