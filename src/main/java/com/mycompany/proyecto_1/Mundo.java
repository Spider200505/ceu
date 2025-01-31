/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_1;

/**
 *
 * @author alejandro.esteban1
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;

public class Mundo {
    private List<Ser> seres;
    private List<Ciudad> ciudades;
    private List<Animal> animales;
    private List<ElementoGeografico> geografia;
    private List<Recurso> recursos;
    private int diaActual;

    private final Enfermedad[] enfermedades = {
        new Enfermedad("Gripe", 15, "Aérea"),
        new Enfermedad("Neumonía", 8, "Aérea"),
        new Enfermedad("Rabia", 2, "Animal"),
        new Enfermedad("Tuberculosis", 10, "Aérea"),
        new Enfermedad("Covid-19", 12, "Aérea"),
        new Enfermedad("Malaria", 7, "Vectorial"),
        new Enfermedad("Hepatitis", 6, "Agua/Alimentos"),
        new Enfermedad("Dengue", 10, "Vectorial"),
        new Enfermedad("Ébola", 5, "Contacto Directo"),
        new Enfermedad("SIDA", 3, "Sexual"),
        new Enfermedad("Cólera", 8, "Agua/Alimentos"),
        new Enfermedad("Tifus", 7, "Agua/Alimentos"),
        new Enfermedad("Herpes", 5, "Contacto Directo"),
        new Enfermedad("Fiebre amarilla", 9, "Vectorial"),
        new Enfermedad("Sífilis", 5, "Sexual")
    };

    public Mundo() {
        seres = new ArrayList<>();
        ciudades = new ArrayList<>();
        animales = new ArrayList<>();
        geografia = new ArrayList<>();
        recursos = new ArrayList<>();
        this.diaActual = 0;
    }

    public void agregarSer(Ser ser) {
        seres.add(ser);
    }

    public void agregarCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void agregarElementoGeografico(ElementoGeografico elemento) {
        geografia.add(elemento);
    }

    public void agregarRecurso(Recurso recurso) {
        recursos.add(recurso);
    }

    public List<Ser> getSeres() {
        return seres;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public List<ElementoGeografico> getGeografia() {
        return geografia;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public int getDiaActual() {
        return diaActual;
    }

    public Enfermedad[] getEnfermedades() {
        return enfermedades;
    }

    public void avanzarDia() {
        diaActual++;
        System.out.println("\n=== Día " + diaActual + " === \n");

        ciudades.forEach(Ciudad::gestionarCiudad);

        for (Ser ser : seres) {
            ser.tomarDecision(this);
            ser.propagarEnfermedades(this);
        }

        for (Animal animal : animales) {
            animal.propagarEnfermedad(this);
        }

        gestionarGuerras();
        eventosGlobales();
        gestionarCatastrofesNaturales();
        gestionarCambioClimatico();
    }

    private void gestionarCambioClimatico() {
        Random random = new Random();
        if (random.nextInt(100) < 5) {
            System.out.println("🌍 Cambio climático afecta la producción de recursos y aumenta la frecuencia de catástrofes.");
            ciudades.forEach(ciudad -> ciudad.incrementarRecursos(-10));
        }
    }

    private void gestionarGuerras() {
        if (ciudades.size() > 1) {
            Random random = new Random();
            for (int i = 0; i < ciudades.size(); i++) {
                for (int j = i + 1; j < ciudades.size(); j++) {
                    if (random.nextInt(100) < 10) {
                        Ciudad ciudad1 = ciudades.get(i);
                        Ciudad ciudad2 = ciudades.get(j);
                        System.out.println("⚔ Guerra entre " + ciudad1.getNombre() + " y " + ciudad2.getNombre() + "!");
                        resolverGuerra(ciudad1, ciudad2);
                    }
                }
            }
        }
    }

    private void resolverGuerra(Ciudad ciudad1, Ciudad ciudad2) {
        Random random = new Random();
        int fuerza1 = ciudad1.getPoblacion() + random.nextInt(50);
        int fuerza2 = ciudad2.getPoblacion() + random.nextInt(50);

        if (fuerza1 > fuerza2) {
            System.out.println(ciudad1.getNombre() + " gana la guerra contra " + ciudad2.getNombre() + ".");
            ciudad1.incrementarRecursos(20);
            ciudad2.reducirPoblacion(30);
        } else {
            System.out.println(ciudad2.getNombre() + " gana la guerra contra " + ciudad1.getNombre() + ".");
            ciudad2.incrementarRecursos(20);
            ciudad1.reducirPoblacion(30);
        }
    }

    private void eventosGlobales() {
        Random random = new Random();
        int evento = random.nextInt(100);

        if (evento < 5) {
            System.out.println("🌍 Evento global: Descubrimiento tecnológico aumenta la recolección de recursos en todas las ciudades.");
            ciudades.forEach(ciudad -> ciudad.incrementarRecursos(50));
        } else if (evento < 10) {
            System.out.println("⚠ Evento global: Una plaga afecta a la población mundial.");
            Iterator<Ser> iteradorSeres = seres.iterator();
            while (iteradorSeres.hasNext()) {
                Ser ser = iteradorSeres.next();
                ser.reducirSalud(20);
                if (ser.getSalud() <= 0) {
                    System.out.println("✝ " + ser.getNombre() + " ha muerto por la plaga.");
                    iteradorSeres.remove();
                }
            }
        }
    }

    private void gestionarCatastrofesNaturales() {
        Random random = new Random();
        int probabilidad = random.nextInt(100);

        if (probabilidad < 5) {
            System.out.println("🌊 Tsunami afecta la costa!");
            ciudades.stream().filter(ciudad -> random.nextBoolean()).forEach(ciudad -> ciudad.reducirPoblacion(20));
        } else if (probabilidad < 10) {
            System.out.println("🌪 Tornado arrasa con campos agrícolas!");
            ciudades.forEach(ciudad -> ciudad.incrementarRecursos(-10));
        } else if (probabilidad < 15) {
            System.out.println("🔥 Terremoto destruye infraestructura!");
            ciudades.forEach(ciudad -> ciudad.reducirPoblacion(10));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Mundo mundo = new Mundo();
        Random random = new Random();
        String[] nombres = {"Juan", "Ana", "Pedro", "Maria", "Luis", "Sofia", "Carlos", "Elena", "Diego", "Lucia"};

        for (int i = 0; i < 100; i++) {
            String nombre = nombres[random.nextInt(nombres.length)] + " " + (i + 1);
            int salud = 50 + random.nextInt(51);
            Ser ser = new Ser(nombre, salud);
            mundo.agregarSer(ser);
        }

        String[] nombresAnimales = {"Perro", "Gato", "Lobo", "Zorro", "Conejo"};
        for (int i = 0 ; i < 50; i++) {
            String nombre = nombresAnimales[random.nextInt(nombresAnimales.length)] + " " + (i + 1);
            Animal animal = new Animal(nombre);
            mundo.agregarAnimal(animal);
        }

        Ciudad ciudad1 = new Ciudad("Ciudad A", "Culto de la Luna");
        Ciudad ciudad2 = new Ciudad("Ciudad B", "Creencia del Sol");
        Ciudad ciudad3 = new Ciudad("Ciudad C", "Fe de las Estrellas");

        for (int i = 0; i < mundo.getSeres().size(); i++) {
            Ser ser = mundo.getSeres().get(i);
            if (i % 3 == 0) {
                ciudad1.agregarHabitante(ser);
            } else if (i % 3 == 1) {
                ciudad2.agregarHabitante(ser);
            } else {
                ciudad3.agregarHabitante(ser);
            }
        }

        mundo.agregarCiudad(ciudad1);
        mundo.agregarCiudad(ciudad2);
        mundo.agregarCiudad(ciudad3);

        mundo.agregarElementoGeografico(new ElementoGeografico("Mar del Norte", "Mar"));
        mundo.agregarElementoGeografico(new ElementoGeografico("Río Azul", "Río"));
        mundo.agregarElementoGeografico(new ElementoGeografico("Cordillera Escarpada", "Montaña"));
        mundo.agregarElementoGeografico(new ElementoGeografico("Océano Pacífico", "Mar"));
        mundo.agregarElementoGeografico(new ElementoGeografico("Río Verde", "Río"));
        mundo.agregarElementoGeografico(new ElementoGeografico("Montes Grises", "Montaña"));

        mundo.agregarRecurso(new Recurso("Hierro", 100));
        mundo.agregarRecurso(new Recurso("Oro", 50));
        mundo.agregarRecurso(new Recurso("Carbón", 200));
        mundo.agregarRecurso(new Recurso("Cobre", 80));

        while (!mundo.getSeres().isEmpty()) {
            mundo.avanzarDia();
            Thread.sleep(45000);
        }

        System.out.println("\n=== Fin de la simulación: Todos los seres han muerto. ===");
    }
}

class Ciudad {
    private String nombre;
    private String religion;
    private int poblacion;
    private int recursos;
    private List<Ser> habitantes;

    public Ciudad(String nombre, String religion) {
        this.nombre = nombre;
        this.religion = religion;
        this.poblacion = 100;
        this.recursos = 50;
        this.habitantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void reducirPoblacion(int cantidad) {
        poblacion = Math.max(poblacion - cantidad, 0);
    }

    public void incrementarRecursos(int cantidad) {
        recursos += cantidad;
    }

    public void agregarHabitante(Ser ser) {
        habitantes.add(ser);
        poblacion++;
    }

    public void gestionarCiudad() {
        System.out.println("Gestionando la ciudad " + nombre + "...");
        if (recursos >= 100) {
            System.out.println("La ciudad " + nombre + " avanza tecnológicamente.");
            recursos -= 100;
        }
    }
}

class Enfermedad {
    private final String nombre;
    private final int probabilidadContagio;
    private final String viaTransmision;

    public Enfermedad(String nombre, int probabilidadContagio, String viaTransmision) {
        this.nombre = nombre;
        this.probabilidadContagio = probabilidadContagio;
        this.viaTransmision = viaTransmision;
    }

    public String getNombre() {
        return nombre;
    }

    public int getProbabilidadContagio() {
        return probabilidadContagio;
    }

    public String getViaTransmision() {
        return viaTransmision;
    }
}

class Ser {
    private final String nombre;
    private int salud;
    private final Random random;
    private final Set<Enfermedad> enfermedades;

    public Ser(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
        this.random = new Random();
        this.enfermedades = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void reducirSalud(int cantidad) {
        salud = Math.max(salud - cantidad, 0);
        System.out.println(nombre + " ha perdido " + cantidad + " de salud.");
    }

    public void tomarDecision(Mundo mundo) {
        if (salud > 50) {
            System.out.println(nombre + " trabaja y recolecta recursos.");
        } else {
            descansar();
        }
    }

    public void descansar() {
        salud = Math.min(salud + 10, 100);
        System.out.println(nombre + " descansa para recuperar salud.");
    }

    public void propagarEnfermedades(Mundo mundo) {
        for (Enfermedad enfermedad : enfermedades) {
            for (Ser otroSer : mundo.getSeres()) {
                if (!otroSer.equals(this) && random.nextInt(100) < enfermedad.getProbabilidadContagio()) {
                    if (enfermedad.getViaTransmision().equals("Aérea") ||
                        (enfermedad.getViaTransmision().equals("Contacto Directo") && random.nextBoolean()) ||
                        (enfermedad.getViaTransmision().equals("Sexual") && random.nextInt(100) < 5)) {
                        otroSer.contraerEnfermedad(enfermedad);
                    }
                }
            }
        }
    }

    public void contraerEnfermedad(Enfermedad enfermedad) {
        if (enfermedades.add(enfermedad)) {
            System.out.println(nombre + " ha contraído " + enfermedad.getNombre() + ".");
        }
    }
}

class Animal {
    private final String nombre;
    private final Random random;

    public Animal(String nombre) {
        this.nombre = nombre;
        this.random = new Random();
    }

    public void propagarEnfermedad(Mundo mundo) {
        for (Enfermedad enfermedad : mundo.getEnfermedades()) {
            if (enfermedad.getViaTransmision().equals("Animal")) {
                for (Ser ser : mundo.getSeres()) {
                    if (random.nextInt(100) < enfermedad.getProbabilidadContagio()) {
                        ser.contraerEnfermedad(enfermedad);
                    }
                }
            }
        }
    }
}

class ElementoGeografico {
    private final String nombre;
    private final String tipo;

    public ElementoGeografico(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}

class Recurso {
    private final String tipo;
    private int cantidad;

    public Recurso(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void extraer(int cantidad) {
        this.cantidad = Math.max(this.cantidad - cantidad, 0);
    }
}