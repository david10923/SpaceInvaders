# SpaceInvaders
Space Invaders fue uno de los primeros juegos identificados con el género matamarcianos
o marcianitos. Actualmente está considerado como uno de los videojuegos más
influyentes e importantes de la historia. El objetivo del juego consiste en controlar una
nave para destruir – disparando un misil – las naves alienígenas que aparecen en el espacio.
Actualmente existen multitud de clones y versiones modernas del juego que han
introducido novedades, como tipos de armas, escudos y superpoderes.
Para esta práctica, utilizaremos tanto elementos del juego clásico como algunas de
las novedades introducidas en las versiones más modernas. En el juego original la acción
se desarrolla en tiempo real, es decir, los enemigos actúan de forma continua independientemente
de las acciones que tome el jugador. Sin embargo, en nuestro caso el juego
se desarrollará por turnos, donde el jugador podrá realizar una acción en cada ciclo del
juego, de forma que el mismo permanece parado hasta que el jugador indica la acción.
Seguidamente, las naves se actualizarán para realizar sus movimientos o acciones correspondientes.
En esta práctica vamos a considerar que el juego consta de un tablero de
8×9 casillas (8 filas por 9 columnas). La casilla de arriba a la izquierda es la (0, 0) y la de
abajo a la derecha la (7, 8). Cada casilla puede estar ocupada por una nave alienígena, por
UCM-ship (la nave que controla el usuario), un ovni, el misil de UCM-ship o un proyectil
lanzado por una nave alienígena. Las casillas que no estén ocupadas se considerarán casillas
vacías. Para distinguir los disparos de ambas naves, de aquí en adelante utilizaremos el
término misil para hacer referencia al disparo realizado por UCM-ship y proyectil al
disparo realizado por las naves alienígenas.
Las naves alienígenas se moverán en grupo. Es decir, todas realizarán el mismo movimiento
– o permanecerán paradas – en el mismo ciclo. Inicialmente, las naves se desplazarán
hacia la izquierda con la velocidad relativa al nivel de dificultad seleccionado. Cuando una
de las naves llegue al borde del tablero, todas las naves se desplazarán una casilla hacia
abajo. En el siguiente ciclo, las naves comenzarán a moverse horizontalmente en dirección
al borde opuesto, tal y como ocurre con el juego original.
Si una nave alienígena logra llegar a la fila en la que se encuentra UCM-ship o
UCM-ship se queda sin puntos de daño, el jugador habrá perdido la partida. Sin embargo,
el jugador ganará cuando haya destruido todas las naves alienígenas, es decir, si
durante el Update, no quedan naves alienígenas en el tablero.
En esta práctica sólo consideraremos dos tipos de naves alienígenas: Nave común y
Nave destructora.
![image](https://user-images.githubusercontent.com/49251020/133243130-824c08e5-1cb1-4bb6-81aa-40abb751396c.png)
