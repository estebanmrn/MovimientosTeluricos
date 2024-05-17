import java.util.ArrayList;


public class Municipio
{
    private String nombre;
    private Departamento departamento;
    private ArrayList <Victima> victimasM;
    private ArrayList <Sismo> sismos;
    

    public Municipio (String nombre, Departamento departamento){
        this.nombre = nombre; 
        this.departamento = departamento;
        this.victimasM = new ArrayList<>();
        this.sismos = new ArrayList <>();
        departamento.agregarMunicipio (this);
        

    }
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Victima> getVictimasM() {
        return victimasM;
    }

    public void agregarVictima(Victima victima) {
        victimasM.add(victima);
    }
    
    public ArrayList <Sismo> getSismos(){
        return sismos;
    }
    
     public void agregarSismo(Sismo sismo) {
        sismos.add(sismo);
    }
    
      public Departamento getDepartamento() {
        return departamento;
    }

}
