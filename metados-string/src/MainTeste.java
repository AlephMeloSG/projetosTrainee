public class MainTeste {
    public static void main(String[] args) {
        String texto;

        texto = "    The Touhou Project (Japanese: 東方Project, Hepburn: Tōhō Purojekuto)," +
                " also known simply as Touhou (東方, literally \"Eastern\" or \"Oriental\")," +
                " is a bullet hell shoot 'em up video game series created by one-man" +
                " independent Japanese doujin soft developer Team Shanghai Alice. Since 1995," +
                "[1][2] the team's member, Jun'ya \"ZUN\" Ōta, has independently developed" +
                " programming, graphics, writing, and music for the series, self-publishing" +
                " 18 mainline games and five spin-offs as of May 2021. ZUN has also produced" +
                " related print works and music albums, and collaborated with developer" +
                " Twilight Frontier on seven official Touhou spin-offs, most being fighting" +
                " games.[3]\n" +
                "\n" +
                "The Touhou Project is set in Gensokyo,[a] a land sealed from the outside" +
                " world and primarily inhabited by humans and yōkai, legendary creatures " +
                "from Japanese folklore that are personified in Touhou as bishōjo in an " +
                "anthropomorphic moe style. Reimu Hakurei, the miko of the Hakurei Shrine " +
                "and the main character of the series, is often tasked with resolving " +
                "supernatural \"incidents\" caused in and around Gensokyo.     ";


        int tamanho = texto.length();
        String textoMinusculo = texto.toLowerCase();
        String textoMaiusculo = texto.toUpperCase();
        String textoSemEspacosFinalInicial = texto.trim();
        texto = texto.trim();

        String textoUltimoCaracter = texto.substring(texto.length() - 1);
        String textoAltera = texto.replace("Touhou", "(--ALGO--)");
        char textoUmCaracter = texto.charAt(5);
        int textoIndex = texto.indexOf("Reimu");
        boolean textoVazio = texto.isEmpty();
        boolean textoContem = texto.contains("Touhou");

    }
}
