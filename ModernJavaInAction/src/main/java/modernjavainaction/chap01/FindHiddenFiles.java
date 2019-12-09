package modernjavainaction.chap01;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class FindHiddenFiles {

    public static void main(String[] args) {

        //Imperative programming
        File[] hiddenFilesOld = new File(".").listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        System.out.println("Using old Java => Count hidden files in current directory : "+hiddenFilesOld.length);
        for (File f:hiddenFilesOld) System.out.println(f);

        System.out.println("\n\n");

        //Functional Programming
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        System.out.println("Using Java 8+ => Count hidden files in current directory : "+hiddenFiles.length);
        Arrays.stream(hiddenFiles).forEach(System.out::println);


    }
}
