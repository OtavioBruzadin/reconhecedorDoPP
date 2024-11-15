package Engine;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Queue;
import java.io.*;

public class Engines {

    public static Boolean singleInputEntry(String input) throws FileNotFoundException {
        Queue<Simbolos.Terminais> entrada = Misc.stringToQueue(input);

        if (entrada == null) {
            System.out.println(input + " = Cadeia Inválida");
            return false;
        }

        System.out.println("Entrada: " + Misc.queueToString(entrada));

        Interpreter interpreter = new Interpreter();
        boolean resultado = interpreter.analisar(entrada);
        String retornoResult = "Cadeia Válida";

        if (!resultado) {
            retornoResult = "Cadeia Inválida";
        }

        System.out.println(input + " = " + retornoResult);
        return resultado;
    }

    public static void multipleInputsEntry(String path) throws FileNotFoundException {
        List<Queue<Simbolos.Terminais>> entradas = Misc.digestFile(path);
        String outputFilePath = "output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String line : Misc.readFile(path)) { 
                String entradaOriginal = line;

                Queue<Simbolos.Terminais> entrada = Misc.stringToQueue(entradaOriginal);

                String retornoResult = "Cadeia Válida";

                if (entrada != null) {
                    Interpreter interpreter = new Interpreter();
                    boolean resultado = interpreter.analisar(entrada);

                    if (!resultado) {
                        retornoResult = "Cadeia Inválida";
                    }
                } else {
                    retornoResult = "Cadeia Inválida";
                }

                String resultadoTexto = entradaOriginal + " = " + retornoResult;
                writer.write(resultadoTexto);
                writer.newLine();
                System.out.println(resultadoTexto);
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever os resultados: " + e.getMessage());
        }
    }
}
