package figuras;

import java.awt.Color;
import java.io.Serializable;

public abstract class Figura implements Serializable{
	private Ponto p;
	private Color cor;
	public Figura(int x, int y, Color cor) {
	// construtor de Figura;
		p=new Ponto(x,y);
		this.cor=cor;	
	}
	// metodos de Figura
	public abstract double getArea();
	public abstract double getPer();
	
	public Color getCor(){
		return this.cor;
	}
	public Ponto getP(){
		return this.p;
	}

    /**
     * @param p the p to set
     */
    public void setP(Ponto p) {
        this.p = p;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(Color cor) {
        this.cor = cor;
    }
}