
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseReadOnlyException;

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
      public Persona editar(Persona objeto){
    this.open();
    Persona encontrado =null;
    ObjectSet resultados = this.oc.get(objeto);
    
    if(resultados.hasNext()){
        encontrado=(Persona) resultados.next();
        encontrado.setNOMBRE("Diego");
        encontrado.setAPELLIDO("García");
        encontrado.setID(2);
    }
    this.oc.close();
    return encontrado;
    }
    
    public Persona eliminar(Persona objeto){
    this.open();
    Persona encontrado =null;
    
    ObjectSet resultados = this.oc.get(objeto);
    
    if(resultados.hasNext()){
        System.out.println(resultados.next());
    }
    
    this.oc.close();
    return encontrado;
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
   
    
    
    
    
}
