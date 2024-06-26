package poke.app.entity;

import jakarta.persistence.*;

@Entity
public class Login {
    @Id
    //AUTO no funciona bien con SQLite porque intenta obtener el valor de una tabla de secuencias para cada tabla
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String pass;
    private int nuevo_user;
    private int pokemonedas;

    @OneToOne(mappedBy = "login")
    private Equipo equipo;

    public Login(Long id, String nombre, String pass, int nuevo_user, int pokemonedas, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
        this.nuevo_user = nuevo_user;
        this.pokemonedas = pokemonedas;
        this.equipo = equipo;
    }

    public Login(Long id, String nombre, String pass, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
        this.equipo = equipo;
    }

    /**
     * Este constructor contiene el parámetro que contendrá (0--> No se ha configurado el usuario, 1--> Chico ,2--> Chica)
     * @param nombre
     * @param pass
     * @param nuevo_user (0--> No se ha configurado el usuario, 1--> Chico ,2--> Chica)
     */
    public Login(String nombre, String pass, int nuevo_user) {
        this.nombre = nombre;
        this.pass = pass;
        this.nuevo_user = nuevo_user;
    }

    public Login(String nombre, String pass, Equipo equipo) {
        this.nombre = nombre;
        this.pass = pass;
        this.equipo = equipo;
    }

    /**
     * Constructor sin ID, utilizado al crear nuevas instancias antes de persistir.
     *
     * @param nombre Nombre de usuario.
     * @param pass   Contraseña del usuario.
     */

    public Login(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    /**
     * Constructor por defecto.
     */

    public Login() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getNuevo_user() {
        return nuevo_user;
    }

    public void setNuevo_user(int nuevo_user) {
        this.nuevo_user = nuevo_user;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPokemonedas() {
        return pokemonedas;
    }

    public void setPokemonedas(int pokemonedas) {
        this.pokemonedas = pokemonedas;
    }

    @Override
    public String toString() {
        return String.format("Login [id=%s, nombre=%s, pass=%s]", id, nombre, pass);
    }
}
