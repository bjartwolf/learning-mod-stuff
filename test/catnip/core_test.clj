(ns catnip.core-test
  (:use clojure.test
        catnip.core
        clojure.math.numeric-tower))

(deftest congruency-test
  (testing "Explaining basic congruency"
    (is ((congruent 5) 5 10)) 
      ; remainder of (10-5)/5 is 0
      ; 5 + 5*1 = 10
      
    (is (not ((congruent 5) 5 11))) 
      ; remainder of (11-5)/5 is 1
      ; 5 + 5*n != 11
                        
    (is ((congruent 12)  38 14)) 
      ; remainder of (38-14)/12 is 0
      ; 14+12*2 = 38
      
    (is (not ((congruent 12) 38 15))) 
      ; remainder of (38-15)/12 is 11
      ; 14+12*n != 38
))

(deftest congruency-of-neg-numbers-test
  (testing "Congruency of negative numbers"
    (is ((congruent 5)  -8 7)) ;
          ; remainder of (-8 -7)/5 is 0
          ; -8 + 3*5 = 7
          
    (is (not ((congruent 5)  -7 7 )))
          ; remainder of (-7-7)/5 is 4
          ; -7 + n*5 != 7
          
    (is ((congruent 5)  2 -3)) 
          ; remainder of (2 - (-3))/5 is 0
          ; 2 + -1*5 = -3
          
    (is ((congruent 5) -3 -8))
          ; remainder of (-3 - (-8))/5 is 0
          ; -3 + (-1)*5 = -8
))

(deftest fermat-little-theorem-test-1
  (testing "Showing some props of fermats little theorem"
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
  (testing "Same properties with variables"
    (let [p 13
          a 4
          b 10]
    (is ((congruent p)  (expt a p) a))
    (is ((congruent p)  (expt b p) b))
    (is ((congruent p)  (expt 21 p) 21))
)))

(deftest fermat-little-theorem-test-3
  (testing "Same properties, new prime"
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


(deftest fermat-little-theorem-test-nonprime
  (testing "Noneprime"
    (let [p 8
          congruent-8 (congruent p)]
    (is (not (congruent-8  (expt 2 (- p 1)) 1)))
    (is (not (congruent-8  (expt 3 (- p 1)) 1))) 
    (is (not (congruent-8  (expt 4 (- p 1)) 1)))
    (is (not (congruent-8  (expt 5 (- p 1)) 1)))
    (is (not (congruent-8  (expt 6 (- p 1)) 1)))
    (is (not (congruent-8  (expt 7 (- p 1)) 1)))
)))


(deftest finding-a-fermat-liar
  (testing "Liar! Liar! 221 is not a prime, but 38 lies!"
    (let [p 221
          congruent-221 (congruent p)]
    (is (congruent-221  (expt 38 (- p 1)) 1)) 
      ; 31 is a bloody liar!
    (is (congruent-221  (expt 21 (- p 1)) 1)) 
      ; 21 is a bloody liar too! They all lie!
    (is (not (congruent-221  (expt 26 (- p 1)) 1))) 
      ; but other gives it away
    (is (not (congruent-221  (expt 22 (- p 1)) 1))) 
      ; but other gives it away
)))
