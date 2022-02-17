import java.util.Objects;

public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		// verifica se o texto recebido é nulo ou então vazio,
		// ou seja, sem nenhum caractere, lançando exceção.
		// armazena o texto recebido em this.texto.
    	if (texto == null || texto == "")
    		throw new Exception("Texto vazio");
    	else
    		this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
    	int iguais = 0;
    	for (int i = 0; i < this.getTamanho(); i++) {
    		if (texto.charAt(i) == letra)
    			iguais++;
    	}
    	return iguais;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        // se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;
        // se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;
        // se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // e assim por diante.
        // lançar excecao caso nao encontre em this.texto
        // a Iézima aparição da letra fornecida.
    	int iezima = -1;
    	for(int j = 0; j < this.texto.length() && i >= 0; j++) {
    		if(this.texto.charAt(j) == letra) {
    			if(i == 0)
    				iezima = j;
    			i--;
    		}
    	}
    	if(iezima < 0)
    		throw new Exception ("Posição não encontrada");
    	else
    		return iezima;
    			
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palavra other = (Palavra) obj;
		return Objects.equals(texto, other.texto);
	}

    @Override
	public int hashCode() {
		return Objects.hash(texto);
	}

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
