package proyecto;

import java.util.Scanner;

public class Proyecto {

    public static void main(String[] args) {

        // TODO code application logic here
        int opcio, nota1, nota2, mp, ms, mostrar, totm;
        boolean omplit = false, estat;
        String nom, nomCicle;
        String tecla = "sda";

        //inicio les variables per que me surt error per despues de cambien
        nom = "sdas";
        nomCicle = "dasda";
        mp = 0;
        ms = 0;
        nota1 = 0;
        nota2 = 0;

        Scanner ent = new Scanner(System.in);

        do {

            System.out.println("\n  Introduix una dels seguents Opcions:\n \n 1. Afegir Alumne \n 2. Editar Alumne \n 3. Llistar  \n 4. Borrar Alumne  \n 5. About \n 6. Sortir\n\n\n");
            opcio = ent.nextInt();

            switch (opcio) {
                case 1:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE AFEGIR ALUMNE\n\n");
                    System.out.println("___________________________________________");
                    System.out.println("___________________________________________");
                    if (omplit == false) {

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

                        System.out.print("Introdueix la Nota mes Baixa de moduls Suspesos :\n");
                        nota2 = ent.nextInt();
                        System.out.println("\n");
                        System.out.println("___________________________________________");
                        System.out.println("___________________________________________");

                        omplit = true;
                    } else {
                        System.out.println("Ja tens Dades Introduides\n");
                        System.out.println("Vols Mostrar o Llistar Les Dades Guardades?( 1.Si o 2.No ):\n");
                        mostrar = ent.nextInt();
                        switch (mostrar) {
                            case 1:
                                System.out.println("-------------------------------------------------------------------");
                                System.out.println("| Nom Alumne: " + (nom));
                                System.out.println("| Nom Curs: " + (nomCicle));
                                System.out.format(" | Numero de moduls Aprovats:  %s   i la nota Més alta: %s", mp, nota1);
                                System.out.format(" | Numero de moduls Suspesos:  %s   i la nota Més alta: %s", ms, nota2);
                                System.out.println("-------------------------------------------------------------------");
                                break;
                            default:
                                break;
                        }
                    }
                    System.out.println("Introdueix una Tecla per continuar.....");
                    tecla = ent.skip("[\r\n]*").nextLine();

                    break;
                case 2:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE EDITAR\n\n");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("| Nom Alumne: " + (nom));
                    System.out.println("| Introduix El Nom Editat: ");
                    nom = ent.skip("[\r\n]*").nextLine();
                    System.out.println("| Nom Curs: " + (nomCicle));
                    System.out.print("  | Introdueix Nom de Cicle Editat:\n ");
                    nomCicle = ent.skip("[\r\n]*").nextLine();
                    System.out.format(" | Numero de moduls Aprovats:  %s   i la nota Més alta: %s  \n", mp, nota1);
                    System.out.print(" |Introdueix Numero de moduls Aprovats:  i la nota més Alta \n");
                    mp = ent.nextInt();
                    nota1 = ent.nextInt();
                    System.out.format(" | Numero de moduls Suspesos:  %s   i la nota Més alta: %s", ms, nota2);
                    System.out.print(" | Introdueix Numero de moduls Supesos:  i la nota més baixa \n");
                    ms = ent.nextInt();
                    nota2 = ent.nextInt();
                    System.out.println("Introdueix una Tecla per continuar.....");
                    tecla = ent.skip("[\r\n]*").nextLine();

                    break;
                case 3:
                    totm = mp + ms;

                    System.out.println("HAS ESCOLLIT LA OPCIO DE LLISTAR\n\n");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("| Nom Alumne: " + (nom));
                    System.out.println("| Nom Curs: " + (nomCicle));
                    System.out.format(" | Numero de moduls Aprovats:  %s   i la nota Més alta: %s", mp, nota1);
                    System.out.format(" | Numero de moduls Suspesos:  %s   i la nota Més alta: %s\n", ms, nota2);

                    if (nota1 > nota2 && mp > ms) {
                        estat = true;
                        System.out.println("Estat Aprovat!!");
                    } else {
                        estat = false;
                        System.out.println("Estat Suspes!!");
                    }
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Introdueix una Tecla per continuar.....");

                    tecla = ent.skip("[\r\n]*").next();

                    break;
                case 4:
                    System.out.println("HAS ESCOLLIT LA OPCIO DE BORRAR\n\n\n");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("-------------- Ojo Esteu Segur de Borrar Tots els Registres? 1-Si o 2-No");
                    System.out.println("intodueix una opcio:");
                    mostrar = ent.nextInt();
                    switch (mostrar) {
                        case 1:
                            omplit = false;
                            System.out.println("----------------------------------");
                            System.out.println("| Nom Alumne: Borrat!! ");
                            System.out.println("| Nom Curs: Borrat!! ");
                            System.out.println("| Moduls aprovats i Nota: Borrats!! ");
                            System.out.println("| Moduls suspesos  i nota : Borrats!! ");
                            System.out.println("---------------Dades borrrades 100%!! ");
                            System.out.println("Introdueix una Tecla per continuar.....");
                            tecla = ent.skip("[\r\n]*").next();
                            break;
                        default:
                            break;
                    }

                    break;
                case 5:
                    System.out.println("----------------About------------------");
                    System.out.println("Aquest Programa Es Creat Per:\n");
                    System.out.println("Ayoub Ait \n Curs: 2016 - 2017 \n Cicle: 1r - Administració de Sistemes Informatics de Xarxes ");
                    System.out.println("___________________________________________");
                    System.out.println("Introdueix una Tecla per continuar.....");
                    tecla = ent.skip("[\r\n]*").next();
                    break;
                case 6:
                    System.out.println("\n\n-------HAS ESCOLLIT LA OPCIO DE SORTIR------");

                    break;
                default:
                    System.out.println(" !!! Perfavor Introdueix una de les OPCIONS !!!\n\n  ");
            }

        } while (opcio != 6);
    }

}
