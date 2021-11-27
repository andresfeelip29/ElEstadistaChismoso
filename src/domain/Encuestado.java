/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Encuestado {

    private Persona[] personas;
    private int tamanio;

    public Encuestado() {
        //..
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public Persona getPersonas(int pos) {
        return this.personas[pos];
    }

    public void crearArreglo(int tamanio) {
        this.tamanio = tamanio;
        this.personas = new Persona[this.tamanio];
    }

    /**
     * Metodo para guardar los objetos de tipo persona en el arreglo personas
     */
    public void agregarEncuestado(Persona personas, int contador) {
        if (contador < this.personas.length) {
            this.personas[contador] = personas;

        }
    }

    /**
     * Metodo utilizado para almacenar la referencia del arreglo de empleados
     * entre instancias
     */
    public Persona[] guardarEncuestados() {
        Persona[] temporal = this.personas;
        return temporal;
    }

    /**
     * Metodo para modificar el arreglo empleados entre instancias
     */
    public void modificarEncuestados(Persona[] personas) {
        this.personas = personas;
    }

    public int promedioHijosEncuestados() {
        int cantidad = 0;
        int promedio;
        int contador = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getNumeroHijos() > 0) {
                cantidad += personas[i].getNumeroHijos();
                contador++;
            }
        }
        if (contador == 0) {
            return 0;
        } else {
            return promedio = (int) (cantidad / contador);
        }
    }

    /*
    Metodo para otener la media de los ingresos de los encuestados
    **/
    public double medianaIngresos() {
        sortBurbujaIngresos();
        double mediana;
        int mitad = personas.length / 2;
        //si la longitud es par, se debe prmediar los del centro
        if (personas.length % 2 == 0) {
            mediana = ((personas[mitad - 1].getIngresoMensual() + personas[mitad].getIngresoMensual()) / 2);
        } else {
            mediana = personas[mitad].getIngresoMensual();
        }
        return mediana;
    }

    public int modaEdad() {
        int moda;
        int posOcurrencia = 0;
        int auxPos = 0;
        int auxOcurrencia = 0;
        int cantidadOcurrencia = 0;
        /*
        * Se utilizan dos for uno para recorrer el arreglo y el segundo para comprar con los demas datos
        * la variables auxOcurrencia y auxPos almacenan la cantidad de ocurrencia y la poscion donde ocurre
        * */
        for (int i = 0; i < personas.length; i++) {
            for (int j = 0; j < personas.length; j++) {
                if (personas[i].getEdad() == personas[j].getEdad()) {
                    auxOcurrencia++;
                    auxPos = i;
                }
            }
            /*
        * Se valida si la cantidad de ocurrencia actual y menor que la de la poscion del arreglo actual
        * si es asi se almacena si no se descarta y vuelve a 0
        * */
            if (cantidadOcurrencia < auxOcurrencia) {
                cantidadOcurrencia = auxOcurrencia;
                posOcurrencia = auxPos;
            }
            auxOcurrencia = 0;
        }

        /* al final se valida si la ocurrencia final es 1 es por que todo los datos son distintos
        * si por el contrario es mayor que 1 se imprimi la cantidad y la poscion
        *
         */
        return moda = personas[posOcurrencia].getEdad();
    }

    /**
     * Metodo burbuja para organizar el arreglo por el ingreso de encuestados
     */
    public void sortBurbujaIngresos() {
        int total = this.personas.length;
        /*
         * El metodo funciona como una matriz bidimensional, el primer for se posiciona sobre el primer elemento de la primerla fila y columnda
         * el segundo for compara el elemnto actual con el elemento superior osea el elemnto + 1
         * y va poscionando ese elemnto en la parte final del arreglo
         * el segundo for al iterar se le va restando la iteracion del primer for dado que los elementos de mitad del arreglo hacia atras se va ordenando
         * es por ello que el metodo solo itera hasta la mitada del arreglo 
         */
        for (int i = 0; i < total - 1; i++) {
            for (int j = 0; j < total - 1 - i; j++) {
                /*
                 * Ordena de manera decendente si quieras comparlo de manera acendente solo cambia el < por > 
                 * el metodo compareTo() devuelve siempre un numero de tipo int
                 * si es < que 0 es por que el objeto a comprar es menor
                 * si es > que 0 es por que el onjeto a comprar es mayor
                 * si es = que 0 es por que los objetos son iguales
                 * El algoritmo actual ordena de menor a mayor si quiren que sea al contrario cambien < por >
                 * Si quisieran orden con otro parametro ya sea la direccion, id o la edad
                 * tiene que cambiar donde dice .getNombre() por .getEdad(), .getDireccion() o .getId()
                 */
                if ((this.personas[j + 1].getIngresoMensual() > this.personas[j].getIngresoMensual())) {
                    /* 
                     * Si la condicion es verdadera entonces se establece como nuevo elemento menor el de una poscion superior
                     * por tal motivo se concatenan dentro del if la informacion referente a 
                     * la poscion actual con su respectivo dato con el nuevo valor menor y su posicion 
                     */
                    Persona aux = this.personas[j];
                    this.personas[j] = this.personas[j + 1];
                    this.personas[j + 1] = aux;

                }
            }
        }
    }

    public String mostrarInformeJefeHogar() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Locale locale = new Locale("es", "CO");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        int largo = this.personas.length;
        String dato = "\n ***** INFORME ENCUESTADOS *****  \n" + "\n";
        for (int i = 0; i < largo; i++) {
            if (this.personas[i].isJefeDeHogar() == true) {
                dato += "Identificacion: " + this.personas[i].getId()
                        + " Nombre: " + this.personas[i].getNombre()
                        + " Edad: " + this.personas[i].getEdad()
                        + " Sexo: " + this.personas[i].getSexo()
                        + " Ingreso mensual: " + "$ " + numberFormat.format(this.personas[i].getIngresoMensual())
                        + "\n" + "----------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------" + "\n";
            }

        }
        return dato;
    }

    public String mostrarInformeHombre() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Locale locale = new Locale("es", "CO");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        int largo = this.personas.length;
        String dato = "\n ***** INFORME ENCUESTADOS *****  \n" + "\n";
        for (int i = 0; i < largo; i++) {
            if (this.personas[i].getSexo().equals("M")) {
                dato += "Identificacion: " + this.personas[i].getId()
                        + " Nombre: " + this.personas[i].getNombre()
                        + " Edad: " + this.personas[i].getEdad()
                        + " Sexo: " + this.personas[i].getSexo()
                        + " Ingreso mensual: " + "$ " + numberFormat.format(this.personas[i].getIngresoMensual())
                        + "\n" + "----------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------" + "\n";
            }

        }
        return dato;
    }

    public String mostrarInformeMujer() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Locale locale = new Locale("es", "CO");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        int largo = this.personas.length;
        String dato = "\n ***** INFORME ENCUESTADOS *****  \n" + "\n";
        for (int i = 0; i < largo; i++) {
            if (this.personas[i].getSexo().equals("F")) {
                dato += "Identificacion: " + this.personas[i].getId()
                        + " Nombre: " + this.personas[i].getNombre()
                        + " Edad: " + this.personas[i].getEdad()
                        + " Sexo: " + this.personas[i].getSexo()
                        + " Ingreso mensual: " + "$ " + numberFormat.format(this.personas[i].getIngresoMensual())
                        + "\n" + "----------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------"
                        + "------------------------------------------------------------------------------------" + "\n";
            }

        }
        return dato;
    }

}
