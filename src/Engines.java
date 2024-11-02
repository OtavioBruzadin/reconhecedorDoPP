import java.io.FileNotFoundException;
import java.util.Queue;

public class Engines {
    public static Boolean SingleInputEntry(String input) throws FileNotFoundException {
        Queue entrada  = Misc.StringToQueue("src/texto.txt");
            System.out.println(entrada);
            Boolean resultado = true;//TODO Adicionar o interpretador recebendo entrada

        return resultado;
    }

    public static void MultipleInputsEntry(String path) throws FileNotFoundException {
        Queue[] entrada  = Misc.DigestFile(path);

        for (int i = 0; i < entrada.length; i++) {
            System.out.println(entrada[i]);
             Boolean resultado = true; //TODO adicionar o interpretador recebendo entrada[i]
            Misc.escreverLinhaNoArquivo(Misc.queueToString(entrada[i]),resultado);
        }

    }

}
