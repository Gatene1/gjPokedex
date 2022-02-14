package com.revature.DavidRiley.gjPokedex;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DexRepository {
    private List<String> pocketMonsters;
    private InputStream file;
    public List<String> pocketMonsters() {
        return pocketMonsters;
    }

    public DexRepository(String fileName){
        this.pocketMonsters = new ArrayList<>();
        // this.file = new File("src/main/resources/" + fileName);
        this.file = getClass().getClassLoader().getResourceAsStream(fileName);
        // this.file = getClass().getClassLoader().getResourceAsStream(fileName);
        load();
    }

    private void load() {
        Scanner scanner = null;
        scanner = new Scanner(this.file);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            this.pocketMonsters.add(scanner.next());
        }
    }

    public List<String> getPocketMonsters() {
        return pocketMonsters;
    }
}
