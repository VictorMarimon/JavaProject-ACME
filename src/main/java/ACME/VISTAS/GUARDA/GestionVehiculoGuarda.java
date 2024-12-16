package ACME.VISTAS.GUARDA;

import ACME.CONTROLADOR.ControladorTipoVehiculo;
import ACME.CONTROLADOR.ControladorVehiculo;
import ACME.MODELO.DAO.TIPO_VEHICULO.Tipo_Vehiculo;
import ACME.MODELO.DAO.VEHICULO.Vehiculo;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class GestionVehiculoGuarda extends JFrame {
    private JTextField txtPlaca, txtCilindraje, txtModelo, txtColor, txtMotor, txtMarca;
    private JComboBox<String> comboTipo;
    private JButton btnConsultar, btnAgregar, btnCancelar;

    public GestionVehiculoGuarda() {
        setTitle("Vehículo");
        setSize(600, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblPlaca = new JLabel("Placa");
        lblPlaca.setBounds(50, 50, 100, 20);
        add(lblPlaca);
        txtPlaca = new JTextField();
        txtPlaca.setBounds(120, 50, 150, 20);
        add(txtPlaca);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(280, 50, 100, 20);
        add(btnConsultar);

        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(50, 90, 100, 20);
        add(lblTipo);
        comboTipo = new JComboBox<>();

        ControladorTipoVehiculo ctv = new ControladorTipoVehiculo();

        List<String> vehiculos = ctv.listadoVehiculos();

        for (String vehiculo : vehiculos){
            comboTipo.addItem(vehiculo);
        }
        comboTipo.setBounds(120, 90, 150, 20);
        add(comboTipo);

        JLabel lblCilindraje = new JLabel("Cilindraje");
        lblCilindraje.setBounds(320, 90, 100, 20);
        add(lblCilindraje);
        txtCilindraje = new JTextField();
        txtCilindraje.setBounds(400, 90, 150, 20);
        add(txtCilindraje);

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setBounds(50, 130, 100, 20);
        add(lblModelo);
        txtModelo = new JTextField();
        txtModelo.setBounds(120, 130, 150, 20);
        add(txtModelo);

        JLabel lblColor = new JLabel("Color");
        lblColor.setBounds(320, 130, 100, 20);
        add(lblColor);
        txtColor = new JTextField();
        txtColor.setBounds(400, 130, 150, 20);
        add(txtColor);

        JLabel lblMotor = new JLabel("Motor");
        lblMotor.setBounds(50, 170, 100, 20);
        add(lblMotor);
        txtMotor = new JTextField();
        txtMotor.setBounds(120, 170, 150, 20);
        add(txtMotor);

        JLabel lblMarca = new JLabel("Marca");
        lblMarca.setBounds(320, 170, 100, 20);
        add(lblMarca);
        txtMarca = new JTextField();
        txtMarca.setBounds(400, 170, 150, 20);
        add(txtMarca);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(50, 230, 100, 30);
        add(btnCancelar);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(450, 230, 100, 30);
        add(btnAgregar);

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Regresando al Menú Principal...");
                dispose();
            }
        });

        btnAgregar.addActionListener(e->{

            ControladorVehiculo cv = new ControladorVehiculo();

            Tipo_Vehiculo tv = new Tipo_Vehiculo();
            Vehiculo vh = new Vehiculo();

            tv.setTipo((String) comboTipo.getSelectedItem());

            vh.setPlaca(txtPlaca.getText());
            vh.setModelo(txtModelo.getText());
            vh.setMotor(txtMotor.getText());
            vh.setMarca(txtMarca.getText());
            vh.setCilindraje(txtCilindraje.getText());
            vh.setColor(txtColor.getText());

            if (cv.nuevoVehiculo(vh, tv)){
                JOptionPane.showMessageDialog(this, "Vehiculo registrado exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(this, "La placa ya existe o faltan campos por llenar.", "No agregado", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnConsultar.addActionListener(e-> {
            ControladorVehiculo cv = new ControladorVehiculo();

            Vehiculo vh = new Vehiculo();

            vh.setPlaca(txtPlaca.getText());

            if (cv.confirmar(vh)){
                JOptionPane.showMessageDialog(this, "Vehiculo SI existe.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this, "El vehiculo NO existe.", "No existe", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setVisible(true);
    }

    private void limpiarCampos() {
        txtPlaca.setText("");
        txtCilindraje.setText("");
        txtModelo.setText("");
        txtColor.setText("");
        txtMotor.setText("");
        txtMarca.setText("");
        comboTipo.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        GestionVehiculoGuarda gv = new GestionVehiculoGuarda();
        gv.setVisible(true);
    }
}
