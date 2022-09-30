package ad1.actividad;

public class Persona {

    private int id;
    private String apellido;
    private String departamento;
    private float salario;

    public Persona(int id, String apellido, String departamento, float salario) {
        this.id = id;
        this.apellido = apellido;
        this.departamento = departamento;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "id=" + id + ", apellido=" + apellido + ", departamento=" + departamento + ", salario=" + salario;
    }
    
    
}
