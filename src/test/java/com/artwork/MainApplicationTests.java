package com.artwork;

import com.api.MainApplication;
import com.api.Model.ArtistDO;
import com.api.Model.ArtworkDO;
import com.api.Model.NationalityDO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest(classes = MainApplication.class)
@AutoConfigureMockMvc
class MainApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	/*   ARTIST MODULE UNIT TESTS  */
	@Test
	public void testCreateArtist() throws Exception{
		ArtistDO artist = new ArtistDO();
		artist.setName("RasimCem");
		artist.setSurname("Aytan");
		artist.setBirth_year(1970);
		artist.setDeath_year(2021);
		artist.setBiography("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		artist.setImage_url("this is image location");
		NationalityDO nation = new NationalityDO();
		nation.setCity("Adana");
		nation.setCountry("Turkey");
		artist.setNation(nation);

		mockMvc.perform(post("/artist")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(artist)))
				.andExpect(status().isCreated())
				//.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").value("RasimCem"))
				.andExpect(jsonPath("$.surname").value("Aytan"))
				.andExpect(jsonPath("$.birth_year").value(1970))
				.andExpect(jsonPath("$.death_year").value(2021))
				.andExpect(jsonPath("$.biography").exists())
				.andExpect(jsonPath("$.image_url").value("this is image location"))
				.andExpect(jsonPath("$.nation.city").value("Adana"))
				.andExpect(jsonPath("$.nation.country").value("Turkey"));
	}

	@Test
	public void testGetArtist() throws Exception{
		String id="1";
		mockMvc.perform(get("/artist/{id}",id)
		.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.surname").exists())
				.andExpect(jsonPath("$.birth_year").exists())
				.andExpect(jsonPath("$.death_year").exists())
				.andExpect(jsonPath("$.biography").exists())
				.andExpect(jsonPath("$.image_url").exists())
				.andExpect(jsonPath("$.nation.country").exists())
				.andExpect(jsonPath("$.nation.city").exists());
	}

	@Test
	public void testGetAllArtist() throws Exception{
		mockMvc.perform(get("/artist/all")
		.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[*].id").exists())
				.andExpect(jsonPath("$[*].name").exists())
				.andExpect(jsonPath("$[*].surname").exists())
				.andExpect(jsonPath("$[*].birth_year").exists())
				.andExpect(jsonPath("$[*].death_year").exists())
				.andExpect(jsonPath("$[*].biography").exists())
				.andExpect(jsonPath("$[*].image_url").exists())
				.andExpect(jsonPath("$[*].nation.country").exists())
				.andExpect(jsonPath("$[*].nation.city").exists());
	}

	@Test
	public void testUpdateArtist() throws Exception{
		ArtistDO artist = new ArtistDO();
		artist.setId(2L);
		artist.setName("Test Name");
		artist.setSurname("Test Surname");
		artist.setBirth_year(1250);
		artist.setDeath_year(1300);
		artist.setBiography("test biography");
		artist.setImage_url("test image URL");
		NationalityDO nation = new NationalityDO();
		nation.setCity("test City");
		nation.setCountry("test Country");
		artist.setNation(nation);

		mockMvc.perform(put("/artist/")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJsonString(artist)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.surname").exists())
				.andExpect(jsonPath("$.birth_year").exists())
				.andExpect(jsonPath("$.death_year").exists())
				.andExpect(jsonPath("$.biography").exists())
				.andExpect(jsonPath("$.image_url").exists())
				.andExpect(jsonPath("$.nation.country").exists())
				.andExpect(jsonPath("$.nation.city").exists());
	}

	@Test
	public void testDeleteArtist() throws Exception{
		String id = "2";
		mockMvc.perform(delete("/artist/{id}",id)
		.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}


	/*  ARTWORK MODULE UNIT TESTS  */

	@Test
	public void testCreateArtwork() throws Exception{
		ArtworkDO artwork = new ArtworkDO();
		artwork.setName("Artwork test Name");
		artwork.setDescription("Artwork test Description");
		artwork.setImagePath("test image path");
		artwork.setCompletion_year(1277);
		artwork.setValue(4562);
		ArtistDO artist = new ArtistDO();
		artist.setName("RasimCem");
		artist.setSurname("Test Surname");
		artist.setBirth_year(1988);
		artist.setDeath_year(2001);
		artist.setBiography("test biography");
		artist.setImage_url("test image url");
		artwork.setArtist(artist);
		mockMvc.perform(post("/artwork")
		.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(artwork)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.description").exists())
				.andExpect(jsonPath("$.imagePath").exists())
				.andExpect(jsonPath("$.completion_year").exists())
				.andExpect(jsonPath("$.value").exists())
				.andExpect(jsonPath("$.artist.id").exists())
				.andExpect(jsonPath("$.artist.name").exists())
				.andExpect(jsonPath("$.artist.surname").exists())
				.andExpect(jsonPath("$.artist.birth_year").exists())
				.andExpect(jsonPath("$.artist.death_year").exists())
				.andExpect(jsonPath("$.artist.biography").exists())
				.andExpect(jsonPath("$.artist.image_url").exists())
				.andExpect(jsonPath("$.artist.nation.id").exists())
				.andExpect(jsonPath("$.artist.nation.country").exists())
				.andExpect(jsonPath("$.artist.nation.city").exists());

	}

	@Test
	public void testGetArtwork() throws Exception{
		String id = "2";
		mockMvc.perform(get("/artwork/{id}",id)
		.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.description").exists())
				.andExpect(jsonPath("$.imagePath").exists())
				.andExpect(jsonPath("$.completion_year").exists())
				.andExpect(jsonPath("$.value").exists())
				.andExpect(jsonPath("$.artist.id").exists())
				.andExpect(jsonPath("$.artist.name").exists())
				.andExpect(jsonPath("$.artist.surname").exists())
				.andExpect(jsonPath("$.artist.birth_year").exists())
				.andExpect(jsonPath("$.artist.death_year").exists())
				.andExpect(jsonPath("$.artist.biography").exists())
				.andExpect(jsonPath("$.artist.image_url").exists())
				.andExpect(jsonPath("$.artist.nation.id").exists())
				.andExpect(jsonPath("$.artist.nation.country").exists())
				.andExpect(jsonPath("$.artist.nation.city").exists());
	}

	@Test
	public void testGetAllArtwork() throws Exception{
		mockMvc.perform(get("/artwork/all")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[*].id").exists())
				.andExpect(jsonPath("$[*].name").exists())
				.andExpect(jsonPath("$[*].description").exists())
				.andExpect(jsonPath("$[*].imagePath").exists())
				.andExpect(jsonPath("$[*].completion_year").exists())
				.andExpect(jsonPath("$[*].value").exists())
				.andExpect(jsonPath("$[*].artist.id").exists())
				.andExpect(jsonPath("$[*].artist.name").exists())
				.andExpect(jsonPath("$[*].artist.surname").exists())
				.andExpect(jsonPath("$[*].artist.birth_year").exists())
				.andExpect(jsonPath("$[*].artist.death_year").exists())
				.andExpect(jsonPath("$[*].artist.biography").exists())
				.andExpect(jsonPath("$[*].artist.image_url").exists())
				.andExpect(jsonPath("$[*].artist.nation.id").exists())
				.andExpect(jsonPath("$[*].artist.nation.country").exists())
				.andExpect(jsonPath("$[*].artist.nation.city").exists());
	}

	@Test
	public void testUpdateArtwork() throws Exception{
		ArtworkDO artwork = new ArtworkDO();
		artwork.setId(2L);
		artwork.setName("Artwork test Name");
		artwork.setDescription("Artwork test Description");
		artwork.setImagePath("test image path");
		artwork.setCompletion_year(1277);
		artwork.setValue(4562);
		ArtistDO artist = new ArtistDO();
		artist.setName("RasimCem");
		artist.setSurname("Test Surname");
		artist.setBirth_year(1988);
		artist.setDeath_year(2001);
		artist.setBiography("test biography");
		artist.setImage_url("test image url");
		artwork.setArtist(artist);

		mockMvc.perform(put("/artwork")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(artwork)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.description").exists())
				.andExpect(jsonPath("$.imagePath").exists())
				.andExpect(jsonPath("$.completion_year").exists())
				.andExpect(jsonPath("$.value").exists())
				.andExpect(jsonPath("$.artist.id").exists())
				.andExpect(jsonPath("$.artist.name").exists())
				.andExpect(jsonPath("$.artist.surname").exists())
				.andExpect(jsonPath("$.artist.birth_year").exists())
				.andExpect(jsonPath("$.artist.death_year").exists())
				.andExpect(jsonPath("$.artist.biography").exists())
				.andExpect(jsonPath("$.artist.image_url").exists())
				.andExpect(jsonPath("$.artist.nation.id").exists())
				.andExpect(jsonPath("$.artist.nation.country").exists())
				.andExpect(jsonPath("$.artist.nation.city").exists());
	}

	@Test
	public void testDeleteArtwork() throws Exception {
		String id = "2";
		mockMvc.perform(delete("/artist/{id}",id)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}


	public static String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
