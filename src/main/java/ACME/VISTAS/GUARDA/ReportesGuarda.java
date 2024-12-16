package ACME.VISTAS.GUARDA;

import ACME.CONTROLADOR.ControladorPersona;
import ACME.VISTAS.SUPERVISOR.MenuSupervisor;

import javax.swing.*;
import java.awt.*;

public class ReportesGuarda extends JFrame {
    private JTextField txtIdentificarUsuario;
    private JButton btnConsultar;
    private JTable tblReportes;
    private JButton btnRegresar;

    public ReportesGuarda() {
        setTitle("Reportes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);  // Aumenté el tamaño de la ventana
        setLocationRelativeTo(null);

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

        JLabel lblTitulo = new JLabel("Ver Reportes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblTitulo, gbc);

        JLabel lblIdentificarUsuario = new JLabel("Identificar Usuario:");
        lblIdentificarUsuario.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(lblIdentificarUsuario, gbc);

        txtIdentificarUsuario = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(txtIdentificarUsuario, gbc);

        btnConsultar = createStyledButton("Consultar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(btnConsultar, gbc);

        String[] columnNames = {"Nombre", "Apellido", "Teléfono", "Email", "Género", "Estado",
                                "Cargo", "Tipo Empresa", "Estado Empresa", "Fecha Entrada", 
                                "Hora Entrada", "Hora Salida", "Anotaciones", "Vehículo"};

        ControladorPersona cp = new ControladorPersona();

        Object[][] data = cp.reportes();

        tblReportes = new JTable(data, columnNames);
        tblReportes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(tblReportes);
        
        scrollPane.setPreferredSize(new Dimension(850, 400));

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(scrollPane, gbc);

        btnRegresar = createStyledButton("Regresar");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(btnRegresar, gbc);

        add(mainPanel);

        btnRegresar.addActionListener(e -> {
            MenuGuarda mg = new MenuGuarda();
            mg.setVisible(true);
            dispose();
        });

        btnConsultar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Consulta realizada con éxito.");
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
        SwingUtilities.invokeLater(() -> new ReportesGuarda().setVisible(true));
    }
}
