/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.InputStream;

/**
 *
 * @author ZENBOOK
 */
public class Adopcion {
    
    String id_solicitud;
    String id_usuario;
    String id_mascota;
    String cantidad_familia;
    String tipo_vivienda;
    String motivo_adopcion;
    String estado;
    String num_tuvo_mascota;
    String tipo_tuvo_mascota;
    String tiene_mascota;
    String estrato_vivienda;
    String rango_salarial;
    String Fecha_solicitud;
    String Nombre_familiar, celular_familiar, ocupacion_familiar, propia_vivienda;
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
    private String id_m;
    private String nombre_m;
    private String raza;
    private String edad;
    private int vacunado;
    private int esterilizado;
    private String descripcion;
    private int disponibilidad;
    private InputStream foto;
    private byte[] verFoto;

    public Adopcion() {
    }

    public String getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(String id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_mascota() {
        return id_mascota;
    }

    public String getPropia_vivienda() {
        return propia_vivienda;
    }

    public void setPropia_vivienda(String propia_vivienda) {
        this.propia_vivienda = propia_vivienda;
    }
    
    public void setId_mascota(String id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre_familiar() {
        return Nombre_familiar;
    }

    public void setNombre_familiar(String Nombre_familiar) {
        this.Nombre_familiar = Nombre_familiar;
    }

    public String getCelular_familiar() {
        return celular_familiar;
    }

    public void setCelular_familiar(String celular_familiar) {
        this.celular_familiar = celular_familiar;
    }

    public String getOcupacion_familiar() {
        return ocupacion_familiar;
    }

    public void setOcupacion_familiar(String ocupacion_familiar) {
        this.ocupacion_familiar = ocupacion_familiar;
    }
    
    

    public String getFecha_solicitud() {
        return Fecha_solicitud;
    }

    public void setFecha_solicitud(String Fecha_solicitud) {
        this.Fecha_solicitud = Fecha_solicitud;
    }
    
    
    public String getCantidad_familia() {
        return cantidad_familia;
    }

    public void setCantidad_familia(String cantidad_familia) {
        this.cantidad_familia = cantidad_familia;
    }

    public String getTipo_vivienda() {
        return tipo_vivienda;
    }

    public void setTipo_vivienda(String tipo_vivienda) {
        this.tipo_vivienda = tipo_vivienda;
    }

    public String getMotivo_adopcion() {
        return motivo_adopcion;
    }

    public void setMotivo_adopcion(String motivo_adopcion) {
        this.motivo_adopcion = motivo_adopcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNum_tuvo_mascota() {
        return num_tuvo_mascota;
    }

    public void setNum_tuvo_mascota(String num_tuvo_mascota) {
        this.num_tuvo_mascota = num_tuvo_mascota;
    }

    public String getTipo_tuvo_mascota() {
        return tipo_tuvo_mascota;
    }

    public void setTipo_tuvo_mascota(String tipo_tuvo_mascota) {
        this.tipo_tuvo_mascota = tipo_tuvo_mascota;
    }

    public String getTiene_mascota() {
        return tiene_mascota;
    }

    public void setTiene_mascota(String tiene_mascota) {
        this.tiene_mascota = tiene_mascota;
    }

    public String getEstrato_vivienda() {
        return estrato_vivienda;
    }

    public void setEstrato_vivienda(String estrato_vivienda) {
        this.estrato_vivienda = estrato_vivienda;
    }

    public String getRango_salarial() {
        return rango_salarial;
    }

    public void setRango_salarial(String rango_salarial) {
        this.rango_salarial = rango_salarial;
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

    public String getId_m() {
        return id_m;
    }

    public void setId_m(String id_m) {
        this.id_m = id_m;
    }

    public String getNombre_m() {
        return nombre_m;
    }

    public void setNombre_m(String nombre_m) {
        this.nombre_m = nombre_m;
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

    
}
