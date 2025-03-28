import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int cantidadNotas = 20;
        double[] notas = generarNotas(cantidadNotas);

        System.out.println("notas generadas:");
        System.out.println(Arrays.toString(notas));

        // manera imperativa
        int mayorCuatro=0;
        int menorTresSeis=0;
        int entreTresSeisYCuatro=0;
        for (double nota : notas) {
            if (nota > 4.0) {
                mayorCuatro++;
            } else if (nota < 3.6) {
                menorTresSeis++;
            } else {
                entreTresSeisYCuatro++;
            }
        }

        System.out.println("\nenfoque imperativo:");
        System.out.println("cantidad de notas mayores a 4.0: " + mayorCuatro);
        System.out.println("cantidad de notas menores a 3.6: " + menorTresSeis);
        System.out.println("cantidad de notas en el rango [3.6, 4.0): " + entreTresSeisYCuatro);

        // programacion funcional
        long mayorCuatroFuncional = Arrays.stream(notas).parallel().filter(n -> n > 4.0).count();
        long menorTresSeisFuncional = Arrays.stream(notas).parallel().filter(n -> n < 3.6).count();
        long entreTresSeisYCuatroFuncional = Arrays.stream(notas).parallel().filter(n -> n >= 3.6 && n < 4.0).count();

        System.out.println("\nenfoque Funcional:");
        System.out.println("cantidad de notas mayores a 4.0: " + mayorCuatroFuncional);
        System.out.println("cantidad de notas menores a 3.6: " + menorTresSeisFuncional);
        System.out.println("cantidad de notas en el rango [3.6, 4.0): " + entreTresSeisYCuatroFuncional);

    }

    public static double[] generarNotas(int cantidadNotas) {
        Random random = new Random();
        double[] notas = new double[cantidadNotas];

        for (int i = 0; i < cantidadNotas; i++) {
            notas[i] = 1.0 + (6.0 * random.nextDouble());
        }
        return notas;
    }
}
