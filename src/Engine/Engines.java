package Engine;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Queue;

public class Engines {

    public static Boolean singleInputEntry(String input) throws FileNotFoundException {
        Queue<Simbolos.Terminais> entrada  = Misc.stringToQueue("src/texto.txt");
        System.out.println(entrada);

        return true;//TODO Adicionar o interpretador recebendo entrada;
    }

    public static void multipleInputsEntry(String path) throws FileNotFoundException {
        List<Queue<Simbolos.Terminais>> entrada  = Misc.digestFile(path);

        for (int i = 0; i < entrada.size(); i++) {
            System.out.println(entrada.get(i));
            Boolean resultado = true; //TODO adicionar o interpretador recebendo entrada[i]
            Misc.escreverLinhaNoArquivo(Misc.queueToString(entrada.get(i)),resultado);
        }

    }

}
