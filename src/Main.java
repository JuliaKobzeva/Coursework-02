
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] bookNames = {"Три товарища","Два капитана"};
        String[] authorNames = {"Э.М.Ремарк","В.А.Каверин"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bookNames.length; i++) {
            sb.append("<<");
            sb.append(bookNames[i]);
            sb.append(">> ");
            sb.append(authorNames[i] + "\n");
        }
        System.out.println(sb.toString());



    }
}