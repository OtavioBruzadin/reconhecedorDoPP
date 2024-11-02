import java.io.*;
import java.util.*;

public class Misc {

    public static String[] ReadFile(String caminhoArquivo) {
        List<String> line = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                line.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line.toArray(new String[0]);
    }

    public static Queue StringToQueue(String chain) {
        Queue<Character> Queue = new LinkedList<>();
        for (int i = 0; i < chain.length(); i++) {
            Queue.add(chain.charAt(i));
        }
        return Queue;
    }

    public static Queue<Character>[] DigestFile (String fileName) throws FileNotFoundException {
        String[] Content = ReadFile(fileName);
        Queue<Character>[] DigestedFile = new LinkedList[Content.length];
        for (int i = 0; i < Content.length; i++) {
            DigestedFile[i] = StringToQueue(Content[i]);
        }
        return DigestedFile;
    }

    public static String queueToString(Queue<?> queue) {
        StringBuilder sb = new StringBuilder();

        for (Object element : queue) {
            sb.append(element);
        }

        return sb.toString();
    }

    public static void escreverLinhaNoArquivo( String chain, Boolean result) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Output.txt", true))) {
            String resultString = (result) ? " {-- VALIDA --}" : " {-- INVALIDA --}";
            bw.write(chain + resultString);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}