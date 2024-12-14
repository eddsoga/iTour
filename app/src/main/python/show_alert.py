import json

# Función heurística (distancia Euclidiana simple)
def heuristica(a, b):
    return ((b[0] - a[0]) ** 2 + (b[1] - a[1]) ** 2) ** 0.5

# Algoritmo A* sin usar len, range, iter ni min
def a_star(start, goal, intersections):
    # Crear un grafo implícito basado en las intersecciones
    graph = {}

    # Construir conexiones (vecinos cercanos) entre intersecciones
    for current in intersections:
        graph[current] = []
        for neighbor in intersections:
            if current != neighbor:
                dist = heuristica(current, neighbor)
                if dist < 0.0005:  # Umbral de cercanía
                    graph[current].append(neighbor)

    # Nodos abiertos (por explorar)
    open_list = []
    open_list.append((0 + heuristica(start, goal), 0, start))

    # Mapas de padres y costos
    came_from = {}
    g_score = {start: 0}

    while open_list:
        # Nodo con el menor f-score
        current_f, current_g, current = open_list[0]
        for node in open_list:
            if node[0] < current_f:
                current_f, current_g, current = node

        open_list.remove((current_f, current_g, current))

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
        for neighbor in graph.get(current, []):
            tentative_g_score = current_g + 1  # Asumimos que la distancia entre nodos es 1
            if neighbor not in g_score or tentative_g_score < g_score[neighbor]:
                came_from[neighbor] = current
                g_score[neighbor] = tentative_g_score
                f_score = tentative_g_score + heuristica(neighbor, goal)
                open_list.append((f_score, tentative_g_score, neighbor))

    return None  # Si no se encuentra un camino

def process_location(start_lat, start_lon, goal_lat, goal_lon, intersections_json):
    try:
        # Decodificar el JSON
        intersections = json.loads(intersections_json)  # Aquí se recibe el JSON como cadena
        print(f"Intersections received: {intersections}")

        # Convertir los datos a un formato más sencillo
        locations = []
        for loc in intersections:
            latitude = loc["position"]["latitude"]
            longitude = loc["position"]["longitude"]
            locations.append((latitude, longitude))  # Cada intersección es una tupla (lat, lon)

        start = (start_lat, start_lon)
        goal = (goal_lat, goal_lon)

        # Si el start no está en las intersecciones, lo agregamos
        # (Opcionalmente, podrías verificar qué tan cerca está de las intersecciones
        # para ver si es razonable agregarlo. Aquí simplemente lo agregamos.)
        if start not in locations:
            locations.append(start)

        # Si el goal no está en las intersecciones, lo agregamos también
        if goal not in locations:
            locations.append(goal)

        # Ahora llamamos a A* con la lista 'locations' que incluye start y goal
        path = a_star(start, goal, locations)

        if path:
            # Devolvemos el path como JSON. El path es una lista de tuplas (lat, lon).
            return json.dumps(path)
        else:
            return json.dumps([])

    except Exception as e:
        return json.dumps({"error": str(e)})

