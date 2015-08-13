import copy
#startstate = [[7, 2, 4],
#             [5, 0, 6],
#             [8, 3, 1]]
startstate =[[5, 1, 2],
             [0, 4, 8],
             [3, 6, 7]]
goalstate = [[0, 1, 2],
             [3, 4, 5],
             [6, 7, 8]]
boardsize = len(startstate[0])
def findblank(game):
    for i in range(3):
        for j in range(3):
            if game[i][j] is 0:
                return [i, j]
def left(game):
    z = findblank(game)
    if z[1] > 0:
        g = copy.deepcopy(game)
        g[z[0]][z[1]] = g[z[0]][z[1]-1]
        g[z[0]][z[1]-1] = 0
        return g
    else:
        return game
def right(game):
    z = findblank(game)
    if z[1] < boardsize-1:
        g = copy.deepcopy(game)
        g[z[0]][z[1]] = g[z[0]][z[1]+1]
        g[z[0]][z[1]+1] = 0
        return g
    else:
        return game
def up(game):
    z = findblank(game)
    if z[0] > 0:
        g = copy.deepcopy(game)
        g[z[0]][z[1]] = g[z[0]-1][z[1]]
        g[z[0]-1][z[1]] = 0
        return g
    else:
        return game
def down(game):
    z = findblank(game)
    if z[0] < boardsize-1:
        g = copy.deepcopy(game)
        g[z[0]][z[1]] = g[z[0]+1][z[1]]
        g[z[0]+1][z[1]] = 0
        return g
    else:
        return game

def actions(game):
    z = findblank(game)
    if z[0] is 0 and z[1] is 0:
        return [right, down]
    elif z[0] is 0 and z[1] is boardsize-1:
        return [left, down]
    elif z[0] is boardsize-1 and z[1] is 0:
        return [right, up]
    elif z[0] is boardsize-1 and z[1] is boardsize-1:
        return [left, up]
    elif z[0] is 0 and z[1] > 0 and z[1] < boardsize-1:
        return [left, right, down]
    elif z[0] is boardsize-1 and z[1] > 0 and z[1] < boardsize-1:
        return [left, right, up]
    elif z[1] is 0 and z[0] > 0 and z[0] < boardsize-1:
        return [right, up, down]
    elif z[1] is boardsize-1 and z[0] > 0 and z[0] < boardsize-1:
        return [left, up, down]
    else:
        return [right, left, up, down]

def solve(game):
    frontier = [[startstate]]
    explored = []
    while frontier:
        path = frontier.pop(0)
        node = path[-1]
        explored.append(node)
        if node == goalstate:
            return path
        for action in actions(node):
            child = action(node)
            if child not in explored:
                newpath = copy.deepcopy(path)
                newpath.append(child)
                frontier.append(newpath)
    return "Failure"

print(solve(startstate))
