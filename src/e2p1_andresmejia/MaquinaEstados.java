//Andres Mejia
package e2p1_andresmejia;
import java.util.ArrayList;


public class MaquinaEstados {
    public ArrayList<String> estados=new ArrayList<>();
    public ArrayList<String> estados_aceptacion=new ArrayList<>();
    public ArrayList<String> aristas=new ArrayList<>();
    public String estado_actual;
    
    public MaquinaEstados(String estados, String aristas){
        this.estados=splitStr(estados,';');
        
        extractAcceptNodes();
        
        
        this.aristas=splitStr(aristas,';');
        for (int i = 0; i < this.aristas.size(); i++) {
            System.out.println(i+" "+ this.aristas.get(i));
        }
        this.estado_actual=this.estados.get(0);
    }
    
    public ArrayList<String> splitStr(String estados, char delim ){
        ArrayList<String> spliteado=new ArrayList<>();
        String[] x = estados.split(String.valueOf(delim));
        for(int i=0; i<x.length; i++){
            spliteado.add(x[i]);
        }
        return spliteado;
    }
    
    public void extractAcceptNodes(){
        
        for (String contador : this.estados){
            if(contador.contains(".")){
                String x=contador.substring(1, 3);
                this.estados.set(this.estados.indexOf(contador),x);
                estados_aceptacion.add(x);
            }
        }
        
    }
    
    public String computeStr(String bin){
        estado_actual = estados.get(0);
        String out="";
        for (int i = 0; i <bin.length(); i++) {
            String unir= estado_actual+','+bin.charAt(i);
            String arreglo=getArista(unir);
            
            System.out.println("arreglo: " + arreglo);
            if(arreglo!=""){
                
                out+=estado_actual+":"+bin.charAt(i)+"->";
                estado_actual=arreglo.split(",")[2];
                out+=estado_actual;
                out+="\n";
            }
            else {
                out="No valido";
                
                return out;
            }
        }
        
        if(estados_aceptacion.contains(estado_actual)){
            out+="\n "
                    + "Aceptado";
        }
        else{
            out+="\n"
                    + "Rechazado";
        }
        
        return out;
    }
    public String getArista(String union){
        for (int i = 0; i < aristas.size(); i++) {
            if(aristas.get(i).contains(union)){
                System.out.println("union: "+ union);
                System.out.println("arista: "+ aristas.get(i));
                return aristas.get(i);
            }
        }
        return "";
    }
    
    
    
    
    
    
    
}
