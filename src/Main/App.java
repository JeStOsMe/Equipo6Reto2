/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Adriana Rojas, Esteban Londoño, Felipe Munevar, Jeaniel Osorno, Maria Kamila Mena, Mathias Labora 
 */
class App {
    
    private int[] CPU = new int[43];
    private String[] subRutines;
    private int steps = 0;
    
    public App(String[] subRutines){
        for (int i = 0; i <=42; i++){
            this.CPU[i] = 0;
        }
        
        this.subRutines = subRutines;
    }
    
    public void readInstruction(String instruction){
        String[] command = instruction.split(" ");
        String[] params = command[1].split(",");
        int intPosition1;
        String position1, position2;
        
        switch (command[0]) {
            case "MOV":
                position2 = (params[1]);
                System.out.println(params[0]);
                System.out.println(params[1]);
                
                if (params[0].contains("R")){
                    position1 = (params[0]);
                    this.copy(position1, position2);
                } else{
                    intPosition1 = Integer.parseInt(params[0]);
                    this.move(intPosition1, position2);
                }
                
                break;
                
            case "ADD":
                
                position1 = params[0];
                position2 = params[1];
                
                this.add(convert(position1), convert(position2));
                
                break;
                
            case "DEC":
                break;
            case "INC":
                break;
            case "INV":
                break;
            case "JMP":
                break;
            case "JZ":
                break;
            case "NOP":
                break;
        }  
    }
    
    public void addSteps(){
        this.steps++;
    }
    
    public int getSteps(){
        return this.steps;
    }
    
    //Imprime todos los elementos de la CPU
    public void print(){
        for (Object element: this.CPU){
            System.out.print(element + " - ");
        }
        System.out.println("");
    }
    
    //Convierte una posición en un número entero
    public int convert(String pos){
        return Integer.parseInt(pos.replace("R", "0"));
    }
    
    public void copy(String pos1, String pos2){
        System.out.println("MOV_copy R" + pos1 + ",R" + pos2 + " => copia el valor del registro Rxx al registro Ryy");
        
        this.CPU[convert(pos2)] = this.CPU[convert(pos1)];
        this.print();
    }
    
    //Recibe un entero number, y lo asigna en la posición pos
    public void move(int number, String pos){
        System.out.println("MOV " + number + ",R" + pos + " => copia la constante numérica d (especificada como un número decimal) al registro Rxx;");
        pos = pos.replace("R", "0");
        this.CPU[Integer.parseInt(pos)] = number;
       
        this.print();
        
    }
    
    //Recibe dos posiciones, suma sus valores, calcula el módulo con 2^32, y asigna el resultado a la posición 1
    public void add(int pos1, int pos2){
        System.out.println("ADD R" + pos1 + ",R" + pos2 + " => calcula (Rxx + Ryy) MOD 2^32 y almacena el resultado en el registro Rxx");
        
        CPU[pos1] = Integer.parseInt(String.valueOf(Math.round((CPU[pos1] + CPU[pos2]) % Math.pow(2, 32))));
        
        this.print();
    }
    
    public void decrement(int position){
        System.out.println("DEC Rxx → disminuye el valor de Rxx en 1. Si el valor del registro es 0, al disminuirlo se genera un desbordamiento y su resultado sería 232–1");
    }
    
    public void increment(int position){
        System.out.println("INC Rxx → aumenta el valor de Rxx en 1. Si el valor del registro es 232–1, al aumentarlo se genera un desbordamiento obteniendo por resultado 0");
    }
    
    public void invert(int position){
        System.out.println("INV Rxx → ejecuta una inversión bit a bit del registro Rxx (convierte 1 en 0 y 0 en 1)");
    }
    
    public void jump(int instruction){
        System.out.println("JMP d → salta incondicionalmente a la instrucción número d (basado en 1). Se garantiza que d es un número de instrucción válido");
    }
    
    
    public int returnFinalValue(){
        return this.CPU[42];
    }
    
    


}
