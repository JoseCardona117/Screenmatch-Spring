package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.service.ConsumoApi;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=supernatural&apikey=e56c8572");
		System.out.println(json);
		ConvierteDatos conversor = new ConvierteDatos();

		var datos = conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);
		json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=supernatural&Season=1&episode=1&apikey=e56c8572");
		DatosEpisodio episodios = conversor.obtenerDatos(json, DatosEpisodio.class);
		System.out.println(episodios);
	}

}
