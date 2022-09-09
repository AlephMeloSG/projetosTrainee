package functions;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.nio.BufferOverflowException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Funcoes {
    public static String paperRockScissors(String player1, String player2) {
        String resultado = "empate";
        player1 = player1.toLowerCase();
        player2 = player2.toLowerCase();

        if (player1.equals("pedra") && player2.equals("papel")) {
            resultado = "Jogador2 venceu";
        } else if (player1.equals("papel") && player2.equals("pedra")) {
            resultado = "Jogador1 venceu";
        } else if (player1.equals("pedra") && player2.equals("tesoura")) {
            resultado = "Jogador1 venceu";
        } else if (player1.equals("tesoura") && player2.equals("pedra")) {
            resultado = "Jogador2 venceu";
        } else if (player1.equals("tesoura") && player2.equals("papel")) {
            resultado = "Jogador1 venceu";
        } else if (player1.equals("papel") && player2.equals("tesoura")) {
            resultado = "Jogador2 venceu";
        }
        return resultado;
    }

    public static void delay(int milliseconds) {
        Date start = new Date();
        long startLong = start.getTime();

        while (true) {
            Date finish = new Date();
            long finishLong = finish.getTime();
            if (finishLong - startLong > milliseconds) {
                break;
            }
        }
    }

    public static String mes(int numeroMes) {
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

    public static int inputInt(String texto) {
        int valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            }
        }

        return valor;
    }
    public static int inputInt(String texto, int min) {
        int valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextInt();
                if (valor < min) {
                    throw new RuntimeException("Valor abaixo do permitido! mínimo: " + min);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }
    public static int inputInt(String texto, int min, int max) {
        int valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextInt();
                if (valor < min || valor > max) {
                    throw new RuntimeException("Valor não permitido! mínimo: " + min + " máximo: " + max);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }

    public static double inputDouble(String texto) {
        double valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            }
        }

        return valor;
    }
    public static double inputDouble(String texto, double min) {
        double valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextDouble();
                if (valor < min) {
                    throw new RuntimeException("Valor abaixo do permitido! mínimo: " + min);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }
    public static double inputDouble(String texto, double min, double max) {
        double valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextDouble();
                if (valor < min || valor > max) {
                    throw new RuntimeException("Valor não permitido! mínimo: " + min + "máximo: " + max);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }

    public static String inputStr(String texto) {
        System.out.print(texto);
        Scanner scanner = new Scanner(System.in);
        String valor;
        valor = scanner.nextLine();
        return valor;
    }
    public static String inputStr(String texto, String contains) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String valor;
            System.out.print(texto);
            valor = scanner.nextLine();
            if (valor.contains(contains)){
                return valor;
            }
        }
    }

    public static void printTimes(String texto, int vezes){
        for (int i = 0; i < vezes; i++) {
            System.out.print(texto);
        }
        System.out.println();
    }

    public static boolean existFile(String file){
        Scanner scanner;
        try {
            scanner = new Scanner(new File(file));
            return true;
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static String readFile(String file, String encode){
        Scanner scanner;
        String texto = "";
        try {
            scanner = new Scanner(new File(file),encode);
            while(scanner.hasNextLine()){
                texto += scanner.nextLine();
                texto += "\n";
            }

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return texto;
    }
    public static String readFile(String file){
        Scanner scanner;
        String linha;
        String texto = "";
        try {
            scanner = new Scanner(new File(file));
            while(scanner.hasNextLine()){
                texto += scanner.nextLine();
                texto += "\n";
            }

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return texto;
    }
    public static void reWriteFile(String file, String texto){
        // Socket s = new Socket();
        OutputStream outputStream;
        Writer writer;
        BufferedWriter bufferedWriter;
        try {
            outputStream = new FileOutputStream(file); // System.out; // s.getOutputStream();
            writer = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(texto);
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void addWriteFile(String file, String texto){
        String contentFile = readFile(file);
        contentFile += texto;
        reWriteFile(file,contentFile);
    }
    public static void addWriteFile(String file, String texto, String encode){
        String contentFile = readFile(file, encode);
        contentFile += texto;
        reWriteFile(file,contentFile);
    }
    public static String readKeyBoard(String textoTitulo){
        // Socket s = new Socket();
        InputStream fileInputStream; // System.in; // s.getInputStream();
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;

        OutputStream outputStream;
        Writer writer;
        BufferedWriter bufferedWriter;

        String linha;
        String texto = "";
        try {
            fileInputStream = System.in;
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            outputStream = System.out; // System.out; // s.getOutputStream();
            writer = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(writer);

            System.out.println(textoTitulo);
            linha = bufferedReader.readLine();
            while (linha != null && !linha.isEmpty()){
                bufferedWriter.write(linha);
                texto += linha;
                linha = bufferedReader.readLine();
                if (!linha.isEmpty()) {
                    texto += "\n";
                }
            }
            bufferedReader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return texto;
    }
    public static String readKeyBoard(){
        // Socket s = new Socket();
        InputStream fileInputStream; // System.in; // s.getInputStream();
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;

        OutputStream outputStream;
        Writer writer;
        BufferedWriter bufferedWriter;

        String linha;
        String texto = "";
        try {
            fileInputStream = System.in;
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            outputStream = System.out; // System.out; // s.getOutputStream();
            writer = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(writer);

            linha = bufferedReader.readLine();
            while (linha != null && !linha.isEmpty()){
                bufferedWriter.write(linha);
                texto += linha;
                linha = bufferedReader.readLine();
                if (!linha.isEmpty()) {
                    texto += "\n";
                }
            }
            bufferedReader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return texto;
    }
    public static void rePrintWriter(String file, String texto){
        // Socket s = new Socket();
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(file);
            // printWriter.write(texto); // nao vejo diferença entre "write" e "print"
            printWriter.print(texto);
            printWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String dataAtual(String format){
        SimpleDateFormat formato = new SimpleDateFormat(format);
        Date data = new Date();
      return formato.format(data);
    };
    public static String dataFormat(String data, String format){
        if (data.isEmpty()){
            return "Data nao informada";
        }
        if (!data.contains("/")){
            data = data.substring(0,2) + "/" + data.substring(2,4) + "/" + data.substring(4,8);
        }
        SimpleDateFormat formato = new SimpleDateFormat(format);
        try {
            return formato.format(formato.parse(data));

        }catch (ParseException e){
            System.out.println("Falha na conversão para data");
            return data;
        }
    }

    public static ArrayList<String> contentSeparation(String texto, String delimitador){
        Scanner scanner = new Scanner(texto);
        ArrayList<String>arrayList = new ArrayList<String>();
        if(!delimitador.equals("|")) {
            scanner.useDelimiter(delimitador);
        }else
            scanner.useDelimiter("\\"+"|");
        while (scanner.hasNext()){
            arrayList.add(scanner.next());
        }
        return arrayList;
    }
    public static ArrayList<String> contentSeparation(String texto, String delimitador, int min){
        Scanner scanner = new Scanner(texto);
        ArrayList<String>arrayList = new ArrayList<String>();
        if(!delimitador.equals("|")) {
            scanner.useDelimiter(delimitador);
        }else
            scanner.useDelimiter("\\"+"|");
        while (scanner.hasNext()){
            arrayList.add(scanner.next());
        }
        if (arrayList.size() < min){
            for(int i = arrayList.size(); i < min; i++){
                arrayList.add("");
            }
        }
        return arrayList;
    }
}
