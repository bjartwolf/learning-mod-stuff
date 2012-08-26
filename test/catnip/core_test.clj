(ns catnip.core-test
  (:use clojure.test
        catnip.core
        clojure.math.numeric-tower))

(deftest a-test
  (testing "Testing congruency"
    (is ((congruent 5)  -8 7))
    (not ((congruent 5)  -7 7 ))
    (is ((congruent 12)  38 14))
    (not ((congruent 12)  38 13))
    (is ((congruent 5)  2 -3)) 
    (is ((congruent 5) -3 -8))))

(deftest fermat-test
  (testing "Testing fermats little theorem"
    (let [p 5]
    (is ((congruent p)  (expt 2 (- p 1)) 1)) 
    (is ((congruent p)  (expt 3 (- p 1)) 1)) 
    (is ((congruent p)  (expt 4 (- p 1)) 1))
    (not ((congruent p)  (expt 5 (- p 1)) 1))
)))

(deftest fermat2-test
  (testing "Testing fermats little theorem for another prime"
    (let [p 7]
    (is ((congruent p)  (expt 2 (- p 1)) 1)) 
    (is ((congruent p)  (expt 3 (- p 1)) 1)) 
    (is ((congruent p)  (expt 4 (- p 1)) 1))
    (is ((congruent p)  (expt 5 (- p 1)) 1))
    (is ((congruent p)  (expt 6 (- p 1)) 1))
    (not ((congruent p)  (expt 7 (- p 1)) 1))
    (is ((congruent p)  (expt 8 (- p 1)) 1))
    (not ((congruent p)  (expt 14 (- p 1)) 1))
    (not ((congruent p)  (expt 21 (- p 1)) 1))
)))