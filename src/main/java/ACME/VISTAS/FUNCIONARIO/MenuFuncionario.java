package ACME.VISTAS.FUNCIONARIO;

import javax.swing.*;
import java.awt.*;

public class MenuFuncionario extends JFrame {
    private JPanel mainPanel;
    private JButton btnFuncionarios;
    private JButton btnReportes;
    private JButton btnConsultas;

    public MenuFuncionario() {
        setTitle("Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Título
        JLabel titleLabel = new JLabel("Menú Principal");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        // Botones
        btnFuncionarios = new JButton("Funcionarios");
        btnReportes = new JButton("Reportes");
        btnConsultas = new JButton("Consultas");

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        mainPanel.add(btnFuncionarios, gbc);

        gbc.gridy = 2;
        mainPanel.add(btnReportes, gbc);

        gbc.gridy = 3;
        mainPanel.add(btnConsultas, gbc);

        // Eventos
        btnFuncionarios.addActionListener(e -> {
            GestionFuncionario funcionarios = new GestionFuncionario();
            funcionarios.setVisible(true);
            this.dispose();
        });

        btnReportes.addActionListener(e -> {
            ReportesFuncionario reportes = new ReportesFuncionario();
            reportes.setVisible(true);
            this.dispose();
        });

        btnConsultas.addActionListener(e -> {
            ReportesFuncionario consultas = new ReportesFuncionario();
            consultas.setVisible(true);
            this.dispose();
        });

        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        MenuFuncionario mf = new MenuFuncionario();

        mf.setVisible(true);
    }
}
