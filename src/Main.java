
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] bookNames = {"Три товарища","Два капитана"};
        String[] authorNames = {"Э.М.Ремарк","В.А.Каверин"};

        for (int i = 0; i < bookNames.length; i++) {
            StringBuilder sb = new StringBuilder(bookNames[i]);
            StringBuilder sb2 = new StringBuilder(authorNames[i]);
            StringBuilder sb3 = sb.insert(0,"<<");
            StringBuilder sb4 = sb.append(">> " + sb2 + "а");
            String book = sb4.toString();
            System.out.println(book);
        }

//        String[] result = Stream.of(bookNames,authorNames).flatMap(Stream::of).toArray(String[]::new);
//        System.out.println(Arrays.toString(result));

    }
}