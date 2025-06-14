package br.dev.pedro.tarefas.ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameTarefas {

    // Componentes da interface
    private JLabel labelTitulo, labelDescricao, labelDataInicial, labelPrazo, labelDataConclusao, labelStatus, labelResponsavel;
    private JTextField txtTitulo, txtDescricao, txtDataInicial, txtPrazo, txtDataConclusao;
    private JComboBox<String> cbStatus, cbResponsavel;
    private JButton btnSalvar, btnSair;

    private JFrame tela;
    private Container painel;

    public FrameTarefas() {
        tela = new JFrame();

        tela.setTitle("Cadastro de tarefas");
        tela.setSize(350, 400);
        tela.setLayout(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        painel = tela.getContentPane();

        inicializarComponentes();
        adicionarComponentes();

        tela.setVisible(true);
    }

    private void inicializarComponentes() {
        labelTitulo = new JLabel("Título:");
        labelTitulo.setBounds(10, 10, 100, 20);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(10, 30, 300, 20);

        labelDescricao = new JLabel("Descrição:");
        labelDescricao.setBounds(10, 55, 100, 20);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(10, 75, 300, 20);

        labelDataInicial = new JLabel("Data Inicial:");
        labelDataInicial.setBounds(10, 100, 100, 20);

        txtDataInicial = new JTextField();
        txtDataInicial.setBounds(10, 120, 130, 20);

        labelPrazo = new JLabel("Prazo:");
        labelPrazo.setBounds(150, 100, 100, 20);

        txtPrazo = new JTextField();
        txtPrazo.setBounds(150, 120, 160, 20);

        labelDataConclusao = new JLabel("Data conclusão:");
        labelDataConclusao.setBounds(10, 145, 150, 20);

        txtDataConclusao = new JTextField();
        txtDataConclusao.setBounds(10, 165, 300, 20);

        labelStatus = new JLabel("Status:");
        labelStatus.setBounds(10, 190, 100, 20);

        cbStatus = new JComboBox<>(new String[]{"NÃO INICIADO", "EM ANDAMENTO", "CONCLUÍDO"});
        cbStatus.setBounds(10, 210, 300, 20);

        labelResponsavel = new JLabel("Responsável:");
        labelResponsavel.setBounds(10, 235, 100, 20);

        cbResponsavel = new JComboBox<>();
        cbResponsavel.setBounds(10, 255, 300, 20);
        cbResponsavel.addItem("Nome do funcionário");

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(40, 300, 100, 30);

        btnSair = new JButton("Sair");
        btnSair.setBounds(180, 300, 100, 30);
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