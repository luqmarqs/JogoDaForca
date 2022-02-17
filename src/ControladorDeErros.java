import java.util.Objects;

public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
		// verifica se qtdMax fornecida não é positiva, lançando
		// uma exceção.
		// armazena qtdMax fornecida em this.qtdMax.
    	if (qtdMax < 0)
    		throw new Exception ("qtdMax não é positiva");
    	else
    		this.qtdMax = qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        // verifica se this.qtdErr ja é igual a this.qtdMax,
        // lançando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo
    	if (this.qtdErr >= this.qtdMax)
    		throw new Exception ("Esgotou quantidade de erros");
    	else
    		this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        // returna true se this.qtdErr for igual a this.qtdMax,
        // ou então false, caso contrario.
    	if (this.qtdErr == this.qtdMax)
    		return true;
    	else
    		return false;
    }

    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControladorDeErros other = (ControladorDeErros) obj;
		return qtdErr == other.qtdErr && qtdMax == other.qtdMax;
	}

    @Override
	public int hashCode() {
		return Objects.hash(qtdErr, qtdMax);
	}

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de cópia
    {
        // copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr
    	if(c == null)
    		throw new Exception("Vazio!");
    	this.qtdMax = c.qtdMax;
    	this.qtdErr = c.qtdErr;
    }

    public Object clone ()
    {
        // returnar uma cópia de this
    	ControladorDeErros ret = null;
    	try {
    		ret = new ControladorDeErros(this);
    	} catch (Exception erro)
    	{}
    	return ret;
    }
}
