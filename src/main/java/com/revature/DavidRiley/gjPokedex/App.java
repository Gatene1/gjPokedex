package com.revature.DavidRiley.gjPokedex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.lang.Object;

public class App extends javax.swing.JPanel {
    private boolean debugging = false;
    private InputStream pokedexFile;
    private Object[][] pokedexEntries = new String[2000][13];
    // This array is a multidimensional array to hold all of the Pokedex table data.

    public static void main(String[] args) {
        Charset.forName("UTF-8");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame pokedexFrame = new JFrame("com.revature.DavidRiley.gjPokedex");
        pokedexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Creating and setting up the window.

        App pokedexPane = new App();
        pokedexPane.setOpaque(true);
        // Content must be Opaque.
        pokedexFrame.setContentPane(pokedexPane);
        // Creating and setting up the content pane for the window.

        pokedexFrame.pack();
        pokedexFrame.setVisible(true);
        // Displaying the window.
    }

    public App() {
        initComponents();
    }

    private void initComponents() {
        this.pokedexFile = getClass().getClassLoader().getResourceAsStream("N_P.csv");
        LoadFile();
        // Assigns the file variable to the CSV file with the pokedex entries in it, and calls the method to
        // load the array with the entry.

        String[] pokedexTableColumns = {"Number", "Name", "Type1", "Type2", "HP", "Atk", "Def", "SpAtk", "SpDef", "Spd",
                "Species", "Height", "Weight"};
        // Creating the Headers for each column in the table.

        JTable pokemonTable = new JTable(this.pokedexEntries, pokedexTableColumns);
        pokemonTable.setPreferredScrollableViewportSize(new Dimension(1500, 210));
        pokemonTable.setFillsViewportHeight(true);
        pokemonTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));


            pokemonTable.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                        String[] pokemonDataArray = new String[13];
                        int selectedRow = pokemonTable.getSelectedRow();
                        pokemonDataArray[0] = pokemonTable.getValueAt(selectedRow, 0).toString();
                        pokemonDataArray[1] = pokemonTable.getValueAt(selectedRow, 1).toString();
                        pokemonDataArray[2] = pokemonTable.getValueAt(selectedRow, 2).toString();
                        pokemonDataArray[3] = pokemonTable.getValueAt(selectedRow, 3).toString();
                        pokemonDataArray[4] = pokemonTable.getValueAt(selectedRow, 4).toString();
                        pokemonDataArray[5] = pokemonTable.getValueAt(selectedRow, 5).toString();
                        pokemonDataArray[6] = pokemonTable.getValueAt(selectedRow, 6).toString();
                        pokemonDataArray[7] = pokemonTable.getValueAt(selectedRow, 7).toString();
                        pokemonDataArray[8] = pokemonTable.getValueAt(selectedRow, 8).toString();
                        pokemonDataArray[9] = pokemonTable.getValueAt(selectedRow, 9).toString();
                        pokemonDataArray[10] = pokemonTable.getValueAt(selectedRow, 10).toString();
                        pokemonDataArray[11] = pokemonTable.getValueAt(selectedRow, 11).toString();
                        pokemonDataArray[12] = pokemonTable.getValueAt(selectedRow, 12).toString();
                        DexRepository dexRepository = new DexRepository("N_P.csv");
                        // The whole indented code above is to store the values of each column in the selected
                        // row on the pokemonTable.
                    DexService dexService = new DexService(dexRepository, pokemonDataArray);
                    DexServer dexServer = new DexServer(dexService);
                }
            });

        JScrollPane scrollPane = new JScrollPane(pokemonTable);
        // Creating the scroll pane and adding the table to it.

        add(scrollPane);
        // Adding the scroll pane to the panel.
    }

    private void LoadFile() {
        // This method is going to be used to load each of the Pokedex entries for each Pokemon into a multidimensional
        // Array that will then be fed into the Pokedex table.
        Scanner fileScanner = null;
        fileScanner = new Scanner(this.pokedexFile);
        fileScanner.useDelimiter("\n");
        String entry;
        // This int variable keeps track of the modulus of currCol % 12.

        int currRow = 0;
        int currCol = 0;
        String currStat = "";
        boolean hasSkippedIDColumn = false;
        boolean hasSkippedTotalColumn = false;
        // The top two variables above will keep track of which row and which column I am on when loading the array.
        // They start at 0, because the array elements start at 0. The String holds the concatenation of the individual
        // chars evaluated from the CSV file. The two booleans on the bottom tell me if the two columns
        // (ID and Total) have been skipped.

        while (fileScanner.hasNext()) {
            // If the current column isn't a factor of 12 (meaning if the row isn't completed) do below.
            // Though 13 columns are reported on this app, arrays are still zero-based.
            entry = fileScanner.next();

            if (entry.substring(0, 3).equals("ID,")){
                continue;
            }
            // If-statement that skips the header of the CSV file.

            for (int dexPointer = 0; dexPointer < entry.length(); dexPointer++) {
                if (currCol == 0 && !hasSkippedIDColumn) {
                    if (entry.substring(dexPointer, dexPointer + 1).equals(",")){
                        hasSkippedIDColumn = true;
                    }
                    continue;
                }

                if (currCol == 4 && !hasSkippedTotalColumn){
                    if (entry.substring(dexPointer, dexPointer + 1).equals(",")){
                        hasSkippedTotalColumn = true;
                    }
                    continue;
                }
                    if (dexPointer == entry.length() - 1) {
                        currStat = currStat + entry.substring(dexPointer, dexPointer + 1);
                        pokedexEntries[currRow][currCol] = currStat;
                        currStat = "";
                        currCol = 0;
                        currRow++;
                        hasSkippedIDColumn = false;
                        hasSkippedTotalColumn = false;
                        // if the column is 0 or 5, skip
                        break;
                    }
                    if (entry.substring(dexPointer, dexPointer + 1).equals(",")) {
                        //currStat = currStat + entry.substring(dexPointer, dexPointer + 1);
                        pokedexEntries[currRow][currCol] = currStat;
                        currStat = "";
                        currCol++;
                        if (currCol == 13) {
                            currCol = 0;
                            currRow++;
                            hasSkippedIDColumn = false;
                            hasSkippedTotalColumn = false;
                            break;
                        }
                    } else {
                        currStat = currStat + entry.substring(dexPointer, dexPointer + 1);
                    }
            }
        }
    }

    private void PrintDebugData(JTable table){
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();


    }
}
