package functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Funcoes {
    public static boolean showInfo = false;
    public static boolean reWriteStringConnectionPG = true;
    public static String path = repeatString("../",countCurrentPath()) + "configFuncoes";

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

    public static BigDecimal inputBigDecimal(String texto) {
        BigDecimal valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextBigDecimal();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor não é um numero!");
            }
        }

        return valor;
    }
    public static BigDecimal inputBigDecimal(String texto, BigDecimal min) {
        BigDecimal valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextBigDecimal();
                if (valor.compareTo(min) < 0){
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
    public static BigDecimal inputBigDecimal(String texto, BigDecimal min, BigDecimal max) {
        BigDecimal valor;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(texto);
                valor = scanner.nextBigDecimal();
                if (valor.compareTo(min) < 0 || valor.compareTo(max) > 0) {
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
    public static String inputStr(String texto, String containsOrder) {
        String textoRetorno = null;
        while (true) {
            boolean containsAll = false;
            Scanner scanner = new Scanner(System.in);
            System.out.print(texto);
            textoRetorno = scanner.nextLine();
            if (textoRetorno.contains(containsOrder)) {
                return textoRetorno;
            }
        }
    }
    public static String inputStr(String texto, int maxChars) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String valor;
            System.out.print(texto);
            valor = scanner.nextLine();
            if (valor.length() <= maxChars){
                return valor;
            }
        }
    }
    public static String inputStr(String texto, int minChars, int maxChars) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String valor;
            System.out.print(texto);
            valor = scanner.nextLine();
            if (valor.length() <= maxChars && valor.length() >= minChars){
                return valor;
            }
            else {
                System.out.println("Minimo Characteres; " + minChars + " Maximo de Characteres: " + maxChars);
            }
        }
    }

    public static Date inputDate(String texto){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String valor;
            System.out.print(texto);
            valor = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try{
                simpleDateFormat.parse(valor);
                return simpleDateFormat.parse(valor);
            } catch (ParseException e) {
                System.out.println("Valor digitado não é uma data!");
            }
        }
    }
    public static LocalDate inputLocalDate(String texto){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String valor;
            System.out.print(texto);
            valor = scanner.nextLine();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try{
                simpleDateFormat.parse(valor);
                return LocalDate.parse(valor,dateTimeFormatter);
            } catch (ParseException e) {
                System.out.println("Valor digitado não é uma data!");
            }
        }
    }
    public static String dataAtual(String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(dateTimeFormatter);
    };
    public static String dataAtual(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(dateTimeFormatter);
    };
    public static String dataHoraAtual(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(dateTimeFormatter);
    };
    public static String stringDataFormat(String data, String format){
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
            System.out.println("Falha na formatacao");
            return data;
        }
    }
    public static String dataToStringFormat(LocalDateTime Date, String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return Date.format(dateTimeFormatter);
    }
    public static String dataToStringFormat(Instant Date, String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter.format(Date);
    }
    public static String dataToStringFormat(LocalDate Date, String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return Date.format(dateTimeFormatter);
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

    public static String duracao(LocalDateTime Data, LocalDateTime Data2){
        return Duration.between(Data,Data2).toString();
    }
    public static Long duracao(LocalDateTime Data, LocalDateTime Data2, String TypeReturn){
        switch (TypeReturn.toLowerCase()){
            case "d":{
                return Duration.between(Data,Data2).toDays();
            }
            case "h":{
                return Duration.between(Data,Data2).toHours();
            }
            case "ms":{
                return Duration.between(Data,Data2).toMillis();
            }
            case "m":{
                return Duration.between(Data,Data2).toMinutes();
            }
            case "n":{
                return Duration.between(Data,Data2).toNanos();
            }
        }
        System.out.println("Tipo Desconhecido!");
        return 0L;
    }
    public static String duracao(LocalDateTime Data, Instant Data2){
        return Duration.between(Data,Data2).toString();
    }
    public static Long duracao(LocalDateTime Data, Instant Data2, String TypeReturn){
        switch (TypeReturn.toLowerCase()){
            case "d":{
                return Duration.between(Data,Data2).toDays();
            }
            case "h":{
                return Duration.between(Data,Data2).toHours();
            }
            case "ms":{
                return Duration.between(Data,Data2).toMillis();
            }
            case "m":{
                return Duration.between(Data,Data2).toMinutes();
            }
            case "n":{
                return Duration.between(Data,Data2).toNanos();
            }
        }
        System.out.println("Tipo Desconhecido!");
        return 0L;
    }
    public static String duracao(LocalDateTime Data, LocalDate Data2){
        return Duration.between(Data,Data2).toString();
    }
    public static Long duracao(LocalDateTime Data, LocalDate Data2, String TypeReturn){
        switch (TypeReturn.toLowerCase()){
            case "d":{
                return Duration.between(Data,Data2).toDays();
            }
            case "h":{
                return Duration.between(Data,Data2).toHours();
            }
            case "ms":{
                return Duration.between(Data,Data2).toMillis();
            }
            case "m":{
                return Duration.between(Data,Data2).toMinutes();
            }
            case "n":{
                return Duration.between(Data,Data2).toNanos();
            }
        }
        System.out.println("Tipo Desconhecido!");
        return 0L;
    }
    public static String duracao(Instant Data, LocalDateTime Data2){
        return Duration.between(Data,Data2).toString();
    }
    public static Long duracao(Instant Data, LocalDateTime Data2, String TypeReturn){
        switch (TypeReturn.toLowerCase()){
            case "d":{
                return Duration.between(Data,Data2).toDays();
            }
            case "h":{
                return Duration.between(Data,Data2).toHours();
            }
            case "ms":{
                return Duration.between(Data,Data2).toMillis();
            }
            case "m":{
                return Duration.between(Data,Data2).toMinutes();
            }
            case "n":{
                return Duration.between(Data,Data2).toNanos();
            }
        }
        System.out.println("Tipo Desconhecido!");
        return 0L;
    }
    public static String duracao(LocalDate Data, LocalDateTime Data2){
        return Duration.between(Data,Data2).toString();
    }
    public static Long duracao(LocalDate Data, LocalDateTime Data2, String TypeReturn){
        switch (TypeReturn.toLowerCase()){
            case "d":{
                return Duration.between(Data,Data2).toDays();
            }
            case "h":{
                return Duration.between(Data,Data2).toHours();
            }
            case "ms":{
                return Duration.between(Data,Data2).toMillis();
            }
            case "m":{
                return Duration.between(Data,Data2).toMinutes();
            }
            case "n":{
                return Duration.between(Data,Data2).toNanos();
            }
        }
        System.out.println("Tipo Desconhecido!");
        return 0L;
    }
    public static String duracao(Instant Data, LocalDate Data2){
        return Duration.between(Data,Data2).toString();
    }
    public static Long duracao(Instant Data, LocalDate Data2, String TypeReturn){
        switch (TypeReturn.toLowerCase()){
            case "d":{
                return Duration.between(Data,Data2).toDays();
            }
            case "h":{
                return Duration.between(Data,Data2).toHours();
            }
            case "ms":{
                return Duration.between(Data,Data2).toMillis();
            }
            case "m":{
                return Duration.between(Data,Data2).toMinutes();
            }
            case "n":{
                return Duration.between(Data,Data2).toNanos();
            }
        }
        System.out.println("Tipo Desconhecido!");
        return 0L;
    }
    public static String duracao(LocalDate Data, Instant Data2){
        return Duration.between(Data,Data2).toString();
    }
    public static Long duracao(LocalDate Data, Instant Data2, String TypeReturn){
        switch (TypeReturn.toLowerCase()){
            case "d":{
                return Duration.between(Data,Data2).toDays();
            }
            case "h":{
                return Duration.between(Data,Data2).toHours();
            }
            case "ms":{
                return Duration.between(Data,Data2).toMillis();
            }
            case "m":{
                return Duration.between(Data,Data2).toMinutes();
            }
            case "n":{
                return Duration.between(Data,Data2).toNanos();
            }
        }
        System.out.println("Tipo Desconhecido!");
        return 0L;
    }


    public static void printTimes(String texto, int vezes){
        for (int i = 0; i < vezes; i++) {
            System.out.print(texto);
        }
        System.out.println();
    }

    public static  String repeatString(String texto, int vezes){
        String resultado = "";
        for (int i = 0; i < vezes; i++){
            resultado += texto;
        }
        return resultado;
    }


    public static int countCurrentPath(){
        if (contentSeparation(System.getProperty("user.dir"),"/").get(0).equals("home")) {
            return contentSeparation(System.getProperty("user.dir"), "/").size() - 2;
        }return contentSeparation(System.getProperty("user.dir"), "/").size();
    }
    public static boolean existFile(String file){
        File f = new File(file);
        if (!f.isFile()) {
            return false;
        }
        return true;
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
    public static boolean checkDirectory(String directory){
        File theDir = new File(directory);
        if (!theDir.exists()){
            return false;
        }
        return true;
    }
    public static void createDirectory(String directory){
        File theDir = new File(directory);
        if (!theDir.exists()){
            theDir.mkdir();
        }
    }

    public static String stringToHtml(String s) {
        StringBuilder out = new StringBuilder(Math.max(16, s.length()));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 127 || c == '"' || c == '\'' || c == '<' || c == '>' || c == '&') {
                out.append("&#");
                out.append((int) c);
                out.append(';');
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    public static List<Integer> hexToRgb(String hexColor){
        int r = Integer.valueOf(hexColor.substring(1, 3), 16);
        int g = Integer.valueOf(hexColor.substring(3, 5), 16);
        int b = Integer.valueOf(hexColor.substring(5, 7), 16);
        List<Integer> list = new ArrayList<>();
        list.add(r);
        list.add(g);
        list.add(b);
        return list;
    }

    public static String rgbToHex(int red, int green, int blue){
        return String.format("#%02x%02x%02x", red, green, blue);
    }

    public static void printWeb(String texto, PrintWriter printWriter){
        PrintWriter saida = printWriter;
        ArrayList<String> particao = contentSeparation(texto,"\n");
        particao.forEach(s -> saida.println(s + "<br>"));
    }

    public static int randomNumber(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public static double randomNumber(double min, double max) {
        return Math.floor(Math.random()*(max-min+1)+min);
    }

    public static String intToString(int numero) {
        return String.valueOf(numero);
    }
    public static String doubleToString(double numero) {
        return String.valueOf(numero);
    }
}