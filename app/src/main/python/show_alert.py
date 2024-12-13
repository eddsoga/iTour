import heapq
import math

# Función heurística (distancia Euclidiana)
def heuristica(a, b):
    return math.sqrt((b[0] - a[0]) ** 2 + (b[1] - a[1]) ** 2)

# Algoritmo A* con el grafo de intersecciones
def a_star(start, goal, intersections):
    # Construir el grafo basado en la distancia mínima entre intersecciones cercanas
    graph = {intersection: [] for intersection in intersections}

    # Conectar cada intersección con otras cercanas
    for i, intersection1 in enumerate(intersections):
        for j, intersection2 in enumerate(intersections):
            if i != j:
                dist = heuristica(intersection1, intersection2)
                # Establecer que la distancia entre dos puntos es el valor de la heurística
                graph[intersection1].append((intersection2, dist))

    # Nodos abiertos (por explorar)
    open_list = []
    heapq.heappush(open_list, (0 + heuristica(start, goal), 0, start))

    # Mapas de padres y costos
    came_from = {}
    g_score = {start: 0}

    while open_list:
        # Nodo con el menor f-score
        _, current_g, current = heapq.heappop(open_list)

        # Si alcanzamos el destino
        if current == goal:
            path = []
            while current in came_from:
                path.append(current)
                current = came_from[current]
            path.append(start)
            path.reverse()
            return path

        # Explorar vecinos
        for neighbor, _ in graph.get(current, []):
            tentative_g_score = current_g + heuristica(current, neighbor)
            if neighbor not in g_score or tentative_g_score < g_score[neighbor]:
                came_from[neighbor] = current
                g_score[neighbor] = tentative_g_score
                f_score = tentative_g_score + heuristica(neighbor, goal)
                heapq.heappush(open_list, (f_score, tentative_g_score, neighbor))

    return None  # Si no se encuentra un camino

# Función para ser llamada desde Java (procesamiento de ubicaciones)
def process_location(lat1, lon1, lat2, lon2, intersections):
    start = (lat1, lon1)
    goal = (lat2, lon2)

    # Ejecutar A* con el grafo de intersecciones
    path = a_star(start, goal, intersections)

    if path:
        return f"Ruta encontrada: {path}"
    else:
        return "No se pudo encontrar una ruta"

# Intersecciones proporcionadas
intersections = [
    (17.076439, -96.744914), (17.076326, -96.744487), (17.076649, -96.744375),
    (17.076735, -96.744356), (17.076480, -96.743916), (17.076693, -96.743817),
    (17.076901, -96.744877), (17.077141, -96.744809), (17.077200, -96.744939),
    (17.077093, -96.744625), (17.077004, -96.744378), (17.076877, -96.743984),
    (17.076704, -96.743834), (17.076852, -96.744300), (17.076945, -96.744258),
    (17.076999, -96.744376), (17.077014, -96.743700), (17.077167, -96.743798),
    (17.077195, -96.743908), (17.077340, -96.743871), (17.077436, -96.744180),
    (17.077394, -96.744004), (17.077406, -96.743729), (17.077502, -96.743966),
    (17.077885, -96.743857), (17.078166, -96.743776), (17.078038, -96.744327),
    (17.078282, -96.744092), (17.078729, -96.743959), (17.078334, -96.744234),
    (17.078876, -96.744415), (17.079218, -96.744147), (17.078986, -96.744815),
    (17.078848, -96.744848), (17.078492, -96.744959), (17.078376, -96.745020),
    (17.078410, -96.745119), (17.078461, -96.745286), (17.078901, -96.745159),
    (17.078306, -96.745147), (17.078144, -96.744658), (17.078052, -96.744681),
    (17.077861, -96.744752), (17.078006, -96.745238), (17.078071, -96.745471),
    (17.077769, -96.745683), (17.077616, -96.745855), (17.078383, -96.745914),
    (17.076757, -96.744942), (17.075572, -96.744810), (17.076482, -96.745068),
    (17.076385, -96.745089), (17.076339, -96.745111), (17.076156, -96.745153),
    (17.076014, -96.744876), (17.075777, -96.744754), (17.077020, -96.743952),
    (17.078208, -96.745182), (17.078369, -96.744597), (17.078835, -96.744264),
    (17.077341, -96.745687), (17.077346, -96.745688), (17.076939, -96.745454),
    (17.077477, -96.744869), (17.076268, -96.744850)
]
