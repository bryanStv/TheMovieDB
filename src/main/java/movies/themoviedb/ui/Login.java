package movies.themoviedb.ui;

import movies.themoviedb.controller.UsuarioController;
import movies.themoviedb.entity.Usuario;
import movies.themoviedb.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class Login {
    private final UsuarioController usuarioController;
    private final UsuarioRepository usuarioRepository;

    private JPanel mainPanel;
    private JTextField userTextField;
    private JPasswordField passTextField;
    private JPanel logoPanel;
    private JPanel datosPanel;
    private JPanel UserPanel;
    private JPanel PasswordPanel;
    private JPanel labelUserPanel;
    private JPanel labelPassPanel;
    private JLabel labelUser;
    private JLabel labelPass;
    private JPanel panelBotones;
    private JButton bforgot;
    private JButton bregister;
    private JButton blogin;
    private JLabel icon;

    public Login(UsuarioController usuarioController, UsuarioRepository usuarioRepository) {
        this.usuarioController = usuarioController;
        this.usuarioRepository = usuarioRepository;

        bforgot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String name = userTextField.getText();

                if (usuarioController.forgotPassword(name)) {
                    String newPass = JOptionPane.showInputDialog("Introduzca la nueva contraseña");
                    Usuario user = usuarioRepository.findByName(name);
                    if(user != null) {
                        user.setPass(newPass);
                        usuarioRepository.save(user);
                        JOptionPane.showMessageDialog(null, "Contraseña cambiada con exito");
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                    }
                }
            }
        });
        blogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean loginSuccess = usuarioController.login(userTextField.getText(), passTextField.getText());
                if(loginSuccess){
                    JOptionPane.showMessageDialog(null,"Bienvenido al sistema");
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario no encontrado");
                }
            }
        });
        bregister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                usuarioController.register(userTextField.getText(), passTextField.getText());
            }
        });
    }

    public void main() {
        JFrame frame = new JFrame();
        frame.setContentPane(new Login(usuarioController,usuarioRepository).mainPanel);
        //Tamaño de pantalla
        Dimension dimension = new Dimension(800,400);
        frame.setMinimumSize(dimension);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
