(defn bfs [graph start end]
  ((fn [frontier explored]
    (if (empty? frontier)
      "Failure"
      (let [path (first frontier)
            node (peek path)
            childs (keys (graph node))]
        (if (= node end)
          path
          (recur 
            (concat (rest frontier) (map #(conj path %)
              (filter #(not (contains? explored %)) childs)))
            (conj explored node))))))
    (vector (vector start)) #{}))



(def graph {
        "Oradea" {
            "Zerind" 71,
            "Sibiu" 151
        },
        "Zerind" {
            "Oradea" 71,
            "Arad" 75
        },
        "Arad" {
            "Zerind" 75,
            "Sibiu" 140,
            "Timisoara" 118
        },
        "Sibiu" {
            "Oradea" 151,
            "Arad" 140,
            "Fagaras" 99,
            "Rimnicu Vilcea" 80
        },
        "Fagaras" {
            "Sibiu" 99,
            "Bucharest" 211
        },
        "Rimnicu Vilcea" {
            "Sibiu" 80,
            "Pitesti" 97,
            "Craiova" 146
        },
        "Timisoara" {
            "Arad" 118,
            "Lugoj" 111
        },
        "Lugoj" {
            "Timisoara" 111,
            "Mehadia" 70
        },
        "Pitesti" {
            "Rimnicu Vilcea" 97,
            "Craiova" 138,
            "Bucharest" 101
        },
        "Mehadia" {
            "Lugoj" 70,
            "Drobeta" 75
        },
        "Drobeta" {
            "Mehadia" 75,
            "Craiova" 120
        },
        "Craiova" {
            "Drobeta" 120,
            "Rimnicu Vilcea" 146,
            "Pitesti" 138
        },
        "Bucharest" {
            "Pitesti" 101,
            "Fagaras" 211,
            "Giurgiu" 90,
            "Urziceni" 85
        },
        "Giurgiu" {
            "Bucharest" 90
        },
        "Urziceni" {
            "Bucharest" 85,
            "Vaslui" 142,
            "Hirsova" 98
        },
        "Hirsova" {
            "Urziceni" 98,
            "Eforie" 86
        },
        "Eforie" {
            "Hirsova" 86
        },
        "Vaslui" {
            "Iasi" 92,
            "Urziceni" 142
        },
        "Iasi" {
            "Neamt" 87,
            "Vaslui" 92
        },
        "Neamt" {
            "Iasi" 87
        }})

(println (bfs graph "Neamt" "Iasi"))
(println (bfs graph "Neamt" "Vaslui"))
(println (bfs graph "Bucharest" "Arad"))
