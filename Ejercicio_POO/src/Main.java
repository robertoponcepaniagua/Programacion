public class Main {
    public static void main(String [] args) {

        Usuario user = new Usuario("Roberto","Ponce Paniagua","11405","Calle Joan","rponpan@g.educaand.es","hola");
        System.out.println(user.getNombre());
        user.setNombre("Robertop");
        System.out.println(user.getNombre());

        System.out.println(user.getEmail());
        user.setEmail("rponpan@hola");
        System.out.println(user.getEmail());

        System.out.println(user.toString());

        Usuario usuario1= new Usuario("Paco","Gordon Figueroa","28356","Calle Almeria","pacopruebas@hola","pacopaco08");
        Usuario usuario2= new Usuario("Cayetano","Ponce Paniagua","11405","Calle Joan","cponpan@hola","cayep12");
        Usuario usuario3= new Usuario("Nay","Garrido Barbadilla","28485","Calle Alameda","naynay@hola","nayhola1234");
        Usuario[] usuarios = {usuario1,usuario2,usuario3};
        validarRegistro(usuarios);
        checkusuario(usuarios);
    }
    public static void validarRegistro(Usuario[] usuarios){
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].getCodigopostal().startsWith("28")) {
                System.out.println("Codigo postal Valido");
            } else {
                System.out.println("ERROR: "+usuarios[i].getNombre()+" bloqueado. Código Postal no permitido.");
            }
        }
    }
    public static void checkusuario(Usuario[] usuarios) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].checkusuario(//falta esto)) {
                System.out.println("Acceso concedido a "+usuarios[i].getNombre());
            } else {
                System.out.print("¡ERROR! Contraseña incorrecta para "+usuarios[i].getNombre());
            }
        }
    }
}
