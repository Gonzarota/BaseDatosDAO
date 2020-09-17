package com.dominio;

public class Usuario {
    int id;
    String nombre;
    String apellido;
    String departamento;
    String sede;

    public Usuario(int id, String nombre, String apellido, String departamento, String sede){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.departamento=departamento;
        this.sede=sede;
    }
    public Usuario(String nombre, String apellido, String departamento, String sede){
        this.nombre=nombre;
        this.apellido=apellido;
        this.departamento=departamento;
        this.sede=sede;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getSede() {
        return sede;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", departamento='" + departamento + '\'' +
                ", sede='" + sede + '\'' +
                '}';
    }
}
