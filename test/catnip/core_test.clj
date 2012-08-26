(ns catnip.core-test
  (:use clojure.test
        catnip.core))

(deftest a-test
  (testing "Testing congruency"
    (is ((congruent 5)  -8 7))
    (not ((congruent 5)  -7 7 ))
    (is ((congruent 12)  38 14))
    (not ((congruent 12)  38 13))
    (is ((congruent 5)  2 -3)) 
    (is ((congruent 5) -3 -8))))