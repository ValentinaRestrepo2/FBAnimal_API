package Modelo;

public class Usuario {
    
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
    private String nombre_barrio;
    private int tipo_usuario;
    private String puesto_trabajo;

    public Usuario() {
    }

    public Usuario(String id_usuario_bd, String id, String nombre, String primer_apellido, String segundo_apellido, String correo, String Fecha_nacimiento, String celular, String direccion, String password, int estado_civil, int barrio, String nombre_barrio, int tipo_usuario, String puesto_trabajo) {
        this.id_usuario_bd = id_usuario_bd;
        this.id = id;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.correo = correo;
        this.Fecha_nacimiento = Fecha_nacimiento;
        this.celular = celular;
        this.direccion = direccion;
        this.password = password;
        this.estado_civil = estado_civil;
        this.barrio = barrio;
        this.nombre_barrio = nombre_barrio;
        this.tipo_usuario = tipo_usuario;
        this.puesto_trabajo = puesto_trabajo;
    }

    public String getNombre_barrio() {
        return nombre_barrio;
    }

    public void setNombre_barrio(String nombre_barrio) {
        this.nombre_barrio = nombre_barrio;
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
