
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseReadOnlyException;
import java.util.ArrayList;

public class Conexion {
   
    private ObjectContainer oc;
    private void open(){
        this.oc=Db4o.openFile("database.yap");
    }
    public boolean Insertar (Persona objeto){
        try{
            this.open();
            oc.set(objeto);
            this.oc.close();
            return true;
        } catch(Exception e){
            System.out.println("bdoo.Controador.InsertarPersona(): "+e);
            return false;
        }
    }
      public void editar(Persona persona, Persona editar) {
        open();
        Persona pers = new Persona(editar.getNOMBRE(), editar.getAPELLIDO(), editar.getID());
        ObjectSet result = oc.get(pers);
        Persona per = (Persona) result.next();
        per.setNOMBRE(persona.getNOMBRE());
        per.setAPELLIDO(persona.getAPELLIDO());
        per.setID(persona.getID());
        oc.set(per);
        oc.close();
    }
    
    public void eliminar(Persona editar){
    open();
        Persona pers = new Persona(editar.getNOMBRE(), editar.getAPELLIDO(), editar.getID());
        ObjectSet result = oc.get(pers);
        Persona per = (Persona) result.next();
        oc.delete(per);
        oc.close();
    }
   
    public Persona buscarPersona (Persona objeto){
        this.open();
        Persona encontrado=null;
        ObjectSet resultados = this.oc.get(objeto);
                if(resultados.hasNext()){
                    encontrado = (Persona) resultados.next();
                }
                this.oc.close();
                return encontrado;
    }
   public ArrayList<Persona> consultarListaPersonas() {
        Persona p = new Persona(null, null, null);
        String lista[] = new String[3];
        ArrayList<Persona> per = new ArrayList<Persona>();
        open();
        ObjectSet result = oc.get(p);
        while (result.hasNext()) {
            per.add((Persona) result.next());
        }
        oc.close();
        return per;
    }
    
    
    
    
}
