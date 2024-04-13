import java.util.Scanner;
import java.util.Random;

public class main{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int v[] = {};
        int opc;
    
        String menu = 
            "1. Inicializar o vetor com números aleatórios.\n" +
            "2. Imprimir o vetor.\n" +
            "3. Verificar existência de um número.\n" +
            "4. Buscar o maior número.\n" +
            "5. Média dos números pares.\n" +
            "6. Percentual dos números ímpares.\n" +
            "7. Média centralizada.\n" +
            "8. Verificar um valor a partir da soma de duas posições.\n" +
            "0. Encerrar programa.";
    
        System.out.println("    OPERAÇÕES COM VETORES  \n");
        /*
        Utilizamos a estrutura while(true) para que o menu ficasse em loop 
        até o usuário desejar encerrar o programa.
        */
        while (true) {
          System.out.println("\n ============================ \n");
          System.out.println(menu);
          System.out.println("\nDigite a opção desejada: \n");
          opc = ler.nextInt();
          System.out.println("\n");
          /*  
          Dentro de cada case, com exceção do número 1 e 0, há uma verificação para saber 
          se o vetor foi inicializado.
          */
          switch (opc) {
            case 1:
              System.out.println("Digite o tamanho do vetor: ");
              int tamVetor = ler.nextInt();
    
              System.out.println("Digite o valor máximo dos números que podem ser gerados: ");
              int valorMax = ler.nextInt();
              
              v = criarVetor(tamVetor, valorMax);
              break;
    
            case 2:
              if (v.length > 0) {
                imprimirVetor(v);
              } else {
                System.out.println("Vetor não inicializado, tente novamente!\n");
              }
              break;
    
            case 3:
              if (v.length > 0) {
                System.out.println("Informe o valor a ser procurado no vetor: ");
                int numProcurado = ler.nextInt();
                
                if(procurarNoVetor(v, numProcurado) == -1 ){
                  System.out.println("Valor não encontrado");
                }else{
                  System.out.println("Valor encontrado na posição "+procurarNoVetor(v, numProcurado));
    
                }  
              } else {
                System.out.println("Vetor não inicializado, tente novamente!\n");
              }
              break;
              
            case 4:
              if (v.length > 0) {
                System.out.println(maiorNumero(v));
              } else {
                System.out.println("Vetor não inicializado, tente novamente!\n");
              }
              break;
    
            case 5:
              if (v.length > 0) {
                System.out.println(mediaPar(v));
              } else {
                System.out.println("Vetor não inicializado, tente novamente!\n");
              }
              break;
    
            case 6: 
              if (v.length > 0) {
                System.out.println(porcentagemImpares(v)+"%");
              } else {
                System.out.println("Vetor não inicializado, tente novamente!\n");
              }
              break;
    
            case 7:
              if (v.length > 0) {
                System.out.println(mediaCentralizada(v));
              } else {
                System.out.println("Vetor não inicializado, tente novamente!\n");
              }
              break;
              
            case 8:
              if (v.length > 0) {
               System.out.println("Digite o valor para a verificação: ");
               int valor = ler.nextInt();  
               System.out.println(somaPosicoes(v,valor));
              } else {
                System.out.println("Vetor não inicializado, tente novamente!\n");
              }
              break;
              
            case 0:
              System.exit(0);
              ler.close();
              break;
    
            default:
              System.out.println("Opção inválida tente novamente... ");
              break;
          }
        } 
    }

    public static int[] criarVetor(int tVetor, int m) {
        Random r = new Random();
        int v[] = new int[tVetor];
        for (int i = 0; i < v.length; i++) {
          v[i] = r.nextInt(m+1);
        }
    
        return v;
    }
      
      /*
      Dentro da função foi criado um vetor que recebe por parâmetros o seu tamanho 
      e o número máximo de números que podem ser gerados, mais um, para que sejam 
      menores ou iguais ao valor escolhido. Após criado, ele retorna este vetor com 
      os valores gerados e o usuário pode realizar as outras funções.
      */
    
    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
          System.out.printf("%d\t", vetor[i]);
        }
        System.out.println(" ");
    }
      
      /*
      Nesta função, é retornado o vetor, que foi gerado anteriormente, a partir do 
      comando System.out.println().
      */
    
    public static int procurarNoVetor(int[] vetor, int numProcurado){
        for (int i= 0; i< vetor.length; i++){
          if(vetor[i] == numProcurado){
            return i;
          }     
        }
        return -1;
    }
      
      /*
      O vetor é percorrido a partir do comando for, e com o comando if, ele compara 
      todos os números do vetor com o número procurado que recebeu por parâmetro, e 
      retorna para o usuário se o número foi encontrado ou não.
      */
    
    public static int maiorNumero(int [] vetor){
        int maior = vetor[0];
        for(int i = 0; i <vetor.length; i++){
         if(vetor[i]>maior){
           maior = vetor[i];
         }
        }
        return maior;    
    }
    
      /*
      O vetor é percorrido a partir do comando for, e com o comando if, é feita uma 
      verificação com os números do vetor e a variável auxiliar “maior”, que recebeu o 
      primeiro valor do vetor, que apartir dessa comparação aloca o maior número contido 
      no vetor dentro da variável “maior”  e a retorna para o usuário.
      */
    
    public static int mediaPar(int [] vetor){
        int pares = 0;
        int contadorPares = 0;
        int media = 0;
        for (int i = 0; i <vetor.length; i++){
          if(vetor[i] != 0 && vetor[i] % 2 == 0){
            pares += vetor[i];
            contadorPares ++;  
          }
        }
        media = pares/contadorPares;
        return media;
    }
    
      /*
      Possui três variáveis auxiliares: "pares": Para armazenar a soma dos números pares, 
      "contadorPares": Para contar quantos   números pares foram encontrados, "media": Para 
      armazenar a média dos números pares. O vetor é percorrido a partir do comando for,  é 
      feita uma verificação dos números pares, onde se o número for par, ele é adicionado à 
      soma dos números pares e incrementa um no contador de pares. Logo após isso, é feito o 
      calculo da média a partir dos valores recebidos, e   é retornada ao usuário a média 
      dos numeros pares.
      */
    
    public static double porcentagemImpares(int [] vetor){
        int contadorImpares = 0;
        for (int i = 0; i < vetor.length; i++) {
          
          if (vetor[i] != 0 && vetor[i] % 2 != 0) {
            contadorImpares++;
          }
        }
        return ((double) contadorImpares/vetor.length)*100;
    }
    
      /*
      Possui uma variável auxiliar para contar quantos números impares estão presentes no vetor.
      É feita uma verificação dos números ímpares, onde se o número for ímpar, é incrementado no 
      contador de  ímpares. Logo após isso, a porcentagem é calculada e retornada ao usuário.
      */
    
    public static double mediaCentralizada(int [] vetor){
        int maior = vetor[0];
        int indexMaior = 0;
        int menor = vetor[0];
        int indexMenor = 0;
        int soma = 0;
        
        for(int i = 0; i <vetor.length; i++){
         if(vetor[i]>maior){
           maior = vetor[i];
           indexMaior = i;
         }
        }
        for(int i = 0; i <vetor.length; i++){
         if(vetor[i]<menor){
           menor = vetor[i];
           indexMenor = i;
         }
        }
        
        for (int i = 0; i < vetor.length; i++){
          if(i != indexMenor && i != indexMaior){
            soma += vetor[i];
          }
        }
        return ((double) soma/(vetor.length - 2));
    }
    
      /*
      É feita uma verificação com os números do vetor e a variável auxiliar “maior“, que 
      recebeu a posição zero do vetor, e quando encontrado o maior valor, ele é alocado na 
      variável “indexMaior“, o mesmo ocorre para o menor valor, só que com as variáveis “menor” 
      e “indexMenor”. Após encontrados, o menor e o maior valor, utilizamos o comando if para 
      somar os valores dentro do vetor que são diferentes das variáveis “maior“ e “menor”, a soma 
      é guardada dentro da variável auxiliar “soma”, e por fim é calculada a média centralizada, 
      dividindo-se a soma dos valores centrais pela quantidade de elementos do vetor, menos 2, 
      pois excluímos o maior e o menor valor.
      */
    
    public static boolean somaPosicoes(int [] vetor, int valorBuscado){
        for (int i = 0; i < vetor.length; i++){
          for (int j = 0; j < vetor.length; j++){
            if(i != j){
              if((vetor[i] + vetor[j])==valorBuscado){
                return true;
              }
            }
          }
        }
        return false;
    }
    
      /*
      Utilizamos o comando for duas vezes para percorrer o mesmo vetor, e depois com a condição 
      de que os índices fossem diferentes, é feita a verificação se soma dos valores nas posições 
      diferentes, são iguais ao valor buscado.
      */

}