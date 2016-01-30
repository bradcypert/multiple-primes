(ns multiple-primes.modules.primes)

(def iterable-seq (iterate inc 2))

(defn- reduce-to-non-zeros
  [lazy-sequence]
  (filter #(not= 0 (mod % (first lazy-sequence)))
            (rest lazy-sequence)))

(defn- generate-lazy-prime-seq
  "Generates a lazy sequence of primes via a sieve. Algorithm info: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes"
  [lazy-sequence]
  (cons (first lazy-sequence)
        (lazy-seq
          (generate-lazy-prime-seq
            (reduce-to-non-zeros lazy-sequence)))))

(defn generate-primes
  "Generates prime numbers given arguement 'n'"
  [n]
  (take n (generate-lazy-prime-seq iterable-seq)))
