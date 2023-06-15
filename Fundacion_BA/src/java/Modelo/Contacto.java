/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Marín
 */
public class Contacto {
    private String id;
    private String nombre;
    private String correo;
    private String celular;
    private String select_pqrs;
    private String asunto;
    private String mensaje;
    private String estado;

    public Contacto() {
        this.id = null;
        this.nombre = null;
        this.correo = null;
        this.celular = null;
        this.select_pqrs = null;
        this.asunto = null;
        this.mensaje = null;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSelect_pqrs() {
        return select_pqrs;
    }

    public void setSelect_pqrs(String select_pqrs) {
        this.select_pqrs = select_pqrs;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
