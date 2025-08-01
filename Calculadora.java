import java.awt.*;
import javax.swing.*;

public class Calculadora{

    public static void main(String[] args){
    
        //Iniciando janela
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setSize(800, 600);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Iniciando panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(119, 221, 119));
        panel.setLayout(new BorderLayout());

        //Criando botão
        JButton button = new JButton("Calcular");
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(119, 221, 119));
        button.setPreferredSize(new Dimension(150, 50));
        button.setFont(new Font("Arial", Font.BOLD, 20));

        //Título da Página
        JLabel label = new JLabel("Calculadora de IMC");
        label.setFont(new Font("Arial", Font.BOLD, 36));

        //Títulos - caixa de texto
        JLabel label1 = new JLabel("Peso: ");
        label1.setFont(new Font("Arial", Font.BOLD, 29));
        JLabel label2 = new JLabel("Altura: ");
        label2.setFont(new Font("Arial", Font.BOLD, 29));

        //Caixa de texto
        JTextField textField = new JTextField(10);
        textField.setFont(new Font("Arial", Font.PLAIN, 29));
        JTextField textField1 = new JTextField(10);
        textField1.setFont(new Font("Arial", Font.PLAIN, 29));
        
        //Adicionar um Listener no click do botão
        button.addActionListener(e -> {
            String entradaPeso = textField.getText(); 
            double peso = Double.parseDouble(entradaPeso); 
            String entradaAltura = textField1.getText(); 
            double altura = Double.parseDouble(entradaAltura); 
            double imc = peso / (altura*altura);
            String grau;
            if(imc < 18.5){
                grau = "Magreza";
            }else if(imc > 18.5 && imc < 24.9){
                grau = "Normal";
            }else if(imc > 25 && imc < 29.9){
                grau = "Sobrepeso";
            }else if(imc > 30 && imc < 34.9){
                grau = "Obesidade Grau 1";
            }else if(imc > 35 && imc < 39.9){
                grau = "Obesidade Grau 2";
            }else{
                grau = "Obesidade Grau 3";
            }
            String resultado = String.format("Seu IMC e: %.2f - %s", imc, grau);
            JOptionPane.showMessageDialog(null, resultado, "Indice de Massa Corporal", 0);    
        });

        //Linha 1
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        formPanel.add(label1);
        formPanel.add(textField);

        //Linha 2
        JPanel formPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        formPanel1.add(label2);
        formPanel1.add(textField1);

        //Juntando a linha 1 e linha 2
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.add(formPanel);
        centro.add(formPanel1);

        //Adicionando título na tela
        panel.add(label, BorderLayout.NORTH);
        
        //Adicionando formulário na tela
        panel.add(centro, BorderLayout.CENTER);
        
        //Adicionando o botão a tela
        panel.add(button, BorderLayout.SOUTH);
        
        //Adicionando componentes a janela
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}