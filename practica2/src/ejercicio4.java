public class ejercicio4 {
    public static void main(String[] args) {
        //Crea un array de números de 100 posiciones, que contendrá los números del 1 al 100.
        //Obtén la suma de todos ellos y la media.

        //Creamos el array de 100 posiciones
        int[] a = new int[100];
        //cremos la variable suma
        int suma =0;
        // Asignamos el valor correspondiente a cada posición
        for (int i = 0; i < 100; i++) {
            a[i] = i + 1;
            }
        // Calculamos la suma de todos los elementos del array
        for (int i = 0; i < 100; i++) {
            suma += a[i];
        }
        // Calculamos la media de los números
        double media = (double) suma / a.length;

        System.out.println("La suma del 1 al 100 incrementalmente es : "+suma);
        System.out.println("La media de la suma es : "+media);
    }
}
