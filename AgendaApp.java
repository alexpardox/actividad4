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
import java.util.Scanner;

public class AgendaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook agenda = new AddressBook("contactos.csv");

        // Al iniciar, cargamos los contactos guardados
        agenda.load();

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("=== AGENDA TELEFÓNICA ===");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar y salir");
            System.out.println("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();
            System.out.println(".....................");

            switch (opcion) {
                case "1":
                    agenda.list();
                    break;

                case "2":
                    System.out.println("Vamos a agregar un nuevo contacto: ");
                    System.out.println("Ingrese el número telefónico: ");
                    String numeroCrear = scanner.nextLine().trim();
                    System.out.println("Ingrese el nombre: ");
                    String nombreCrear = scanner.nextLine().trim();
                    agenda.create(numeroCrear, nombreCrear);
                    break;

                case "3":
                    System.out.println("Ingrese el número telefónico a eliminar: ");
                    String numeroEliminar = scanner.nextLine().trim();
                    agenda.delete(numeroEliminar);
                    break;

                case "4":
                    // Antes de salir, guardamos los cambios
                    agenda.save();
                    System.out.println("Contactos guardados. Saliendo...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
