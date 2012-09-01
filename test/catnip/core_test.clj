(ns catnip.core-test
  (:use clojure.test
        catnip.core
        clojure.math.numeric-tower))

(deftest congruency-test
  (testing "Explaining basic congruency"
    (is ((congruent 5) 5 10))
    (is (not ((congruent 5) 5 11)))
    (is ((congruent 12)  38 14))
    (is (not ((congruent 12) 38 15)))
))

(deftest congruency-of-neg-numbers-test
  (testing "Congruency of negative numbers"
    (is ((congruent 5)  -8 7))
    (is (not ((congruent 5)  -7 7 )))
    (is ((congruent 5)  2 -3)) 
    (is ((congruent 5) -3 -8))
))

(deftest fermat-little-theorem-test-1
  (testing "Testing fermats little theorem"
    (let [p 5]
    (is ((congruent p)  (expt 2 (- p 1)) 1)) 
    (is ((congruent p)  (expt 3 (- p 1)) 1)) 
    (is ((congruent p)  (expt 4 (- p 1)) 1))
    (is (not ((congruent p)  (expt 5 (- p 1)) 1)))
    (is (not ((congruent p)  (expt 10 (- p 1)) 1)))
    (is ((congruent p)  (expt 15 (- p 1)) 0))
    (is ((congruent p)  (expt 25 (- p 1)) 0))
)))


(deftest fermat-little-theorem-test-2
  (testing "Testing fermats theorem"
    (let [p 13
          a 4
          b 10]
    (is ((congruent p)  (expt a p) a))
    (is ((congruent p)  (expt b p) b))
    (is ((congruent p)  (expt 21 p) 21))
)))

(deftest fermat-little-theorem-test-3
  (testing "Testing fermats little theorem for another prime"
    (let [p 7
          congruent-7 (congruent p)]
    (is (congruent-7  (expt 2 (- p 1)) 1)) 
    (is (congruent-7  (expt 3 (- p 1)) 1)) 
    (is (congruent-7  (expt 4 (- p 1)) 1))
    (is (congruent-7  (expt 5 (- p 1)) 1))
    (is (congruent-7  (expt 6 (- p 1)) 1))
    (is (not (congruent-7  (expt 7 (- p 1)) 1)))
    (is (congruent-7  (expt 8 (- p 1)) 1))
    (is (not (congruent-7 (expt 14 (- p 1)) 1)))
    (is (not (congruent-7 (expt 21 (- p 1)) 1)))
)))