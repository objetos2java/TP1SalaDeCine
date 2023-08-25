package pjc.objetosII;

public class SalaDeCine {
    private int filas;
    private int butacasPorFila;
    private boolean[][] ocupadas;

    public SalaDeCine(int filas, int butacasPorFila) {
        this.filas = filas;
        this.butacasPorFila = butacasPorFila;
        ocupadas = new boolean[filas][butacasPorFila];
    }

    public boolean estaVacia() {
        for (int fila = 0; fila < filas; fila++) {
            for (int asiento = 0; asiento < butacasPorFila; asiento++) {
                if (ocupadas[fila][asiento]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean estaOcupada(int fila, int asiento) {
        if (fila < 0 || fila >= filas || asiento < 0 || asiento >= butacasPorFila) {
            return false; // Butaca inválida
        }
        return ocupadas[fila][asiento];
    }

    public boolean ocuparButaca(int fila, int asiento) {
        if (fila < 0 || fila >= filas || asiento < 0 || asiento >= butacasPorFila) {
            return false; // Butaca inválida
        }
        if (!ocupadas[fila][asiento]) {
            ocupadas[fila][asiento] = true;
            return true;
        }
        return false; // La butaca ya está ocupada
    }

    public int totalButacasOcupadas() {
        int count = 0;
        for (int fila = 0; fila < filas; fila++) {
            for (int asiento = 0; asiento < butacasPorFila; asiento++) {
                if (ocupadas[fila][asiento]) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean hayEspacioPara(int cantidadDePersonas) {
        for (int fila = 0; fila < filas; fila++) {
            int espaciosDisponibles = 0;
            for (int asiento = 0; asiento < butacasPorFila; asiento++) {
                if (!ocupadas[fila][asiento]) {
                    espaciosDisponibles++;
                    if (espaciosDisponibles >= cantidadDePersonas) {
                        return true;
                    }
                } else {
                    espaciosDisponibles = 0;
                }
            }
        }
        return false;
    }



    
    public void mostrarOcupacion() {
        for (int fila = 0; fila < filas; fila++) {
            for (int asiento = 0; asiento < butacasPorFila; asiento++) {
                if (ocupadas[fila][asiento]) {
                    System.out.print("X "); // X para asiento ocupado
                } else {
                    System.out.print("O "); // O para asiento libre
                }
            }
            System.out.println(); // Nueva línea para la siguiente fila
        }
    }
    
    
}

