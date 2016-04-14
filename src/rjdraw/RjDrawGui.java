package rjdraw;

import desenha.*;
import figuras.*;
import janelas.*;
import janelaIcone.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author rodrigo & joel
 */
@SuppressWarnings("serial")
class RjDrawGui extends javax.swing.JFrame{
        
        ArrayList<Figura> figuras = FiguresSave.getArrayFiguras();
	
        Color backGroundselectedColor;
	JScrollPane jScrollPane2;
	JList<String> listaFiguras;
	DefaultListModel<String> element;
	janelas.CircCreator circCreator1;
	janelas.RetCreator retCreator1;
	janelas.LineCreator lineCreator1;
	javax.swing.JColorChooser colorSelector;
	javax.swing.JLabel eixos;
	javax.swing.JFileChooser fileOpen;
	javax.swing.JFileChooser fileSaver;
	javax.swing.JMenu arquivo;
	javax.swing.JMenu editar;
	javax.swing.JMenu desenhar;
	javax.swing.JMenu cor;
        
        //NOVO
        janelaIcone.Icone icone;
        javax.swing.JMenu sobre;
	javax.swing.JMenuItem logo;
        //javax.swing.JLabel labeTwoFormations;
        
        
        javax.swing.JMenuBar barraMenus;
	javax.swing.JMenuItem arquivoCarregar;
	javax.swing.JMenuItem editarLimpar;
	javax.swing.JMenuItem editarDesfazer;
	javax.swing.JMenuItem editarCopiar;
	javax.swing.JMenuItem editarColar;
	javax.swing.JMenuItem arquivoSalvar;
	javax.swing.JMenuItem arquivoSair;
	javax.swing.JMenuItem desenharCirculo;
	javax.swing.JMenuItem desenharRetangulo;
	javax.swing.JMenuItem desenharLinha;
	javax.swing.JMenuItem corFundo;
	javax.swing.JMenuItem arquivoSalvarRede;
	javax.swing.JMenuItem corDesenho;
	javax.swing.JPanel painelDesenho;
	javax.swing.JPanel saidaEixos;
	/**
	 * Creates new form RjDrawGui
	 */
	public RjDrawGui() {
		super("RJ Draw");
		initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
		
		element=new DefaultListModel<String>();
		element.addElement("Historico");
		
		listaFiguras = new JList<String>(element);
		listaFiguras.setBackground(Color.LIGHT_GRAY);
		jScrollPane2 = new JScrollPane(listaFiguras);
		fileSaver = new javax.swing.JFileChooser();
		fileOpen = new javax.swing.JFileChooser();
		colorSelector = new javax.swing.JColorChooser();
		circCreator1 = new CircCreator();
		retCreator1 = new RetCreator();
		lineCreator1 = new LineCreator();
		painelDesenho = new PainelDesenho();
		saidaEixos = new javax.swing.JPanel();
		eixos = new javax.swing.JLabel();
		barraMenus = new javax.swing.JMenuBar();
		arquivo = new javax.swing.JMenu();
		arquivoCarregar = new javax.swing.JMenuItem();
		arquivoSalvar = new javax.swing.JMenuItem();
		arquivoSalvarRede = new javax.swing.JMenuItem();
		arquivoSair = new javax.swing.JMenuItem();
		editar = new javax.swing.JMenu();
		editarCopiar = new javax.swing.JMenuItem();
		editarColar = new javax.swing.JMenuItem();
		editarDesfazer = new javax.swing.JMenuItem();
		editarLimpar = new javax.swing.JMenuItem();
		desenhar = new javax.swing.JMenu();
		desenharCirculo = new javax.swing.JMenuItem();
		desenharRetangulo = new javax.swing.JMenuItem();
		desenharLinha = new javax.swing.JMenuItem();
		cor = new javax.swing.JMenu();
		corFundo = new javax.swing.JMenuItem();
		corDesenho = new javax.swing.JMenuItem();
                sobre=new javax.swing.JMenu();
                logo=new javax.swing.JMenuItem();
                icone=new Icone();

		FigCriaAction figCriaAction = new FigCriaAction();

		circCreator1.getFigCria().addActionListener(figCriaAction);
		retCreator1.getFigCria().addActionListener(figCriaAction);
		lineCreator1.getFigCria().addActionListener(figCriaAction);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		painelDesenho.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				painelDesenhoMouseMoved(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				painelDesenho);
		painelDesenho.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 469, Short.MAX_VALUE)
				);

		//jScrollPane2.setViewportView(listaFiguras);

		saidaEixos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		saidaEixos.setFocusable(false);

		eixos.setText("eixos");
		saidaEixos.add(eixos);

		arquivo.setText("File");
		arquivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		arquivoCarregar.setText("Carregar");
		arquivoCarregar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		arquivoCarregar.addActionListener(new java.awt.event.ActionListener() {
                        @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		arquivo.add(arquivoCarregar);

		arquivoSalvar.setText("Salvar");
		arquivoSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		arquivoSalvar.addActionListener(new java.awt.event.ActionListener() {
                        @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		arquivo.add(arquivoSalvar);

		/*arquivoSalvarRede.setText("Salvar no RDrive");
		arquivoSalvarRede
		.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem8ActionPerformed(evt);
			}
		});
		arquivo.add(arquivoSalvarRede);*/

		arquivoSair.setText("Sair");
		arquivoSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		arquivo.add(arquivoSair);

		barraMenus.add(arquivo);

		editar.setText("Edit");

		/*editarCopiar.setText("Copiar");
		editar.add(editarCopiar);

		editarColar.setText("Colar");
		editar.add(editarColar);*/

		editarDesfazer.setText("Desfazer");
		editarDesfazer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		editarDesfazer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				desfazerDesenhoActionPerformed(evt);
			}
		});
		editar.add(editarDesfazer);

		editarLimpar.setText("Limpar desenho");
		editarLimpar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		editarLimpar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				limparDesenhoActionPerformed(evt);
			}
		});
		editar.add(editarLimpar);

		barraMenus.add(editar);

		desenhar.setText("Desenhar");

		desenharCirculo.setText("Circulo");
		desenharCirculo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				desenhaCirculoActionPerformed(evt);
			}
		});
		desenhar.add(desenharCirculo);

		desenharRetangulo.setText("Retangulo");
		desenharRetangulo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				desenhaRetanguloActionPerformed(evt);
			}
		});
		desenhar.add(desenharRetangulo);

		desenharLinha.setText("Linha");
		desenharLinha.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				desenhaRetaActionPerformed(evt);
			}
		});
		desenhar.add(desenharLinha);
		barraMenus.add(desenhar);

		cor.setText("Cor");

		corFundo.setText("Selecionar Cor de Fundo");
		corFundo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem7ActionPerformed(evt);
			}
		});
		cor.add(corFundo);

		/*corDesenho.setText("Selecionar Cor do desenho");
		cor.add(corDesenho);*/

		barraMenus.add(cor);
                
                sobre.setText("Sobre");
                
                //NOVO
                logo.setText("Logo e Desenvolvedores");
                
                logo.addActionListener(new java.awt.event.ActionListener() {
                          public void actionPerformed(java.awt.event.ActionEvent evt){
                              jMenuItem8ActionPerformed(evt);
                          }
                });
               
                
                sobre.add(logo);
                
                barraMenus.add(sobre);
                
		setJMenuBar(barraMenus);
		//listaFiguras.setBackground(Color.GRAY);
		//listaFiguras.setAutoscrolls(true);
		//add(listaFiguras,BorderLayout.EAST);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(saidaEixos, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addComponent(painelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(painelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane2))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(saidaEixos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
				);

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents







	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		int resposta = JOptionPane.showConfirmDialog(null,
				"Deseja salvar antes de sair?");
		if (resposta == JOptionPane.CANCEL_OPTION) {
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		} else if (resposta == JOptionPane.YES_OPTION) {
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			int i = fileSaver.showSaveDialog(this);
			if (i == JFileChooser.APPROVE_OPTION) {
				// Médodo qu salva o worspace]
				try {
					figuresPersist(fileSaver.getSelectedFile().getCanonicalPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(ABORT);

			}
		} else if (resposta == JOptionPane.NO_OPTION) {
			this.dispose();
			System.exit(0);
		} else if (resposta == JOptionPane.CLOSED_OPTION) {
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}

	}

	private void painelDesenhoMouseMoved(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		eixos.setText("Eixo X: " + evt.getX()+ " - Eixo Y: " + evt.getY());
	}
        // ======================Menu Sobre========================//
        private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt){
            icone.mostraGUI();
            icone.setVisible(true);
            
            
        }

	//======================== Menu Arquivo ===================//

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
		// TODO add your handling code here:
		int i = fileOpen.showOpenDialog(this);
		if (i == JFileChooser.APPROVE_OPTION) {
			// médoto para carregar o espaço de trabalho
			try {
				figuras.clear();
				painelDesenho.removeAll();
				painelDesenho.setBackground(Color.WHITE);
				element.removeAllElements();
				listaFiguras.removeAll();
				element.addElement("Historico");
				painelDesenho.updateUI();
				listaFiguras.updateUI();
				getWorkspace(fileOpen.getSelectedFile().getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
		// TODO add your handling code here:
		this.dispose();
		System.exit(0);
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt){// GEN-FIRST:event_jMenuItem2ActionPerformed
		// TODO add your handling code here:
		int i = fileSaver.showSaveDialog(this);
		if (i == JFileChooser.APPROVE_OPTION){
			try {
				figuresPersist(fileSaver.getSelectedFile().getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	//======================== Menu Cor ===================//

	@SuppressWarnings("static-access")
	private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem7ActionPerformed
		// TODO add your handling code here:
		this.setVisible(true);
		backGroundselectedColor = colorSelector.showDialog(null,
				"Escolha uma cor", painelDesenho.getForeground());
		painelDesenho.setBackground(backGroundselectedColor);
		
	}

	//======================== Menu Editar ===================//

	private void limparDesenhoActionPerformed(java.awt.event.ActionEvent evt){
		if(figuras.size()>0){
			//desenhos.clear();
			figuras.clear();
			painelDesenho.removeAll();
			painelDesenho.setBackground(Color.WHITE);
			element.removeAllElements();
			listaFiguras.removeAll();
			element.addElement("Historico");
			painelDesenho.updateUI();
			listaFiguras.updateUI();
		}
		else{
			//desenhos.clear();
			painelDesenho.setBackground(Color.WHITE);
			painelDesenho.updateUI();
		}
	}
	private void desfazerDesenhoActionPerformed(java.awt.event.ActionEvent evt){
            if(getComponents().length>0){
		painelDesenho.remove(getComponent(getComponents().length-1));
                painelDesenho.updateUI();
            }
	}


	//======================== Menu Desenhar ===================//

	private void desenhaCirculoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem4ActionPerformed
		// TODO add your handling code here:
		circCreator1.mostraGUI();
		circCreator1.setVisible(true);

	}// GEN-LAST:event_jMenuItem4ActionPerformed

	private void desenhaRetanguloActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem4ActionPerformed
		// TODO add your handling code here:
		retCreator1.mostraGUI();
		retCreator1.setVisible(true);
	}// GEN-LAST:event_jMenuItem4ActionPerformed

	private void desenhaRetaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem6ActionPerformed
		// TODO add your handling code here:
		lineCreator1.mostraGUI();
		lineCreator1.setVisible(true);
	} 
	private class FigCriaAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == circCreator1.getFigCria()) {
				try {
					Color color = JColorChooser.showDialog(null,
							"Escolha uma cor para o desenho", null);
					Circulo c = new Circulo(Float.parseFloat(circCreator1
							.getRaio().getText()), color,
							Integer.parseInt(circCreator1.getTX().getText()),
							Integer.parseInt(circCreator1.getTY().getText()));
					((PainelDesenho) painelDesenho).paintFig(c);
					figuras.add(c);
					circCreator1.getTX().requestFocus();
					element.addElement("Circulo - ("+c.getP().getX()+","
							+c.getP().getY()+")");
					circCreator1.dispose();
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage(),
							"ERROR", JOptionPane.ERROR_MESSAGE);
					circCreator1.getTX().requestFocus();
				}
			}
			else if (e.getSource() == retCreator1.getFigCria()) {
				try {
					Color color = JColorChooser.showDialog(null,
							"Escolha uma cor para o desenho", null);
					Retangulo r = new Retangulo(Float.parseFloat(retCreator1
							.getAltura().getText()),Float.parseFloat(retCreator1
									.getLargura().getText()), color,
									Integer.parseInt(retCreator1.getTX().getText()),
									Integer.parseInt(retCreator1.getTY().getText()));
					((PainelDesenho) painelDesenho).paintFig(r);
					figuras.add(r);
					retCreator1.getTX().requestFocus();
					element.addElement("Retangulo - ("+r.getP().getX()+","
							+r.getP().getY()+")");
					retCreator1.dispose();
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage(),
							"ERROR", JOptionPane.ERROR_MESSAGE);
					retCreator1.getTX().requestFocus();
				}
			}
			else if (e.getSource() == lineCreator1.getFigCria()) {
				try {
					Color color = JColorChooser.showDialog(null,
							"Escolha uma cor para o desenho", null);
					Reta l = new Reta(Integer.parseInt(lineCreator1
							.getTX().getText()),Integer.parseInt(lineCreator1
									.getTY().getText()),
									Integer.parseInt(lineCreator1.getX2().getText()),
									Integer.parseInt(lineCreator1.getY2().getText()),color);
					((PainelDesenho) painelDesenho).paintFig(l);
					figuras.add(l);
					lineCreator1.getTX().requestFocus();
					element.addElement("Reta - ("+l.getP().getX()+","
							+l.getP().getY()+")");
					lineCreator1.dispose();
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage(),
							"ERROR", JOptionPane.ERROR_MESSAGE);
					lineCreator1.getTX().requestFocus();
				}
			}
			painelDesenho.updateUI();
		}
	}

	public static void main(String args[]) {
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new RjDrawGui().setVisible(true);
			}
		});
	}

	private void figuresPersist(String fileName){
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		
		try {
			if(!fileName.endsWith(".draw")){
				fos = new FileOutputStream(fileName+".draw");
			}
			else
				fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(figuras);
			out.close();
			System.out.println("Object Persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void getWorkspace(String filename){
		
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			FiguresSave.getArrayFiguras().addAll((ArrayList<Figura>) in.readObject());
			figuras=FiguresSave.getArrayFiguras();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		((PainelDesenho) painelDesenho).recuperaDesenhos();
		for(int i=0;i<figuras.size();i++){
			if(figuras.get(i) instanceof Reta){
			element.addElement("Reta - ("+figuras.get(i).getP().getX()+","
					+figuras.get(i).getP().getY()+")");
			}
			else if(figuras.get(i) instanceof Circulo){
				element.addElement("Circulo - ("+figuras.get(i).getP().getX()+","
						+figuras.get(i).getP().getY()+")");
			}
			else if(figuras.get(i) instanceof Retangulo){
				element.addElement("Retangulo - ("+figuras.get(i).getP().getX()+","
						+figuras.get(i).getP().getY()+")");
			}
		}
		painelDesenho.updateUI();
	}
}
