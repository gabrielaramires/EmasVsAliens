public class EstadoDoJogo {
    static char matriz[][] = new char[5][4];

    static void organizarMatriz(){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<4;j++){
                if(i == 0 || i == 1){
                    matriz[i][j] = 'E';
                } else if(i == 4 && (j == 1 || j ==2)){
                    matriz[i][j] = 'A';
                } else {
                    matriz[i][j] = '.';
                }
                System.out.print(" "+matriz[i][j]);
            }
            System.out.println(" ");
        }  
    }
    static void mostrar(){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<4;j++){
                System.out.print(" "+matriz[i][j]);
            }
            System.out.println(" ");
        }  
    }
    static boolean posicaoAlien(int linha, int coluna){
        if(matriz[linha][coluna]=='A'){
            return true;
        }
        return false;
    }
    static boolean isDentroDaMatriz(int l, int c){
        if(l>=0 && c>=0 && l<5 && c<4){
            return true;
        }
        return false;
    }
    static boolean isDesocupada(int l, int c){
        if(matriz[l][c]=='.'){
            return true;
        }
        return false;
    }
    static boolean moveAlien(int linhaAntiga, int colunaAntiga, int linhaNova, int colunaNova){
        if(((linhaAntiga-linhaNova)==1 || (linhaAntiga-linhaNova)==-1) && colunaAntiga == colunaNova){
            matriz[linhaAntiga][colunaAntiga] = '.';
            matriz[linhaNova][colunaNova] = 'A';
            return true;
        } else if(((colunaAntiga-colunaNova)==1 || (colunaAntiga-colunaNova)==-1) && linhaAntiga==linhaNova){
            matriz[linhaAntiga][colunaAntiga] = '.';
            matriz[linhaNova][colunaNova] = 'A';
            return true;
        }
        return false;
    }
    static boolean posicaoEma(int linha, int coluna){
        if(matriz[linha][coluna]=='E'){
            return true;
        }
        return false;
    }
     static boolean moveEma(int linhaAntiga, int colunaAntiga, int linhaNova, int colunaNova){
        if(((linhaAntiga-linhaNova)==1 || (linhaAntiga-linhaNova)==-1) && colunaAntiga == colunaNova){
            matriz[linhaAntiga][colunaAntiga] = '.';
            matriz[linhaNova][colunaNova] = 'E';
            return true;
        } else if(((colunaAntiga-colunaNova)==1 || (colunaAntiga-colunaNova)==-1) && linhaAntiga==linhaNova){
            matriz[linhaAntiga][colunaAntiga] = '.';
            matriz[linhaNova][colunaNova] = 'E';
            return true;
        }
        return false;
    }

    static boolean fimDeJogo(){
        return true;
    }

}