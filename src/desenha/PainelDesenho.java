/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenha;

//import excecao.OutOfBoundsException;
import excecao.OutOfBoundsException;
import figuras.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.Serializable;
import javax.swing.*;
  
@SuppressWarnings("serial")
public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener,KeyListener,Serializable{
	private PainelDesenho painelAnterior;
	public PainelDesenho(){
		this.setBounds(getVisibleRect());
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		painelAnterior = null;
		
	}
	
	public void paintFig(Figura f) throws OutOfBoundsException{
		if(f instanceof Circulo){
			Point l = new Point(f.getP().getX(),f.getP().getY());
			if(!(this.getVisibleRect().contains(new Point(l.x,l.y)))
				||this.getVisibleRect().getWidth() < l.x+2*((Circulo)f).getRaio()
				||this.getVisibleRect().getWidth() < l.y+2*((Circulo)f).getRaio()){
				throw new OutOfBoundsException("Desenho fora da area, tente outro ponto");
			}
			Circulo_Desenho c = new Circulo_Desenho(f);
			c.addMouseListener(this);
			c.addMouseMotionListener(this);
			c.addKeyListener(this);
			this.add(c);
			c.setBounds(l.x, l.y, (int)(2*((Circulo)f).getRaio()),(int)(2*((Circulo)f).getRaio()));
			c.setOpaque(false);
			
		}
		else if(f instanceof Retangulo){
			Point l = new Point(f.getP().getX(),f.getP().getY());
			if(!(this.getVisibleRect().contains(new Point(l.x,l.y)))
				||this.getVisibleRect().getWidth() < l.x+((Retangulo)f).getB()
				||this.getVisibleRect().getWidth() < l.y+((Retangulo)f).getH()){
				throw new OutOfBoundsException("Desenho fora da area, tente outro ponto");
			}
			Retangulo_Desenho r = new Retangulo_Desenho(f);
			r.addMouseListener(this);
			r.addMouseMotionListener(this);
			r.addKeyListener(this);
			this.add(r);
			r.setBounds(l.x,l.y,(int)(((Retangulo)f).getB()),(int)(((Retangulo)f).getH()));
			r.setOpaque(false);
		}
		else if(f instanceof Reta){
			Point l = new Point(f.getP().getX(),f.getP().getY());
			if(!(this.getVisibleRect().contains(new Point(l.x,l.y)))
				||!(this.getVisibleRect().contains(((Reta)f).getPf().getX(), ((Reta)f).getPf().getY()))){
				throw new OutOfBoundsException("Desenho fora da area, tente outro ponto");
			}
			Line_Desenho lr = new Line_Desenho(f);
			lr.addMouseListener(this);
			lr.addMouseMotionListener(this);
			lr.addKeyListener(this);
			this.add(lr);
			if(l.x<((Reta)f).getPf().getX()&&l.y<((Reta)f).getPf().getY())
				lr.setBounds(l.x,l.y,Math.abs(((Reta)f).getPf().getX() - (l.x)),Math.abs(((Reta)f).getPf().getY() - (l.y)));
			else if(l.x>((Reta)f).getPf().getX())
				lr.setBounds(((Reta)f).getPf().getX(),l.y,(l.x)-((Reta)f).getPf().getX(),((Reta)f).getPf().getY() - (l.y));
			else if(l.y>((Reta)f).getPf().getX())
				lr.setBounds(l.x,((Reta)f).getPf().getY(),((Reta)f).getPf().getX() - (l.x),(l.y)-((Reta)f).getPf().getY());
			else if(l.y>((Reta)f).getPf().getX()&&l.x>((Reta)f).getPf().getX())
				lr.setBounds(((Reta)f).getPf().getX(),((Reta)f).getPf().getY() ,((Reta)f).getPf().getX()-(l.x),((Reta)f).getPf().getY()-(l.y));
			lr.setOpaque(false);
		}
	}
	
	public PainelDesenho getLastPanel(){
		return painelAnterior;
	}
	
	public void mudaContexto(){
		painelAnterior=this;
		}
	
	private class Circulo_Desenho extends JPanel{
		Figura f;
		public Circulo_Desenho(Figura f){
			this.f=f;
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setColor(f.getCor());
			g2d.setStroke(new BasicStroke(2.0f));
			g2d.draw(new Ellipse2D.Float(0, 0, 2*((Circulo) f).getRaio(), 2*((Circulo) f).getRaio()));
		}

	}
	private class Retangulo_Desenho extends JPanel{
		Figura f;
		
		public Retangulo_Desenho(Figura f){
			this.f=f;
			
			//this.setVisible(true);
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setColor(f.getCor());
			g2d.setStroke(new BasicStroke(2.0f));
			g2d.draw(new Rectangle.Float(0, 0, this.getWidth(),this.getHeight()));
		}
	}
	private class Line_Desenho extends JPanel{
		Figura f;
		
		public Line_Desenho(Figura f){
			this.f=f;
			//this.setVisible(true);
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setColor(f.getCor());
			g2d.setStroke(new BasicStroke(2.0f));
			g2d.draw(new Line2D.Float(0,0,this.getWidth(),this.getHeight()));
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == MouseEvent.BUTTON3){
			int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo apagar essa imagem?");
			if(i==JOptionPane.YES_OPTION){
				this.remove((Component)e.getSource());
				FiguresSave.getArrayFiguras().remove(e.getComponent());
				this.updateUI();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DELETE){
			this.remove(((JPanel)e.getSource()));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void recuperaDesenhos(){
		for(int i = 0;i<FiguresSave.getArrayFiguras().size();i++){
			Figura f=FiguresSave.getArrayFiguras().get(i);
			if(f instanceof Circulo){
				Point l = new Point(f.getP().getX(),f.getP().getY());
				Circulo_Desenho c = new Circulo_Desenho(f);
				c.addMouseListener(this);
				c.addMouseMotionListener(this);
				this.add(c);
				c.setBounds(l.x, l.y, (int)(2*((Circulo)f).getRaio()),(int)(2*((Circulo)f).getRaio()));
				c.setOpaque(false);
				
			}
			else if(f instanceof Retangulo){
				Point l = new Point(f.getP().getX(),f.getP().getY());
				Retangulo_Desenho r = new Retangulo_Desenho(f);
				r.addMouseListener(this);
				r.addMouseMotionListener(this);
				r.addKeyListener(this);
				this.add(r);
				r.setBounds(l.x,l.y,(int)(((Retangulo)f).getB()),(int)(((Retangulo)f).getH()));
				r.setOpaque(false);
			}
			else if(f instanceof Reta){
				Point l = new Point(f.getP().getX(),f.getP().getY());
				Line_Desenho lr = new Line_Desenho(f);
				lr.addMouseListener(this);
				lr.addMouseMotionListener(this);
				lr.addKeyListener(this);
				this.add(lr);
				lr.setBounds(l.x,l.y,((Reta)f).getPf().getX() - (l.x),((Reta)f).getPf().getY() - (l.y));
				lr.setOpaque(false);
			}
		}
	}
}
