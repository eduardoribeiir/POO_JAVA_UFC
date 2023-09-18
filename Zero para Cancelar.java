import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class ComputaSequencia {
    private ArrayList<Integer> numeros;

    public ComputaSequencia() {
        this.numeros = new ArrayList<>();
    }

    public void cadastra(int valor) {
        if (valor != 0) {
            this.numeros.add(valor);
        } else if (!this.numeros.isEmpty()) {
            this.numeros.remove(this.numeros.size() - 1);
        }
    }

    public int computa() {
        int soma = 0;
        for (int numero : this.numeros) {
            soma += numero;
        }
        return soma;
    }

    @Override
    public String toString() {
        return "valores = " + this.numeros;
    }
}

class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        ComputaSequencia sequencia = new ComputaSequencia();

        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            System.out.println("$" + line);
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("cadastra")) {
                sequencia.cadastra(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("computa")) {
                System.out.println(sequencia.computa());
            } else if (ui[0].equals("show")) {
                System.out.println(sequencia);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}