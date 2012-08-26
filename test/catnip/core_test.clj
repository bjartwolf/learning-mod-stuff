(ns catnip.core-test
  (:use clojure.test
        catnip.core))

(deftest a-test
  (testing "Testing congruency"
    (is (= ((congruent 5)  -8 7) true))
    (not (= ((congruent 5)  -7 7) true))
    (is (= ((congruent 12)  38 14) true))
    (not (= ((congruent 12)  38 13) true))
    (is (= ((congruent 5)  2 -3) true)) 
    (is (= ((congruent 5) -3 -8) true))))