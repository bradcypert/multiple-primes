(ns multiple-primes.modules.table
  (:require [clojure.string :refer [join]]))

(defn- build-header
  "Builds the header for the multiplication table, given a sequence"
  [sequence]
  (str "  " (join " " sequence)))

(defn- build-row
  "Builds a single row of the multiplication table, given the base num, and a sequence"
  [base sequence]
  (str base " " (join " " (map #(* base %1) sequence))))

(defn- build-rows
  "Builds the rows of the multiplication table, given a sequence of self-multiplying numbers."
  [sequence]
  (map #(build-row %1 sequence) sequence))

(defn print-table-for-seq
  "Builds a multiplication table for a given sequence of numbers."
  [sequence]
  (do
    (println (build-header sequence))
    (println (join "\n" (build-rows sequence)))))