package domain;

import java.util.Date;

public class Persona {

    private int id;
    private String nombre;
    private int edad;
    private String sexo;
    private String estadoCivil;
    private double ingresoMensual;
    private boolean jefeDeHogar;
    private int numeroHijos;

    public Persona(int id, String nombre, int edad, String sexo, String estadoCivil,
            double ingresoMensual, boolean jefeHogar, int numeroHijos) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.ingresoMensual = ingresoMensual;
        this.jefeDeHogar = jefeHogar;
        this.numeroHijos = numeroHijos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getIngresoMensual() {
        return this.ingresoMensual;
    }

    public void setIngresoMensual(double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    public boolean isJefeDeHogar() {
        return this.jefeDeHogar;
    }

    public void setJefeDeHogar(boolean jefeDeHogar) {
        this.jefeDeHogar = jefeDeHogar;
    }

    public int getNumeroHijos() {
        return this.numeroHijos;
    }

    public void setNumeroHijos(int numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{nombre=").append(nombre);
        sb.append(", direccion=").append(sexo);
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }

}
