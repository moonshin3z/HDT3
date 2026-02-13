import sorts.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] tamanios = {10, 50, 100, 500, 1000, 2000, 3000};

        System.out.println("=== Benchmark de Algoritmos de Ordenamiento ===\n");

        try {
            // Generar archivos de datos si no existen
            for (int n : tamanios) {
                generarDatos(n);
            }

            // Ejecutar benchmarks
            PrintWriter csv = new PrintWriter(new FileWriter("resultados/resultados.csv"));
            csv.println("Algoritmo,Tamanio,Condicion,Tiempo(ms)");

            String[] algoritmos = {"GnomeSort", "MergeSort", "QuickSort", "RadixSort", "HeapSort"};

            for (String algo : algoritmos) {
                System.out.println("Probando " + algo + "...");
                for (int n : tamanios) {
                    // Test con datos desordenados
                    int[] datos = leerDatos(n);
                    long tiempo = medirTiempo(algo, datos);
                    csv.println(algo + "," + n + ",desordenado," + (tiempo/1_000_000.0));

                    // Test con datos ordenados
                    Arrays.sort(datos);
                    tiempo = medirTiempo(algo, datos);
                    csv.println(algo + "," + n + ",ordenado," + (tiempo/1_000_000.0));
                }
            }

            csv.close();
            System.out.println("\n¡Listo! Resultados guardados en resultados/resultados.csv");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void generarDatos(int n) throws IOException {
        File archivo = new File("datos/numeros_" + n + ".txt");
        if (archivo.exists()) return;

        PrintWriter pw = new PrintWriter(new FileWriter(archivo));
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            pw.println(rand.nextInt(10000));
        }
        pw.close();
    }

    private static int[] leerDatos(int n) throws IOException {
        Scanner sc = new Scanner(new File("datos/numeros_" + n + ".txt"));
        int[] datos = new int[n];

        for (int i = 0; i < n; i++) {
            datos[i] = sc.nextInt();
        }
        sc.close();
        return datos;
    }

    private static long medirTiempo(String algoritmo, int[] datos) {
        int[] copia = Arrays.copyOf(datos, datos.length);

        long inicio = System.nanoTime();

        switch (algoritmo) {
            case "GnomeSort":
                GnomeSort.sort(copia);
                break;
            case "MergeSort":
                MergeSort.sort(copia);
                break;
            case "QuickSort":
                QuickSort.sort(copia);
                break;
            case "RadixSort":
                RadixSort.sort(copia);
                break;
            case "HeapSort":
                HeapSort.sort(copia);
                break;
        }

        long fin = System.nanoTime();
        return fin - inicio;
    }
}
