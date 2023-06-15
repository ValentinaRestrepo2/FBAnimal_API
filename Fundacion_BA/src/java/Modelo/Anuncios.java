package Modelo;

import java.io.InputStream;

/**
 *
 * @author ZENBOOK
 */
public class Anuncios {

    String id_anuncio;
    String nombre_anuncio;
    String descripcion;
    int costo;
    private InputStream foto;
    private byte[] verFoto;

    public Anuncios() {
    }

    public String getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(String id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public String getNombre_anuncio() {
        return nombre_anuncio;
    }

    public void setNombre_anuncio(String nombre_anuncio) {
        this.nombre_anuncio = nombre_anuncio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public byte[] getVerFoto() {
        return verFoto;
    }

    public void setVerFoto(byte[] verFoto) {
        this.verFoto = verFoto;
    }
    
    
}
