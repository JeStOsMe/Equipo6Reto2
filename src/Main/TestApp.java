package Main;

/**
 *
 * @author Adriana Rojas, Esteban Londoño, Felipe Munevar, Jeaniel Osorno, Maria
 * Kamila Mena, Mathias Labora
 */
public class TestApp {

    public static void main(String[] args) {
        String[] subRutines = new String[]{
            "MOV 13,R00",
            "INV R00",
            "MOV 10,R01",
            "JZ 8",
            "ADD R02,R01",
            "DEC R00",
            "JMP 4",
            "MOV R02,R42"
        };

        App app = new App(subRutines);
        System.out.println("Welcome to Online IDE!! Happy Coding :)");

        try {
            for (int i = 0; i <= subRutines.length; i++) {

                if (i > subRutines.length) {
                    break;
                }

                if (subRutines[i].contains("JZ")) {
                    if (app.returnInitialValue() == 0) {
                        i = Integer.parseInt(subRutines[i].split(" ")[1]) - 2;
                        app.addSteps();
                        continue;
                    }
                    app.addSteps();
                    continue;
                }

                if (subRutines[i].contains("JMP")) {
                    i = Integer.parseInt(subRutines[i].split(" ")[1]) - 2;
                    app.addSteps();
                    continue;
                }

                app.readInstruction(subRutines[i]);
                app.addSteps();

                if (app.getSteps() > 50000) {
                    System.out.println(" ***** LÍMITE ALCANZADO *****");
                    System.out.println("El valor final de esto es: " + app.returnFinalValue());
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("El valor final de esto es: " + app.returnFinalValue());
            System.out.println("Total pasos: " + app.getSteps());
        }

    }

}
