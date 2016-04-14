package janelas;
import figuras.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import desenha.FiguresSave;
@SuppressWarnings("serial")
public class RetCreator extends FigureCreator implements FocusListener {

	private JTextField x = new JTextField(5);
	private JTextField y = new JTextField(5);
	private JTextField h = new JTextField(5);
	private JTextField l = new JTextField(5);
	

	public RetCreator() {
		super("Criar reatngulos");
		initGui();
	}

	private void initGui() {
                figureLabel.setText("Dados do retangulo: x,y, altura e largura");
                figCria.setText("Criar Retangulo");
		x.addFocusListener(this);
		y.addFocusListener(this);
		h.addFocusListener(this);
		l.addFocusListener(this);
		dadosF.add(x);
                dadosF.add(y);
                dadosF.add(h);
                dadosF.add(l);
                dadosF.add(figCria);
                this.setLayout(new GridLayout(3, 1));
                this.add(dadosF, BorderLayout.CENTER);
                this.add(saida, BorderLayout.CENTER);
                this.add(warningPanel,BorderLayout.CENTER);
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		this.setResizable(false);

	}

	/**
	 *
	 */
        @Override
	public void mostraGUI() {
		x.setText(null);
		y.setText(null);
		h.setText(null);
		l.setText(null);
                qntFigs.setText(getFiguras()+" Retangulo(s)");
		this.setLocationRelativeTo(null);   

	}
        
        @Override
	public int getFiguras() {
		int cont = 0;
		for (Figura figura : FiguresSave.getArrayFiguras()) {
			if (figura instanceof Retangulo) {
				cont++;
			}
		}
		return cont;
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getComponent() == this.getTX() || e.getComponent() == this.getTY()) {
			warning.setForeground(Color.BLUE);
			warning.setText("Entre com valores inteiros");
		} else if (e.getComponent() == h) {
			warning.setForeground(Color.BLUE);
			warning.setText("Entre com valores maiores que zero");
		}
		else if (e.getComponent() == l) {
			warning.setForeground(Color.BLUE);
			warning.setText("Entre com valores maiores que zero");
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getComponent() == x && e.getOppositeComponent() == y) {
			if (getTX().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Entre com  um valor para X");
				getTX().requestFocus();
			} else {
				try {
					Integer.parseInt(getTX().getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Entre com  um valor numerico para X");
					getTX().requestFocus();
				}
			}
		} else if (e.getComponent() == y && e.getOppositeComponent() == h) {
			if (y.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Entre com  um valor para Y");
				getTY().requestFocus();
			} else {
				try {
					Integer.parseInt(y.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Entre com  um valor numerico para Y");
					getTY().requestFocus();
				}
			}
		} else if (e.getComponent() == h && e.getOppositeComponent() == l) {
			if (h.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Entre com  um valor para Altura");
				h.requestFocus();
			} else {
				try {
					Double.parseDouble(h.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Entre com  um valor numerico para Altura");
					getTY().requestFocus();
				}
			}
		}
		 else if (e.getComponent() == l && e.getOppositeComponent() == figCria) {
				if (l.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Entre com  um valor para RAIO");
					h.requestFocus();
				} else {
					try {
						Double.parseDouble(h.getText());
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Entre com  um valor numerico para Largura");
						l.requestFocus();
					}
				}
			}
	}

        /**
	 * @return the x
	 */
	public JTextField getTX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public JTextField getTY() {
		return y;
	}

	/**
	 * @return the altura
	 */
	public JTextField getAltura() {
		return h;
	}

	public JTextField getLargura() {
		return l;
	}

}

