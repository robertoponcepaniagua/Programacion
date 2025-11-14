public class Usuario {
    private String nombre;
    private String apellidos;
    private String codigopostal;
    private String direccion;
    private String email;
    private String contrasena;

    //Contructor:
    public Usuario(String nombre, String apellidos, String codigopostal, String direccion, String email, String contrasena) {
        nombre = "Roberto";
        apellidos = "Ponce Paniagua";
        codigopostal = "11405";
        direccion = "C/ Joan Miró 1, RES Europa, Portal 5 bj A";
        email = "rponpan078@g.educaand.es";
        contrasena = "1234";
    }
    //Metodo get

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }
}


