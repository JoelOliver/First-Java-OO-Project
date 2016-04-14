package janelas;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import figuras.Figura;

@SuppressWarnings("serial")
public abstract class FigureCreator extends JFrame{

    protected JLabel figureLabel = new JLabel();
    protected JPanel dadosF = new JPanel();
    protected JLabel qntFigs = new JLabel();
    protected JLabel warning = new JLabel();
    protected JButton figCria = new JButton("Criar figura");
    protected JPanel saida = new JPanel();
    protected JPanel warningPanel = new JPanel();
    public FigureCreator(String s){
    	super(s);
    	saida.setLayout(new FlowLayout(FlowLayout.CENTER));
        warningPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        qntFigs.setText(getFiguras() + " circulos");
        saida.add(qntFigs, BorderLayout.CENTER);
        warningPanel.add(warning,BorderLayout.CENTER);
        dadosF.setLayout(new FlowLayout(FlowLayout.CENTER));
        dadosF.add(figureLabel);
        this.setLayout(new GridLayout(3, 1));
        this.add(dadosF, BorderLayout.CENTER);
        this.add(saida, BorderLayout.CENTER);
        this.add(warningPanel,BorderLayout.CENTER);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(false);
    }
    
    protected abstract int getFiguras();
    public abstract void mostraGUI();
    
    public JButton getFigCria(){
    	return figCria;
    }

}
