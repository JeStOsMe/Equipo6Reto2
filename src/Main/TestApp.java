package Main;

/**
 *
 * @author Adriana Rojas, Esteban Londoño, Felipe Munevar, Jeaniel Osorno, Maria Kamila Mena, Mathias Labora 
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

        App app = new App(subRutines);
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        for (String rutine: subRutines){
            app.readInstruction(rutine);
            app.addSteps();
            
            if (app.getSteps() > 50000){
                System.out.println(" ***** LÍMITE ALCANZADO *****");
                System.out.println("El valor final de esto es: " + app.returnFinalValue());
                break;
            }
        }
        
        System.out.println("El valor final de esto es: " + app.returnFinalValue());
        
        
        
    }

}
