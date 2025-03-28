# sistema-de-notas
primero para generar las noras, se genero aleatoriamente en un rango de 1.0 a 7.0 utilizando la clase random. La funcion generarNotas(int cantidadNotas) devuelve un array de valores double con las notas generadas

public static double[] generarNotas(int cantidadNotas) {
    Random random = new Random();
    double[] notas = new double[cantidadNotas];

    for (int i = 0; i < cantidadNotas; i++) {
        notas[i] = 1.0 + (6.0 * random.nextDouble());
    }
    return notas;
}

luego de eso pasamos a hacer los 2 enfoques, el enfoque imperativo y el enfoque con programacion funcional
en el enfoque imperativo se utilizo un bucle for para recorrer el array de notas y clasificar cada una en su respectiva categoria

int mayorCuatro = 0;
int menorTresSeis = 0;
int entreTresSeisYCuatro = 0;

for (double nota : notas) {
    if (nota > 4.0) {
        mayorCuatro++;
    } else if (nota < 3.6) {
        menorTresSeis++;
    } else {
        entreTresSeisYCuatro++;
    }
}

luego lo hicimos enfocado en la programacion funcional
donde se usa streams para procesar el array de manera mas declarativa y paralela

long mayorCuatroFuncional = Arrays.stream(notas).parallel().filter(n -> n > 4.0).count();
long menorTresSeisFuncional = Arrays.stream(notas).parallel().filter(n -> n < 3.6).count();
long entreTresSeisYCuatroFuncional = Arrays.stream(notas).parallel().filter(n -> n >= 3.6 && n < 4.0).count();

en comparativa el enfoque imperativo usa estructuras de control tradicionales y mass lineas de codigo
la programacion funcional emplea stream para hacer el codigo mas compacto y es mas eficiente en el procesamiento de datos