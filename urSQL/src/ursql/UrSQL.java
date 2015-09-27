/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ursql;

import java.util.Arrays;
import java.util.List;
import objects.RuntimeDatabaseProcessor;
import objects.Schema;
import objects.SystemCatalog;
import objects.Table;
        
/**
 *
 * @author Erick
 */
public class UrSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
       Connection conn = new Connection();
       
       conn.startConnection();
              
       List<String> commands = Arrays.asList(   
                                                "CREATE DATABASE serpentario",
                                                "SET DATABASE serpentario",
                                                
                                                "CREATE TABLE serpiente AS (idSerpiente INTEGER NOT NULL, especie INTEGER NOT NULL, nombre VARCHAR NULL, nacimiento DATETIME NOT NULL, PRIMARY KEY (idSerpiente));",
                                                "INSERT INTO serpiente (idSerpiente,especie,nombre,nacimiento) VALUES (3,1,\"django\",\"14/8/1999 6:6:6\")",
                                                "INSERT INTO serpiente (idSerpiente,especie,nombre,nacimiento) VALUES (5,5,\"coco\",\"15/9/2000 3:3:3\")",
                                                "INSERT INTO serpiente (idSerpiente,especie,nombre,nacimiento) VALUES (4,5,\"beto\",\"15/1/1995 6:30:0\")",
                                                "INSERT INTO serpiente (idSerpiente,especie,nombre,nacimiento) VALUES (7,3,\"Lord Voldemort\",\"18/8/1998 6:30:0\")",
                                                "INSERT INTO serpiente (idSerpiente,especie,nombre,nacimiento) VALUES (8,2,\"cocori\",\"18/8/1998 6:30:0\")",
                                                
                                                "CREATE TABLE cocodrilo AS (idCocodrilo INTEGER NOT NULL, nombre VARCHAR NULL, nacimiento DATETIME NOT NULL, PRIMARY KEY (idCocodrilo));",
                                                "INSERT INTO cocodrilo (idCocodrilo,nombre,nacimiento) VALUES (20,\"juancho\",\"21/6/1985 0:0:0\")",
                                                "INSERT INTO cocodrilo (idCocodrilo,nombre,nacimiento) VALUES (21,\"marceline\",\"1/1/19980 0:0:0\")",
                                                
                                                "CREATE TABLE animal AS (idAnimal INTEGER NOT NULL, nombre VARCHAR NOT NULL, habitat VARCHAR NULL, PRIMARY KEY (idAnimal));",
                                                "INSERT INTO animal (idAnimal,nombre,habitat) VALUES (3,\"django\",\"desierto 1\")",
                                                "INSERT INTO animal (idAnimal,nombre,habitat) VALUES (5,\"coco\",\"desierto 2\")",
                                                "INSERT INTO animal (idAnimal,nombre,habitat) VALUES (4,\"beto\",\"desierto 2\")",
                                                "INSERT INTO animal (idAnimal,nombre,habitat) VALUES (7,\"Lord Voldemort\",\"cueva 1\")",
                                                "INSERT INTO animal (idAnimal,nombre,habitat) VALUES (20,\"juancho\",\"manglar 1\")",
                                                "INSERT INTO animal (idAnimal,nombre,habitat) VALUES (21,\"marceline\",\"manglar 1\")",
                                                
                                                /* visitantes del serpentario */
                                                "CREATE TABLE visitante AS (id INTEGER NOT NULL, nombre CHAR(20) NOT NULL, ingreso DECIMAL(15,2) NULL, nacimiento DATETIME NULL, animalfavorito INTEGER NULL, PRIMARY KEY (id));",
                                                "INSERT INTO visitante (id, nombre, ingreso, nacimiento, animalfavorito) VALUES (0,\"maikol\",100000000.25,\"15/1/1995 14:30:0\",3)",
                                                "INSERT INTO visitante (id, nombre, ingreso, nacimiento, animalfavorito) VALUES (1,\"alfonso\",100000.00,\"14/8/1999 6:00:0\",7)",
                                                "INSERT INTO visitante (id, nombre, animalfavorito) VALUES (2,\"joselyn\",20)",
                                                "INSERT INTO visitante (id, nombre, animalfavorito) VALUES (3,\"gloriana\",21)",
                                                
                                                "CREATE TABLE especie AS (idEspecie INTEGER NOT NULL, nombreComun VARCHAR NULL, familia VARCHAR NULL, PRIMARY KEY (idEspecie));",
                                                "INSERT INTO especie (idEspecie,nombreComun) VALUES (5,\"Boa Constrictor\")",
                                                "INSERT INTO especie (idEspecie,nombreComun) VALUES (1,\"Cascabel\")",
                                                "INSERT INTO especie (idEspecie,nombreComun) VALUES (3,\"Piton\")",
                                                
                                                "ALTER TABLE serpiente ADD CONSTRAINT FOREIGN KEY especie REFERENCES especie(idEspecie)",
                                                                                                
                                                "DISPLAY DATABASE serpentario",
                                                
                                                "SELECT * FROM serpiente",
                                                "SELECT * FROM cocodrilo",
                                                "SELECT * FROM animal",
                                                "SELECT * FROM visitante",
                                                "SELECT * FROM especie",
                                                
                                                "SELECT * FROM serpiente WHERE nacimiento < \"1/1/1999 0:0:0\"",
                                                "SELECT nombre, idSerpiente FROM serpiente WHERE nombre LIKE \"co\"",
                                                "SELECT nombre FROM serpiente WHERE nombre NOT \"co\"",
                                                
                                                "DELETE FROM serpiente WHERE nombre = \"cocori\"",
                                                
                                                "SELECT * FROM serpiente", 
                                                
                                                /* solamente los animales que están actualmente en el serpentario */
                                                "SELECT nombre FROM animal JOIN serpiente ON idAnimal = idSerpiente",
                                                
                                                "SELECT habitat, COUNT(habitat) FROM animal GROUP BY habitat",
                                                
                                                "SELECT name, idAnimal FROM animal JOIN visitante ON idAnimal = animalfavorito"
               
                                                );
       
       
       for (String comd : commands)
       {
           System.out.print("> ");
           System.out.println(comd);
           conn.executeCommand(comd);
           System.out.println("");
       }
       
    }
    
}
