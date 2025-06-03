/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.actividad4;

/**
 *
 * @author alexpardox
 */
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String, String> contactos;
    private String nombreArchivo;

    public AddressBook(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.contactos = new HashMap<>();
    }

    /**
     * Carga los contactos desde el archivo CSV al HashMap.
     * Cada línea del archivo debe tener el formato: {Número},{Nombre}
     */
    public void load() {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            // Si el archivo no existe, no hay nada que cargar
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", 2);
                if (partes.length == 2) {
                    String numero = partes[0].trim();
                    String nombre  = partes[1].trim();
                    contactos.put(numero, nombre);
                }
            }
        } catch (IOException e) {
            System.err.println("Error cargando contactos: " + e.getMessage());
        }
    }

    /**
     * Guarda los contactos del HashMap en el archivo CSV.
     * Cada línea se escribe como: {Número},{Nombre}
     */
    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Map.Entry<String, String> entrada : contactos.entrySet()) {
                String numero = entrada.getKey();
                String nombre = entrada.getValue();
                bw.write(numero + "," + nombre);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error guardando contactos: " + e.getMessage());
        }
    }

    /**
     * Lista todos los contactos en consola con el formato:
     * Contactos:
     * {Número} : {Nombre}
     */
    public void list() {
        System.out.println("*** Contactos almacenados (Número/Nombre): ***");
        if (contactos.isEmpty()) {
            System.out.println("  (La agenda está vacía)");
            return;
        }
        for (Map.Entry<String, String> entrada : contactos.entrySet()) {
            String numero = entrada.getKey();
            String nombre = entrada.getValue();
            System.out.printf("  %s : %s%n", numero, nombre);
        }
    }

    /**
     * Crea un nuevo contacto. Si el número ya existe, sobrescribe el nombre.
     *
     * @param numero Número telefónico (clave)
     * @param nombre Nombre asociado
     */
    public void create(String numero, String nombre) {
        contactos.put(numero, nombre);
        System.out.println("Contacto agregado/actualizado correctamente.");
    }

    /**
     * Elimina un contacto dado su número telefónico.
     *
     * @param numero Número telefónico a eliminar
     */
    public void delete(String numero) {
        if (contactos.remove(numero) != null) {
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("No existe ningún contacto con ese número.");
        }
    }
}
