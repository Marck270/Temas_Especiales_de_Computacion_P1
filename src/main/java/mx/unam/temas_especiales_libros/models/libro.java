package mx.unam.temas_especiales_libros.models;

import java.math.BigDecimal;
import java.sql.Struct;

public class libro {
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private String email_edutorial;
    private BigDecimal precio;
    private String genero;

    @Override
    public String toString() {
        return "libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", email_edutorial='" + email_edutorial + '\'' +
                ", precio=" + precio +
                ", genero='" + genero + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getEmail_edutorial() {
        return email_edutorial;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getGenero() {
        return genero;
    }

    public libro(int id, String titulo, String autor, String editorial, String email_edutorial, BigDecimal precio, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.email_edutorial = email_edutorial;
        this.precio = precio;
        this.genero = genero;
    }

    public libro(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setEmail_edutorial(String email_edutorial) {
        this.email_edutorial = email_edutorial;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
