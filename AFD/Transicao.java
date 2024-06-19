package AFD;
/**
 * Transicao: Represents a transition between two nodes
 * It has a destination node and a char (the symbol of the transition)
 * @author Nicolas Arvani
 */
public class Transicao {
    private Node destino;
    private char letra;

    public Transicao(Node destino, char letra) {
        this.destino = destino;
        this.letra = letra;
    }

    public Node getDestino() {
        return destino;
    }

    public char getLetra() {
        return letra;
    }
}
