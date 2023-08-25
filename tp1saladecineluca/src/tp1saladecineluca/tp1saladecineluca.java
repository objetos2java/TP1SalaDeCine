package tp1saladecineluca;

public class tp1saladecineluca {
    private Integer[][] ocupacion;
    private Integer totalButacas;
    private Integer totalFilas;

    public tp1saladecineluca(Integer totalButacas, Integer totalFilas) {
        this.totalButacas = totalButacas;
        this.totalFilas = totalFilas;
        ocupacion = new Integer[totalFilas][totalButacas];
    }

    public boolean estaVacia() {
        for (int fila = 0; fila < totalFilas; fila++) {
            for (int asiento = 0; asiento < totalButacas; asiento++) {
                if (ocupacion[fila][asiento] != null && ocupacion[fila][asiento] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean estaButacaOcupada(Integer fila, Integer asiento) {
        validarButaca(fila, asiento);
        return ocupacion[fila - 1][asiento - 1] != null && ocupacion[fila - 1][asiento - 1] == 1;
    }

    public boolean ocuparButaca(Integer fila, Integer asiento) {
        validarButaca(fila, asiento);
        if (ocupacion[fila - 1][asiento - 1] != null && ocupacion[fila - 1][asiento - 1] == 1) {
            return false;
        }
        ocupacion[fila - 1][asiento - 1] = 1;
        return true;
    }

    public int totalButacasOcupadas() {
        int ocupadas = 0;
        for (Integer fila = 0; fila < totalFilas; fila++) {
            for (Integer asiento = 0; asiento < totalButacas; asiento++) {
                if (ocupacion[fila][asiento] != null && ocupacion[fila][asiento] == 1) {
                    ocupadas++;
                }
            }
        }
        return ocupadas;
    }

    public boolean hayEspacioPara(Integer cantidadDePersonas) {
        for (Integer fila = 0; fila < totalFilas; fila++) {
            int espacioContiguo = 0;
            for (int asiento = 0; asiento < totalButacas; asiento++) {
                if (ocupacion[fila][asiento] == null || ocupacion[fila][asiento] == 0) {
                    espacioContiguo++;
                    if (espacioContiguo == cantidadDePersonas) {
                        return true;
                    }
                } else {
                    espacioContiguo = 0;
                }
            }
        }
        return false;
    }

    private void validarButaca(Integer fila, Integer asiento) {
        if (fila < 1 || fila > totalFilas || asiento < 1 || asiento > totalButacas) {
            throw new IllegalArgumentException("Fila o asiento inválido");
        }
    }

    public static void main(String[] args) {
    	tp1saladecineluca sala = new tp1saladecineluca(10, 5);
        sala.ocuparButaca(1, 3);
        sala.ocuparButaca(2, 5);
        sala.ocuparButaca(3, 2);

        System.out.println("Sala vacía: " + sala.estaVacia());
        System.out.println("Butaca ocupada (1, 3): " + sala.estaButacaOcupada(1, 3));
        System.out.println("Butaca ocupada (2, 5): " + sala.estaButacaOcupada(2, 5));
        System.out.println("Total de butacas ocupadas: " + sala.totalButacasOcupadas());
        System.out.println("Hay espacio para 3 personas: " + sala.hayEspacioPara(3));
        System.out.println("Hay espacio para 4 personas: " + sala.hayEspacioPara(4));
    }
}
