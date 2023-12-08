package com.sigurd.geoguessr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "/application.properties")
class GeoguessrApplicationTests {
	@Test
	void contextLoads() {
	}

}
