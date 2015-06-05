quicksort [] = []
quicksort (x:xs) = (quicksort [ a | a <-xs , a <= x ]) ++ [x] ++ (quicksort [ a | a <-xs , a > x ])

main = print (quicksort [ -10, 23, 24, 52, 69, 1, 193, 34, 95, 3, 910, 6 ])
