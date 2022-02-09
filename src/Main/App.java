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
                /*position1 = Integer.parseInt(params[0].substring(1));
                position2 = Integer.parseInt(params[1].substring(1));
                this.add(position1, position2);
                */
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
        
        /*
        if(command[0].equalsIgnoreCase("MOV") || command[0].equalsIgnoreCase("ADD")){
            String[] params = command[1].split(",");
            if(params[0].startsWith("R")){
                int position1 = Integer.parseInt(params[0].substring(1));
                int position2 = Integer.parseInt(params[1].substring(1));
                if(command[0].equalsIgnoreCase("MOV")){
                    this.copy(position1, position2);
                } else {
                    this.add(position1, position2);
                }
            } else {
                int number = Integer.parseInt(params[0]);
                int position = Integer.parseInt(params[1].substring(1));
                this.move(number, position);
            }
        } else if(command[1].startsWith("R")) {
            if();
        }
     */   
    }
    
    public void print(){
        for (Object element: this.CPU){
            System.out.print(element + " - ");
        }
        System.out.println("");
    }
    
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
    
    public void add(int pos1, int pos2){
        System.out.println("ADD R" + pos1 + ",R" + pos2 + " => calcula (Rxx + Ryy) MOD 232 y almacena el resultado en el registro Rxx");
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
    
    
    //;
    //
    //JZ d → salta a la instrucción d (basado en 1) sólo si el registro R00 contiene 0;
    //NOP

}
