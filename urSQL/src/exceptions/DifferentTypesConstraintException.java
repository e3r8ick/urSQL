/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Maikol
 */
public class DifferentTypesConstraintException extends Exception {

    public DifferentTypesConstraintException() {
        super ("ERROR: Los tipos de datos que se quieren referenciar no son compatibles");
    }
    
}
