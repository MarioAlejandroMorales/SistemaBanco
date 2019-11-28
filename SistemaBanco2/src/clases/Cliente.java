package clases;

public class Cliente {

    private String nombre;
    private String sexo;
    private String fecha_nac;
    private String domicilio;
    private String telefono;
    private String correo;
    private String curp;

    public Cliente(String nombre, String sexo, String fecha_nac, String domicilio, String telefono, String correo, String curp) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecha_nac = fecha_nac;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.correo = correo;
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

}
