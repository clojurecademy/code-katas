(ns code-katas.katas.intro
  (:require [clojurecademy.dsl.core :refer :all]
            [clojurecademy.dsl.test :refer :all]))

(def sub-ch-intro
  (sub-chapter 'sub-ch-intro
               "What is Code Kata?"

               (subject 'sbj-what-is-code-kata?
                        "About Code Kata"

                        (learn
                          (text
                            (p "A " (bold "code kata") " is an exercise in programming which helps programmers hone their skills through practice and repetition. The term was probably first coined by " (link "Dave Thomas" "https://goo.gl/N1bwfc") ", co-author of the book " (italic "The Pragmatic Programmer") ", in a bow to the Japanese concept of kata in the martial arts. As of October 2011, Dave Thomas has published 21 different katas.")

                            (p (bold "The Kata"))

                            (p "What makes a good practice session? You need time without interruptions, and a simple thing you want to try. You need to try it as many times as it takes, and be comfortable making mistakes. You need to look for feedback each time so you can work to improve. There needs to be no pressure: this is why it is hard to practice in a project environment. it helps to keep it fun: make small steps forward when you can. Finally, you’ll recognize a good practice session because you’ll came out of it knowing more than when you went in.")

                            (p "Code Kata is an attempt to bring this element of practice to software development. A kata is an exercise in karate where you repeat a form many, many times, making little improvements in each. The intent behind code kata is similar. Each is a short exercise (perhaps 30 minutes to an hour long). Some involve programming, and can be coded in many different ways. Some are open ended, and involve thinking about the issues behind programming. These are unlikely to have a single correct answer. I add a new kata every week or so. Invest some time in your craft and try them.")

                            (p "Remember that the point of the kata is not arriving at a correct answer. The point is the stuff you learn along the way. The goal is the practice, not the solution."))))))


