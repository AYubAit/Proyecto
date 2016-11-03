package proyecto;

import java.util.Scanner;

public class Proyecto {

    public static void main(String[] args) {

        // TODO code application logic here
        int opcio, nota1, nota2, mp, ms, mostrar;
        boolean omplit = false, estat;
        String nom, nomCicle ;

        Scanner ent = new Scanner(System.in);

        do {

            System.out.println("\n  Introduix una dels seguents Opcions:\n \n 1. Afegir Alumne \n 2. Editar Alumne \n 3. Llistar  \n 4. Borrar Alumne  \n 5. About \n 6. Sortir\n\n\n");
            opcio = ent.nextInt();

            switch (opcio) {
                case 1:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE AFEGIR ALUMNE\n\n\n");
                    System.out.println("___________________________________________");
                    System.out.println("___________________________________________");
                    if (omplit==false) {

                        System.out.print("Introdueix Nom de Alumne: \n");
                        nom = ent.skip("[\r\n]*").nextLine();

                        System.out.print("Introdueix Nom de Cicle:\n ");
                        nomCicle = ent.skip("[\r\n]*").nextLine();

                        System.out.print("Introdueix Numero de moduls Aprovats: \n");
                        mp = ent.nextInt();
                        
                        System.out.print("Introdueix la Nota mes alta de moduls Aprovats: \n");
                        nota1 = ent.nextInt();

                        System.out.print("Introdueix Numero del Moduls Suspesos: \n");
                        ms = ent.nextInt();
                        
                        System.out.print("Introdueix la Nota mes Baixa de moduls Suspesos :\n" );
                        nota2 = ent.nextInt();
                        System.out.println("\n");
                        System.out.println("___________________________________________");
                        System.out.println("___________________________________________");
                        
                        omplit = true;
                    } else{
                        System.out.println("Ja tens Dades Introduides\n");
                        System.out.println("Vols Mostrar o Llistar Les Dades Guardades?( 1. Si \n 2- No ):\n");
                        mostrar = ent.nextInt();
                        if (mostrar == 1) {
                            System.out.println("Nom Alumne:" (+nom));
                        }
                    }
                    

                    break;
                case 2:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE EDITAR\n\n\n");
                    break;
                case 3:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE LLISTAR\n\n\n");
                    System.out.println("Nom de Alumne: "+ ( nom + "\n\n"));
                    
                    
                    
                    break;
                case 4:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE BORRAR\n\n\n");
                    break;
                case 5:
                    System.out.println("Aquest Programa Es Creat Per:\n");
                    System.out.println("Ayoub Ait \n Curs: 2016 - 2017 \n Cicle: 1r - Administració de Sistemes Informatics de Xarxes ");
                    System.out.println("___________________________________________");
                    break;
                case 6:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE SORTIR\n\n\n");

                    break;
                default:
                    System.out.println("Perfavor Introdueix una de les OPCIONS\n\n\n  ");
            }
           
            

        } while (opcio != 6);
    }

}
