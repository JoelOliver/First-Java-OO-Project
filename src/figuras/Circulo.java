package figuras;

import excecao.NegativeValorException;
import java.awt.Color;

public class Circulo extends Figura {
	private float raio;
	
	public Circulo(float raio, Color cor, int x, int y) throws NegativeValorException {
		super(x,y,cor);
		if(raio<=0)
			throw new NegativeValorException("Valor menor/igual a zero para raio");
		else
                    this.raio = raio;
	}
	public Circulo(float raio, int x, int y) throws NegativeValorException {
		super(x,y,Color.GRAY);
		if(raio<=0)
			throw new NegativeValorException("Valor menor/igual a zero para raio");
		else
			this.raio = raio;
	}
		
	public double getArea() {return Math.PI * getRaio() * getRaio();}
	
	public double getPer() {return 2 * Math.PI * getRaio();}

    /**
     * @return the raio
     */
    public float getRaio() {
        return raio;
    }

    /**
     * @param raio the raio to set
     */
    public void setRaio(float raio) {
        this.raio = raio;
    }
}