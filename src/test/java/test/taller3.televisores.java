package taller3.televisores;

public class Marca {
    private String nombre;

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    private static int numTV = 0;

    public TV(Marca marca, boolean estado) {
        this.marca = marca;
        this.estado = estado;
        this.canal = 1;
        this.volumen = 1;
        this.precio = 500;
        numTV++;
    }

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

    public boolean getEstado() {
        return estado;
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

    public static int getNumTV() {
        return numTV;
    }

    public static void setNumTV(int numTV) {
        TV.numTV = numTV;
    }

    public void turnOn() {
        estado = true;
    }

    public void turnOff() {
        estado = false;
    }

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
}

package taller3.televisores;

public class Control {
    private TV tv;

    public TV getTv() {
        return tv;
    }

    public void setTv(TV tv) {
        this.tv = tv;
    }

    public void enlazar(TV tv) {
        this.tv = tv;
        tv.setControl(this);
    }

    public void turnOn() {
        tv.turnOn();
    }

    public void turnOff() {
        tv.turnOff();
    }

    public void canalUp() {
        tv.canalUp();
    }

    public void canalDown() {
        tv.canalDown();
    }

    public void volumenUp() {
        tv.volumenUp();
    }

    public void volumenDown() {
        tv.volumenDown();
    }

    public void setCanal(int canal) {
        tv.setCanal(canal);
    }

    public void setVolumen(int volumen) {
        tv.setVolumen(volumen);
    }
}

package taller3.televisores;

public class TestTV {

    public static void main(String[] args) {
        Marca marca1 = new Marca("Samsung");
        TV tv1 = new TV(marca1, false);

        tv1.turnOn();
        System.out.println(tv1.getEstado());  // Debería imprimir: true

        tv1.setCanal(50);
        System.out.println(tv1.getCanal());  // Debería imprimir: 50

        Control control1 = new Control();
        control1.enlazar(tv1);

        control1.turnOff();
        System.out.println(tv1.getEstado());  // Debería imprimir: false

        control1.turnOn();
        System.out.println(tv1.getEstado());  // Debería imprimir: true

        control1.setCanal(100);
        System.out.println(tv1.getCanal());  // Debería imprimir: 100

        control1.volumenUp();
        System.out.println(tv1.getVolumen());  // Debería imprimir: 2

        System.out.println(TV.getNumTV());  // Debería imprimir el número de televisores creados
    }
}

