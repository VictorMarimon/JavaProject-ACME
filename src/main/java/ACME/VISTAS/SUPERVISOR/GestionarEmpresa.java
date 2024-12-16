/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACME.VISTAS.SUPERVISOR;

import ACME.CONTROLADOR.ControladorCiudad;
import ACME.CONTROLADOR.ControladorDireccion;
import ACME.CONTROLADOR.ControladorEmpresa;
import ACME.CONTROLADOR.ControladorEstadoEmpresa;
import ACME.MODELO.DAO.CIUDAD.Ciudad;
import ACME.MODELO.DAO.DIRECCION.Direccion;
import ACME.MODELO.DAO.EMPRESA.Empresa;
import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_Empresa;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class GestionarEmpresa extends JFrame {
    private JTextField txtNit, txtNombreEmpresa, txtRazonSocial, txtCorreo, txtTelefono, txtCiudad, 
                       txtCalle, txtCarrera, txtTransversal, txtDiagonal, txtNumero;
    private JComboBox<String> cmbEstado, cmbCiudad;
    private JDateChooser dateFechaAsociacion;
    private JButton btnAgregar, btnCancelar;

    public GestionarEmpresa() {
        setTitle("Formulario de Empresa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);  // Tamaño de la ventana
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

        JLabel lblTitulo = new JLabel("Formulario Empresa", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblTitulo, gbc);

        JLabel lblNit = new JLabel("NIT:");
        lblNit.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(lblNit, gbc);

        txtNit = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(txtNit, gbc);

        JLabel lblNombreEmpresa = new JLabel("Nombre de la Empresa:");
        lblNombreEmpresa.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lblNombreEmpresa, gbc);

        txtNombreEmpresa = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(txtNombreEmpresa, gbc);

        JLabel lblRazonSocial = new JLabel("Razón Social:");
        lblRazonSocial.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(lblRazonSocial, gbc);

        txtRazonSocial = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(txtRazonSocial, gbc);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(lblEstado, gbc);

        cmbEstado = new JComboBox<>();

        ControladorEstadoEmpresa cee = new ControladorEstadoEmpresa();

        List<String> estados = cee.listado();

        for (String estado : estados){
            cmbEstado.addItem(estado);
        }
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(cmbEstado, gbc);

        JLabel lblFechaAsociacion = new JLabel("Fecha de Asociación:");
        lblFechaAsociacion.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(lblFechaAsociacion, gbc);

        dateFechaAsociacion = new JDateChooser();
        dateFechaAsociacion.setDateFormatString("yyyy-MM-dd");
        gbc.gridx = 1;
        gbc.gridy = 5;
        mainPanel.add(dateFechaAsociacion, gbc);

        JLabel lblCorreo = new JLabel("Correo Electrónico:");
        lblCorreo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(lblCorreo, gbc);

        txtCorreo = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 6;
        mainPanel.add(txtCorreo, gbc);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(lblTelefono, gbc);

        txtTelefono = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 7;
        mainPanel.add(txtTelefono, gbc);

        JLabel lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(lblCiudad, gbc);

        cmbCiudad = new JComboBox<>();

        ControladorCiudad cc = new ControladorCiudad();

        List<String> ciudades = cc.listado();

        for (String ciudad : ciudades){
            cmbCiudad.addItem(ciudad);
        }
        gbc.gridx = 1;
        gbc.gridy = 8;
        mainPanel.add(cmbCiudad, gbc);

        JLabel lblCalle = new JLabel("Calle:");
        lblCalle.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 9;
        mainPanel.add(lblCalle, gbc);

        txtCalle = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 9;
        mainPanel.add(txtCalle, gbc);

        JLabel lblCarrera = new JLabel("Carrera:");
        lblCarrera.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 10;
        mainPanel.add(lblCarrera, gbc);

        txtCarrera = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 10;
        mainPanel.add(txtCarrera, gbc);

        JLabel lblTransversal = new JLabel("Transversal:");
        lblTransversal.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 11;
        mainPanel.add(lblTransversal, gbc);

        txtTransversal = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 11;
        mainPanel.add(txtTransversal, gbc);

        JLabel lblDiagonal = new JLabel("Diagonal:");
        lblDiagonal.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 12;
        mainPanel.add(lblDiagonal, gbc);

        txtDiagonal = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 12;
        mainPanel.add(txtDiagonal, gbc);

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 13;
        mainPanel.add(lblNumero, gbc);

        txtNumero = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 13;
        mainPanel.add(txtNumero, gbc);

        btnAgregar = createStyledButton("Agregar");
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 1;
        mainPanel.add(btnAgregar, gbc);

        btnCancelar = createStyledButton("Cancelar");
        gbc.gridx = 1;
        gbc.gridy = 14;
        gbc.gridwidth = 1;
        mainPanel.add(btnCancelar, gbc);

        add(mainPanel);

        btnCancelar.addActionListener(e -> {
            MenuSupervisor menuSupervisor = new MenuSupervisor();
            menuSupervisor.setVisible(true);
            dispose();
        });

        btnAgregar.addActionListener(e -> {

            ControladorDireccion cd = new ControladorDireccion();
            ControladorEmpresa ce = new ControladorEmpresa();

            Direccion d = new Direccion();
            Ciudad c = new Ciudad();
            Empresa emp = new Empresa();
            Estado_Empresa eEmp = new Estado_Empresa();

            d.setNumero(txtNumero.getText());
            d.setCarrera(txtCarrera.getText());
            d.setDiagonal(txtDiagonal.getText());
            d.setCalle(txtCalle.getText());
            d.setTransversal(txtTransversal.getText());

            c.setNombre_ciudad((String) cmbCiudad.getSelectedItem());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            emp.setFecha_asociacion(sdf.format(dateFechaAsociacion.getDate()));
            emp.setEmpresa(txtNombreEmpresa.getText());
            emp.setRazon_social(txtRazonSocial.getText());
            emp.setTelefono(txtTelefono.getText());
            emp.setNit(Integer.parseInt(txtNit.getText()));
            emp.setEmail(txtCorreo.getText());

            eEmp.setEstado((String) cmbEstado.getSelectedItem());

            if (cd.agregarDireccion(d, c) && ce.nuevaEmpresa(emp, eEmp,d)){
                JOptionPane.showMessageDialog(this, "Empresa agregada con éxito.");

                txtNit.setText("");
                txtNombreEmpresa.setText("");
                txtRazonSocial.setText("");
                txtCorreo.setText("");
                txtTelefono.setText("");
                txtCiudad.setText("");
                txtCalle.setText("");
                txtCarrera.setText("");
                txtTransversal.setText("");
                txtDiagonal.setText("");
                txtNumero.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Falta llenar campos o la empresa ya existe.");
            }
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
}

