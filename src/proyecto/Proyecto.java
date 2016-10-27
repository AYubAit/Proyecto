package proyecto;

import java.util.Scanner;

public class Proyecto {

    public static void main(String[] args) {

        // TODO code application logic here
        
        
        int opcio, nota1, nota2;
        boolean omplit = false , estat;
        String nom, mp, ms;

        Scanner ent = new Scanner(System.in);

        do {

            System.out.println("Introduix una dels seguents Opcions:\n \n 1. Afegir Alumne \n 2. Editar Alumne \n 3. Llistar  \n 4. Borrar Alumne  \n 5. About \n 6. Sortir");
            opcio = ent.nextInt();
                                           
                               

            switch (opcio) {
                case 1:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE AFEGIR ALUMNE");
                    if (!omplit){
                        
                        System.out.print("Introdueix Nom de Alumne: ");
                        nom = ent.nextLine();
                        
                        System.out.print("Introdueix Nom del Moduls Aprovats: ");
                        mp = ent.nextLine();
                        
                        System.out.print("Introdueix la Nota de" + mp );
                        nota1 = ent.nextInt();
                        
                        System.out.print("Introdueix Nom del Moduls Suspes: ");
                        ms = ent.nextLine();
                        
                        System.out.print("Introdueix la Nota de" + ms);
                        nota2 = ent.nextInt();
                        
                        omplit=true;
                    }else {System.out.println("Ja tens Dades Introduides");}
                    
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
