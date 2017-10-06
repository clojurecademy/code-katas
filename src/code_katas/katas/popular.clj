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
                                                        (is (= (fizzbuzz 11) "11") :default :advanced)))))))


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