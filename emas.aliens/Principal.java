import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        int linhaAntiga, colunaAntiga, linhaNova, colunaNova;
        boolean dentroDaMatriz, desocupado, localAlien, localEma, posicaoFinalAlien, posicaoFinalEma;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem Vindo ao Jogo Emas Vs Aliens");
        //mostra o estado inicial do jogo
        EstadoDoJogo.organizarMatriz();
        do{
            do{
                System.out.println("Jogador 1, informe a posição do Alien que deseja mover");
                linhaAntiga = entrada.nextInt();
                colunaAntiga = entrada.nextInt();
                //recebe se há Alien na posição, se não exibe mensagem negativa
                localAlien = EstadoDoJogo.posicaoAlien(linhaAntiga, colunaAntiga);
                if(localAlien == false){
                    System.out.println("Não existe um Alien na posição informada");
                }
                //enquanto não há alien na posição, repete
            } while(localAlien == false);
            do{
                System.out.println("Jogador 1, informe a posição desejada para o Alien:");
                linhaNova = entrada.nextInt();
                colunaNova = entrada.nextInt();
                //recebe se a posição desejada para o Alien está dentro da matriz
                dentroDaMatriz = EstadoDoJogo.isDentroDaMatriz(linhaNova, colunaNova);
                //recebe se a posição desejada para o Alien está desocupada
                desocupado = EstadoDoJogo.isDesocupada(linhaNova, colunaNova);
                posicaoFinalAlien = false;
                //se alguma das informações anteriores for falsa exibe mensagem negativa
                if(!dentroDaMatriz || !desocupado){
                    System.out.println("Jogada inválida");
                } else {
                    //recebe se o Alien está se movendo na diagonal
                    posicaoFinalAlien = EstadoDoJogo.moveAlien(linhaAntiga, colunaAntiga, linhaNova, colunaNova);
                    //se sim exibe mensagem negativa
                    if(posicaoFinalAlien==false){
                        System.out.println("Posição Invalida");
                    //se não, move o Alien para a posição desejada
                    } else{
                        EstadoDoJogo.moveAlien(linhaAntiga, colunaAntiga, linhaNova, colunaNova);
                    }
                    //mostra o estado do jogo atualizado
                    EstadoDoJogo.mostrar();
                }
                //enquanto alguma das posições forem inválidas a rodada segue do jogador 1
            } while(!dentroDaMatriz || !desocupado || !posicaoFinalAlien);

            do{
                System.out.println("Jogador 2, informe a posição da Ema que deseja mover");
                linhaAntiga = entrada.nextInt();
                colunaAntiga = entrada.nextInt();
                //recebe se há Ema na posição, se não exibe mensagem negativa
                localEma = EstadoDoJogo.posicaoEma(linhaAntiga, colunaAntiga);
                if(localEma == false){
                    System.out.println("Não existe uma Ema na posição informada");
                }
                //enquanto não há Ema na posição, repete
            } while(localEma == false);
            do{
                System.out.println("Jogador 2, informe a posição desejada para a Ema:");
                linhaNova = entrada.nextInt();
                colunaNova = entrada.nextInt();
                //recebe se a posição desejada para Ema está dentro da matriz
                dentroDaMatriz = EstadoDoJogo.isDentroDaMatriz(linhaNova, colunaNova);
                //recebe se a posição desejada  para Ema está desocupada
                desocupado = EstadoDoJogo.isDesocupada(linhaNova, colunaNova);
                posicaoFinalEma = false;
                //se alguma das informações anteriores for falsa exibe mensagem negativa
                if(!dentroDaMatriz || !desocupado){
                    System.out.println("Jogada inválida");
                } else {
                    //recebe se a Ema está se movendo na diagonal
                    posicaoFinalEma = EstadoDoJogo.moveEma(linhaAntiga, colunaAntiga, linhaNova, colunaNova);
                    //se sim exibe mensagem negativa
                    if(posicaoFinalEma == false){
                        System.out.println("Posição Inválida");
                    //se não, move a Ema para a posição desejada
                    } else {
                    EstadoDoJogo.moveEma(linhaAntiga, colunaAntiga, linhaNova, colunaNova);
                    }
                    //mostra o estado do jogo atualizado
                    EstadoDoJogo.mostrar();
                }
                //enquanto alguma das posições forem inválidas a rodada segue do jogador 2
            } while(!dentroDaMatriz || !desocupado || !posicaoFinalEma);
            //condição de fim de jogo
        } while(EstadoDoJogo.fimDeJogo()==true);
        entrada.close();
    }
}