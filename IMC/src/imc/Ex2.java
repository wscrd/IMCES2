/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imc;

//importação das classes necessárias
//layouts para alinhamento dos componentes
import java.awt.FlowLayout;
import java.awt.GridLayout;
//janela
import javax.swing.JFrame;
//butão
import javax.swing.JButton;
//caixa de seleção
import javax.swing.JComboBox;
//inserção de texto e/ou imagem
import javax.swing.JLabel;
//classe Icon junto com ImageIcon anexão uma imagem a um Jlabel
import javax.swing.Icon;
import javax.swing.ImageIcon;
//exibição de textos numa pequena caixa de mensagens
import javax.swing.JOptionPane;
//painel
import javax.swing.JPanel;
//caixa de textos
import javax.swing.JTextArea;
//campo para inserção de valores ou caracteres
import javax.swing.JTextField;
//Evento para de ouvir um evento do botão
import java.awt.event.ActionListener;
//Evento de executar uma ação do evento que foi ouvido(ativado)
import java.awt.event.ActionEvent;
//Tratador de erros
import java.util.InputMismatchException;

//Criação da classe EX2 extendendo a classe JFrame que foi importada
public class Ex2 extends JFrame
{
   //declaração das variáveis
   //Vetor de caracteres (String) de 2 colunas
   private String sexo[]={"Mulher","Homem"};
   //inteiros (int)
   public int tipo, foto;
   //numeros de pontos flutuantes (double)
   public double altura, peso, massa;
   //criando um array já com os valores configurados do tipo double
   public double imc_homens[] ={20.7,26.4};
   public double imc_mulheres[] ={19.1,25.8};
   private String string="";

   //criação do FlowLayout que alinha componentes da esquerda para a direita.
   private FlowLayout flowLayout = new FlowLayout();
   /*criação de GridLayout com 4 linhas e 2 colunas com 10 de espaço em largura
    e 1 de altura*/
   private GridLayout gridLayout = new GridLayout(4,2,10,1);
   //criação de um painel
   private JPanel gridJPanel = new JPanel();

   //criação de dois botões com os nomes Calcular e Limpar Dados
   private JButton butao = new JButton("Calcular");
   private JButton butao2 = new JButton("Limpar Dados");
   //criação das label's
   private JLabel Lsexo = new JLabel("Escolha o sexo:");
   private JLabel Laltura = new JLabel("Altura em cm:");
   private JLabel Lpeso = new JLabel("Peso em Kg:");
   private JLabel Lresultado = new JLabel("");
   private JLabel Lfoto = new JLabel("");
   //criação de campos com 5 de largura
   private JTextField Faltura = new JTextField("",5);
   private JTextField Fpeso = new JTextField("",5);

   //criação de uma caixa de seleção
   private JComboBox escolha = new JComboBox(sexo);

   //anexando a imagem um icone de nome limpar
   private Icon limpar = new ImageIcon(getClass().getResource("blank.gif"));
   //criando um vetor com as demais imagens
   private Icon imagemM[] = {new ImageIcon(getClass().getResource("esqueleto.gif")), new ImageIcon
   (getClass().getResource("normalM.jpg")),new ImageIcon(getClass().getResource("obesa.jpg"))};
   private Icon imagemH[] = {new ImageIcon(getClass().getResource("esqueleto.gif")), new ImageIcon
   (getClass().getResource("normalH.jpg")),new ImageIcon(getClass().getResource("obeso.jpg"))};

   //construtor de Ex2 sem argumentos
   public Ex2()
   {
    //título  da janela
    super("Calculo do IMC(índice de massa corporal)");
    //alinhamento do frame com o uso do objeto flowLayout
    super.setLayout(flowLayout);
    //tamanho da janela
    setSize(370, 160);
    //inclusão dos componentes de maximinizar, miniminizar e fechar
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //exibe 2 linhas da caixa de seleção ao clicá-la
    escolha.setMaximumRowCount(2);
    //alinha o painel com o objeto gridLayout
    gridJPanel.setLayout(gridLayout);
    //adiciona os componentes
    gridJPanel.add(Lsexo);
    gridJPanel.add(escolha);
    gridJPanel.add(Laltura);
    gridJPanel.add(Faltura);
    gridJPanel.add(Lpeso);
    gridJPanel.add(Fpeso);
    gridJPanel.add(butao);
    gridJPanel.add(butao2);

    //adiciona a janela principal
    super.add(gridJPanel);
    super.add(Lfoto);
    super.add(Lresultado);

    //criação de uma classe interna anônima para butao
    butao.addActionListener(
    new ActionListener()
    {
       public void actionPerformed(ActionEvent event)
       {
        switch (escolha.getSelectedIndex())
        {
           /*caso seja a primeira opção que foi selecionada na caixa de seleção
            configure tipo=0 e vá para o método Calculos*/
           case 0:
           {
             tipo=0; //mulher
             Calculos();
             break;
           }
           //caso seja a segunda opção, configura tipo como 1 e vá para o método Calculos.
           case 1:
           {
             tipo=1; //homem
             Calculos();
             break;
           }
        }
       }
     }//Fim da classe interna anônima
    );//fim da chamada para addActionListerner

    //classe interna anônima para butao2
    butao2.addActionListener(
    new ActionListener()
    {
       //ao clicar no butao2 de nome limpar chama o método limpar
       public void actionPerformed(ActionEvent event)
       {
        limpar();
       }
    }//Fim da classe interna anônima
    );//fim da chamada para addActionListerner
   }

   //método que realiza os calculos
   private void Calculos()
   {
       try //tratador de erros com try e catch
       {
          //pega e converte os caracteres em ponto flutuante do campo Faltura para a variavel altura
          altura=Double.parseDouble(Faltura.getText());
          //converte para metros
          altura/=100;
          //da mesma forma com Fpeso para a variável peso
          peso=Double.parseDouble(Fpeso.getText());
          //realiza calculos
          massa = Calcula(tipo, peso, altura);
          /*Se a massa corporal for menor do que o estabelecido pelo vetor configure a variável
           string com essa frase*/
          string = mensagem(tipo, massa);
          //reconfigure o tamanho da tela
          setSize(370, 500);
          //configure a label Lresultado com a variável string
          Lresultado.setText(string);
       }
       //caso ocorra uma excessão(erro) exiba uma mensagem nua caixa de mensagem
       catch(NumberFormatException exception)
       {
        JOptionPane.showMessageDialog(this,"No número inválido!\nEx: Use '.' ao invés de ',' para separar as casas decimais.","ERROR FATAL!!!",JOptionPane.ERROR_MESSAGE);
        //limpe s campos e variáveis
        Fpeso.setText("");
        Faltura.setText("");
        peso=0;
        altura=0;
       }
   }
   
   public static double Calcula(int tipo, double peso, double altura) {
       double imc;
       imc = peso/(altura*altura);
       return imc;
   }
   
   public String mensagem(int tipo, double massa) {
       String saida = "";
       if (tipo==0)
         {
            if (imc_mulheres[0]>massa)
            {
               saida = String.format("CUIDADO!!!Voce estar abaixo do peso! IMC %.2f",massa);
               foto=0;
            }
            else if((imc_mulheres[0]<massa) && (massa<=imc_mulheres[1]))
            {
               saida = String.format("PARABENS!!Voce estar com o peso ideal! IMC %.2f",massa);
               foto=1;
            }
            else
            {
               saida = String.format("CUIDADO!!Voce estar obesa! IMC %.2f",massa);
               foto=2;
            }
            //configure a foto conforme a posição da variável foto
         }
         else if (tipo==1)
         {
            if (imc_homens[0]>massa)
            {
               saida = String.format("CUIDADO!!!Voce estar abaixo do peso! IMC %.2f",massa);
               //configura a posição que será exibido a imagem
               foto=0;
            }
            else if((imc_homens[0]<massa) && (massa<imc_homens[1]))
            {
               saida = String.format("PARABENS!!Voce estar com o peso ideal! IMC %.2f",massa);
               foto=1;
            }
            else
            {
               saida = String.format("CUIDADO!!Voce estar obeso! IMC %.2f",massa);
               foto=2;
            }
            //configure a foto conforme a posição da variável foto
            
            
         }
       setIconPeloGenero(tipo);
       return saida;
   }
   
   public void setIconPeloGenero(int tipo) {
       this.foto = foto;
       if (tipo == 0)
         Lfoto.setIcon(imagemM[foto]);
       else if (tipo == 1)
         Lfoto.setIcon(imagemH[foto]);
   }
   //método para limpar os dados da tela e retornar a tela ao seu tamanho original
   private void limpar()
   {
    Fpeso.setText("");
    Faltura.setText("");
    Lresultado.setText("");
    //substitua a imagem atual por essa
    Lfoto.setIcon(limpar);
    setSize(300, 160);
   }
}//Fim da classe Ex2