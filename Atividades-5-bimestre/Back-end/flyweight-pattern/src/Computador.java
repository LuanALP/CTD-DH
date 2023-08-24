import java.lang.module.Configuration;

public class Computador {
    private int ram;
    private int hd;
    public static int contador;

    public Computador(int ram, int hd) {
        this.ram = ram;
        this.hd = hd;
//        contador = Computador.contador + 1;
        contador++;
        System.out.println("contador: " + Computador.contador);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }
}
