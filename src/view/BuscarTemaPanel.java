package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

import util.SpringUtilities;

public class BuscarTemaPanel extends JPanel{
	
	private JLabel buscarTemaLabel, nomeTemaL;
	private JTextField nomeTemaT;
	private JButton buscarTemaButton;
	private JPanel inicioPanel, meioPanel ,fimPanel;
	
	
	
	public BuscarTemaPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		buscarTemaLabel = new JLabel("BUSCAR TEMA");
		
		nomeTemaL = new JLabel("Nome do Tema:");
		nomeTemaT = new JTextField(10);
		
		buscarTemaButton = new JButton("Buscar");
		
		inicioPanel = new JPanel();
		inicioPanel.add(buscarTemaLabel);
		
		meioPanel = new JPanel(new SpringLayout());
		meioPanel.add(nomeTemaL);
		meioPanel.add(nomeTemaT);
		SpringUtilities.makeCompactGrid(meioPanel, 
				1, 2, //linha, coluna
				2, 70, //inicialX, inicialY
				3, 100);//finalX, finalY
		
		fimPanel = new JPanel();
		fimPanel.add(buscarTemaButton);
		
		add(inicioPanel, BorderLayout.NORTH);
		add(meioPanel, BorderLayout.CENTER);
		add(fimPanel, BorderLayout.SOUTH);
		
	}



	public JLabel getBuscarTemaLabel() {
		return buscarTemaLabel;
	}



	public JLabel getNomeTemaL() {
		return nomeTemaL;
	}



	public JTextField getNomeTemaT() {
		return nomeTemaT;
	}



	public JButton getBuscarTemaButton() {
		return buscarTemaButton;
	}



	public JPanel getInicioPanel() {
		return inicioPanel;
	}



	public JPanel getMeioPanel() {
		return meioPanel;
	}



	public JPanel getFimPanel() {
		return fimPanel;
	}
	

}
