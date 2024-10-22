import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaBemVindo {

    // Lista para armazenar os produtos e quantidades selecionados
    ArrayList<String> carrinho = new ArrayList<>();
    private JFrame novaTela;

    public void mostrar() {
        // Criação da nova janela (frame) se ainda não foi criada
        if (novaTela == null) {
            novaTela = new JFrame("Bem-vindo");
            novaTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            novaTela.setSize(400, 300);
            novaTela.setLayout(new BorderLayout());

            // Criação do label de boas-vindas
            JLabel welcomeLabel = new JLabel("Bem-vindo! Selecione os produtos:", JLabel.CENTER);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
            novaTela.add(welcomeLabel, BorderLayout.NORTH);

            // Lista de produtos com opção de seleção múltipla
            String[] produtos = {"Produto A", "Produto B", "Produto C"};
            JList<String> listaProdutos = new JList<>(produtos);
            listaProdutos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            JScrollPane scrollPane = new JScrollPane(listaProdutos);
            novaTela.add(scrollPane, BorderLayout.CENTER);

            // Painel de botões
            JPanel buttonPanel = new JPanel();
            novaTela.add(buttonPanel, BorderLayout.SOUTH);

            // Botão para adicionar produtos ao carrinho
            JButton adicionarCarrinhoButton = new JButton("Adicionar ao Carrinho");
            buttonPanel.add(adicionarCarrinhoButton);

            // Botão para visualizar o carrinho
            JButton visualizarCarrinhoButton = new JButton("Visualizar Carrinho");
            buttonPanel.add(visualizarCarrinhoButton);

            // Ação do botão "Adicionar ao Carrinho"
            adicionarCarrinhoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtém os produtos selecionados
                    java.util.List<String> selecionados = listaProdutos.getSelectedValuesList();

                    // Solicita a quantidade para cada produto selecionado e adiciona ao carrinho
                    for (String produto : selecionados) {
                        String quantidade = JOptionPane.showInputDialog("Informe a quantidade para: " + produto);
                        carrinho.add(produto + " - Quantidade: " + quantidade);
                    }
                }
            });

            // Ação do botão "Visualizar Carrinho"
            visualizarCarrinhoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a interface do carrinho para pré-visualização, mantendo a janela principal aberta
                    TelaCarrinho telaCarrinho = new TelaCarrinho(carrinho, TelaBemVindo.this);
                    telaCarrinho.mostrar(); // Mostra o conteúdo do carrinho
                    novaTela.setVisible(false); // Esconde a tela de produtos, mas não a fecha
                }
            });

            // Exibe a nova tela
            novaTela.setLocationRelativeTo(null);
        }
        novaTela.setVisible(true);
    }

    public void exibirJanela() {
        novaTela.setVisible(true); // Reutiliza a mesma janela
    }
}
