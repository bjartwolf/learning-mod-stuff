(ns catnip.core)

(defn congruent [x]
  "I return a check if two functions are congruent x"
  (fn [a b] 
    (= (rem (- a b) x) 0 )))

(defn congruent10 [a b]
  "I check if two functions are congruent 10"
  ((congruent 10) a b))

(congruent10 47 57)
((congruent 5) -3 -8)