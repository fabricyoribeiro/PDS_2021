package view;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

import util.SpringUtilities;

public class EnderecoPanel extends JPanel {
	private JLabel rua, numero, bairro, cidade, estado, cep, tituloEnderecoL, vazioLabel;
	private JTextField ruaF, numeroF, bairroF, cidadeF, estadoF;
	private JFormattedTextField cepF;
	private JPanel mainPanel;
	private JSeparator separator;
	private ButtonPanel buttonPanel;

	public EnderecoPanel() {
		setLayout(new BorderLayout());
		
		separator = new JSeparator();
		rua = new JLabel("Rua:");
		ruaF = new JTextField();
		numero = new JLabel("Número:");
		numeroF = new JTextField();
		
		numeroF.addKeyListener(new KeyAdapter() {
			  public void keyTyped(KeyEvent e) {
			    char c = e.getKeyChar();
			       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
			    	 Mensagem.exibirMensagem("Este campo aceita somente números");
			        e.consume();  // ignore the event if it's not an alphabet
			    }
			   }
		});
		
		bairro = new JLabel("Bairro:");
		bairroF = new JTextField();
		cidade = new JLabel("Cidade:");
		cidadeF = new JTextField();
		
		cidadeF.addKeyListener(new KeyAdapter() {
			  public void keyTyped(KeyEvent e) {
			    char c = e.getKeyChar();
			       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
				    Mensagem.exibirMensagem("Este campo aceita somente letras");
			        e.consume();  // ignore the event if it's not an alphabet
			    }
			   }
		});
		
		estado = new JLabel("Estado:");
		estadoF = new JTextField();
		
		estadoF.addKeyListener(new KeyAdapter() {
			  public void keyTyped(KeyEvent e) {
			    char c = e.getKeyChar();
			       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
					Mensagem.exibirMensagem("Este campo aceita somente letras");
			        e.consume();  // ignore the event if it's not an alphabet
			    }
			   }
		});
		
		cep = new JLabel("CEP:");
		try {
			cepF = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tituloEnderecoL = new JLabel("ENDEREÇO:");
		vazioLabel = new JLabel("");

		buttonPanel = new ButtonPanel();
		mainPanel = new JPanel(new SpringLayout());
		mainPanel.add(tituloEnderecoL);
		mainPanel.add(vazioLabel);
		mainPanel.add(rua);
		mainPanel.add(ruaF);
		mainPanel.add(numero);
		mainPanel.add(numeroF);
		mainPanel.add(bairro);
		mainPanel.add(bairroF);
		mainPanel.add(cidade);
		mainPanel.add(cidadeF);
		mainPanel.add(estado);
		mainPanel.add(estadoF);
		mainPanel.add(cep);
		mainPanel.add(cepF);
		SpringUtilities.makeCompactGrid(mainPanel,7,2,6,6,6,6);
		add(separator, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		
	}

	public JLabel getRua() {
		return rua;
	}

	public JLabel getNumero() {
		return numero;
	}

	public JLabel getBairro() {
		return bairro;
	}

	public JLabel getCidade() {
		return cidade;
	}

	public JLabel getEstado() {
		return estado;
	}

	public JLabel getCep() {
		return cep;
	}

	public JTextField getRuaF() {
		return ruaF;
	}

	public JTextField getNumeroF() {
		return numeroF;
	}

	public JTextField getBairroF() {
		return bairroF;
	}

	public JTextField getCidadeF() {
		return cidadeF;
	}

	public JTextField getEstadoF() {
		return estadoF;
	}

	public JFormattedTextField getCepF() {
		return cepF;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setNumero(JLabel numero) {
		this.numero = numero;
	}

	public void setNumeroF(JTextField numeroF) {
		this.numeroF = numeroF;
	}

	public JLabel getTituloEnderecoL() {
		return tituloEnderecoL;
	}

	public JLabel getVazioLabel() {
		return vazioLabel;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}

}
