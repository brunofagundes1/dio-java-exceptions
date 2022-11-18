import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class ExceptionCustomizada1 {
    public static void main(String[] args) {
        String nomeDoArquivo = JOptionPane.showInputDialog("Entre com o nome do arquivo: ");

        imprimirArquivoNoConsole(nomeDoArquivo);

        System.out.println("Final");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) {
        try {
            BufferedReader br = lerArquivo(nomeDoArquivo);
            String line = br.readLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            do {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            } while (line != null);
            bw.flush();
            br.close();

        } catch (ArquivoNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado");
            e.printStackTrace();
        }
    }

    public static BufferedReader lerArquivo(String nomeDoArquivo) throws ArquivoNaoEncontradoException {
        File file = new File(nomeDoArquivo);
        try {
            return new BufferedReader(new FileReader(nomeDoArquivo));
        } catch (FileNotFoundException e) {
            throw new ArquivoNaoEncontradoException(file.getName(), file.getPath());
        }
    }

}

class ArquivoNaoEncontradoException extends Exception {
    private String nomeDoArquivo;
    private String diretorio;

    public ArquivoNaoEncontradoException(String nomeDoArquivo, String diretorio) {
        super("O arquivo " + nomeDoArquivo + " não foi encontado no diretorio " + diretorio);
        this.nomeDoArquivo = nomeDoArquivo;
        this.diretorio = diretorio;
    }

    @Override
    public String toString() {
        return "ArquivoNaoEncontradoException{" +
                "nomeDoArquivo='" + nomeDoArquivo + "\'" +
                ", diretorio='" + diretorio + "\'" +
                "}";
    }
}
