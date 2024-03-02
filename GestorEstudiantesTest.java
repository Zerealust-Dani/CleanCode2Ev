/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.ed.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Usuario
 */
public class GestorEstudiantesTest {
    private GestorEstudiantes gestorEstudiantes;

    @BeforeAll
    public static void setUpBeforeAll() {
        System.out.println("Configuración inicial para todas las pruebas");
    }

    @AfterAll
    public static void tearDownAfterAll() {
        System.out.println("Tareas de limpieza después de todas las pruebas");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Inicialización antes de cada prueba");
        gestorEstudiantes = new GestorEstudiantes(5);
        gestorEstudiantes.agregarEstudiante(new Estudiante("11111111","Juan", 20));
        gestorEstudiantes.agregarEstudiante(new Estudiante("22222222","Maria", 22));
        gestorEstudiantes.agregarEstudiante(new Estudiante("11111112","Carlos", 17));
        gestorEstudiantes.agregarEstudiante(new Estudiante("11111113","Laura", 19));
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tareas de limpieza después de cada prueba");
    }

    @Test
    public void testAgregarEstudiante() {
        int cantidadInicial = gestorEstudiantes.obtenerEstudiantes().length;
        gestorEstudiantes.agregarEstudiante(new Estudiante("33333333", "Pedro", 21));
        int cantidadDespuesDeAgregar = gestorEstudiantes.obtenerEstudiantes().length;
        assertEquals(cantidadInicial + 1, cantidadDespuesDeAgregar);
    }
    
    @Test
    public void testVerificarMayorDeEdad() {
        assertTrue(gestorEstudiantes.verificarMayorDeEdad("11111111")); 
    }

    @Test
    public void testBorrarEstudianteExistente() {
        int cantidadInicial = gestorEstudiantes.obtenerEstudiantes().length;
        gestorEstudiantes.borrarEstudiante("11111111");
        int cantidadDespuesDeBorrar = gestorEstudiantes.obtenerEstudiantes().length;
        assertEquals(cantidadInicial - 1, cantidadDespuesDeBorrar);
    }

    @Test
    public void testBorrarEstudianteNoExistente() {
        int cantidadInicial = gestorEstudiantes.obtenerEstudiantes().length;
        gestorEstudiantes.borrarEstudiante("99999999"); // Un NIA que no existe
        int cantidadDespuesDeBorrar = gestorEstudiantes.obtenerEstudiantes().length;
        assertEquals(cantidadInicial, cantidadDespuesDeBorrar);
    }

    

    @Test
    public void testVerificarMenorDeEdad() {
        assertFalse(gestorEstudiantes.verificarMayorDeEdad("11111112")); // Carlos es menor de edad
    }

}

