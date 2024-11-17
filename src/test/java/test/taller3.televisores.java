package taller3.televisores;

public class Marca {
	private String nombre;
	
	public Marca(String nombre) {
		this.setNombre(nombre);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

package taller3.televisores;

public class Control {
	private TV tv;
	
	public void enlazar(TV tv) {
		this.tv = tv;
		tv.setControl(this);
	}
	
	public void turnOn() {
		this.tv.turnOn();
	}
	
	public void turnOff() {
		this.tv.turnOff();
	}
	
	public void canalUp() {
		this.tv.canalUp();
	}
	
	public void canalDown() {
		this.tv.canalDown();
	}
	
	public void volumenUp() {
		this.tv.volumenUp();
	}
	
	public void volumenDown() {
		this.tv.volumenDown();
	}
	
	public void setCanal(int canal) {
		this.tv.setCanal(canal);
	}
	
	public void setVolumen(int volumen) {
		this.tv.setVolumen(volumen);
	}
	
	public TV getTv() {
		return this.tv;
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
	private static int numTV = 0;
	
	public TV(Marca marca, boolean estado) {
		this.marca = marca;
		this.estado = estado;
		this.canal = 1;
		this.volumen = 1;
		this.precio = 500;
		
		TV.numTV++;
	}
	
	public static int getNumTV() {
		return TV.numTV;
	}
	
	public static void setNumTV(int numTV) {
		TV.numTV = numTV;
	}
	
	public void turnOn() {
		this.estado = true;
	}
	
	public void turnOff() {
		this.estado = false;
	}
	
	public void canalUp() {
		this.setCanal(this.canal + 1);
	}
	
	public void canalDown() {
		this.setCanal(this.canal - 1);
	}
	
	public void volumenUp() {
		this.setVolumen(this.volumen + 1);
	}
	
	public void volumenDown() {
		this.setVolumen(this.volumen - 1);
	}
	
	public Marca getMarca() {
		return this.marca;
	}
	
	public int getCanal() {
		return this.canal;
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
	public int getVolumen() {
		return this.volumen;
	}
	
	public Control getControl() {
		return this.control;
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public void setCanal(int canal) {
		if (this.estado && canal >= 1 && canal <= 120)
			this.canal = canal;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public void setVolumen(int volumen) {
		if (this.estado && volumen >= 0 && volumen <= 7)
			this.volumen = volumen;
	}
	
	public void setControl(Control control) {
		this.control = control;
	}
}

package taller3.televisores;

public class TestTV {
	public static void main(String[] args) {
		Marca marca1 = new Marca("Semsung");
	    Marca marca2 = new Marca("Lj");
		
	    TV tv1 = new TV(marca1, true);
	    TV tv2 = new TV(marca2, false);
	    
	    tv1.setPrecio(2000);
	    tv2.setCanal(90);
	    tv1.setCanal(121);
		tv2.setVolumen(7);
		
		Control control1 = new Control();
		control1.enlazar(tv1);
		control1.turnOff();
		control1.setCanal(50);
		control1.turnOn();
		control1.canalUp();
		control1.volumenUp();
		
	    System.out.println(tv2.getCanal());
	    System.out.println(tv1.getPrecio());
	    System.out.println(tv1.getMarca().getNombre());
	    System.out.println(tv1.getCanal());
	}
}