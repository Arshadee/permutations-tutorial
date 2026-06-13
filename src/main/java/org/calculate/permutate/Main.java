package org.calculate.permutate;
/**
 * Main Application Class of Permuation generator
 *
 */
public class Main
{
    public static final String EMPTY_STRING = "";

    public static void main(String[] args) {

//              StaticInput staticInput = new StaticInput();
//              staticInput.run();

        UserInput userInput = new UserInput();
        userInput.run(args);


    }
}