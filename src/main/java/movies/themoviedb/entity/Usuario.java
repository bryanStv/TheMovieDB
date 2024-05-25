package movies.themoviedb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_usuario;

    private String name;
    private String pass;

    public Usuario(Long id_usuario, String name, String pass) {
        this.id_usuario = id_usuario;
        this.name = name;
        this.pass = pass;
    }

    public Usuario(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public Usuario() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
