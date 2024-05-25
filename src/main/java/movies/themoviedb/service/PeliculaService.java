package movies.themoviedb.service;

import com.google.gson.Gson;
import movies.themoviedb.entity.Pelicula;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PeliculaService {
    private static Pelicula[] conectarApi(String nombre){
        nombre = nombre.toLowerCase();
        final Gson gson = new Gson();

        try {
            URL pokeAPI = new URL("https://search.imdbot.workers.dev/?q=" + nombre);
            BufferedReader in = new BufferedReader(new InputStreamReader(pokeAPI.openStream(), StandardCharsets.UTF_8));
            Pelicula p[] = gson.fromJson(in, Pelicula[].class);
            return p;
        }catch (FileNotFoundException e){
            System.out.println("Peliculas no encontradas");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void urlPosterPelicula(String nombre){
        Pelicula p[] = conectarApi(nombre);

        for (Pelicula pelicula : p){
            System.out.println(pelicula.getDescription().getImg_Poster());
        }
    }


}
