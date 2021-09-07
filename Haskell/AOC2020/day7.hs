import Data.List.Split.Internals (splitOn)
import Data.Char

main = do
    input <- readFile "input/test7.txt"
    let processed = map(splitOn "contain") $ splitOn "\n" input
    print $ map parseBag processed

data Bag = Bag {parent:: String , children:: [String]} deriving (Show)

parseBag :: [String] -> Bag
parseBag [a,b] = Bag {parent= concat $ take 2 $ words a, children = splitChildren b }

splitChildren :: String -> [String]
splitChildren x = filter (not . null) $ map (dropWhile (not . isAlpha) . removeS . removeSpace) (splitOn "bag" x)

removeSpace :: String -> String
removeSpace = filter (not. (`elem` " "))

removeS :: String -> String
removeS ('s':xs) = xs
removeS xs = xs 