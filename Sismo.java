import java.util.ArrayList;


public class Sismo
{
    private Municipio epicentro;
    private double profundidad;
    private double magnitud;
    private Fecha fecha;
    private String hora;
    private String duracion;
    private ArrayList <Victima> victimas;
    private ArrayList <Municipio> municipios;
    private ArrayList <Departamento> departamentos;
    
    
    public Sismo(Municipio epicentro, double magnitud, double profundidad, Fecha fecha, String hora,
                 String duracion) {
        this.epicentro = epicentro;
        this.magnitud = magnitud;
        this.profundidad = profundidad;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.victimas = new ArrayList<>();
        this.municipios = new ArrayList<>();
        this.departamentos = new ArrayList <>();
        epicentro.agregarSismo(this);
    }
    public ArrayList<Victima> getVictimas() {
        return victimas;
    }
    
    public void agregarVictima(Victima victima){
        victimas.add(victima);
    }
    
    public ArrayList<Municipio> getMunicipios(){
        return municipios;
    }
    
    public void agregarMunicipio(Municipio municipio){
        municipios.add(municipio);
    }
    
    public Municipio getEpicentro() {
        return epicentro;
    }

    public void setEpicentro(Municipio epicentro) {
        this.epicentro = epicentro;
    }

    public double getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    
     public void calcularMagnitud(){
        TipoSismo tipo;
        Daño daño = new Daño(null,null);
        if(this.magnitud >=1.0 && this.magnitud <=1.9){
            System.out.println("el sismo no tiene ni un tipo de magnitud ni un daño marcado");
        }else if( this.magnitud >= 2.0 && this.magnitud <= 2.9){
            tipo = TipoSismo.MICRO;
            daño.setDetalle("No son perceptibles");
            System.out.println("el tipo de magnitud es " +tipo + " y sus daños " + daño.getDetalle());
       }else if(this.magnitud >= 3.0 && this.magnitud <= 3.9){
            tipo = TipoSismo.MENOR;
            daño.setDetalle("Perceptibles con poco movimiento y sin daño.");
            System.out.println("el tipo del magnitud es " +tipo + " y sus daños " + daño.getDetalle());
        }else if(this.magnitud >= 4.0 && this.magnitud <= 4.9){
            tipo = TipoSismo.LIGERA;
            daño.setDetalle("Perceptibles con movimiento de objetos y rara vez produce daño.");
            System.out.println("el tipo del magnitud es " +tipo + " y sus daños " + daño.getDetalle());
        }else if(this.magnitud >= 5.0 && this.magnitud <= 5.9){
            tipo = TipoSismo.MODERADA;
            daño.setDetalle("Puede causar daños mayores en construcciones débiles o mal construidas. ");
            System.out.println("el tipo del magnitud es " +tipo + " y sus daños " + daño.getDetalle());
        }else if(this.magnitud >= 6.0 && this.magnitud <= 6.9){
            tipo = TipoSismo.FUERTE;
            daño.setDetalle("Pueden ser destructivos. ");
            System.out.println("el tipo del magnitud es " +tipo + " y sus daños " + daño.getDetalle());
        }else if(this.magnitud >= 7.0 && this.magnitud <= 7.9){
            tipo = TipoSismo.MAYOR;
            daño.setDetalle("Pueden ser destructivos en zonas extensas. ");
            System.out.println("el tipo del magnitud es " +tipo + " y sus daños " + daño.getDetalle());
        }else if(this.magnitud >= 8.0 && this.magnitud <= 9.9){
            tipo = TipoSismo.GRANDE;
            daño.setDetalle("Catastróficos, provocando destrucción total en zonas cercanas al epicentro ");
            System.out.println("el tipo del magnitud es " +tipo + " y sus daños " + daño.getDetalle());
        }else if(this.magnitud >= 10.0){
            tipo = TipoSismo.EPICA;
            daño.setDetalle("Jamás registrado, puede generar una extinción local. ");
            System.out.println("el tipo del magnitud es " +tipo + " y sus daños " + daño.getDetalle());
        }else {
            tipo = TipoSismo.EPICA;
            daño.setDetalle("Jamás registrado, puede generar una extinción local. ");
            System.out.println("el tipo del magnitud es " +tipo + " y sus daños " + daño.getDetalle());            
        }
    }
    
    public void registrarTipoSismo(){
        TipoProfundidad tipoP;
        if(this.profundidad < 0){
            System.out.println("dato erroneo");
        }else if(this.profundidad >= 0.1 && this.profundidad <= 69.9){
            tipoP = TipoProfundidad.SUPERFICIAL;
            System.out.println("el tipo de sismo es " + tipoP);
        }else if(this.profundidad >=70.0 && this.profundidad <= 300.0){
            tipoP= TipoProfundidad.INTERMEDIO;
            System.out.println("el tipo de sismo es " + tipoP);
        }else if (this.profundidad > 300.0){
            tipoP= TipoProfundidad.PROFUNDO;
            System.out.println("el tipo de sismo es " + tipoP);
        }
    }
    
     public void mostrarMunicipiosAfectadosPorDepartamento() {
         
        for (Victima victima : victimas) {
        Municipio municipio = victima.getMunicipio();
        if (!municipios.contains(municipio)) {
            municipios.add(municipio);
        }
    }

    // Iterar sobre los municipios afectados para mostrarlos
    for (Municipio municipio : municipios) {
        System.out.println("Municipio: " + municipio.getNombre() + " (" + municipio.getDepartamento().getNombre() + ")");
        System.out.println("Víctimas afectadas:");
        ArrayList<Victima> victimasUnicas = new ArrayList<>();
        for (Victima victima : municipio.getVictimasM()) {
             if (!victimasUnicas.contains(victima)) {
                    victimasUnicas.add(victima);
                }
        } 
        for (Victima victima : victimasUnicas) {
                System.out.println("  - " + victima.getDetalle());
        }
        
    }

}
    public void mostrarInfoSismo(){
        System.out.println("**************************************************************************************************");
        System.out.println("el epicentro del sismo fue: " + epicentro.getNombre() +
                         "\nla magnitud del sismo fue: " + this.magnitud + 
                         "\nla profundidad del sismo fue: " + this.profundidad +
                         "\nla fecha del sismo fue: " + this.fecha +
                         "\nla hora del sismo fue: " + this.hora +
                         "\nla duracion del sismo fue: "+ this.duracion);
                                
    }
    
    
}

    
    

