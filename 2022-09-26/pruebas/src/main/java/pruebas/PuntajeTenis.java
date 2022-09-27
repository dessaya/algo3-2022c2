package pruebas;

interface PuntajeTenis {
	enum Jugador {LOCAL, VISITANTE};
	enum Puntos {CERO, QUINCE, TREINTA, CUARENTA, VENTAJA};
	
	// marca un punto para el jugador local o visitante
	void punto(Jugador j);
	
	// devuelve cuál de los dos jugadores tiene el servicio
	Jugador servicio();
	
	// devuelve la tabla de puntaje de los sets;
	// cada elemento es un array de 2 enteros {local, visitante}.
	// por ejemplo, si la tabla es "6-3, 2-6, 2-1", devuelve {{6, 3}, {2, 6}, {2, 1}} 
	int[][] puntajeSets();
	
	// devuelve el puntaje del game actual, de la forma {local, visitante}
	// por ejemplo: {QUINCE, CUARENTA}, o {VENTAJA, CUARENTA}
	Puntos[] puntajeGame();
}
