
public class Main {
    public static void main (String[]args){
        Persona p = new Persona("Mario","Palma",1);
        Conexion c= new Conexion();
        
        System.out.println("Se guarda el objeto"+1);
    
        //boolean v=c.Insertar(p);
    Persona resultado=null;
    resultado=c.buscarPersona(p);
        System.out.println("La persona se llama: "+resultado.toString());
    }
            

}
