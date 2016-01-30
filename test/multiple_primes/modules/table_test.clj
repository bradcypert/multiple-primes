(ns multiple-primes.modules.table-test
  (:require [clojure.test :refer :all]
            [multiple-primes.modules.table :refer :all]))

;;I normally wouldn't monkey with testing private functions
;;however, the core logic comes is private, with the public
;;interface being used to print the output
(def private-build-header #'multiple-primes.modules.table/build-header)
(def private-build-row #'multiple-primes.modules.table/build-row)
(def private-build-rows #'multiple-primes.modules.table/build-rows)

(deftest test-build-header
  (testing "Header should contain two spaces at start"
    (is (= "  " (subs (private-build-header [1 2 3]) 0 2))))

  (testing "Sample Header"
    (is (= "  1 2 3" (private-build-header [1 2 3])))))

(deftest test-build-row
  (testing "Row should start with the base value for that row"
    (is (= "2" (subs (private-build-row 2 [1 2 3]) 0 1))))

  (testing "Sample row, given base of 2 and sequence [1,2,3]"
    (is (= "2 2 4 6" (private-build-row 2 [1 2 3])))))

(deftest test-build-rows
  (testing "Sample row from Build Rows given seq [1,2,3]"
    (is (= "1 1 2 3" (first (private-build-rows [1,2,3]))))))


