import java.util.Objects;

public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        // torna this.letrasJaDigitadas igual ao String vazio
    	this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo
    	for(int i = 0; i < this.letrasJaDigitadas.length(); i++) {
    		if(this.letrasJaDigitadas.charAt(i) == letra)
    			return true;
    	}
    	return false;
    }

    public void registre (char letra) throws Exception
    {
		// verifica se a letra fornecida ja foi digitada (pode usar
		// o método this.isJaDigitada, para isso), lancando uma exceção
		// em caso afirmativo.
		// concatena a letra fornecida a this.letrasJaDigitadas.
    	if(this.isJaDigitada(letra))
    		throw new Exception("Letra já digitada!");
    	else {
    		this.letrasJaDigitadas = this.letrasJaDigitadas + letra; //verificar se isso aqui funcionou
    	}
    }

    public String toString ()
    {
		// retorna um String com TODAS as letras presentes em
		// this.letrasJaDigitadas separadas por vírgula (,).
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < this.letrasJaDigitadas.length(); i++)
    	{
    		sb.append(this.letrasJaDigitadas.charAt(i) + ", ");
    	}
    	return sb.toString();
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControladorDeLetrasJaDigitadas other = (ControladorDeLetrasJaDigitadas) obj;
		return Objects.equals(letrasJaDigitadas, other.letrasJaDigitadas);
	}

    @Override
	public int hashCode() {
		return Objects.hash(letrasJaDigitadas);
	}

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception // construtor de cópia
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas
    	if(controladorDeLetrasJaDigitadas == null)
    		throw new Exception ("Vazio");
    	this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone ()
    {
        // criar uma cópia do this com o construtor de cópia e retornar
    	ControladorDeLetrasJaDigitadas c = null;
   	 try {
   		 c = new ControladorDeLetrasJaDigitadas(this);
   	 }catch (Exception erro)
   	 {}
   	 return c;
    }
}
