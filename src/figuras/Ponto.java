package figuras;

import java.io.Serializable;

public class Ponto implements Serializable{
	private int x;
    private int y;
    private Ponto pa;
	
	public Ponto(int x, int y){
		this.x = x;
		this.y = y;
		pa = null;
	}
	
	public Ponto(int x, int y, Ponto pa){
		this(x,y);
		this.pa = pa;
	}	
	
	public void move(int x, int y){
            this.setPa(new Ponto(this.getX(), this.getY(), this.getPa()));
		this.setX(x); this.setY(y);
	}
	public double getDist(Ponto p){
		return(Math.sqrt(Math.pow(this.x-p.getX(), 2)+Math.pow(this.y-p.getY(), 2)));
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	public Ponto getPa() {return pa;}

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param pa the pa to set
     */
    public void setPa(Ponto pa) {
        this.pa = pa;
    }
	

}
