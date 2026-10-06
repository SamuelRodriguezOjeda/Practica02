package modelo;

public class cliente {

    private int numero;
    private String nombre;
    private int edad;
    private double puntos;

    public cliente(int numero, String nombre, int edad, double puntos) {
        this.numero = numero;
        this.nombre = nombre;
        this.edad = edad;
        this.puntos = puntos;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }
    
}
