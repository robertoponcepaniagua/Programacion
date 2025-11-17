public class Usuario {
    //Atributos
    private String nombre;
    private String apellidos;
    private String codigopostal;
    private String direccion;
    private String email;
    private String contrasena;

    //Contructor:
    public Usuario(String n, String a, String c, String d, String e, String p) {
        this.nombre = n;
        this.apellidos = a;
        this.codigopostal = c;
        this.direccion = d;
        this.email = e;
        this.contrasena = p;

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
    public  void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
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
    public void setEmail(String nuevoemail) {
        if (email.contains("@")) {
            this.email = nuevoemail;
        }
        else {
            System.out.println("El email no es valido no contiene [@]");
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean checkusuario(String email, String contrasena) {
        return this.email.equals(email) && this.contrasena.equals(contrasena);
    }
    //Metodo TOSTRING
    public String toString(){
        return "El nombre es: "+ this.nombre+" "+this.apellidos+" y el email es "+this.email+" "+this.codigopostal+" "+this.direccion+" "+this.contrasena;
    }
}


