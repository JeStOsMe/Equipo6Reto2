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
    
    public void readInstruction(String instruction){
        String[] command = instruction.split(" ");
        
        switch (command[0]) {
            case "MOV":
                int position1 = Integer.parseInt(params[0].substring(1));
                int position2 = Integer.parseInt(params[1].substring(1));
                this.copy(position1, position2);
                break;
            case "ADD":
                int position1 = Integer.parseInt(params[0].substring(1));
                int position2 = Integer.parseInt(params[1].substring(1));
                this.add(position1, position2);
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
    
    public void copy(int pos1, int pos2){
        System.out.println("MOV R" + pos1 + ",R" + pos2 + " => copia el valor del registro Rxx al registro Ryy");
    }
    
    public void move(int number, int pos){
        System.out.println("MOV " + number + ",R" + pos + " => copia la constante numérica d (especificada como un número decimal) al registro Rxx;");
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
