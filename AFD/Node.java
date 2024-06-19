package AFD;

import java.util.ArrayList;

/**
 * Node: Represents a node in the automaton
 * It has a label (the name of the node), and a list of transitions
 * Also, it has a boolean to indicate if it is a final state
 * @author Nicolas Arvani
 */
public class Node {
    private ArrayList<Transicao> transicoes = new ArrayList<Transicao>();
    private String label;
    private boolean finalState;


    public Node(String label, ArrayList<Transicao> transicoes) {
        this.label = label;
        this.transicoes = transicoes;
    }
    
    public Node (String label){
        this.label = label;
    }   

    public ArrayList<Transicao> getTransicoes() {
        return transicoes;
    }

    public String getLabel() {
        return label;
    }

    public boolean isFinalState() {
        return finalState;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setTransicoes(ArrayList<Transicao> transicoes) {
        this.transicoes = transicoes;
    }

    public void setFinalState(boolean finalState) {
        this.finalState = finalState;
    }

    public void addTransicao(Transicao transicao) {
        transicoes.add(transicao);
    }

}
