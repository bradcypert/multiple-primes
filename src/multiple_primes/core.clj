(ns multiple-primes.core
  (:require [multiple-primes.modules.primes :refer [generate-primes]]
            [multiple-primes.modules.table :refer [print-table-for-seq]])
  (:gen-class))

(def ^:const default-prime-count 10)
(def ^:const error-input-message "Not a valid number entered. Using 10 instead.")

(defn- isValidAsNumber?
  "Checks if a string is valid for a number regex check"
  [num-string]
  (and
    (not (empty? num-string))
    (not (empty? (re-find #"\d*" num-string)))))

(defn- parse-input-for-number
  "Parses the user input and returns the number of primes to build table against."
  [args]
  (let [num-input (get (apply hash-map args) "-n")]
    (if (isValidAsNumber? num-input)
      (Integer/parseInt num-input)
      (do
        (println error-input-message)
        default-prime-count))))

(defn -main
  "Initial dispatcher for Prime Multiplication Table generator"
  [& args]
  (let [prime-seq (generate-primes (parse-input-for-number args))]
     (print-table-for-seq prime-seq)))