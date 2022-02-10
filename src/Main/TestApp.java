package Main;

/**
 *
 * @author Adriana Rojas, Esteban Londoño, Felipe Munevar, Jeaniel Osorno, Maria
 * Kamila Mena, Mathias Labora
 */
public class TestApp {

    public static void main(String[] args) {
        String[] subRutines = new String[]{
            "MOV 5,R00",
            "MOV 10,R01",
            "JZ 7",
            "ADD R02,R01",
            "DEC R00",
            "JMP 3",
            "MOV R02,R42"

        };

        String finalResult = "";
        App app = new App(subRutines);
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        
        if (subRutines.length > 1024){
            System.out.println("ERROR: solo se aceptan hasta 1024 instrucciones.");
            return;
        }

        try {
            for (int i = 0; i <= subRutines.length; i++) {
                
                if (app.getSteps() > 50000) {
                    System.out.println(" ***** LÍMITE ALCANZADO *****");
                    System.out.println("El valor final de esto es: " + app.returnFinalValue());
                    break;
                }
                
                
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

            }
            
            finalResult = String.valueOf(app.returnFinalValue());
            System.out.println("El valor final de esto es: " + finalResult);
            System.out.println("Total pasos: " + app.getSteps());
            
        } catch (ArrayIndexOutOfBoundsException ex) {
            
            finalResult = String.valueOf(app.returnFinalValue());
            System.out.println("El valor final de esto es: " + finalResult);
            System.out.println("Total pasos: " + app.getSteps());
        }
        
        app.setResult(finalResult);
        String superFinalResult = app.getResult();
        
    }

}
