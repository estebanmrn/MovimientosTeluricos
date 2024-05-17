
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
    // Crear un departamento
    Departamento departamento1 = new Departamento("NORTE DE SANTANDER");
    Departamento departamento2 = new Departamento("SANTANDER");
    // Crear varios municipios
    Municipio municipio1 = new Municipio("CUCUTA", departamento1);
    Municipio municipio2 = new Municipio("LOS PATIOS", departamento1);
    Municipio municipio3 = new Municipio("BUCARAMANGA", departamento2);
    // Crear victimas 
    Victima victima1 = new Victima("arturo", municipio1);
    Victima victima2 = new Victima("pepe", municipio1);
    Victima victima3 = new Victima("julian", municipio3);

    // Crear un sismo con las víctimas en los municipios afectados
    Sismo sismo1 = new Sismo(municipio1, 5.0, 10.0, new Fecha(1, 1, 2022), "12:00", "1 hora");
    Sismo sismo2 = new Sismo(municipio3, 6.0, 70.0, new Fecha(1, 1, 2022), "12:00", "1 hora");
    
    //agregar cada victima a su respectivo sismo
    sismo1.agregarVictima(victima1);
    sismo1.agregarVictima(victima2);
    
    //agregar cada municipio a su respectivo sismo 
    sismo1.agregarMunicipio(municipio1);
    sismo1.agregarMunicipio(municipio3);

    // Mostrar los municipios afectados por departamento
    sismo1.mostrarMunicipiosAfectadosPorDepartamento();
    
    //mostrarinfosismos
    sismo1.mostrarInfoSismo();
    sismo1.calcularMagnitud();
    sismo1.registrarTipoSismo();
    
    sismo2.mostrarInfoSismo();
    sismo2.calcularMagnitud();
    sismo2.registrarTipoSismo();
    
    

   

}
}

