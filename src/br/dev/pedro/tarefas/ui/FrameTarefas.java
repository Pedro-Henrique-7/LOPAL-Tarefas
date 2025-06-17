package br.dev.pedro.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.dev.pedro.tarefas.dao.FuncionarioDAO;
import br.dev.pedro.tarefas.dao.TarefasDAO;
import br.dev.pedro.tarefas.model.Funcionario;
import br.dev.pedro.tarefas.model.Status;
import br.dev.pedro.tarefas.model.Tarefa;

public class FrameTarefas {

	// Componentes da interface
	private JLabel labelTitulo, labelDescricao, labelDataInicial, labelPrazo, labelDataConclusao, labelStatus,
			labelResponsavel;
	private JTextField txtTitulo, txtDescricao, txtDataInicial, txtPrazo, txtDataConclusao;
	private JComboBox<Status> cbStatus;
	private JComboBox<String> cbResponsavel;
	private JButton btnSalvar, btnSair;

	// variavel para armazenar o status
	private Status statusSelecionado;
	private String funcionarioSelecionado;

	private JFrame tela;
	private Container painel;

	public FrameTarefas() {

		inicializarJanela();
		inicializarComponentes();
		adicionarComponentes();
		tela.setVisible(true);
	}

	private void inicializarComponentes() {
		iniciarLabels();
		iniciarCamposTxt();
		inicializarComboBox();
		iniciarBtn();
		configurarEventos();
	}

	private void inicializarJanela() {
		tela = new JFrame();
		tela.setTitle("Cadastro de tarefas");
		tela.setSize(350, 400);
		tela.setLayout(null);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		painel = tela.getContentPane();

	}

	private void iniciarLabels() {
		labelTitulo = new JLabel("Título:");
		labelTitulo.setBounds(10, 10, 100, 20);
		labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 55, 100, 20);
		labelDataInicial = new JLabel("Data Inicial:");
		labelDataInicial.setBounds(10, 100, 100, 20);
		labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(150, 100, 100, 20);
		labelDataConclusao = new JLabel("Data conclusão:");
		labelDataConclusao.setBounds(10, 145, 150, 20);
		labelStatus = new JLabel("Status:");
		labelStatus.setBounds(10, 190, 100, 20);
		labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(10, 235, 100, 20);
	}

	private void iniciarCamposTxt() {
		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 30, 300, 20);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 75, 300, 20);
		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(10, 120, 130, 20);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(150, 120, 160, 20);
		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(10, 165, 300, 20);
	}

	private void inicializarComboBox() {
		cbStatus = new JComboBox<Status>();
		cbStatus.setBounds(10, 210, 300, 20);
		// obter os valores do enum
		Status[] status = Status.values();

		// adicionar valores ao combobox

		for (Status estado : status) {
			cbStatus.addItem(estado);
		}
		statusSelecionado = (Status) cbStatus.getSelectedItem();

		cbResponsavel = new JComboBox<>();
		cbResponsavel.setBounds(10, 255, 300, 20);
		configurarResponsaveis();

	}

	private void iniciarBtn() {

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(40, 300, 100, 30);

		btnSair = new JButton("Sair");
		btnSair.setBounds(180, 300, 100, 30);
	}

	private void configurarResponsaveis() {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();

		String[][] responsaveis = new String[funcionarios.size()][9];
		int i = 0;
		for (Funcionario f : funcionarios) {
			responsaveis[0][0] = f.getNome();
			i++;

			cbResponsavel.addItem(responsaveis[0][0].toString());
		}

		funcionarioSelecionado = (String) cbResponsavel.getSelectedItem();
	}

	private void calcularConclusão() {
		// verificar campos necessarios
		if (txtDataInicial.getText().trim().isEmpty() || txtPrazo.getText().trim().isEmpty()) {
			txtDataConclusao.setText("");
			return;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			// obter data inicial
			Date dataInicial = sdf.parse(txtDataInicial.getText());

			// obter prazo e validar
			int prazo;
			try {
				prazo = Integer.parseInt(txtPrazo.getText());
				if (prazo < 0) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				txtDataConclusao.setText("");
				JOptionPane.showMessageDialog(tela, "O prazo deve ser um número inteiro positivo!", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// calcular data de conclusão
			Calendar cal = Calendar.getInstance();
			cal.setTime(dataInicial);
			cal.add(Calendar.DAY_OF_MONTH, prazo);

			txtDataConclusao.setText(sdf.format(cal.getTime()));

		} catch (java.text.ParseException e) {
			txtDataConclusao.setText("");
			JOptionPane.showMessageDialog(tela, "Digite a data no formato correto (dd/MM/aaaa)!", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void configurarEventos() {

		txtPrazo.getDocument().addDocumentListener(new DocumentListener() {
			//configurando que em todos as alterações no prazo vai ser acionada a função calcularConclusão
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				calcularConclusão();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				calcularConclusão();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				calcularConclusão();

			}
		});

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Validação dos campos obrigatórios
				if (txtTitulo.getText().trim().isEmpty() || txtDescricao.getText().trim().isEmpty()
						|| txtDataInicial.getText().trim().isEmpty() || txtPrazo.getText().trim().isEmpty()
						|| statusSelecionado == null || funcionarioSelecionado == null) {
					JOptionPane.showMessageDialog(tela, "Todos os campos devem ser preenchidos", "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					// salvando conteudo do txt em variaveis
					String titulo = txtTitulo.getText();
					String descricao = txtDescricao.getText();
					String dataInicial = txtDataInicial.getText();
					int prazo = Integer.parseInt(txtPrazo.getText());

					Status status = statusSelecionado;
					String responsavel = funcionarioSelecionado;
					String dataConclusao = txtDataConclusao.getText();

					// criando nova tarefa e definindo parametros
					Tarefa t = new Tarefa(titulo, descricao, dataInicial, prazo, dataConclusao, status.toString(),
							responsavel);

					// gravar tarefa no arquivo
					TarefasDAO dao = new TarefasDAO(t);
					dao.gravar();

					JOptionPane.showMessageDialog(tela, titulo + "\ncadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});

	}

	private void adicionarComponentes() {
		painel.add(labelTitulo);
		painel.add(txtTitulo);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelDataInicial);
		painel.add(txtDataInicial);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataConclusao);
		painel.add(txtDataConclusao);
		painel.add(labelStatus);
		painel.add(cbStatus);
		painel.add(labelResponsavel);
		painel.add(cbResponsavel);
		painel.add(btnSalvar);
		painel.add(btnSair);
	}
}