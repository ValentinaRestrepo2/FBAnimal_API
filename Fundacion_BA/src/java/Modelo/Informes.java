/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.InputStream;
import java.util.Date;
import oracle.sql.TIMESTAMP;

/**
 *
 * @author PC
 */
public class Informes {
    private String id_informe;
    private String descripcion_informe;
    private String mensaje_informe;
    private InputStream foto;
    private byte[] verFoto; 
    private String mascota_informe;
    private String usuario_informe;
    private String fecha_informe;
    private String respuesta_admin_informe;
    
    // MASCOTAS
    private String idMascota;
    private String nombreMascota;
    private String razaMascota;
    private String edadMascota;
    private int vacunadoMascota;
    private int esterilizadoMascota;
    private String descripcionMascota;
    private int disponibilidadMascota;
    private InputStream fotoMascota;
    private byte[] verFotoMascota;
    
    // USUARIO
    private String id_usuario_bd;
    private String id;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String correo;
    private String Fecha_nacimiento;
    private String celular;
    private String direccion;
    private String password;
    private int estado_civil;
    private int barrio;
    private int tipo_usuario;
    private String puesto_trabajo;
    
    public Informes() {
    }

    public String getId_informe() {
        return id_informe;
    }

    public void setId_informe(String id_informe) {
        this.id_informe = id_informe;
    }

    public String getDescripcion_informe() {
        return descripcion_informe;
    }

    public void setDescripcion_informe(String descripcion_informe) {
        this.descripcion_informe = descripcion_informe;
    }

    public String getMensaje_informe() {
        return mensaje_informe;
    }

    public void setMensaje_informe(String mensaje_informe) {
        this.mensaje_informe = mensaje_informe;
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

    public String getFecha_informe() {
        return fecha_informe;
    }

    public void setFecha_informe(String fecha_informe) {
        this.fecha_informe = fecha_informe;
    }

    public String getMascota_informe() {
        return mascota_informe;
    }

    public void setMascota_informe(String mascota_informe) {
        this.mascota_informe = mascota_informe;
    }

    public String getUsuario_informe() {
        return usuario_informe;
    }

    public void setUsuario_informe(String usuario_informe) {
        this.usuario_informe = usuario_informe;
    }

    public String getRespuesta_admin_informe() {
        return respuesta_admin_informe;
    }

    public void setRespuesta_admin_informe(String respuesta_admin_informe) {
        this.respuesta_admin_informe = respuesta_admin_informe;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public String getEdadMascota() {
        return edadMascota;
    }

    public void setEdadMascota(String edadMascota) {
        this.edadMascota = edadMascota;
    }

    public int getVacunadoMascota() {
        return vacunadoMascota;
    }

    public void setVacunadoMascota(int vacunadoMascota) {
        this.vacunadoMascota = vacunadoMascota;
    }

    public int getEsterilizadoMascota() {
        return esterilizadoMascota;
    }

    public void setEsterilizadoMascota(int esterilizadoMascota) {
        this.esterilizadoMascota = esterilizadoMascota;
    }

    public String getDescripcionMascota() {
        return descripcionMascota;
    }

    public void setDescripcionMascota(String descripcionMascota) {
        this.descripcionMascota = descripcionMascota;
    }

    public int getDisponibilidadMascota() {
        return disponibilidadMascota;
    }

    public void setDisponibilidadMascota(int disponibilidadMascota) {
        this.disponibilidadMascota = disponibilidadMascota;
    }

    public InputStream getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(InputStream fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public byte[] getVerFotoMascota() {
        return verFotoMascota;
    }

    public void setVerFotoMascota(byte[] verFotoMascota) {
        this.verFotoMascota = verFotoMascota;
    }

    public String getId_usuario_bd() {
        return id_usuario_bd;
    }

    public void setId_usuario_bd(String id_usuario_bd) {
        this.id_usuario_bd = id_usuario_bd;
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

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(String Fecha_nacimiento) {
        this.Fecha_nacimiento = Fecha_nacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(int estado_civil) {
        this.estado_civil = estado_civil;
    }

    public int getBarrio() {
        return barrio;
    }

    public void setBarrio(int barrio) {
        this.barrio = barrio;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getPuesto_trabajo() {
        return puesto_trabajo;
    }

    public void setPuesto_trabajo(String puesto_trabajo) {
        this.puesto_trabajo = puesto_trabajo;
    }
    
    
}
