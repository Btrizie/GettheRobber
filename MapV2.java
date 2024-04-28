package Trabalho1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapV2 {
    //variáveis:
    private File myObj;
    private Scanner myReader;

    private String[] size;
    private int row, column, start;
    private int coordinatei, coordinatej;

    private char[][] matrix;
    private char pointer;
    private String builder;
    private int sumTotal;

    private final ArrayList <Integer> total = new ArrayList<>();

    public MapV2(String fileName) throws FileNotFoundException{
            //o txt deve ser recebido pela main, apenas teste por enqnt
            myObj = new File(fileName);
            myReader = new Scanner(myObj);

            //recebe o tamanho da matriz
            size = myReader.nextLine().split(" ");
            row = Integer.parseInt(size[0]);
            column = Integer.parseInt(size[1]);

            matrix = new char[row][column];
            pointer = ' ';
            builder = "";
            System.out.println(row + " " + column);
    }

    public void reader() {
        //transforma o txt em uma matrix
        int i = 0;
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            char[] arr = line.toCharArray();

            //preenche aa matriz
            for (int j = 0; j < column && j < arr.length; j++) {
                matrix[i][j] = arr[j];
            }
            i++;
        }

        //acha o início do matriz
        for (int m = 0; m < row; m++) {
            if (matrix[m][0] == '-') {
                start = m;
                break;
            }
        }
        coordinatei = start;
        coordinatej = 0;
    }

    //percorre a matriz
    public void processMatrix() {
        int direction = 1;
        while (pointer != '#') {
            pointer = matrix[coordinatei][coordinatej];
            switch (direction){
                //direção --> direita
                case 1 -> {
                    if(Character.isDigit(pointer)) {
                        builder(0, -1);
                    }
                    if (pointer == '\\') {
                        direction = 2;
                        coordinatei += 1;
                    } else if (pointer == '/') {
                        direction = -2;
                        coordinatei -= 1;
                    }
                    else {
                        coordinatej += direction;
                    }
                }
                //direção --> esquerda
                case -1 -> {
                    if(Character.isDigit(pointer)) {
                        builder(0, 1);
                    }
                    if(pointer == '\\'){
                        direction = -2;
                        coordinatei -= 1;
                    } else if (pointer == '/') {
                        direction = 2;
                        coordinatei += 1;
                    } else {
                        coordinatej += direction;
                    }
                }
                //direção --> baixo
                case 2 -> {
                    if(Character.isDigit(pointer)) {
                        builder(-1, 0);
                    }
                    if(pointer == '\\'){
                        direction = 1;
                        coordinatej += 1;
                    } else if (pointer == '/') {
                        direction = -1;
                        coordinatej -= 1;
                    } else {
                        coordinatei += direction-1;
                    }
                }
                //direção --> cima
                case -2 -> {
                    if(Character.isDigit(pointer)) {
                        builder(1, 0);
                    }
                    if(pointer == '\\'){
                        direction = -1;
                        coordinatej -= 1;
                    } else if (pointer == '/') {
                        direction = 1;
                        coordinatej += 1;
                    } else {
                        coordinatei += direction+1;
                    }
                }
            }
        }
        myReader.close();
    }
    
    //agrupa os numeros escritos em ordem ex: <--29-- / total.add(92);
    public void builder(int i, int j){
        //verifica se o character anterior é um digito 
        if(Character.isDigit(matrix[coordinatei + i][coordinatej + j])){
            builder += String.valueOf(pointer);
        }
        else{
            builder = String.valueOf(pointer);
        }

        //caso o próximo character não for um numero, considera o builder como pronto
        if(!Character.isDigit(matrix[coordinatei - i][coordinatej - j])){
            total.add(Integer.parseInt(builder));
        }
    }

    //retorna o total
    public void getTotal(){
        System.out.println("Total: " + sumTotal);
    }

    //faz a sumTotal da array "total" que contém os numeros lidos
    public void setTotal(){
        sumTotal = 0;
        for (Integer i : total) {
            sumTotal += i.intValue();
        }
    }
}
