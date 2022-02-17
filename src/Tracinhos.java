import java.util.Arrays;

public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
		// verifica se qtd não é positiva, lançando uma exceção.
		// instancia this.texto com um vetor com tamanho igual qtd.
		// preenche this.texto com underlines (_).
    	if (qtd <= 0)
    		throw new Exception("Palavra vazia");
    	this.texto = new char[qtd];
    	for(int i=0; i < qtd; i++)
    		this.texto[i] = '_';
    	
    	}

    public void revele (int posicao, char letra) throws Exception
    {
		// verifica se posicao é negativa ou então igual ou maior
		// do que this.texto.length, lançando uma exceção.
		// armazena a letra fornecida na posicao tambem fornecida
		// do vetor this.texto
    	if(posicao < 0 || posicao >= this.texto.length)
    		throw new Exception ("Posição inexistente");
    	this.texto[posicao] = letra;
    		
    }

    public boolean isAindaComTracinhos ()
    {
        // percorre o vetor de char this.texto e verifica
        // se o mesmo ainda contem algum underline ou se ja
        // foram todos substituidos por letras; retornar true
        // caso ainda reste algum underline, ou false caso
        // contrario
    	for(int i = 0; i < this.texto.length; i++) {
    		if (this.texto[i] == '_')
    			return true;
    	}
    	return false;
    }

    public String toString ()
    {
        // retorna um String com TODOS os caracteres que há
        // no vetor this.texto, intercalados com espaços em
        // branco
    	String palavra = "";
    	for(int i = 0; i < texto.length; i++) {
    		palavra = palavra + texto[i] + " ";
    	}
    	return palavra;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tracinhos other = (Tracinhos) obj;
		return Arrays.equals(texto, other.texto);
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(texto);
		return result;
	}

    public Tracinhos (Tracinhos t) throws Exception // construtor de cópia
    {
        // intanciar this.texto um vetor com o mesmo tamanho de t.texto
        // e copilar o conteúdo de t.texto para this.texto
    	if(t == null)
    		throw new Exception ("Vazio!");
    	this.texto = t.texto;
    }

    public Object clone ()
    {
        // retornar uma copia de this
    	Tracinhos clonado = null;
    	try
    	{
    		clonado = new Tracinhos(this);
    	}
    	catch (Exception erro)
    	{}
    	return clonado;
    	
    }
}
