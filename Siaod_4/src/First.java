import java.io.*;
import java.util.*;
public class First {
    public static void main(String[] args) throws IOException {
        Deque<String> dec = new LinkedList<>();
        Deque<String> answer = new LinkedList<>();
        File file = new File("C:\\Users\\WithLove\\IdeaProjects\\Siaod_4\\Books.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            dec.add(scanner.nextLine());
        }
        scanner.close();
        String min = dec.getFirst();
        int m = dec.size();
        for (int i = 0; i< m-1; i++) {
            Iterator iterator = dec.iterator();
            while (iterator.hasNext()) {
                String s = (String) iterator.next();
                if (s.compareTo(min) < 0)
                    min = s;
            }
            answer.addLast(min);
            dec.remove(min);
            min=dec.getFirst();

        }
        answer.addLast(min);
        System.out.println(answer);
        String temp = answer.getFirst();
        try (PrintWriter pw = new PrintWriter("C:\\Users\\WithLove\\IdeaProjects\\Siaod_4\\First.txt")) {
            for (int i=0;i<m;i++){
                Iterator iterator = answer.iterator();
                while (iterator.hasNext()) {
                    String s = (String) iterator.next();
                    pw.println(s + "\n");
                }
                answer.remove(temp);
            }
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }
}

