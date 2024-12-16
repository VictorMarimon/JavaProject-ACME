package ACME.VISTAS.FUNCIONARIO;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

import ACME.CONTROLADOR.ControladorCiudad;
import ACME.CONTROLADOR.ControladorDireccion;
import ACME.CONTROLADOR.ControladorEmpleado;
import ACME.CONTROLADOR.ControladorPersona;
import ACME.MODELO.CREDENCIALES.GESTION.CredencialesException;
import ACME.MODELO.CREDENCIALES.GESTION.Funcionario;
import ACME.MODELO.CREDENCIALES.GESTION.GestorCredenciales;
import ACME.MODELO.CREDENCIALES.GESTION.Supervisor;
import ACME.MODELO.DAO.CARGO.Cargo;
import ACME.MODELO.DAO.CIUDAD.Ciudad;
import ACME.MODELO.DAO.DIRECCION.Direccion;
import ACME.MODELO.DAO.EMPRESA.Empresa;
import ACME.MODELO.DAO.ESTADO_PERSONA.Estado_Persona;
import ACME.MODELO.DAO.PERSONA.Persona;
import ACME.MODELO.DAO.TIPO.Tipo;
import com.toedter.calendar.JDateChooser;


public class GestionFuncionario extends JFrame {
    // Declaración de componentes
    private JTextField txtIdentificacion, txtPrimerNombre, txtSegundoNombre, txtPrimerApellido, txtSegundoApellido,
            txtUsuario, txtContrasena, txtCorreo, txtTelefono, txtNIT, txtCalle, txtCarrera, txtTransversal,
            txtDiagonal, txtNumero;

    private JComboBox<String>  cbGenero, cbCiudad;
    private JDateChooser dateFechaNacimiento;
    private JButton  btnCancelar, btnAgregar;

    public GestionFuncionario() {
        setTitle("Funcionario");
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("FUNCIONARIO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(300, 10, 200, 30);
        add(lblTitulo);

        agregarLabelYTexto("Identificación", 30, 60, txtIdentificacion = new JTextField());
        agregarLabelYTexto("Primer Nombre", 30, 100, txtPrimerNombre = new JTextField());
        agregarLabelYTexto("Segundo Nombre", 30, 140, txtSegundoNombre = new JTextField());
        agregarLabelYTexto("Primer Apellido", 30, 180, txtPrimerApellido = new JTextField());
        agregarLabelYTexto("Segundo Apellido", 30, 220, txtSegundoApellido = new JTextField());
        agregarLabelYTexto("Usuario", 30, 260, txtUsuario = new JTextField());
        agregarLabelYTexto("Contraseña", 30, 300, txtContrasena = new JTextField());

        agregarLabelYComboBox("Género", 450, 60, cbGenero = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"}));

        dateFechaNacimiento = new JDateChooser();
        dateFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        agregarLabelYDateChooser("Fecha Nacimiento", 450, 100, dateFechaNacimiento);
        agregarLabelYTexto("Correo Electronico", 450, 140, txtCorreo = new JTextField());
        agregarLabelYTexto("Teléfono", 450, 180, txtTelefono = new JTextField());
        agregarLabelYTexto("NIT Empresa", 450, 260, txtNIT = new JTextField());


        cbCiudad = new JComboBox<>();

        ControladorCiudad cc = new ControladorCiudad();

        List<String> ciudades = cc.listado();

        for (String ciudad : ciudades){
            cbCiudad.addItem(ciudad);
        }

        agregarLabelYComboBox("Ciudad", 450, 300, cbCiudad);
        agregarLabelYTexto("Calle", 450, 340, txtCalle = new JTextField());
        agregarLabelYTexto("Carrera", 450, 380, txtCarrera = new JTextField());
        agregarLabelYTexto("Transversal", 450, 420, txtTransversal = new JTextField());
        agregarLabelYTexto("Diagonal", 450, 460, txtDiagonal = new JTextField());
        agregarLabelYTexto("Número", 450, 500, txtNumero = new JTextField());

        btnCancelar = new JButton("cancelar");
        btnCancelar.setBounds(550, 540, 100, 30);
        add(btnCancelar);

        btnAgregar = new JButton("agregar");
        btnAgregar.setBounds(680, 540, 100, 30);
        add(btnAgregar);

        btnAgregar.addActionListener(e -> {
            ControladorDireccion cd = new ControladorDireccion();
            ControladorPersona cp = new ControladorPersona();
            ControladorEmpleado ce = new ControladorEmpleado();

            Direccion d = new Direccion();
            Ciudad c = new Ciudad();
            Empresa emp = new Empresa();
            Tipo t = new Tipo();
            Estado_Persona ep = new Estado_Persona();
            Persona per = new Persona();
            Cargo cargo = new Cargo();

            d.setNumero(txtNumero.getText());
            d.setCarrera(txtCarrera.getText());
            d.setDiagonal(txtDiagonal.getText());
            d.setCalle(txtCalle.getText());
            d.setTransversal(txtTransversal.getText());

            c.setNombre_ciudad((String) cbCiudad.getSelectedItem());

            emp.setNit(Integer.parseInt(txtNIT.getText()));

            t.setNombre_tipo("Funcionario");

            ep.setEstado_per("Activo");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            per.setCedula(Integer.parseInt(txtIdentificacion.getText()));
            per.setTelefono(txtTelefono.getText());
            per.setPrimer_nombre(txtPrimerNombre.getText());
            per.setSegundo_nombre(txtSegundoNombre.getText());
            per.setPrimer_apellido(txtPrimerApellido.getText());
            per.setSegundo_apellido(txtSegundoApellido.getText());
            per.setGenero((String) cbGenero.getSelectedItem());
            per.setEmail(txtCorreo.getText());
            per.setFecha_nacimiento(sdf.format(dateFechaNacimiento.getDate()));

            cargo.setNombre_cargo("Jefe de Recursos Humanos");

            String archivo = "funcionarios.txt";
            GestorCredenciales<Funcionario> gestor = new GestorCredenciales<>(archivo, Funcionario::fromString);

            try {
                if (gestor.verificarCredencial(txtUsuario.getText(), txtContrasena.getText())){
                    JOptionPane.showMessageDialog(this, "El usuario o contraseña ya existe.");
                }else{
                    if (cd.agregarDireccion(d, c) && cp.nuevaPersona(per, t, ep, d) && ce.nuevoEmpleado(per, emp, cargo)){

                        try {
                            Funcionario funcionario = new Funcionario(txtUsuario.getText(), txtContrasena.getText());
                            gestor.guardarCredencial(funcionario);
                        } catch (CredencialesException ee) {
                            System.err.println("Error: " + ee.getMessage());
                        }

                        JOptionPane.showMessageDialog(this, "Funcionario agregado con éxito.");

                        txtIdentificacion.setText("");
                        txtPrimerNombre.setText("");
                        txtSegundoNombre.setText("");
                        txtPrimerApellido.setText("");
                        txtSegundoApellido.setText("");
                        txtUsuario.setText("");
                        txtContrasena.setText("");
                        txtCorreo.setText("");
                        txtTelefono.setText("");
                        txtNIT.setText("");
                        txtCalle.setText("");
                        txtCarrera.setText("");
                        txtTransversal.setText("");
                        txtDiagonal.setText("");
                        txtNumero.setText("");

                    }else{
                        JOptionPane.showMessageDialog(this, "Falta llenar campos o el funcionario ya existe.");
                    }
                }
            } catch (CredencialesException ex) {
                throw new RuntimeException(ex);
            }

        });

        setVisible(true);
    }

    private void agregarLabelYTexto(String texto, int x, int y, JTextField campo) {
        JLabel lbl = new JLabel(texto);
        lbl.setBounds(x, y, 120, 20);
        add(lbl);
        campo.setBounds(x + 150, y, 150, 20);
        add(campo);
    }

    private void agregarLabelYComboBox(String texto, int x, int y, JComboBox<String> combo) {
        JLabel lbl = new JLabel(texto);
        lbl.setBounds(x, y, 120, 20);
        add(lbl);
        combo.setBounds(x + 150, y, 150, 20);
        add(combo);
    }

    private void agregarLabelYDateChooser(String texto, int x, int y, JDateChooser dateChooser) {
        JLabel lbl = new JLabel(texto);
        lbl.setBounds(x, y, 120, 20);
        add(lbl);
        dateChooser.setBounds(x + 150, y, 150, 20);
        add(dateChooser);
    }

    public static void main(String[] args) {
        GestionFuncionario gf = new GestionFuncionario();

        gf.setVisible(true);
    }
}
