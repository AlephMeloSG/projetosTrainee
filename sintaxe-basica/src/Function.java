import java.util.Date;

public class Function {
    public static String paperRockScissors(String player1, String player2) {
        String resultado = "empate";
        player1 = player1.toLowerCase();
        player2 = player2.toLowerCase();

        if (player1.equals("pedra") && player2.equals("papel")){
            resultado = "Jogador2 venceu";
        }else if (player1.equals("papel") && player2.equals("pedra")){
            resultado = "Jogador1 venceu";
        }else if (player1.equals("pedra") && player2.equals("tesoura")){
            resultado = "Jogador1 venceu";
        }else if (player1.equals("tesoura") && player2.equals("pedra")){
            resultado = "Jogador2 venceu";
        }else if (player1.equals("tesoura") && player2.equals("papel")){
            resultado = "Jogador1 venceu";
        }else if (player1.equals("papel") && player2.equals("tesoura")){
            resultado = "Jogador2 venceu";
        }
        return resultado;
    }

    public static void delay(int milliseconds){
        Date start = new Date();
        long startLong = start.getTime();

        while (true){
            Date finish = new Date();
            long finishLong = finish.getTime();
            if(finishLong - startLong > milliseconds){
                break;
            }
        }
    }

    public static String mes(int numeroMes){
        String mesPalavra;
        switch (numeroMes) {
            case 1: {
                mesPalavra = "Janeiro";
                break;
            }
            case 2: {
                mesPalavra = "Fevereiro";
                break;
            }
            case 3: {
                mesPalavra = "Março";
                break;
            }
            case 4: {
                mesPalavra = "Abril";
                break;
            }
            case 5: {
                mesPalavra = "Maio";
                break;
            }
            case 6: {
                mesPalavra = "Junho";
                break;
            }
            case 7: {
                mesPalavra = "Julho";
                break;
            }
            case 8: {
                mesPalavra = "Agosto";
                break;
            }
            case 9: {
                mesPalavra = "Setembro";
                break;
            }
            case 10: {
                mesPalavra = "Outubro";
                break;
            }
            case 11: {
                mesPalavra = "Novembro";
                break;
            }
            case 12: {
                mesPalavra = "Dezembro";
                break;
            }
            default:
                mesPalavra = "Desconhecido..";
        }
        return mesPalavra;
    }

}
