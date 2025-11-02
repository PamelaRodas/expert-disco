package com.Scared.Warren;

import com.Scared.Warren.Model.Historias;
import com.Scared.Warren.Model.Repository.HistoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private HistoriaRepository historiaRepository;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("═══════════════════════════════════════════");
        System.out.println("  BIENVENIDO AL REGISTRO DE LOS WARREN");
        System.out.println("═══════════════════════════════════════════\n");
        
        boolean continuar = true;
        while (continuar) {
            System.out.print("Título de la historia: ");
            String titulo = scanner.nextLine();
            System.out.print("Año del suceso: ");
            int anio = Integer.parseInt(scanner.nextLine());
            System.out.print("Tipo (Ej. Poltergeist, Demonio, Fantasma): ");
            String tipo = scanner.nextLine();
            System.out.print("Descripción breve: ");
            String descripcion = scanner.nextLine();

            Historias historia = new Historias(titulo, anio, tipo, descripcion);
            historiaRepository.save(historia);
            System.out.println("\n✓ Historia registrada correctamente!\n");
            
            System.out.print("¿Desea agregar otra historia? (s/n): ");
            String resp = scanner.nextLine();
            if (!resp.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("  TODAS LAS HISTORIAS REGISTRADAS:");
        System.out.println("═══════════════════════════════════════════\n");
        historiaRepository.findAll().forEach(System.out::println);
        System.out.println("\nTotal: " + historiaRepository.count());
    }
}