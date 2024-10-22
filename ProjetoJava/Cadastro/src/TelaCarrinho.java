import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaCarrinho {

    private ArrayList<String> carrinho;
    private TelaBemVindo telaBemVindo;

    // Construtor que recebe a lista de produtos selecionados e a instância da tela de produtos
    public TelaCarrinho(ArrayList<String> carrinho, TelaBemVindo telaBemVindo) {
        this.carrinho = carrinho;
        this.telaBemVindo = telaBemVindo;
    }

    public void mostrar() {
        // Criação da nova janela (frame)
        JFrame novaTela = new JFrame("Carrinho");
        novaTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        novaTela.setSize(400, 300);
        novaTela.setLayout(new BorderLayout());

        // Criação do label de boas-vindas
        JLabel carrinhoLabel = new JLabel("Carrinho de Compras", JLabel.CENTER);
        carrinhoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        novaTela.add(carrinhoLabel, BorderLayout.NORTH);

        // Lista de produtos no carrinho
        JList<String> listaCarrinho = new JList<>(carrinho.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(listaCarrinho);
        novaTela.add(scrollPane, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        novaTela.add(buttonPanel, BorderLayout.SOUTH);

        // Botão para finalizar a compra
        JButton finalizarButton = new JButton("Finalizar Compra");
        buttonPanel.add(finalizarButton);

        // Botão para continuar comprando
        JButton continuarButton = new JButton("Continuar Comprando");
        buttonPanel.add(continuarButton);

        // Ação do botão "Finalizar Compra"
        finalizarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(novaTela, "Compra finalizada com sucesso!");
            novaTela.dispose(); // Fecha a tela do carrinho após finalizar a compra
        });

        // Ação do botão "Continuar Comprando"
        continuarButton.addActionListener(e -> {
            // Reabre a tela de produtos (sem criar uma nova)
            telaBemVindo.exibirJanela();
            novaTela.dispose(); // Fecha a tela do carrinho
        });

        // Exibe a nova tela
        novaTela.setLocationRelativeTo(null);
        novaTela.setVisible(true);
    }
}
