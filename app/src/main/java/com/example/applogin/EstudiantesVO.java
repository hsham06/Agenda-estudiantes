package com.example.applogin;

public class EstudiantesVO {

    private String nombre;
    private String Info;
    private int foto;

    public EstudiantesVO(){

    }

    public EstudiantesVO(String nombre, String info, int foto) {
        this.nombre = nombre;
        Info = info;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
