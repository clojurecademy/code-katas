(ns code-katas.katas.popular
  (:require [clojurecademy.dsl.core :refer :all]
            [clojurecademy.dsl.test :refer :all]))


(def sub-ch-popular
  (sub-chapter 'sub-ch-popular
               "Popular Katas"

               (subject 'sb-fizzbuzz
                        "FizzBuzz"

                        (learn
                          (text
                            (p "Return " (bold "“fizz”") ", " (bold "“buzz”")
                               " or " (bold "“fizzbuzz”") ".")

                            (p "For a given natural number greater than zero return:")
                            (p (bold "“fizz”") " if the number is dividable by 3")
                            (p (bold "“buzz”") " if the number is dividable by 5")
                            (p (bold "“fizzbuzz”") " if the number is dividable by 15")
                            (p "the same number(in " (italic "String") " form) if no other requirement is fulfilled")))

                        (instruction 'ins-fizzbuzz
                                     (run-pre-tests? true)
                                     (initial-code "(ns fizzbuzz-kata)\n\n\n(defn fizzbuzz\n  [n]\n  )")
                                     (rule :no-rule? true)

                                     (sub-instruction 'sub-ins-dividable-by-3
                                                      (text
                                                        (p (hi "fizzbuzz") " function should return "
                                                           (bold "“fizz”")
                                                           " if given number dividable by 3."))

                                                      (testing
                                                        (is (= (fizzbuzz 3) "fizz") :default :advanced)
                                                        (is (= (fizzbuzz 6) "fizz") :default :advanced)
                                                        (is (= (fizzbuzz 9) "fizz") :default :advanced)
                                                        (is (= (fizzbuzz 12) "fizz") :default :advanced)
                                                        (is (= (fizzbuzz 18) "fizz") :default :advanced)
                                                        (is (= (fizzbuzz 21) "fizz") :default :advanced)
                                                        (is (= (fizzbuzz 24) "fizz") :default :advanced)))

                                     (sub-instruction 'sub-ins-dividable-by-5
                                                      (text
                                                        (p "Return " (bold "“buzz”") " if given number dividable by 5."))

                                                      (testing
                                                        (is (= (fizzbuzz 5) "buzz") :default :advanced)
                                                        (is (= (fizzbuzz 10) "buzz") :default :advanced)
                                                        (is (= (fizzbuzz 20) "buzz") :default :advanced)
                                                        (is (= (fizzbuzz 25) "buzz") :default :advanced)
                                                        (is (= (fizzbuzz 35) "buzz") :default :advanced)
                                                        (is (= (fizzbuzz 40) "buzz") :default :advanced)
                                                        (is (= (fizzbuzz 50) "buzz") :default :advanced)))

                                     (sub-instruction 'sub-ins-dividable-by-15
                                                      (text
                                                        (p "Return " (bold "“fizzbuzz”") " if given number dividable by 15."))

                                                      (testing
                                                        (is (= (fizzbuzz 0) "fizzbuzz") :default :advanced)
                                                        (is (= (fizzbuzz 15) "fizzbuzz") :default :advanced)
                                                        (is (= (fizzbuzz 30) "fizzbuzz") :default :advanced)
                                                        (is (= (fizzbuzz 45) "fizzbuzz") :default :advanced)
                                                        (is (= (fizzbuzz 60) "fizzbuzz") :default :advanced)
                                                        (is (= (fizzbuzz 75) "fizzbuzz") :default :advanced)
                                                        (is (= (fizzbuzz 90) "fizzbuzz") :default :advanced)
                                                        (is (= (fizzbuzz 105) "fizzbuzz") :default :advanced)))

                                     (sub-instruction 'sub-ins-not-fulfilled
                                                      (text
                                                        (p "Return same number in " (bold "String")
                                                           " form if no other requirement is fulfilled."))

                                                      (testing
                                                        (is (= (fizzbuzz 1) "1") :default :advanced)
                                                        (is (= (fizzbuzz 2) "2") :default :advanced)
                                                        (is (= (fizzbuzz 4) "4") :default :advanced)
                                                        (is (= (fizzbuzz 7) "7") :default :advanced)
                                                        (is (= (fizzbuzz 8) "8") :default :advanced)
                                                        (is (= (fizzbuzz 11) "11") :default :advanced)))))


               (subject 'sb-prime-factors
                        "Prime Factors"

                        (learn
                          (text
                            (p (bold "Prime Factors: ") "prime numbers that divide an integer without remainder.")
                            (p "e.g. " (hi "2 = 2, 4 = 2 * 2, 24 = 2 * 2 * 2 * 3") " and so on.")))

                        (instruction 'ins-prime-factors
                                     (run-pre-tests? true)
                                     (initial-code "(ns prime-factors-kata)\n\n\n(defn prime-factors\n  [n]\n  )")
                                     (rule :no-rule? true)

                                     (sub-instruction 'sub-ins-prime-factors-2
                                                      (text
                                                        (code (= (prime-factors 2) [2])))

                                                      (testing
                                                        (is (= (prime-factors 2) [2]) :default :advanced)))

                                     (sub-instruction 'sub-ins-prime-factors-3
                                                      (text
                                                        (code (= (prime-factors 3) [3])))

                                                      (testing
                                                        (is (= (prime-factors 3) [3]) :default :advanced)))

                                     (sub-instruction 'sub-ins-prime-factors-4
                                                      (text
                                                        (code (= (prime-factors 4) [2 2])))

                                                      (testing
                                                        (is (= (prime-factors 4) [2 2]) :default :advanced)))

                                     (sub-instruction 'sub-ins-prime-factors-6
                                                      (text
                                                        (code (= (prime-factors 6) [2 3])))

                                                      (testing
                                                        (is (= (prime-factors 6) [2 3]) :default :advanced)))

                                     (sub-instruction 'sub-ins-prime-factors-8
                                                      (text
                                                        (code (= (prime-factors 8) [2 2 2])))

                                                      (testing
                                                        (is (= (prime-factors 8) [2 2 2]) :default :advanced)))

                                     (sub-instruction 'sub-ins-prime-factors-9
                                                      (text
                                                        (code (= (prime-factors 9) [3 3])))

                                                      (testing
                                                        (is (= (prime-factors 9) [3 3]) :default :advanced)))

                                     (sub-instruction 'sub-ins-prime-factors-10
                                                      (text
                                                        (code (= (prime-factors 10) [2 5])))

                                                      (testing
                                                        (is (= (prime-factors 10) [2 5]) :default :advanced)))

                                     (sub-instruction 'sub-ins-prime-factors-60
                                                      (text
                                                        (code (= (prime-factors 60) [2 2 3 5])))

                                                      (testing
                                                        (is (= (prime-factors 60) [2 2 3 5]) :default :advanced)))))))


(defcoursetest my-test-1
               [ch-katas sub-ch-popular sb-fizzbuzz ins-fizzbuzz sub-ins-dividable-by-3]
               (defn fizzbuzz [x]
                 (let [v [(= (mod x 3) 0) (= (mod x 5) 0)]]
                   ({[true false] "fizz"} v))))


(defcoursetest my-test-2
               [ch-katas sub-ch-popular sb-fizzbuzz ins-fizzbuzz sub-ins-dividable-by-5]
               (defn fizzbuzz [x]
                 (let [v [(= (mod x 3) 0) (= (mod x 5) 0)]]
                   ({[true false] "fizz"
                     [false true] "buzz"} v))))


(defcoursetest my-test-3
               [ch-katas sub-ch-popular sb-fizzbuzz ins-fizzbuzz sub-ins-dividable-by-15]
               (defn fizzbuzz [x]
                 (let [v [(= (mod x 3) 0) (= (mod x 5) 0)]]
                   ({[true false] "fizz"
                     [false true] "buzz"
                     [true true]  "fizzbuzz"} v))))


(defcoursetest my-test-4
               [ch-katas sub-ch-popular sb-fizzbuzz ins-fizzbuzz sub-ins-not-fulfilled]
               (defn fizzbuzz [x]
                 (let [v [(= (mod x 3) 0) (= (mod x 5) 0)]]
                   ({[true false]  "fizz"
                     [false true]  "buzz"
                     [true true]   "fizzbuzz"
                     [false false] (str x)} v))))

(defcoursetest my-test-5
               [ch-katas sub-ch-popular sb-prime-factors ins-prime-factors sub-ins-prime-factors-2]
               (defn generate-with-candidate [x candidate]
                 (if (= x candidate)
                   [candidate]
                   (if (= 0 (rem x candidate))
                     (concat [candidate] (generate-with-candidate (/ x candidate) candidate))
                     (generate-with-candidate x (+ candidate 1)))))

               (defn prime-factors [x]
                 (generate-with-candidate x 2)))

(defcoursetest my-test-6
               [ch-katas sub-ch-popular sb-prime-factors ins-prime-factors sub-ins-prime-factors-3]
               (defn generate-with-candidate [x candidate]
                 (if (= x candidate)
                   [candidate]
                   (if (= 0 (rem x candidate))
                     (concat [candidate] (generate-with-candidate (/ x candidate) candidate))
                     (generate-with-candidate x (+ candidate 1)))))

               (defn prime-factors [x]
                 (generate-with-candidate x 2)))

(defcoursetest my-test-7
               [ch-katas sub-ch-popular sb-prime-factors ins-prime-factors sub-ins-prime-factors-4]
               (defn generate-with-candidate [x candidate]
                 (if (= x candidate)
                   [candidate]
                   (if (= 0 (rem x candidate))
                     (concat [candidate] (generate-with-candidate (/ x candidate) candidate))
                     (generate-with-candidate x (+ candidate 1)))))

               (defn prime-factors [x]
                 (generate-with-candidate x 2)))

(defcoursetest my-test-8
               [ch-katas sub-ch-popular sb-prime-factors ins-prime-factors sub-ins-prime-factors-6]
               (defn generate-with-candidate [x candidate]
                 (if (= x candidate)
                   [candidate]
                   (if (= 0 (rem x candidate))
                     (concat [candidate] (generate-with-candidate (/ x candidate) candidate))
                     (generate-with-candidate x (+ candidate 1)))))

               (defn prime-factors [x]
                 (generate-with-candidate x 2)))

(defcoursetest my-test-9
               [ch-katas sub-ch-popular sb-prime-factors ins-prime-factors sub-ins-prime-factors-8]
               (defn generate-with-candidate [x candidate]
                 (if (= x candidate)
                   [candidate]
                   (if (= 0 (rem x candidate))
                     (concat [candidate] (generate-with-candidate (/ x candidate) candidate))
                     (generate-with-candidate x (+ candidate 1)))))

               (defn prime-factors [x]
                 (generate-with-candidate x 2)))

(defcoursetest my-test-10
               [ch-katas sub-ch-popular sb-prime-factors ins-prime-factors sub-ins-prime-factors-9]
               (defn generate-with-candidate [x candidate]
                 (if (= x candidate)
                   [candidate]
                   (if (= 0 (rem x candidate))
                     (concat [candidate] (generate-with-candidate (/ x candidate) candidate))
                     (generate-with-candidate x (+ candidate 1)))))

               (defn prime-factors [x]
                 (generate-with-candidate x 2)))

(defcoursetest my-test-11
               [ch-katas sub-ch-popular sb-prime-factors ins-prime-factors sub-ins-prime-factors-10]
               (defn generate-with-candidate [x candidate]
                 (if (= x candidate)
                   [candidate]
                   (if (= 0 (rem x candidate))
                     (concat [candidate] (generate-with-candidate (/ x candidate) candidate))
                     (generate-with-candidate x (+ candidate 1)))))

               (defn prime-factors [x]
                 (generate-with-candidate x 2)))

(defcoursetest my-test-12
               [ch-katas sub-ch-popular sb-prime-factors ins-prime-factors sub-ins-prime-factors-60]
               (defn generate-with-candidate [x candidate]
                 (if (= x candidate)
                   [candidate]
                   (if (= 0 (rem x candidate))
                     (concat [candidate] (generate-with-candidate (/ x candidate) candidate))
                     (generate-with-candidate x (+ candidate 1)))))

               (defn prime-factors [x]
                 (generate-with-candidate x 2)))

