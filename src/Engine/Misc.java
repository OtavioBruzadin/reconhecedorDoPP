package Engine;

import java.io.*;
import java.util.*;

public class Misc {

    public static String[] readFile(String caminhoArquivo) {
        List<String> line = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                line.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Não foi possível encontrar o arquivo.");
        }

        return line.toArray(new String[0]);
    }

    public static Queue<Simbolos.Terminais> stringToQueue(String chain) {
        Queue<Simbolos.Terminais> queue = new LinkedList<>();
        for (int i = 0; i < chain.length(); i++) {
            Simbolos.Terminais symbol = Simbolos.getTerminalFromString(chain.charAt(i));

            if(symbol != null) queue.add(symbol);
            else return null;
        }
        return queue;
    }

    public static List<Queue<Simbolos.Terminais>> digestFile (String fileName) throws FileNotFoundException {
        String[] Content = readFile(fileName);
        List<Queue<Simbolos.Terminais>> digestedFile = new ArrayList<>();
        for (int i = 0; i < Content.length; i++) {
            digestedFile.add(stringToQueue(Content[i]));
        }
        return digestedFile;
    }

    public static String queueToString(Queue<Simbolos.Terminais> queue) {
        StringBuilder sb = new StringBuilder();

        for (Simbolos.Terminais element : queue) {
            sb.append(Simbolos.getStringFromTerminal(element));
        }

        return sb.toString();
    }

    public static void escreverLinhaNoArquivo( String chain, Boolean result) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true))) {
            String resultString = (result) ? " {-- VALIDA --}" : " {-- INVALIDA --}";
            bw.write(chain + resultString);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}