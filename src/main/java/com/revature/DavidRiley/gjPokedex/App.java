package com.revature.DavidRiley.gjPokedex;

public class App {

    public static void main(String[] args){
        DexRepository dexRepository = new DexRepository("N_P.csv");
        DexService dexService = new DexService(dexRepository);
        DexServer dexServer = new DexServer(dexService);
    }
}
