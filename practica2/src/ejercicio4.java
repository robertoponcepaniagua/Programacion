public class ejercicio4 {
    public static void main(String[] args) {
        int[] a = new int[100];
        int suma =0;
        for (int i = 0; i < 100; i++) {
            a[i] = i + 1;
            }
        for (int i = 0; i < 100; i++) {
            suma += a[i];
        }
        double media = (double) suma / a.length;

        System.out.println("La suma del 1 al 100 incrementalmente es : "+suma);
        System.out.println("La media de la suma es : "+media);
    }
}
