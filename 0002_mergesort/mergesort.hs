split [] = ([],[])
split (x:[]) = ([x],[])
split (x:y:[]) = ([x],[y])
split (x:y:xs) = (x:l,y:r) where (l,r) = split xs

merge [] [] = []
merge [x] [] = [x]
merge [] [x] = [x]
merge xs [] = xs
merge [] xs = xs
merge allx@(x:xs) ally@(y:ys) = if x > y then y:(merge allx ys) else x:(merge xs ally)

mergesort [] = []
mergesort [x] = [x]
mergesort xs = merge (mergesort l) (mergesort r) where (l,r) = split xs

main = print (mergesort [ -10, 23, 24, 52, 69, 1, 193, 34, 95, 3, 910 ])
