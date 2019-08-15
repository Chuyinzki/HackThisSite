package com.chuyinzki.hack;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;

public class ProgrammingLevelOne {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(unscramble("eensitni\n"
            + "aalirndc\n"
            + "qnomiue\n"
            + "leasnyt\n"
            + "vaaahlll\n"
            + "kcneich\n"
            + "clpeoi\n"
            + "lramiagy\n"
            + "thiezn\n"
            + "hrpmyu"));
    }

    public static String unscramble(String combined) throws IOException, URISyntaxException {
        String[] strings = stringSort(combined.split("\n"));

        String rawString = new String(Files.readAllBytes(Paths.get(ProgrammingLevelOne.class.getResource("/wordlist.txt").toURI())));
        String[] dict = rawString.split("\r\n");
        String[] sortedDict = stringSort(dict);

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < dict.length; i++)
            map.put(sortedDict[i], dict[i]);

        String[] ret = new String[strings.length];
        for(int i = 0; i < strings.length; i++)
            ret[i] = map.get(strings[i]);

        return String.join(",", ret);
    }

    private static String[] stringSort(String[] strings) {
        String[] ret = new String[strings.length];
        for(int i = 0; i < strings.length; i++) {
            char[] temp = strings[i].toCharArray();
            Arrays.sort(temp);
            ret[i] = new String(temp);
        }
        return ret;
    }
}
