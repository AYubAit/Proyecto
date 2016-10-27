package proyecto;

import java.util.Scanner;

public class Proyecto {

    public static void main(String[] args) {

        // TODO code application logic here
        
        
        int opcio;
        boolean omplit = false;

        Scanner ent = new Scanner(System.in);

        do {

            System.out.println("Introduix una dels seguents Opcions:\n \n 1. Afegir Alumne \n 2. Editar Alumne \n 3. Llistar  \n 4. Borrar Alumne  \n 5. About \n6. Sortir");
            opcio = ent.nextLine().charAt(0);
            
            
            
            
            
            
            

            switch (opcio) {
                case 1:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE AFEGIR ALUMNE");
                    
                    break;
                case 2:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE EDITAR");
                    break;
                case 3:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE LLISTAR");
                    break;
                case 4:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE BORRAR");
                    break;
                case 5:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE ABOUT");
                    break;
                case 6:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE SORTIR");
                    

                    break;
                default:
                    System.out.println("Perfavor Introdueix una de les OPCIONS  ");
            }
            if (opcio==6) break;

        } while (true);
    }

}
