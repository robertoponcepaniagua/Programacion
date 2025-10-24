public class ejercicio11 {
    public static void main(String[] args) {
        //Escribe un programa java que invierta el orden de los valores de un array. Por invertir el
        //orden de los valores de un array, me refiero que el último pasa a ser el primero, el
        //penúltimo el segundo y así sucesivamente. PRUEBA CON UN ARRAY DE TAMAÑO 6.
        int[] array = {1,2,3,4,5,6};
        int[] arrayinvertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayinvertido[i] =array[array.length-1-i];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(arrayinvertido[i]);
        }
    }
}