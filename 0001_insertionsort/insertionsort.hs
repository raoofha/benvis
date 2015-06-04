
insert y [] = [y]
insert y (x:sorted) = if y > x then x:(insert y sorted) else y:x:sorted

insertionsort [] = []
insertionsort (x:[]) = [x]
insertionsort (x:xs) = insert x (insertionsort xs)

main = print (insertionsort [ 23, 24, 52, 69, 1, 193, 34, 95, 3, 910 ])
