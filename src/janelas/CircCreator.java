package janelas;


import figuras.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import desenha.FiguresSave;

/**
 *
 * @author rodrigo & joel
 */
@SuppressWarnings("serial")
public class CircCreator extends FigureCreator implements FocusListener {
    
    private JTextField x = new JTextField(5);
    private JTextField y = new JTextField(5);
    private JTextField raio = new JTextField(5);
    
    public CircCreator() {
        super("Criar circulos");
        initGui();
    }

    private void initGui() {
    	figureLabel.setText("Dados do Circulo: x, y e raio");
    	figCria.setText("Criar Circulo");
        x.addFocusListener(this);
        y.addFocusListener(this);
        dadosF.add(x);
        dadosF.add(y);
        dadosF.add(raio);
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
    public void focusGained(FocusEvent e) {
        if (e.getComponent() == this.getTX() || e.getComponent() == this.getTY()) {
            warning.setForeground(Color.BLUE);
            warning.setText("Entre com valores inteiros");
        } else if (e.getComponent() == getRaio()) {
            warning.setForeground(Color.BLUE);
            warning.setText("Entre com valores maiores que zero");
        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getComponent() == getTX() && e.getOppositeComponent() == getTY()) {
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
        } else if (e.getComponent() == getTY() && e.getOppositeComponent() == getRaio()) {
            if (getTY().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Entre com  um valor para Y");
                getTY().requestFocus();
            } else {
                try {
                    Integer.parseInt(getTY().getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Entre com  um valor numerico para Y");
                    getTY().requestFocus();
                }
            }
        } else if (e.getComponent() == getRaio() && e.getOppositeComponent() == getFigCria()) {
            if (getRaio().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Entre com  um valor para RAIO");
                getRaio().requestFocus();
            } else {
                try {
                    Double.parseDouble(getRaio().getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Entre com  um valor numerico para RAIO");
                    getTY().requestFocus();
                }
            }
        }
    }

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
     * @return the raio
     */
    public JTextField getRaio() {
        return raio;
    }

	@Override
	public void mostraGUI() {
		// TODO Auto-generated method stub
		x.setText(null);
		y.setText(null);
		raio.setText(null);
		qntFigs.setText(getFiguras() + " circulos" );
		this.setLocationRelativeTo(null);  
	}

	@Override
	protected int getFiguras() {
		// TODO Auto-generated method stub
		 int cont = 0;
	        for (Figura figura : FiguresSave.getArrayFiguras()) {
	            if (figura instanceof Circulo) {
	                cont++;
	            }
	        }
	        return cont;
	}

}
