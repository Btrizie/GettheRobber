package Trabalho1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String fileName, loop = " ";
        int count = 1;
        
    
        while (!loop.equals("a")) {
            System.out.printf("---Leitura[%d] de casos---\n", count);
            System.out.printf("Insira qual caso deseja verificar (ex: nome.txt): ");
            fileName = in.nextLine();
            /*MapV2 rdv2 = new MapV2(fileName);
            rdv2.reader();
            rdv2.processMatrix();
            rdv2.setTotal();
            rdv2.getTotal();*/

            MapV3 m3 = new MapV3(fileName);
            m3.read();
            m3.getTotal();

            System.out.printf("\nO que deseja fazer a seguir?\n  (a)sair\n  (b)verificar novamente\n");
            loop = in.nextLine();
            count++;
        }
        in.close();
    }
}
