package figuras;

import java.awt.Color;

public class Reta extends Figura{
private Ponto pf;
	public Reta(int x, int y,int xf,int yf, Color cor) {
		super(x, y, cor);
		pf = new Ponto(xf,yf);
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.getP().getDist(this.pf);
	}

	@Override
	public double getPer() {
		// TODO Auto-generated method stub
		return this.getP().getDist(this.pf);
	}
	public Ponto getPf(){
		return this.pf;
	}

}
