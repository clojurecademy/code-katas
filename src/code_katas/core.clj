(ns code-katas.core
  (:require [clojurecademy.dsl.core :refer [manifest course]]
            [code-katas.chapters :refer :all]))

(def my-manifest (manifest :title "Code Katas"
                           :report-bug-email-or-link "https://github.com/clojurecademy/4Clojure/issues"
                           :name 'code-katas
                           :skip? true
                           :short-description "A curated list of code katas"
                           :long-description "A kata, or code kata, is defined as an exercise in programming which helps hone your skills through practice and repetition. Dave Thomas, started this movement for programming. These exercises vary from general to more complex algorithms and real life situations for you to try using Clojure programming language. Remember that code katas are not quizzes or puzzles. You should not only try to 'solve' it, but find a very good solution, following best practices of the programming language you are using."
                           :who-is-this-course-for :clojure-experience))

(def course-map (course my-manifest
                        ch-katas))