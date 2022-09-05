package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

import util.SpringUtilities;

public class ClientePanel extends JPanel {
	private JLabel cadastroL, nomeL, cpfL, enderecoL, emailL, telefoneL, rgLabel, descontoLabel;
	private JTextField nome, email, descontoField;
	private JPanel logoPanel,mainPanel,buttonPanel;
	private JFormattedTextField telefoneF, cpf, rgField;
	private JButton cadastrarButton,enderecoButton;
	private EnderecoPanel enderecoPanel;

	public ClientePanel() {
		setLayout(new BorderLayout());
		setBackground(Color.white);

		cadastroL = new JLabel("CADASTRAR CLIENTE");
		nomeL = new JLabel("Nome: ");
		nome = new JTextField();
		
		nome.addKeyListener(new KeyAdapter() {
			  public void keyTyped(KeyEvent e) {
			    char c = e.getKeyChar();
			       if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
					Mensagem.exibirMensagem("Este campo aceita somente letras");
			        e.consume();  // ignore the event if it's not an alphabet
			    }
			   }
		});

		cpfL = new JLabel("CPF: ");
		try {
			cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			cpf.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		rgLabel = new JLabel("RG: ");
		try {
			rgField = new JFormattedTextField(new MaskFormatter("##.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		emailL = new JLabel("Email: ");
		email = new JTextField();

		telefoneL = new JLabel("Telefone: ");
		
		descontoLabel = new JLabel("Possui desconto: ");
		descontoField = new JTextField();
		
		try {
			telefoneF = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
			telefoneF.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		logoPanel = new JPanel();
		logoPanel.add(cadastroL);
		//Panel Building
		
		mainPanel= new JPanel(new SpringLayout());
		mainPanel.add(nomeL);
		mainPanel.add(nome);
		mainPanel.add(cpfL);
		mainPanel.add(cpf);
		mainPanel.add(rgLabel);
		mainPanel.add(rgField);		
		mainPanel.add(emailL);
		mainPanel.add(email);
		mainPanel.add(telefoneL);
		mainPanel.add(telefoneF);
		
		mainPanel.add(descontoLabel);
		mainPanel.add(descontoField);
		
		//descontoField.setEnabled(false);
		descontoLabel.setVisible(false);
		descontoField.setVisible(false);
		
		SpringUtilities.makeCompactGrid(mainPanel,6,2,4,4,4,4);
		
		buttonPanel = new JPanel();
		cadastrarButton = new JButton("Cadastrar");
		buttonPanel.add(cadastrarButton);
		enderecoPanel = new EnderecoPanel();
		add(logoPanel,BorderLayout.NORTH);
		add(mainPanel,BorderLayout.CENTER);
		add(enderecoPanel, BorderLayout.SOUTH);
		//add(buttonPanel,BorderLayout.SOUTH);
		

	}

	public JLabel getDescontoLabel() {
		return descontoLabel;
	}

	public void setDescontoLabel(JLabel descontoLabel) {
		this.descontoLabel = descontoLabel;
	}

	public JTextField getDescontoField() {
		return descontoField;
	}

	public void setDescontoField(JTextField descontoField) {
		this.descontoField = descontoField;
	}

	public JLabel getCadastroL() {
		return cadastroL;
	}

	public JLabel getNomeL() {
		return nomeL;
	}

	public JLabel getCpfL() {
		return cpfL;
	}

	public JLabel getEnderecoL() {
		return enderecoL;
	}

	public JLabel getEmailL() {
		return emailL;
	}

	public JLabel getTelefoneL() {
		return telefoneL;
	}

	public JTextField getNome() {
		return nome;
	}

	public JLabel getRgLabel() {
		return rgLabel;
	}

	public void setRgLabel(JLabel rgLabel) {
		this.rgLabel = rgLabel;
	}

	public JFormattedTextField getRgField() {
		return rgField;
	}

	public void setRgField(JFormattedTextField rgField) {
		this.rgField = rgField;
	}

	public JTextField getEmail() {
		return email;
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

	public JFormattedTextField getTelefoneF() {
		return telefoneF;
	}

	public JFormattedTextField getCpf() {
		return cpf;
	}

	public JButton getCadastrarButton() {
		return cadastrarButton;
	}

	public JButton getEnderecoButton() {
		return enderecoButton;
	}

	public void setCadastroL(JLabel cadastroL) {
		this.cadastroL = cadastroL;
	}

	public void setNomeL(JLabel nomeL) {
		this.nomeL = nomeL;
	}

	public void setCpfL(JLabel cpfL) {
		this.cpfL = cpfL;
	}

	public void setEnderecoL(JLabel enderecoL) {
		this.enderecoL = enderecoL;
	}

	public void setEmailL(JLabel emailL) {
		this.emailL = emailL;
	}

	public void setTelefoneL(JLabel telefoneL) {
		this.telefoneL = telefoneL;
	}

	public void setNome(JTextField nome) {
		this.nome = nome;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public void setLogoPanel(JPanel logoPanel) {
		this.logoPanel = logoPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public void setTelefoneF(JFormattedTextField telefoneF) {
		this.telefoneF = telefoneF;
	}

	public void setCpf(JFormattedTextField cpf) {
		this.cpf = cpf;
	}

	public void setCadastrarButton(JButton cadastrarButton) {
		this.cadastrarButton = cadastrarButton;
	}

	public void setEnderecoButton(JButton enderecoButton) {
		this.enderecoButton = enderecoButton;
	}

	public EnderecoPanel getEnderecoPanel() {
		return enderecoPanel;
	}

	public void setEnderecoPanel(EnderecoPanel enderecoPanel) {
		this.enderecoPanel = enderecoPanel;
	}
	
	
}
