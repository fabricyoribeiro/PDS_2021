package view;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
	import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
	import javax.swing.KeyStroke;
import javax.swing.SpringLayout;

import util.SpringUtilities;

	public class TelaMenu extends JFrame {

		JMenuBar menuBar;
		JMenu cadastrarMenu, buscarMenu, atualizarMenu;
		JMenuItem clienteMenuItemCadastrar, clienteMenuItemAtualizar, FestaMenuItemCadastrar, FestaMenuItemBuscar, FestaMenuItemAtualizar,
		exitMenuItemCadastrar, exitMenuItemBuscar, exitMenuItemAtualizar, sairMenuItem, clienteMenuItemBuscar, temaMenuItem, temaMenuitemBuscar;
		ClientePanel formularioCliente;
		JPanel telaPricipalPanel, panelGeral;
		BuscarClientePanel formularioBuscarCliente;
		JScrollPane scrollPane;
		FestaPanel festaPanel;
		BuscarTemaPanel buscarTemaPanel;
		
		BuscarFestaPanel buscarFestaPanel;
		
		TemaPanel temaPanel;
		
		public TelaMenu() {
			super("Sistema");
			setSize(300, 330);
			setLayout(new BorderLayout());
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			
			menuBar = new JMenuBar();

			cadastrarMenu = new JMenu("Cadastrar");
			cadastrarMenu.setMnemonic(KeyEvent.VK_C);
			
			buscarMenu = new JMenu("Buscar");
			buscarMenu.setMnemonic(KeyEvent.VK_B);
			

			sairMenuItem = new JMenuItem("Sair");
			sairMenuItem.setMnemonic(KeyEvent.VK_S);
			
			temaMenuitemBuscar = new JMenuItem("Tema de festa");
			temaMenuitemBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
			
			temaMenuItem = new JMenuItem("Tema de festa");
			temaMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));

			clienteMenuItemCadastrar = new JMenuItem("Cliente");
			clienteMenuItemCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
			
			clienteMenuItemBuscar = new JMenuItem("Cliente");
			clienteMenuItemBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
			
			
			FestaMenuItemCadastrar = new JMenuItem("Festa");
			FestaMenuItemCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
			
			FestaMenuItemBuscar = new JMenuItem("Festa");
			FestaMenuItemBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
			
			exitMenuItemCadastrar = new JMenuItem("Exit");
			exitMenuItemCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
			
			exitMenuItemBuscar = new JMenuItem("Exit");
			exitMenuItemBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
			
			
			menuBar.add(cadastrarMenu);
			menuBar.add(buscarMenu);
			cadastrarMenu.add(clienteMenuItemCadastrar);
			menuBar.add(sairMenuItem);

			cadastrarMenu.add(FestaMenuItemCadastrar);
			cadastrarMenu.add(temaMenuItem);
			cadastrarMenu.add(new JSeparator());
			cadastrarMenu.add(exitMenuItemCadastrar);
			
			buscarMenu.add(clienteMenuItemBuscar);
			buscarMenu.add(FestaMenuItemBuscar);
			buscarMenu.add(temaMenuitemBuscar);
			buscarMenu.add(new JSeparator());
			buscarMenu.add(exitMenuItemBuscar);
			
			
			add(menuBar, BorderLayout.NORTH);

			panelGeral = new JPanel();
			
			telaPricipalPanel = new JPanel();
			formularioCliente = new ClientePanel();
			telaPricipalPanel.setLayout(new BorderLayout());
			festaPanel = new FestaPanel();
			festaPanel.setVisible(false);
						
			telaPricipalPanel.add(formularioCliente, BorderLayout.NORTH);
			formularioCliente.setVisible(false);
			
			temaPanel = new TemaPanel();
			temaPanel.setVisible(false);
			
			formularioBuscarCliente = new BuscarClientePanel();
			formularioBuscarCliente.setVisible(false);
			
			buscarTemaPanel = new BuscarTemaPanel();
			buscarTemaPanel.setVisible(false);
			
			buscarFestaPanel = new BuscarFestaPanel();
			buscarFestaPanel.setVisible(false);
			
			panelGeral.add(telaPricipalPanel);
			panelGeral.add(formularioBuscarCliente);
			panelGeral.add(festaPanel);
			panelGeral.add(temaPanel);
			panelGeral.add(buscarTemaPanel);
			
			panelGeral.add(buscarFestaPanel);
			
			scrollPane = new JScrollPane(panelGeral, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

			add(scrollPane, BorderLayout.CENTER);
			
			setVisible(true);
		}

		public JMenuItem getTemaMenuItem() {
			return temaMenuItem;
		}

		public void atualizarTelaRapido() {
			repaint();
			validate();
			invalidate();
		}

		public void atualizarTela(JPanel painel) {
			if (telaPricipalPanel != null) {
				getContentPane().remove(telaPricipalPanel);
			}
			telaPricipalPanel = painel;
			getContentPane().add(telaPricipalPanel);
			atualizarTelaRapido();
		}


		public void setMenuBar(JMenuBar menuBar) {
			this.menuBar = menuBar;
		}

		public JMenu getCadastrarMenu() {
			return cadastrarMenu;
		}

		public void setCadastrarMenu(JMenu cadastrarMenu) {
			this.cadastrarMenu = cadastrarMenu;
		}

		public JMenuItem getSairMenuItem() {
			return sairMenuItem;
		}

		public void setSairMenuItem(JMenuItem sairMenuItem) {
			this.sairMenuItem = sairMenuItem;
		}

		public JPanel getTelaPricipalPanel() {
			return telaPricipalPanel;
		}

		public void setTelaPricipalPanel(JPanel telaPricipalPanel) {
			this.telaPricipalPanel = telaPricipalPanel;
		}

		public JMenu getBuscarMenu() {
			return buscarMenu;
		}

		public JMenu getAtualizarMenu() {
			return atualizarMenu;
		}

		public JMenuItem getClienteMenuItemCadastrar() {
			return clienteMenuItemCadastrar;
		}

		public JMenuItem getClienteMenuItemAtualizar() {
			return clienteMenuItemAtualizar;
		}

		public JMenuItem getFestaMenuItemCadastrar() {
			return FestaMenuItemCadastrar;
		}

		public JMenuItem getFestaMenuItemBuscar() {
			return FestaMenuItemBuscar;
		}

		public JMenuItem getFestaMenuItemAtualizar() {
			return FestaMenuItemAtualizar;
		}

		public JMenuItem getExitMenuItemCadastrar() {
			return exitMenuItemCadastrar;
		}

		public JMenuItem getExitMenuItemBuscar() {
			return exitMenuItemBuscar;
		}

		public JMenuItem getExitMenuItemAtualizar() {
			return exitMenuItemAtualizar;
		}

		public JMenuItem getClienteMenuItemBuscar() {
			return clienteMenuItemBuscar;
		}

		public ClientePanel getFormularioCliente() {
			return formularioCliente;
		}

		public TemaPanel getTemaPanel() {
			return temaPanel;
		}

		public BuscarClientePanel getFormularioBuscarCliente() {
			return formularioBuscarCliente;
		}

		public JPanel getPanelGeral() {
			return panelGeral;
		}

		public JScrollPane getScrollPane() {
			return scrollPane;
		}

		public FestaPanel getFestaPanel() {
			return festaPanel;
		}

		public JMenuItem getTemaMenuitemBuscar() {
			return temaMenuitemBuscar;
		}

		public BuscarTemaPanel getBuscarTemaPanel() {
			return buscarTemaPanel;
		}

		public BuscarFestaPanel getBuscarFestaPanel() {
			return buscarFestaPanel;
		}

	}


