import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaLogin {

    public static void main(String[] args) {
        // Criação do frame de login
        JFrame frame = new JFrame("Tela de Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Componentes de login
        JLabel userLabel = new JLabel("Usuário:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(userLabel, gbc);

        JTextField userField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(userField, gbc);

        JLabel passLabel = new JLabel("Senha:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(passField, gbc);

        JButton loginButton = new JButton("Entrar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(loginButton, gbc);

        // Ação do botão de login
        ActionListener loginAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("admin") && password.equals("1234")) {
                    // Cria uma instância de TelaBemVindo e abre a nova interface
                    TelaBemVindo telaBemVindo = new TelaBemVindo();
                    telaBemVindo.mostrar();
                    frame.dispose(); // Fecha a tela de login
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário ou senha incorretos.");
                }
            }
        };

        // Adiciona o ActionListener ao botão
        loginButton.addActionListener(loginAction);

        // Adiciona KeyListener ao JTextField e JPasswordField
        userField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginAction.actionPerformed(new ActionEvent(loginButton, ActionEvent.ACTION_PERFORMED, null));
                }
            }
        });

        passField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginAction.actionPerformed(new ActionEvent(loginButton, ActionEvent.ACTION_PERFORMED, null));
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}