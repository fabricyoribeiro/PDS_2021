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

public class BuscarClientePanel extends JPanel{
	private JLabel buscarClienteLabel, cpfLabel;
	private JFormattedTextField cpf;
	private JButton buscarClienteButton;
	private JPanel inicioPanel, meioPanel ,fimPanel;
	
	
	
	public BuscarClientePanel() {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		buscarClienteLabel = new JLabel("BUSCAR CLIENTE");
		
		cpfLabel = new JLabel("CPF:");
		try {
			cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			cpf.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		buscarClienteButton = new JButton("Buscar");
		
		inicioPanel = new JPanel();
		inicioPanel.add(buscarClienteLabel);
		
		meioPanel = new JPanel(new SpringLayout());
		meioPanel.add(cpfLabel);
		meioPanel.add(cpf);
		SpringUtilities.makeCompactGrid(meioPanel, 
				1, 2, //linha, coluna
				2, 70, //inicialX, inicialY
				3, 100);//finalX, finalY
		
		fimPanel = new JPanel();
		fimPanel.add(buscarClienteButton);
		
		add(inicioPanel, BorderLayout.NORTH);
		add(meioPanel, BorderLayout.CENTER);
		add(fimPanel, BorderLayout.SOUTH);
		
		
	}

	public JLabel getBuscarClienteLabel() {
		return buscarClienteLabel;
	}

	public JLabel getCpfLabel() {
		return cpfLabel;
	}

	public JFormattedTextField getCpf() {
		return cpf;
	}

	public JButton getBuscarClienteButton() {
		return buscarClienteButton;
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
