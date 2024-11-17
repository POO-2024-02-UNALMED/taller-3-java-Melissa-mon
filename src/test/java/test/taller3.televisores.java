package taller3.televisores;

public class Marca {
    private String nombre;

    // Constructor
    public Marca(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

package taller3.televisores;

public class Control {
    private TV tv;

    // Método para enlazar el control con un televisor
    public void enlazar(TV tv) {
        this.tv = tv;
        tv.setControl(this);
    }

    // Métodos de control remoto
    public void turnOn() {
        if (tv != null) {
            tv.turnOn();
        }
    }

    public void turnOff() {
        if (tv != null) {
            tv.turnOff();
        }
    }

    public void canalUp() {
        if (tv != null) {
            tv.canalUp();
        }
    }

    public void canalDown() {
        if (tv != null) {
            tv.canalDown();
        }
    }

    public void volumenUp() {
        if (tv != null) {
            tv.volumenUp();
        }
    }

    public void volumenDown() {
        if (tv != null) {
            tv.volumenDown();
        }
    }

    public void setCanal(int canal) {
        if (tv != null) {
            tv.setCanal(canal);
        }
    }

    public void setVolumen(int volumen) {
        if (tv != null) {
            tv.setVolumen(volumen);
        }
    }

    // Getters y setters
    public TV getTv() {
        return tv;
    }

    public void setTv(TV tv) {
        this.tv = tv;
    }
}

package taller3.televisores;

public class TV {
    private Marca marca;
    private int canal;
    private int precio;
    private boolean estado;
    private int volumen;
    private Control control;
    
    // Atributo estático para contar la cantidad de televisores creados
    private static int numTV = 0;

    // Constructor
    public TV(Marca marca, boolean estado) {
        this.marca = marca;
        this.estado = estado;
        this.canal = 1;
        this.volumen = 1;
        this.precio = 500;
        numTV++; // Aumentar el contador de televisores
    }

    // Métodos setters y getters
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        if (estado && canal >= 1 && canal <= 120) {
            this.canal = canal;
        }
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        if (estado && volumen >= 0 && volumen <= 7) {
            this.volumen = volumen;
        }
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public boolean isEstado() {
        return estado;
    }

    public void turnOn() {
        this.estado = true;
    }

    public void turnOff() {
        this.estado = false;
    }

    public static int getNumTV() {
        return numTV;
    }

    // Métodos para controlar el canal
    public void canalUp() {
        if (estado && canal < 120) {
            canal++;
        }
    }

    public void canalDown() {
        if (estado && canal > 1) {
            canal--;
        }
    }

    // Métodos para controlar el volumen
    public void volumenUp() {
        if (estado && volumen < 7) {
            volumen++;
        }
    }

    public void volumenDown() {
        if (estado && volumen > 0) {
            volumen--;
        }
    }

    // Método para obtener el estado del televisor
    public boolean getEstado() {
        return estado;
    }
}

package taller3.televisores;

public class TestTV {
    public static void main(String[] args) {
        // Crear marca
        Marca marca1 = new Marca("Samsung");

        // Crear televisores
        TV tv1 = new TV(marca1, true);  // Televisor encendido
        TV tv2 = new TV(marca1, false); // Televisor apagado

        // Crear controles remotos
        Control control1 = new Control();
        control1.enlazar(tv1); // Enlazar control con el televisor

        // Mostrar número de televisores creados
        System.out.println("Número de televisores creados: " + TV.getNumTV());

        // Usar el control remoto para cambiar el canal y volumen
        System.out.println("Canal actual TV1: " + tv1.getCanal());
        control1.canalUp();
        System.out.println("Canal después de subir: " + tv1.getCanal());

        System.out.println("Volumen actual TV1: " + tv1.getVolumen());
        control1.volumenUp();
        System.out.println("Volumen después de subir: " + tv1.getVolumen());

        // Apagar el televisor
        control1.turnOff();
        System.out.println("Estado de TV1 después de apagar: " + tv1.getEstado());

        // Intentar cambiar el canal cuando está apagado
        control1.canalDown();
        System.out.println("Canal después de intentar bajar estando apagado: " + tv1.getCanal());
    }
}

