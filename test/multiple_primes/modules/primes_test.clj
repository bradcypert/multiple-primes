(ns multiple-primes.modules.primes-test
  (:require [clojure.test :refer :all]
            [multiple-primes.modules.primes :refer :all]))

(deftest test-generate-primes
  (testing "should generate prime numbers when asked for 3 primes"
    (is (= [2 3 5] (generate-primes 3))))

  (testing "should generate prime numbers when asked for 10 primes"
    (is (= [2 3 5 7 11 13 17 19 23 29] (generate-primes 10)))))
