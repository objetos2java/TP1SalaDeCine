package SalaDeCine;

public class SalaDeCine {
	private Integer filas;
	private Integer butacasPFila;
	private Boolean[][] butacas;
	
	public SalaDeCine(Integer filas, Integer butacasPFila) {
		this.filas = filas;
		this.butacasPFila = butacasPFila;
		this.butacas= new Boolean[filas][butacasPFila];
		
		for (int fila = 0; fila < filas; fila++) {
			for (int butaca = 0; butaca < butacasPFila; butaca++) {
				butacas[fila][butaca] = false;
			}
		}
	}
	
	public Boolean estaVacia() {
		for (int fila = 0; fila < filas; fila++) {
            for (int butaca = 0; butaca < butacasPFila; butaca++) {
                if (butacas[fila][butaca]) {
                    return false;
                }
            }
        }
        return true;
	}
	
	public Boolean butacaOcupada(int fila, int butaca) {
        return butacas[fila][butaca];
    }
	
	public void ocuparButaca(int fila, int butaca) {
        if (!this.butacaOcupada(fila, butaca)) {
            butacas[fila][butaca] = true;
        }        
    }
	
	public Integer totalButacasOcupadas() {
        int total = 0;
        for (int fila = 0; fila < filas; fila++) {
            for (int butaca = 0; butaca < butacasPFila; butaca++) {
                if (butacas[fila][butaca]) {
                    total++;
                }
            }
        }
        return total;
    }
	
	public Boolean hayEspacioPara(int cantidadDePersonas) {
		if (cantidadDePersonas <= butacasPFila) {
			for (int fila = 0; fila < filas; fila++) {
	            int butacasLibres = 0;
	            for (int butaca = 0; butaca < butacasPFila; butaca++) {
	                if (!this.butacaOcupada(fila, butaca)) {
	                    butacasLibres++;
	                    if (butacasLibres >= cantidadDePersonas) {
	                        return true;
	                    }
	                } 	else {
	                    butacasLibres = 0;
	                }
	            }
	        }
		}
        return false;
    }
	public Integer butacasTotales() {
		return filas * butacasPFila;
	}
}
