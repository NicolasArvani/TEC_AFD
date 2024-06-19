package AFD;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * AfdParser: Parses the input file and creates the AFD automaton
 * @author Nicolas Arvani
 * @author Isabella Bicudo
 */
public class AfdParser {

    private File file;
    private ArrayList<Character> alfabeto = new ArrayList<Character>();
    private Map<String, Node> nodes = new HashMap<String, Node>();
    private String initialState;

    public AfdParser(File file){
        this.file = file;
    }

    public void rodarAutomato() throws Exception {
        Scanner entradaScanner = new Scanner(file);

        // Adding the alphabet
        String line = entradaScanner.nextLine();
        
        String[] tokens = line.split(" ");
        for(String token : tokens){
            if(token.equals(" ") || token.length() == 0){
                continue;
            }
            alfabeto.add(token.charAt(0));
        }

        // Adding the states (nodes)
        line = entradaScanner.nextLine();
        tokens = line.split(" ");
        for(String token : tokens){
            // making sure the token is not empty
            if(token.equals(" ") || token.length() == 0){
                continue;
            }
            Node node = new Node(token);
            nodes.put(token, node);
        }
        

        // getting the number of transitions
        line = entradaScanner.nextLine();
        int numTrans = Integer.parseInt(line);

        // getting the transitions (stateA, symbol(char), stateB)
        for(int i = 0; i < numTrans; i++){
            line = entradaScanner.nextLine();
            tokens = line.split(" ");
            if(tokens.length != 3){
                throw new Exception("Erro na linha " + i + "! Número de tokens inválido!");
            }

            String stateA = tokens[0];
            char symbol = tokens[1].charAt(0);
            String stateB = tokens[2];

            // create the transition
            Node nodeA = nodes.get(stateA);
            Node nodeB = nodes.get(stateB);
            Transicao transicao = new Transicao(nodeB, symbol);
            nodeA.addTransicao(transicao);
        }

        // getting the initial state
        line = entradaScanner.nextLine();
        this.initialState = line;

        // getting the final states
        line = entradaScanner.nextLine();
        tokens = line.split(" ");
        for(String token : tokens){
            // just to make sure the token is not empty
            if(token.equals(" ") || token.length() == 0){
                continue;
            }
            Node node = nodes.get(token);
            node.setFinalState(true);
        }

        
        // getting the number of strings to be tested
        line = entradaScanner.nextLine();
        int numStrings = Integer.parseInt(line);

        // getting the strings to be tested
        String[] strings = new String[numStrings];
        for(int i = 0; i < numStrings; i++){
            strings[i] = entradaScanner.nextLine();
        }

        entradaScanner.close();
        
        // for each string, check if it's valid
        for(String string : strings){
            System.out.println(isValidString(string) ? "Aceita" : "Rejeita");
        }
    }


    private boolean isValidString(String string){
        char[] chars = string.toCharArray();
        Node currentNode = nodes.get(initialState);
        // for each char i'm gonna check if the current node has a transition for that char 
        for(int i = 0; i < chars.length; i++){
            boolean found = false;
            char c = chars[i];
            // Loop through the transitions of the current node (maybe a hashmap would be better? idk)
            for(Transicao transicao : currentNode.getTransicoes()){
                if(transicao.getLetra() == c){ // If the current char is the same as the transition's char, then...
                    currentNode = transicao.getDestino(); // ... go to the destination node
                    found = true; // found :)
                    break;
                }
            }
            // If we didn't find a transition for the current char, and its not the last char, it's not valid
            if(i != chars.length - 1 && !found){
                return false;
            }
        }

        //Ended the string, let's check if we are at the final state
        if(currentNode.isFinalState()){
            return true; // We are at the final state, so the string is valid
        }
        return false; // The string is not valid
    }

}
