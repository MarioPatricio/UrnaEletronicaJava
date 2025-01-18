import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UrnaEletronica {

    private List<Candidato> _candidatos = new ArrayList<>();
    private int _votoNulo = 0, _votoVal = 0, empatou = 0;
    private String vencedor = " ";

    public UrnaEletronica(List<Candidato> candidatos){
        this._candidatos = candidatos;
    }

    public void receberVoto(String numero){
        int numeroConv = Integer.parseInt(numero);
        if (numeroConv >= 1 && numeroConv <= _candidatos.size()){
            for (Candidato candidato : _candidatos) {
                if (numero.equals(candidato.getNumero())){
                    candidato.incrementarVoto();
                    _votoVal++;
                }
    
            }
        }else {
            _votoNulo++;
        }
        
    }

    public void apurarResultado(){
        int maior = 0;

        for (Candidato candidato : _candidatos) {
            if (maior < candidato.getVoto()){
                maior = candidato.getVoto();
                vencedor = candidato.getNome();
            }
            
        }

        for (Candidato candidato : _candidatos) {
            if (candidato.getVoto() == maior){
                empatou++;
            }
            
        }

    }

    public void exibirResultado(){
        double _porcentagem;
        System.out.println("Resultado da votação: ");
        for (Candidato candidato : _candidatos) {
            _porcentagem = ((double) candidato.getVoto()/_votoVal)*100;
            System.out.println("Candidato: "+ candidato.getNome()+ " | Número: " + 
            candidato.getNumero() + " | Votos totais: " + candidato.getVoto()+ " (" +_porcentagem +"%)");
        }

        System.out.println("Votos nulos: "+ _votoNulo);

        if (empatou > 1){
            System.out.println("Empate!");
        }else {
            System.out.println("O vencedor é " + vencedor);
        }

    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String numero;

    Candidato c1 = new Candidato("Ada Lovelace", "01");
    Candidato c2 = new Candidato("Alan Turing", "02");
    Candidato c3 = new Candidato("Marie Curie", "03");
    Candidato c4 = new Candidato("Albert Einstein", "04");
    Candidato c5 = new Candidato("Ludwig Van Beethowen", "05");

    List<Candidato> lista = new ArrayList<>();
    lista.add(c1);
    lista.add(c2);
    lista.add(c3);
    lista.add(c4);
    lista.add(c5);

    UrnaEletronica urna = new UrnaEletronica(lista);

    System.out.println("Seja bem-vindo a eleição das figuras históricas!");
    System.out.printf("Candidatos:\n01 - Ada Lovelace\n02 - Alan Turing\n03 - Marie Curie\n04 - Albert Einstein\n05 - Ludwig Van Beethowen\n");

    for (int i = 0; i < 10; i++){
        System.out.println("Digite a numeração de seu candidato: ");
        numero = sc.next();
        while(numero.length() != 2){
            System.out.println("Digite novamente (2 dígitos): ");
            numero = sc.next();
        }
        if (numero.length()==2){
            urna.receberVoto(numero);
            System.out.println("Voto computado.");
        }
        
    }

    urna.apurarResultado();
    urna.exibirResultado();

    sc.close();
        
    }
    
}
