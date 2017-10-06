(ns code-katas.chapters
  (:require [clojurecademy.dsl.core :refer :all]
            [code-katas.katas.intro :refer :all]
            [code-katas.katas.popular :refer :all]))


(def ch-katas (chapter 'ch-katas
                       "Katas"
                       sub-ch-intro
                       sub-ch-popular))