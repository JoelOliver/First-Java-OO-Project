package janelas;
import figuras.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import desenha.FiguresSave;
@SuppressWarnings("serial")
public class LineCreator extends FigureCreator implements FocusListener {

	private JTextField x = new JTextField(5);
	private JTextField y = new JTextField(5);
	private JTextField x2 = new JTextField(5);
	private JTextField y2 = new JTextField(5);

	public LineCreator() {
		super("Criar retas");
		initGui();
	}

	private void initGui() {
		figureLabel.setText("Dados da reta: x1, y1, x2 e y2");
		figCria.setText("Criar Reta");
		x.addFocusListener(this);
		y.addFocusListener(this);
		x2.addFocusListener(this);
		y2.addFocusListener(this);
		dadosF.add(x);
		dadosF.add(y);
		dadosF.add(x2);
		dadosF.add(y2);
		dadosF.add(figCria);
		this.setLayout(new GridLayout(3,1));
		this.add(dadosF,BorderLayout.CENTER);
		this.add(saida, BorderLayout.CENTER);
		this.add(warningPanel,BorderLayout.CENTER);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		this.setResizable(false);

	}

	/**
	 *
	 */
	public void mostraGUI() {
		x.setText(null);
		y.setText(null);
		x2.setText(null);
		y2.setText(null);
		qntFigs.setText(getFiguras()+" Reta(s)");
		this.setLocationRelativeTo(null);   

	}

	@Override
	public int getFiguras() {
		int cont = 0;
		for (Figura figura : FiguresSave.getArrayFiguras()) {
			if (figura instanceof Reta) {
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
		} else if (e.getComponent() == x2) {
			warning.setForeground(Color.BLUE);
			warning.setText("Entre com valores maiores que zero");
		}
		else if (e.getComponent() == y2) {
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
		} else if (e.getComponent() == y && e.getOppositeComponent() == x2) {
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
		} else if (e.getComponent() == x2 && e.getOppositeComponent() == y2) {
			if (x2.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Entre com  um valor para Altura");
				x2.requestFocus();
			} else {
				try {
					Double.parseDouble(x2.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Entre com  um valor numerico para Altura");
					getTY().requestFocus();
				}
			}
		}
		else if (e.getComponent() == y2 && e.getOppositeComponent() == figCria) {
			if (y2.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Entre com  um valor para RAIO");
				y2.requestFocus();
			} else {
				try {
					Double.parseDouble(x2.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Entre com  um valor numerico para Largura");
					y2.requestFocus();
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
	public JTextField getX2() {
		return x2;
	}

	public JTextField getY2() {
		return y2;
	}

}


