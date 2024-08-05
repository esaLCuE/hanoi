import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void afficherTableau(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tableau[i][j] + " ");
            }
            System.out.println();
        }
    }

    static char [][] tableau = new char[3][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ori;
        int dest;
        char depl='A';
        boolean oriImp;
        boolean destImp;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableau[i][j] = '-';
            }
        }
        tableau[2][0] = 'G';
        tableau[1][0] = 'M';
        tableau[0][0] = 'P';
        afficherTableau();

        while ( (tableau[2][2] != 'G') || (tableau[1][2] != 'M') || (tableau[0][2] != 'P')) {
            ori = 4;
            dest = 4;
            oriImp = true;
            destImp = true;
            while (oriImp) {
                while (ori != 0 && ori != 1 && ori != 2) {
                    System.out.println("Choisir pile d'origine (1, 2 ou 3)");
                    ori = sc.nextInt()-1;
                }
                if (tableau[0][ori] =='P') {
                    depl = tableau[0][ori];
                    tableau[0][ori] = '-';
                    oriImp = false;
                } else if (tableau[1][ori] =='P' || tableau[1][ori] =='M') {
                    depl = tableau[1][ori];
                    tableau[1][ori] = '-';
                    oriImp = false;
                } else if (tableau[2][ori] =='P' || tableau[2][ori] =='M' || tableau[2][ori] =='G') {
                    depl = tableau[2][ori];
                    tableau[2][ori] = '-';
                    oriImp = false;
                } else {
                    System.out.println("Erreur : colonne vide.");
                    ori = 4;
                }

            }
            System.out.println("Vous transportez un disque de taille "+ depl);
            afficherTableau();
            while (destImp) {
                while (dest != 0 && dest != 1 && dest != 2) {
                    System.out.println("Choisir pile d'arrivée (1, 2 ou 3)");
                    dest = sc.nextInt()-1;
                }
                if (tableau[2][dest] == '-'){
                    tableau[2][dest] = depl;
                    destImp = false;
                } else if (tableau[1][dest] == '-' && ((tableau[2][dest]) == 'G' || depl =='P' ) ){
                    tableau[1][dest] = depl;
                    destImp = false;
                } else if (tableau[0][dest] == '-' && depl == 'P'){
                    tableau[0][dest] = depl;
                    destImp = false;
                } else {
                    System.out.println("Déplacement impossible sur cette colonne");
                    dest = 4;
                }
            }
            afficherTableau();
        }
        System.out.println("Gg mon reuf");
    }
}