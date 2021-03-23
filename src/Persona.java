/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Persona {
    private String NOMBRE,APELLIDO;
    private int ID;

    public Persona(String NOMBRE, String APELLIDO, int ID) {
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Persona{" + "NOMBRE=" + NOMBRE + ", APELLIDO=" + APELLIDO + ", ID=" + ID + '}';
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
