package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

import util.SpringUtilities;

public class BuscarFestaPanel  extends JPanel{
	private JLabel buscarFestaLabel, cpfLabel;
	private JFormattedTextField cpf;
	private JButton buscarFestaButton;
	private JPanel inicioPanel, meioPanel ,fimPanel;
	
	public BuscarFestaPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		buscarFestaLabel = new JLabel("BUSCAR FESTA");
		
		cpfLabel = new JLabel("CPF DO CLIENTE DA FESTA: ");
		try {
			cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			cpf.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		buscarFestaButton = new JButton("Buscar");
		
		inicioPanel = new JPanel();
		inicioPanel.add(buscarFestaLabel);
		
		meioPanel = new JPanel(new SpringLayout());
		meioPanel.add(cpfLabel);
		meioPanel.add(cpf);
		SpringUtilities.makeCompactGrid(meioPanel, 
				2, 1, //linha, coluna
				6, 40, //inicialX, inicialY
				6, 10);//finalX, finalY
		
		fimPanel = new JPanel(new SpringLayout());
		fimPanel.add(buscarFestaButton);
		SpringUtilities.makeCompactGrid(fimPanel, 1, 1,
				55, 95,
				6, 0);
		
		add(inicioPanel, BorderLayout.NORTH);
		add(meioPanel, BorderLayout.CENTER);
		add(fimPanel, BorderLayout.SOUTH);
	}


	public JLabel getBuscarFestaLabel() {
		return buscarFestaLabel;
	}

	public JLabel getCpfLabel() {
		return cpfLabel;
	}

	public JFormattedTextField getCpf() {
		return cpf;
	}

	public JButton getBuscarFestaButton() {
		return buscarFestaButton;
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
