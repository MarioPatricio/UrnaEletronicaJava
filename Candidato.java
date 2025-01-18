public class Candidato {

    private String _nome, _numero;
    private int _voto;
    
    public Candidato(){

    }

    public Candidato(String nome, String numero){
        this._nome=nome;
        this._numero=numero;
    }

    public String getNome(){
        return this._nome;
    }

    public String getNumero(){
        return this._numero;
    }

    public int getVoto(){
        return this._voto;
    }

    public void incrementarVoto(){
        this._voto++;
    }

}
