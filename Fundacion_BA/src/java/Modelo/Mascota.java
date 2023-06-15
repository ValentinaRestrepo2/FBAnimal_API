package Modelo;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author ZENBOOK
 */
public class Mascota {

    private String id;
    private String nombre;
    private String raza;
    private String edad;
    private int sexo;
    private int vacunado;
    private int esterilizado;
    private String descripcion;
    private int disponibilidad;
    private InputStream foto;
    private byte[] verFoto;
    private String genero_mascota;

    public Mascota() {
    }

    public Mascota(String id, String nombre, String raza, String edad, int sexo, int vacunado, int esterilizado, String descripcion, int disponibilidad, InputStream foto, byte[] verFoto, String genero_mascota) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.sexo = sexo;
        this.vacunado = vacunado;
        this.esterilizado = esterilizado;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.foto = foto;
        this.verFoto = verFoto;
        this.genero_mascota = genero_mascota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getVacunado() {
        return vacunado;
    }

    public void setVacunado(int vacunado) {
        this.vacunado = vacunado;
    }

    public int getEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(int esterilizado) {
        this.esterilizado = esterilizado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
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

    public String getGenero_mascota() {
        return genero_mascota;
    }

    public void setGenero_mascota(String genero_mascota) {
        this.genero_mascota = genero_mascota;
    }

    
}
