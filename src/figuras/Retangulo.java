package figuras;

import excecao.NegativeValorException;
import java.awt.Color;

public class Retangulo extends Figura {
	private float h;
	private float b;
	
	public Retangulo(float h,float b, Color cor, int x, int y) throws NegativeValorException {
		super(x,y,cor);
		if(h<=0||b<=0)
			throw new NegativeValorException("Valor menor/igual a zero para altura ou largura");
		else{
			this.h = h;
			this.b = b;
		}
	}
	public Retangulo(float h,float b, int x, int y) throws NegativeValorException {
		super(x,y,Color.GRAY);
		if(h<=0||b<=0)
			throw new NegativeValorException("Valor menor/igual a zero para altura ou largura");
		else{
			this.h = h;
			this.b = b;
		}
	}
		
	public double getArea() {return (this.getB() * this.getH());}
	
	public double getPer() {return (2*this.getB() +2* this.getH());}

    /**
     * @return the h
     */
    public float getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(float h) {
        this.h = h;
    }

    /**
     * @return the b
     */
    public float getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(float b) {
        this.b = b;
    }
}

