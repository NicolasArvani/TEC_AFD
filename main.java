import java.io.File;
import AFD.AfdParser;

/**
 * Trabalho de TECC7 2024 - AFD
 * Utilização: java main <entrada.txt>
 * Sendo <entrada.txt> o nome do arquivo de entrada
 * 
 * @author Nicolas Arvani
 * @author Isabella Bicudo
 */
public class main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java main <entrada.txt>");
            return;
        }

        String entrada = args[0];
        // load the entrada file
        File entradaFile = new File(entrada);
        
        AfdParser afdParser = new AfdParser(entradaFile);
        try{
            afdParser.rodarAutomato();
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            return;
        }
    }
}