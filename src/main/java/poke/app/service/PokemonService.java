package poke.app.service;

import com.google.gson.Gson;
import poke.app.entity.Pokemon;
import poke.app.entity.PokemonChain;
import poke.app.entity.PokemonImages;
import poke.app.entity.PokemonSpecies;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PokemonService {

    private static Pokemon llamadasAPI(String nombre){
        nombre = nombre.toLowerCase();
        final Gson gson = new Gson();

        try {
            URL pokeAPI = new URL("https://pokeapi.co/api/v2/pokemon/" + nombre);
            BufferedReader in = new BufferedReader(new InputStreamReader(pokeAPI.openStream(), StandardCharsets.UTF_8));
            Pokemon p = gson.fromJson(in, Pokemon.class);
            return p;
        }catch (FileNotFoundException e){
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Pokemon llamadasAPIporID(int id){
        final Gson gson = new Gson();

        try {
            URL pokeAPI = new URL("https://pokeapi.co/api/v2/pokemon/" + id);
            BufferedReader in = new BufferedReader(new InputStreamReader(pokeAPI.openStream(), StandardCharsets.UTF_8));
            Pokemon p = gson.fromJson(in, Pokemon.class);
            return p;
        }catch (FileNotFoundException e){
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static PokemonChain llamadasAPIPokemonChainID(int id){
        final Gson gson = new Gson();

        try {
            URL pokeAPI = new URL("https://pokeapi.co/api/v2/evolution-chain/" + id);
            BufferedReader in = new BufferedReader(new InputStreamReader(pokeAPI.openStream(), StandardCharsets.UTF_8));
            PokemonChain p = gson.fromJson(in, PokemonChain.class);
            return p;
        }catch (FileNotFoundException e){
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static PokemonSpecies llamadasAPISpecies(String nombre){
        nombre = nombre.toLowerCase();
        final Gson gson = new Gson();

        try {
            URL pokeAPI = new URL("https://pokeapi.co/api/v2/pokemon-species/" + nombre);
            BufferedReader in = new BufferedReader(new InputStreamReader(pokeAPI.openStream(), StandardCharsets.UTF_8));
            PokemonSpecies p = gson.fromJson(in, PokemonSpecies.class);
            return p;
        }catch (FileNotFoundException e){
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static PokemonSpecies llamadasAPISpeciesID(int id){
        final Gson gson = new Gson();

        try {
            URL pokeAPI = new URL("https://pokeapi.co/api/v2/pokemon-species/" + id);
            BufferedReader in = new BufferedReader(new InputStreamReader(pokeAPI.openStream(), StandardCharsets.UTF_8));
            PokemonSpecies p = gson.fromJson(in, PokemonSpecies.class);
            return p;
        }catch (FileNotFoundException e){
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Pokemon getPokemon(String name){
        Pokemon p = llamadasAPI(name);
        return p;
    }

    public static Pokemon getPokemon(int id){
        Pokemon p = llamadasAPIporID(id);
        return p;
    }

    public static String getName(int id){
        try {
            Pokemon p = llamadasAPIporID(id);
            return p.name;
        }catch(NullPointerException e){
            return "VACÍO";
        }
    }

    public static String getDescription(String name){
        PokemonSpecies pe = llamadasAPISpecies(name);
        for (PokemonSpecies.FlavorTextEntry i : pe.flavor_text_entries){
            if(i.language.name.equals("en")){
                return i.flavor_text;
            }
        }
        return null;
    }

    public static String urlSpritePokemon(String nombre){
        Pokemon p = llamadasAPI(nombre);
        //Sprites pequeñitos
        //String sprite = p.sprites.versions.generationVIII.icons.frontDefault;
        //Sprites más grandecitos
        //String sprite = p.sprites.frontDefault;
        //Sprites animados
        String sprite = p.sprites.other.showdown.frontDefault;
        return sprite;
    }

    public static String urlSpritePokemonByID(int id){

        if (id != 0)
        {
            Pokemon p = llamadasAPIporID(id);
            //Sprites pequeñitos
            //String sprite = p.sprites.versions.generationVIII.icons.frontDefault;
            //Sprites más grandecitos
            //String sprite = p.sprites.frontDefault;
            //Sprites animados
            String sprite = p.sprites.other.showdown.frontDefault;
            return sprite;
        }
       else
        {
            return "src/main/resources/img/defaultPokeball.png";
        }
    }

    public static String urlSpritePokemonByIDStatico(int id){

        if (id != 0)
        {
            Pokemon p = llamadasAPIporID(id);
            //Sprites pequeñitos
            //String sprite = p.sprites.versions.generationVIII.icons.frontDefault;
            //Sprites más grandecitos
            //String sprite = p.sprites.frontDefault;
            //Sprites animados
            String sprite = p.sprites.other.officialArtwork.frontDefault;
            //String sprite = p.sprites.versions.generationVIII.icons.frontDefault;
            return sprite;
        }
        else
        {
            return "src/main/resources/img/defaultPokeball.png";
        }
    }

    public static int idOficialDeOrder(int order){
        return 0;
    }
}
