package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

import model.BaseDeDados;
import model.Tema;
import util.SpringUtilities;

public class FestaPanel extends JPanel{
	
	private JLabel cadastroL, clienteL, enderecoL, temaL, dataFestaL, horaInicioL, horaFimL, valorEntradaL;
	private JTextField horaInicioT, horaFimT, valorEntradaT;
	private JPanel logoPanel,mainPanel,buttonPanel;
	private JFormattedTextField dataFestaF, clienteT;
	private JButton cadastrarButton;
	private EnderecoPanel enderecoPanel;
	private JComboBox temaT;
	private Vector temas;

	public FestaPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.white);

		cadastroL = new JLabel("CADASTRAR FESTA");
		clienteL = new JLabel("CPF Cliente: ");
		
		try {
			clienteT = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			clienteT.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		temaL = new JLabel("Tema: ");
		temas = new Vector();
		temas.addAll(BaseDeDados.getTemas());
		
		temaT = new JComboBox(temas);

		dataFestaL = new JLabel("Data da festa: ");
		try {
			dataFestaF = new JFormattedTextField(new MaskFormatter("##/##/####"));
			dataFestaF.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		horaInicioL = new JLabel("Horário de inicio: ");
		horaInicioT = new JTextField();
		
		horaFimL = new JLabel("Horário do fim: ");
		horaFimT = new JTextField();
		
		valorEntradaL = new JLabel("Valor de entrada: ");
		valorEntradaT = new JTextField();
		valorEntradaT.addKeyListener(new KeyAdapter() {
			  public void keyTyped(KeyEvent e) {
			    char c = e.getKeyChar();
			       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
			    	 Mensagem.exibirMensagem("Este campo aceita somente números");
			        e.consume();  // ignore the event if it's not an alphabet
			    }
			   }
		});
	
		logoPanel = new JPanel();
		logoPanel.add(cadastroL);
		
		mainPanel= new JPanel(new SpringLayout());
		mainPanel.add(clienteL);
		mainPanel.add(clienteT);
		mainPanel.add(temaL);
		mainPanel.add(temaT);
		mainPanel.add(dataFestaL);
		mainPanel.add(dataFestaF);		
		mainPanel.add(horaInicioL);
		mainPanel.add(horaInicioT);
		mainPanel.add(horaFimL);
		mainPanel.add(horaFimT);
		mainPanel.add(valorEntradaL);
		mainPanel.add(valorEntradaT);
		
		SpringUtilities.makeCompactGrid(mainPanel,6,2,4,4,4,4);
		
		buttonPanel = new JPanel();
		cadastrarButton = new JButton("Cadastrar");
		buttonPanel.add(cadastrarButton);
		enderecoPanel = new EnderecoPanel();
		add(logoPanel,BorderLayout.NORTH);
		add(mainPanel,BorderLayout.CENTER);
		add(enderecoPanel, BorderLayout.SOUTH);
		
	}


	public JLabel getCadastroL() {
		return cadastroL;
	}

	public JLabel getClienteL() {
		return clienteL;
	}

	public JLabel getEnderecoL() {
		return enderecoL;
	}

	public JLabel getTemaL() {
		return temaL;
	}

	public JLabel getDataFestaL() {
		return dataFestaL;
	}

	public JLabel getHoraInicioL() {
		return horaInicioL;
	}

	public JLabel getHoraFimL() {
		return horaFimL;
	}

	public JLabel getValorEntradaL() {
		return valorEntradaL;
	}

	public JComboBox getTemaT() {
		return temaT;
	}

	public JTextField getHoraInicioT() {
		return horaInicioT;
	}

	public JTextField getHoraFimT() {
		return horaFimT;
	}

	public JTextField getValorEntradaT() {
		return valorEntradaT;
	}

	public JPanel getLogoPanel() {
		return logoPanel;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public Vector getTemas() {
		return temas;
	}


	public JFormattedTextField getDataFestaF() {
		return dataFestaF;
	}

	public JFormattedTextField getClienteT() {
		return clienteT;
	}

	public JButton getCadastrarButton() {
		return cadastrarButton;
	}

	public EnderecoPanel getEnderecoPanel() {
		return enderecoPanel;
	}
		

}
