package Entidades;

public class Contacto {
    private String nombre;
    private String telefono;
    private String organizacion;
    private int img;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public void setImg(int img){
        this.img = img;
    }

    public int getImg(){
        return this.img;
    }
}
