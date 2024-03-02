/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.ed.model;

/**
 *
 * @author Usuario
 */
public class Estudiante implements InformacionEstudiante{
    
    public static final String CURSO = "DAM1";
    private static final int EDAD_MAYORIA_EDUCATIVA = 18;
    public int edad;
    private String NIA;
    private String nombre;
   
    // Constructor
    public Estudiante(String NIA, String nombre, int edad) {
        try {
            if (NIA == null || NIA.isEmpty() || nombre == null || nombre.isEmpty() || edad < 0) {
                throw new IllegalArgumentException("Los parámetros de creación del estudiante no son válidos.");
            }
            this.NIA = NIA;
            this.nombre = nombre;
            this.edad = edad;
        } catch (IllegalArgumentException e) {
            System.err.println("Error al crear el estudiante: " + e.getMessage());
            throw new MiExcepcion("Error al crear el estudiante.", e);
        } finally {
            System.out.println("Bloque finally: Operaciones finales o de limpieza.");
        }

    }
    
    @Override
    public String getNombre() {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalStateException("El nombre del estudiante no es válido.");
        }
        return nombre;
    }
    @Override
    public String getNIA() {
        if (NIA == null || NIA.isEmpty()) {
            throw new IllegalStateException("El NIA del estudiante no es válido.");
        }
        return NIA;
    }
    @Override
    public int getEdad() {
        try {
            if (edad < 0) {
                throw new IllegalStateException("La edad del estudiante no es válida.");
            }
            return edad;
        } catch (IllegalStateException e) {
            System.err.println("Error al obtener la edad del estudiante: " + e.getMessage());
            throw new MiExcepcion("Error al obtener la edad del estudiante.", e);
        }
    }

    // Método de comportamiento
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    // Métodos de sobreescritura de la clase Object
    @Override
    public String toString() {
        return "Estudiante [NIA=" + NIA + ", nombre=" + nombre + ", edad=" + edad + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((NIA == null) ? 0 : NIA.hashCode());
        return result;
    }
    
    public static Estudiante crearEstudiante(String NIA, String nombre, int edad) {
        return new Estudiante(NIA, nombre, edad);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Estudiante other = (Estudiante) obj;
        if (NIA == null) {
            if (other.NIA != null) {
                return false;
            }
        } else if (!NIA.equals(other.NIA)) {
            return false;
        }
        return true;
    }

    private static class MiExcepcion extends RuntimeException {

        public MiExcepcion(String mensaje, Throwable causa) {
            super(mensaje, causa);
        }
    }
}
