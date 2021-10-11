package com.d4coders.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testConstructor() {
		Album album = new Album("Title","Artist",10,120,"https://i.ytimg.com/vi/NuPfJDRkW-E/hqdefault.jpg");
		album.setTitle("Title");
		assertEquals("Title",album.getTitle());
		album.setArtist("Artist");
		assertEquals("Artist",album.getArtist());
		album.setSongCount(20);
		assertEquals(20,album.getSongCount());
		album.setLength(10000);
		assertEquals(10000 , album.getLength());
	}

}
