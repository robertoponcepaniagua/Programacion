public class Main {
    public static void main(String [] args) {

        Usuario user = new Usuario("Roberto","Ponce Paniagua","11405","Calle Joan","rponpan@g.educaand.es","hola");
        System.out.println(user.getNombre());
        user.setNombre("Robertop");
        System.out.println(user.getNombre());

        System.out.println(user.getEmail());
        user.setEmail("roberto@hola");
        System.out.println(user.getEmail());

        System.out.println(user.toString());

        //Usuario[] usuarios;
        //validarRegistro();
    }
    public static void validarRegistro(Usuario[] usuarios){}
}
