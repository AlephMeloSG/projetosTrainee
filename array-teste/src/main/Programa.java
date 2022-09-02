package main;

import modelo.ArrayFunctions;

public class Programa {
    public static void main(String[] args) {

        ArrayFunctions arrayFunctions = new ArrayFunctions(6);

        arrayFunctions.arrayAdd("aqua");
        arrayFunctions.arrayAdd(false);
        arrayFunctions.arrayAdd(199.1);
        arrayFunctions.arrayAdd(99999999999999.99);
        arrayFunctions.arrayAdd(arrayFunctions);

        arrayFunctions.imprimirArray();

    }
}
