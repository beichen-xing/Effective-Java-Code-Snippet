import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class rule45 {
}

class Anagrams{

    public static void main(String[] args) throws IOException {
        /*
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        Map<String, Set<String>> groups = new HashMap<>();

        try(Scanner s = new Scanner(dictionary)){
            while (s.hasNext()){
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }

        for(Set<String> group : groups.values()){
            if(group.size() >= minGroupSize)
                System.out.println(group.size());
        }

         */
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        try(Stream<String> words = Files.lines(dictionary)){
            words.collect(groupingBy(word -> alphabetize(word))).values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(g -> System.out.println(g.size()));
        }

    }

    private static String alphabetize(String s){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

}
