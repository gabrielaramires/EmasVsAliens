import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        int linhaAntiga, colunaAntiga, linhaNova, colunaNova;
        boolean dentroDaMatriz, desocupado, localAlien, localEma, posicaoFinalAlien, posicaoFinalEma;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem Vindo ao Jogo Emas Vs Aliens");
        EstadoDoJogo.organizarMatriz();
        //EstadoDoJogo jogo = new EstadoDoJogo();
        do{
            do{
                System.out.println("Jogador 1, informe a posição do Alien que deseja mover");
                linhaAntiga = entrada.nextInt();
                colunaAntiga = entrada.nextInt();
                localAlien = EstadoDoJogo.posicaoAlien(linhaAntiga, colunaAntiga);
                if(localAlien == false){
                    System.out.println("Não existe um Alien na posição informada");
                }
            } while(localAlien == false);
            do{
                System.out.println("Jogador 1, informe a posição desejada para o Alien:");
                linhaNova = entrada.nextInt();
                colunaNova = entrada.nextInt();
                dentroDaMatriz = EstadoDoJogo.isDentroDaMatriz(linhaNova, colunaNova);
                desocupado = EstadoDoJogo.isDesocupada(linhaNova, colunaNova);
                posicaoFinalAlien = false;
                if(!dentroDaMatriz || !desocupado){
                    System.out.println("Jogada inválida");
                } else {
                    posicaoFinalAlien = EstadoDoJogo.moveAlien(linhaAntiga, colunaAntiga, linhaNova, colunaNova);
                    if(posicaoFinalAlien==false){
                        System.out.println("Posição Invalida");
                    } else{
                        EstadoDoJogo.moveAlien(linhaAntiga, colunaAntiga, linhaNova, colunaNova);
                    }
                    EstadoDoJogo.mostrar();
                }
            } while(!dentroDaMatriz || !desocupado || !posicaoFinalAlien);

            do{
                System.out.println("Jogador 2, informe a posição da Ema que deseja mover");
                linhaAntiga = entrada.nextInt();
                colunaAntiga = entrada.nextInt();
                localEma = EstadoDoJogo.posicaoEma(linhaAntiga, colunaAntiga);
                if(localEma == false){
                    System.out.println("Não existe uma Ema na posição informada");
                }
            } while(localEma == false);
            do{
                System.out.println("Jogador 2, informe a posição desejada para a Ema:");
                linhaNova = entrada.nextInt();
                colunaNova = entrada.nextInt();
                dentroDaMatriz = EstadoDoJogo.isDentroDaMatriz(linhaNova, colunaNova);
                desocupado = EstadoDoJogo.isDesocupada(linhaNova, colunaNova);
                posicaoFinalEma = false;
                if(!dentroDaMatriz || !desocupado){
                    System.out.println("Jogada inválida");
                } else {
                    posicaoFinalEma = EstadoDoJogo.moveEma(linhaAntiga, colunaAntiga, linhaNova, colunaNova);
                    if(posicaoFinalEma == false){
                        System.out.println("Posição Inválida");
                    } else {
                    EstadoDoJogo.moveEma(linhaAntiga, colunaAntiga, linhaNova, colunaNova);
                    }
                    EstadoDoJogo.mostrar();
                }
            } while(!dentroDaMatriz || !desocupado || !posicaoFinalEma);
        } while(EstadoDoJogo.fimDeJogo()==true);
        entrada.close();
    }
}
