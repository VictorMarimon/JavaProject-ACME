package ACME.VISTAS.SUPERVISOR;

import ACME.VISTAS.Login;

import javax.swing.*;
import java.awt.*;

public class MenuSupervisor extends JFrame {
    private JButton btnReportarUsuario;
    private JButton btnReportes;
    private JButton btnGestionarEmpresa;
    private JButton btnGestionarGuardiaSeguridad;
    private JButton btnGestionarFuncionarioEmpresa;
    private JButton btnEstadoTrabajadorInvitado;
    private JButton btnCerrarSesion;

    public MenuSupervisor() {
        setTitle("Menú Supervisor - Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Panel principal con degradado
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(52, 152, 219);
                Color color2 = new Color(41, 128, 185);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel lblTitulo = new JLabel("Menú Supervisor", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblTitulo, gbc);

        // Botones principales
        btnReportarUsuario = createStyledButton("Reportar Usuario");
        btnReportes = createStyledButton("Reportes");
        btnGestionarEmpresa = createStyledButton("Gestionar Empresa");
        btnGestionarGuardiaSeguridad = createStyledButton("Gestionar Guardia de Seguridad");
        btnGestionarFuncionarioEmpresa = createStyledButton("Gestionar Funcionario de Empresa");
        btnEstadoTrabajadorInvitado = createStyledButton("Estado Trabajador/Invitado");
        btnCerrarSesion = createStyledButton("Cerrar Sesión");

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        mainPanel.add(btnReportarUsuario, gbc);

        gbc.gridy = 2;
        mainPanel.add(btnReportes, gbc);

        gbc.gridy = 3;
        mainPanel.add(btnGestionarEmpresa, gbc);

        gbc.gridy = 4;
        mainPanel.add(btnGestionarGuardiaSeguridad, gbc);

        gbc.gridy = 5;
        mainPanel.add(btnGestionarFuncionarioEmpresa, gbc);

        gbc.gridy = 6;
        mainPanel.add(btnEstadoTrabajadorInvitado, gbc);

        gbc.gridy = 7;
        mainPanel.add(btnCerrarSesion, gbc);

        add(mainPanel);

        btnCerrarSesion.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea cerrar sesión?",
                "Confirmar Cierre de Sesión",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });

        btnEstadoTrabajadorInvitado.addActionListener(e -> {
                EstadoSupervisor estadoSupervisor = new EstadoSupervisor();
                estadoSupervisor.setVisible(true);
                dispose();
        });
        
        btnReportarUsuario.addActionListener(e -> {
                ReporteSupervisor reporteSupervisor = new ReporteSupervisor();
                reporteSupervisor.setVisible(true);
                dispose();
        });
        
        btnReportes.addActionListener(e -> {
                ReportesSupervisor verReporteSupervisor = new ReportesSupervisor();
                verReporteSupervisor.setVisible(true);
                dispose();
        });
        
        btnGestionarEmpresa.addActionListener(e -> {
                GestionarEmpresa geationarEmpresa = new GestionarEmpresa();
                geationarEmpresa.setVisible(true);
                dispose();
        });
        
        btnGestionarFuncionarioEmpresa.addActionListener(e -> {
                GestionFuncionario geationarFuncionario = new GestionFuncionario();
                geationarFuncionario.setVisible(true);
                dispose();
        });
        
        btnEstadoTrabajadorInvitado.addActionListener(e -> {
                EstadoSupervisor estadoSupervisor = new EstadoSupervisor();
                estadoSupervisor.setVisible(true);
                dispose();
        });
        
        btnGestionarGuardiaSeguridad.addActionListener(e -> {
                GestionGuarda gestionarGuardia = new GestionGuarda();
                gestionarGuardia.setVisible(true);
                dispose();
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(300, 40));
        button.setBackground(new Color(46, 204, 113));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuSupervisor().setVisible(true));
    }
}
