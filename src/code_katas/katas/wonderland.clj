(ns code-katas.katas.wonderland
  (:require [clojurecademy.dsl.core :refer :all]
            [clojurecademy.dsl.test :refer :all]))


(def sub-ch-wonderland
  (sub-chapter 'sub-ch-wonderland
               "Wonderland Katas"

               (subject 'sbj-alphabet-cipher
                        "Alphabet Cipher"

                        (learn
                          (text
                            (p "Lewis Carroll published a cipher known as " (link "The Alphabet Cipher" "https://en.wikipedia.org/wiki/The_Alphabet_Cipher"))
                            (p "This Alphabet Cipher involves alphabet substitution using a keyword.")
                            (p "First you must make a substitution chart like this, where each row of the alphabet is rotated by one as each letter goes down the chart.")
                            (code ";   ABCDEFGHIJKLMNOPQRSTUVWXYZ\n; A abcdefghijklmnopqrstuvwxyz\n; B bcdefghijklmnopqrstuvwxyza\n; C cdefghijklmnopqrstuvwxyzab\n; D defghijklmnopqrstuvwxyzabc\n; E efghijklmnopqrstuvwxyzabcd\n; F fghijklmnopqrstuvwxyzabcde\n; G ghijklmnopqrstuvwxyzabcdef\n; H hijklmnopqrstuvwxyzabcdefg\n; I ijklmnopqrstuvwxyzabcdefgh\n; J jklmnopqrstuvwxyzabcdefghi\n; K klmnopqrstuvwxyzabcdefghij\n; L lmnopqrstuvwxyzabcdefghijk\n; M mnopqrstuvwxyzabcdefghijkl\n; N nopqrstuvwxyzabcdefghijklm\n; O opqrstuvwxyzabcdefghijklmn\n; P pqrstuvwxyzabcdefghijklmno\n; Q qrstuvwxyzabcdefghijklmnop\n; R rstuvwxyzabcdefghijklmnopq\n; S stuvwxyzabcdefghijklmnopqr\n; T tuvwxyzabcdefghijklmnopqrs\n; U uvwxyzabcdefghijklmnopqrst\n; V vwxyzabcdefghijklmnopqrstu\n; W wxyzabcdefghijklmnopqrstuv\n; X xyzabcdefghijklmnopqrstuvw\n; Y yzabcdefghijklmnopqrstuvwx\n; Z zabcdefghijklmnopqrstuvwxy")
                            (p "Both parties need to decide on a secret keyword. This keyword is not written down anywhere, but memorized.")
                            (p "To encode the message, first write down the message:")
                            (p (hi "meetmebythetree"))
                            (p "Then, write the keyword, (which in this case is scones), repeated as many times as necessary.\n\n")
                            (p (hi "sconessconessco"))
                            (p (hi "meetmebythetree"))
                            (p "Now you can look up the column S in the table and follow it down until it meets the M row. The value at the intersection is the letter e. All the letters would be thus encoded.")
                            (p (hi "sconessconessco"))
                            (p (hi "meetmebythetree"))
                            (p (hi "egsgqwtahuiljgs"))
                            (p "The encoded message is now " (hi "egsgqwtahuiljgs"))
                            (p "To decode, the person would use the secret keyword and do the opposite.")))

                        (instruction 'ins-alphabet-cipher
                                     (run-pre-tests? true)
                                     (initial-code "(ns alphabet-cipher.coder)\n\n\n(defn encode [keyword message]\n  \"encodeme\")\n\n\n(defn decode [keyword message]\n  \"decodeme\")\n\n\n(defn decipher [cipher message]\n  \"decypherme\")")
                                     (rule :no-rule? true)

                                     (sub-instruction 'sub-ins-encode
                                                      (text
                                                        (p "Please fill " (hi "encode") " function and make sure that following test are passing.")
                                                        (code "(= \"hmkbxebpxpmyllyrxiiqtoltfgzzv\"\n   (encode \"vigilance\" \"meetmeontuesdayeveningatseven\"))")
                                                        (code "(= \"egsgqwtahuiljgs\"\n   (encode \"scones\" \"meetmebythetree\"))"))

                                                      (testing
                                                        (is (= "hmkbxebpxpmyllyrxiiqtoltfgzzv"
                                                               (encode "vigilance" "meetmeontuesdayeveningatseven")) :default :advanced)
                                                        (is (= "egsgqwtahuiljgs"
                                                               (encode "scones" "meetmebythetree")) :default :advanced)))

                                     (sub-instruction 'sub-ins-decode
                                                      (text
                                                        (p "Please fill " (hi "decode") " function and make sure that following test are passing.")
                                                        (code "(= \"meetmeontuesdayeveningatseven\"\n   (decode \"vigilance\" \"hmkbxebpxpmyllyrxiiqtoltfgzzv\"))")
                                                        (code "(= \"meetmebythetree\"\n   (decode \"scones\" \"egsgqwtahuiljgs\"))"))

                                                      (testing
                                                        (is (= "meetmeontuesdayeveningatseven"
                                                               (decode "vigilance" "hmkbxebpxpmyllyrxiiqtoltfgzzv")) :default :advanced)
                                                        (is (= "meetmebythetree"
                                                               (decode "scones" "egsgqwtahuiljgs")) :default :advanced)))

                                     (sub-instruction 'sub-ins-decipher
                                                      (text
                                                        (p "Please fill " (hi "decipher") " function and make sure that following test are passing.")
                                                        (code "(= \"vigilance\"\n   (decipher \"opkyfipmfmwcvqoklyhxywgeecpvhelzg\" \"thequickbrownfoxjumpsoveralazydog\"))")
                                                        (code "(= \"scones\"\n   (decipher \"hcqxqqtqljmlzhwiivgbsapaiwcenmyu\" \"packmyboxwithfivedozenliquorjugs\"))"))

                                                      (testing
                                                        (is (= "vigilance"
                                                               (decipher "opkyfipmfmwcvqoklyhxywgeecpvhelzg" "thequickbrownfoxjumpsoveralazydog"))
                                                            :default :advanced)
                                                        (is (= "scones"
                                                               (decipher "hcqxqqtqljmlzhwiivgbsapaiwcenmyu" "packmyboxwithfivedozenliquorjugs")) :default :advanced)))))


               (subject 'subj-card-game-war
                        "Card Game War"

                        (learn
                          (text
                            (p "This kata is a version of the classic card game " (link "War" "https://en.wikipedia.org/wiki/War_%28card_game%29") ".")
                            (p "The rules of this card game are quite simple.")
                            (p "There are " (bold "two") " players.")
                            (p "The cards are all dealt equally to each player.")
                            (p "Each round, player 1 lays a card down face up at the same time that player 2 lays a card down face up. Whoever has the highest value card, wins both round and takes both cards.")
                            (p "The winning cards are added to the bottom of the winners deck.")
                            (p "Aces are high.")
                            (p "If both cards are of equal value, then the winner is decided upon by the highest suit. The suits ranks in order of ascending value are spades, clubs, diamonds, and hearts.")
                            (p "The player that runs out of cards loses.")))

                        (instruction 'ins-card-game-war
                                     (run-pre-tests? true)
                                     (initial-code "(ns card-game-war.game)\n\n(def suits [:spade :club :diamond :heart])\n(def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])\n(def cards\n  (for [suit suits\n        rank ranks]\n    [suit rank]))\n\n\n(defn play-round \n  [player1-card player2-card]\n  ;;fill me\n  )\n\n\n(defn play-game \n  [player1-cards player2-cards]\n  ;;fill me\n  )")
                                     (rule :no-rule? true)

                                     (sub-instruction 'sub-ins-highest-rank
                                                      (text
                                                        (p "The highest rank wins the cards in the round.")
                                                        (code "(= [[[:spade 4] [:spade 2]] []]\n   (play-round [:spade 4] [:spade 2]))")
                                                        (code "(= [[] [[:spade 4] [:spade 2]]]\n   (play-round [:spade 2] [:spade 4]))"))

                                                      (testing
                                                        (is (= [[[:spade 4] [:spade 2]] []] (play-round [:spade 4] [:spade 2])) :default :advanced)
                                                        (is (= [[] [[:spade 4] [:spade 2]]] (play-round [:spade 2] [:spade 4])) :default :advanced)))

                                     (sub-instruction 'sub-ins-queens-are-higher
                                                      (text
                                                        (p "Queens are higher rank than jacks.")
                                                        (code "(= [[[:spade :queen] [:spade :jack]] []]\n   (play-round [:spade :queen] [:spade :jack]))"))

                                                      (testing
                                                        (is (= [[[:spade :queen] [:spade :jack]] []] (play-round [:spade :queen] [:spade :jack])) :default :advanced)))

                                     (sub-instruction 'sub-ins-kings-are-higher
                                                      (text
                                                        (p "Kings are higer rank than queens.")
                                                        (code "(= [[[:spade :king] [:spade :queen]] []]\n   (play-round [:spade :king] [:spade :queen]))"))

                                                      (testing
                                                        (is (= [[[:spade :king] [:spade :queen]] []] (play-round [:spade :king] [:spade :queen])) :default :advanced)))

                                     (sub-instruction 'sub-ins-aces-are-higher
                                                      (text
                                                        (p "Aces are higer rank than kings.")
                                                        (code "(= [[[:spade :ace] [:spade :king]] []]\n   (play-round [:spade :ace] [:spade :king]))"))

                                                      (testing
                                                        (is (= [[[:spade :ace] [:spade :king]] []] (play-round [:spade :ace] [:spade :king])) :default :advanced)))

                                     (sub-instruction 'sub-ins-clubs-beats-pades
                                                      (text
                                                        (p "If the ranks are equal, clubs beat spades.")
                                                        (code "(= [[[:club 2] [:spade 2]] []]\n   (play-round [:club 2] [:spade 2]))"))

                                                      (testing
                                                        (is (= [[[:club 2] [:spade 2]] []] (play-round [:club 2] [:spade 2])) :default :advanced)))

                                     (sub-instruction 'sub-ins-diamonds-beat-clubs
                                                      (text
                                                        (p "If the ranks are equal, diamonds beat clubs.")
                                                        (code "(= [[[:diamond 2] [:club 2]] []]\n   (play-round [:diamond 2] [:club 2]))"))

                                                      (testing
                                                        (is (= [[[:club 2] [:spade 2]] []] (play-round [:club 2] [:spade 2])) :default :advanced)))

                                     (sub-instruction 'sub-ins-hearts-beat-diamonds
                                                      (text
                                                        (p "If the ranks are equal, hearts beat diamonds.")
                                                        (code "(= [[[:heart 2] [:diamond 2]] []]\n   (play-round [:heart 2] [:diamond 2]))"))

                                                      (testing
                                                        (is (= [[[:heart 2] [:diamond 2]] []] (play-round [:heart 2] [:diamond 2])) :default :advanced)))

                                     (sub-instruction 'sub-ins-player-loses
                                                      (text
                                                        (p "The player loses when they run out of cards.")
                                                        (code "(let [win-start  [[:heart 10]]\n      lose-start [[:heart 9]]]\n  (= :player1 (play-game win-start lose-start))\n  (= :player2 (play-game lose-start win-start)))"))

                                                      (testing
                                                        (is (= :player1 (play-game [[:heart 10]] [[:heart 9]])) :default :advanced)
                                                        (is (= :player2 (play-game [[:heart 9]] [[:heart 10]])) :default :advanced)))

                                     ))

               (subject 'sbj-tiny-maze
                        "Tiny Maze"

                        (learn
                          (text
                            (p "Alice found herself very tiny and wandering around Wonderland. Even the grass around her seemed like a maze.")
                            (p "This is a tiny maze solver.")
                            (p "A maze is represented by a matrix:")
                            (code "[[:S 0 1]\n [1  0 1]\n [1  0 :E]]")
                            (p "S : start of the maze")
                            (p "E : end of the maze")
                            (p "1 : This is a wall that you cannot pass through")
                            (p "0 : A free space that you can move through")
                            (p "The goal is the get to the end of the maze. A solved maze will have a :x in the start, the path, and the end of the maze, like this:")
                            (code "[[:x :x 1]\n [1  :x 1]\n [1  :x :x]]")))

                        (instruction 'ins-tiny-maze
                                     (run-pre-tests? true)
                                     (initial-code "(ns tiny-maze.solver)\n\n\n(defn solve-maze \n  [maze]\n  ;fill me\n  )")
                                     (rule :no-rule? true)

                                     (sub-instruction 'sub-ins-3x3-maze
                                                      (text
                                                        (p "Can find way to exit with 3x3 maze:")
                                                        (code "(let [maze [[:S 0 1]\n            [1 0 1]\n            [1 0 :E]]\n      sol  [[:x :x 1]\n            [1 :x 1]\n            [1 :x :x]]]\n  (= sol (solve-maze maze)))"))

                                                      (testing
                                                        (is (= [[:x :x 1] [1 :x 1] [1 :x :x]]
                                                               (solve-maze [[:S 0 1] [1 0 1] [1 0 :E]])) :default :advanced)))

                                     (sub-instruction 'sub-ins-4x4-maze
                                                      (text
                                                        (p "Can find way to exit with 4x4 maze:")
                                                        (code "(let [maze [[:S 0 0 1]\n            [1 1 0 0]\n            [1 0 0 1]\n            [1 1 0 :E]]\n      sol  [[:x :x :x 1]\n            [1 1 :x 0]\n            [1 0 :x 1]\n            [1 1 :x :x]]]\n  (= sol (solve-maze maze)))"))

                                                      (testing
                                                        (is (= [[:x :x :x 1] [1 1 :x 0] [1 0 :x 1] [1 1 :x :x]]
                                                               (solve-maze [[:S 0 0 1] [1 1 0 0] [1 0 0 1] [1 1 0 :E]])) :default :advanced)))))))


(defcoursetest my-wonderful-test-1
               [ch-katas sub-ch-wonderland sbj-alphabet-cipher ins-alphabet-cipher sub-ins-encode]
               (defn char-int [c]
                 (- (int c) 97))

               (defn int-char [i]
                 (char (+ i 97)))

               (defn encode [keyword message]
                 (apply str (for [i (range 0 (count message))
                                  :let [m (int-char (mod (+ (char-int (nth keyword (mod i (count keyword))))
                                                            (char-int (nth message i)))
                                                         26))]] m))))

(defcoursetest my-wonderful-test-2
               [ch-katas sub-ch-wonderland sbj-alphabet-cipher ins-alphabet-cipher sub-ins-decode]
               (defn char-int [c]
                 (- (int c) 97))

               (defn int-char [i]
                 (char (+ i 97)))

               (defn encode [keyword message]
                 (apply str (for [i (range 0 (count message))
                                  :let [m (int-char (mod (+ (char-int (nth keyword (mod i (count keyword))))
                                                            (char-int (nth message i)))
                                                         26))]] m)))

               (defn decode [keyword message]
                 (apply str (for [i (range 0 (count message))
                                  :let [m (int-char (mod (- (char-int (nth message i))
                                                            (char-int (nth keyword (mod i (count keyword)))))

                                                         26))]]
                              m))))


(defcoursetest my-wonderful-test-3
               [ch-katas sub-ch-wonderland sbj-alphabet-cipher ins-alphabet-cipher sub-ins-decipher]
               (defn to-keyword [c]
                 (keyword (str c)))

               (def a-z (mapv #(to-keyword (char %)) (range 97 123)))

               (defn idx->str [x]
                 (if (> x 25)
                   (name (a-z (rem x 26)))
                   (name (a-z x))))

               (defn key->idx [k c]
                 (.indexOf c k))

               (defn ->enc [[key char] coll]
                 (let [k (key->idx key coll)
                       c (key->idx char coll)
                       i (+ k c)]
                   (if (> i 25)
                     (idx->str (rem i 26))
                     (idx->str i))))

               (defn ->dec [[key char] coll]
                 (let [k (key->idx key coll)
                       c (key->idx char coll)]
                   (idx->str (+ c (- 26 k)))))

               (defn rpt-keyword [k m]
                 (reduce str (take (count m) (cycle k))))

               (defn match-key-message [keyword message]
                 (map #(vector (to-keyword %1) (to-keyword %2))
                      (rpt-keyword keyword message) message))

               (defn encode [keyword message]
                 (reduce (fn [a b] (str a (->enc b a-z))) ""
                         (match-key-message keyword message)))

               (defn check [keyword test]
                 (= keyword (rpt-keyword test keyword)))

               (defn decode [keyword message]
                 (let [m (match-key-message keyword message)]
                   (reduce (fn [a b] (str a (->dec b a-z))) ""
                           (match-key-message keyword message))))

               (defn decipher [cipher message]
                 (let [keystr (decode message cipher)
                       perms  (reductions #(str % %2) "" keystr)]
                   (loop [h (first perms)
                          t (rest perms)]
                     (cond
                       (check keystr h) h
                       (empty? t) :not-found
                       :else (recur (first t) (rest t)))))))


(defcoursetest my-wonderful-test-4
               [ch-katas sub-ch-wonderland subj-card-game-war ins-card-game-war sub-ins-highest-rank]
               (def suits [:spade :club :diamond :heart])
               (def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
               (def cards
                 (for [suit suits
                       rank ranks]
                   [suit rank]))

               (defn keyfn [[suit rank]]
                 (+
                   (* 100 (.indexOf ranks rank))
                   (.indexOf suits suit)))

               (defn play-round [player1-card player2-card]
                 (if (> (keyfn player1-card) (keyfn player2-card))
                   [[player1-card player2-card] []]
                   [[] [player2-card player1-card]])))


(defcoursetest my-wonderful-test-5
               [ch-katas sub-ch-wonderland subj-card-game-war ins-card-game-war sub-ins-queens-are-higher]
               (def suits [:spade :club :diamond :heart])
               (def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
               (def cards
                 (for [suit suits
                       rank ranks]
                   [suit rank]))

               (defn keyfn [[suit rank]]
                 (+
                   (* 100 (.indexOf ranks rank))
                   (.indexOf suits suit)))

               (defn play-round [player1-card player2-card]
                 (if (> (keyfn player1-card) (keyfn player2-card))
                   [[player1-card player2-card] []]
                   [[] [player2-card player1-card]])))


(defcoursetest my-wonderful-test-6
               [ch-katas sub-ch-wonderland subj-card-game-war ins-card-game-war sub-ins-kings-are-higher]
               (def suits [:spade :club :diamond :heart])
               (def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
               (def cards
                 (for [suit suits
                       rank ranks]
                   [suit rank]))

               (defn keyfn [[suit rank]]
                 (+
                   (* 100 (.indexOf ranks rank))
                   (.indexOf suits suit)))

               (defn play-round [player1-card player2-card]
                 (if (> (keyfn player1-card) (keyfn player2-card))
                   [[player1-card player2-card] []]
                   [[] [player2-card player1-card]])))


(defcoursetest my-wonderful-test-7
               [ch-katas sub-ch-wonderland subj-card-game-war ins-card-game-war sub-ins-aces-are-higher]
               (def suits [:spade :club :diamond :heart])
               (def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
               (def cards
                 (for [suit suits
                       rank ranks]
                   [suit rank]))

               (defn keyfn [[suit rank]]
                 (+
                   (* 100 (.indexOf ranks rank))
                   (.indexOf suits suit)))

               (defn play-round [player1-card player2-card]
                 (if (> (keyfn player1-card) (keyfn player2-card))
                   [[player1-card player2-card] []]
                   [[] [player2-card player1-card]])))


(defcoursetest my-wonderful-test-8
               [ch-katas sub-ch-wonderland subj-card-game-war ins-card-game-war sub-ins-clubs-beats-pades]
               (def suits [:spade :club :diamond :heart])
               (def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
               (def cards
                 (for [suit suits
                       rank ranks]
                   [suit rank]))

               (defn keyfn [[suit rank]]
                 (+
                   (* 100 (.indexOf ranks rank))
                   (.indexOf suits suit)))

               (defn play-round [player1-card player2-card]
                 (if (> (keyfn player1-card) (keyfn player2-card))
                   [[player1-card player2-card] []]
                   [[] [player2-card player1-card]])))


(defcoursetest my-wonderful-test-9
               [ch-katas sub-ch-wonderland subj-card-game-war ins-card-game-war sub-ins-diamonds-beat-clubs]
               (def suits [:spade :club :diamond :heart])
               (def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
               (def cards
                 (for [suit suits
                       rank ranks]
                   [suit rank]))

               (defn keyfn [[suit rank]]
                 (+
                   (* 100 (.indexOf ranks rank))
                   (.indexOf suits suit)))

               (defn play-round [player1-card player2-card]
                 (if (> (keyfn player1-card) (keyfn player2-card))
                   [[player1-card player2-card] []]
                   [[] [player2-card player1-card]])))


(defcoursetest my-wonderful-test-10
               [ch-katas sub-ch-wonderland subj-card-game-war ins-card-game-war sub-ins-hearts-beat-diamonds]
               (def suits [:spade :club :diamond :heart])
               (def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
               (def cards
                 (for [suit suits
                       rank ranks]
                   [suit rank]))

               (defn keyfn [[suit rank]]
                 (+
                   (* 100 (.indexOf ranks rank))
                   (.indexOf suits suit)))

               (defn play-round [player1-card player2-card]
                 (if (> (keyfn player1-card) (keyfn player2-card))
                   [[player1-card player2-card] []]
                   [[] [player2-card player1-card]])))


(defcoursetest my-wonderful-test-11
               [ch-katas sub-ch-wonderland subj-card-game-war ins-card-game-war sub-ins-player-loses]
               (def suits [:spade :club :diamond :heart])
               (def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
               (def cards
                 (for [suit suits
                       rank ranks]
                   [suit rank]))

               (defn keyfn [[suit rank]]
                 (+
                   (* 100 (.indexOf ranks rank))
                   (.indexOf suits suit)))

               (defn play-round [player1-card player2-card]
                 (if (> (keyfn player1-card) (keyfn player2-card))
                   [[player1-card player2-card] []]
                   [[] [player2-card player1-card]]))

               (defn next-step [[player1-cards player2-cards]]
                 (if (or (empty? player1-cards) (empty? player2-cards))
                   nil
                   (let [[player1-result player2-result]
                         (play-round (first player1-cards) (first player2-cards))]
                     [(concat (rest player1-cards) player1-result)
                      (concat (rest player2-cards) player2-result)])))

               (defn play-game [player1-cards player2-cards]
                 (let [game-steps (take-while identity (iterate next-step [player1-cards player2-cards]))
                       end-state  (last game-steps)
                       [player1-end player2-end] end-state]
                   (cond (not (empty? player1-end)) :player1
                         (not (empty? player2-end)) :player2
                         :else :draw))))


(defcoursetest my-wonderful-test-12
               [ch-katas sub-ch-wonderland sbj-tiny-maze ins-tiny-maze sub-ins-3x3-maze]
               (defn- row-count
                 "Returns the row count of the maze.
                  (row-count [[1] [2] [3]])
                  => 3"
                 [maze]
                 (count maze))

               (defn- col-count
                 "Returns the column count of the maze.
                  (col-count [[1 2 3]])
                  => 3"
                 [maze]
                 (count (first maze)))

               (defn- start-position
                 "Finds the start position in the maze.
                  (start-position [[:S 0 1] [0 0 1] [1 0 :E]])
                  => [0 0]"
                 [maze]
                 (let [index (.indexOf (flatten maze) :S)]
                   [(unchecked-divide-int index (row-count maze)) (mod index (col-count maze))]))

               (defn- in-bounds?
                 "Checks to see if the passed position is in the bounds of the row and columns of the maze.
                  (in-bounds? 3 3 [4 0])
                  => false
                  (in-bounds? 3 3 [1 1])
                  => true"
                 [rows cols [x y]]
                 (not (or (< x 0) (< y 0) (>= x rows) (>= y cols))))

               (defn- valid-move?
                 "Checks to see if the position is a valid position given a move. Valid positions are only those that are in bounds and
                  have either a 0 or :E in their spot.
                  (valid-move? [[:x :x 1] [0 0 1] [1 0 :E]] [1 2])
                  => false
                  (valid-move? [[:x :x 1] [0 0 1] [1 0 :E]] [1 1])
                  => true"
                 [move pos]
                 (let [value (get-in move pos)]
                   (or (= value 0) (= value :E))))

               (defn- next-moves
                 "Returns only the next valid positions given a maze and a current position.
                 (next-moves [0 0] [[:x 0 1] [0 0 1] [1 0 :E]])
                 => ([1 0] [0 1])"
                 [[x y] maze]
                 (let [rows      (row-count maze)
                       cols      (col-count maze)
                       positions [[(+ x 1) y] [x (+ y 1)] [x (- y 1)] [(- x 1) y]]]
                   (filter #(and (in-bounds? rows cols %) (valid-move? maze %)) positions)))

               (defn- solved?
                 "Checks to see if the maze is solved by determining if there is an :E in the maze.
                  (solved? [[:x :x 1] [1 :x 1] [1 :x :x]])
                  => true
                  (solved? [[:x :x 1] [1 :x 1] [1 :x :E]])
                  => false"
                 [maze]
                 (= -1 (.indexOf (flatten maze) :E)))

               (defn- solutions
                 "Finds all possible solutions to the maze."
                 [position moves]
                 (let [current-move (last moves)
                       next-moves   (next-moves position current-move)]
                   (if-not (seq next-moves)
                     (when (solved? current-move)
                       [moves])
                     (mapcat #(solutions % (conj moves (assoc-in current-move % :x))) next-moves))))

               (defn solve-maze
                 "Solves the maze and returns the shortest solution."
                 [maze]
                 (let [start-position (start-position maze)
                       initial-moves  [(assoc-in maze start-position :x)]]
                   (->> (solutions start-position initial-moves)
                        (sort-by count)
                        first
                        last))))


(defcoursetest my-wonderful-test-13
               [ch-katas sub-ch-wonderland sbj-tiny-maze ins-tiny-maze sub-ins-4x4-maze]
               (defn- row-count
                 "Returns the row count of the maze.
                  (row-count [[1] [2] [3]])
                  => 3"
                 [maze]
                 (count maze))

               (defn- col-count
                 "Returns the column count of the maze.
                  (col-count [[1 2 3]])
                  => 3"
                 [maze]
                 (count (first maze)))

               (defn- start-position
                 "Finds the start position in the maze.
                  (start-position [[:S 0 1] [0 0 1] [1 0 :E]])
                  => [0 0]"
                 [maze]
                 (let [index (.indexOf (flatten maze) :S)]
                   [(unchecked-divide-int index (row-count maze)) (mod index (col-count maze))]))

               (defn- in-bounds?
                 "Checks to see if the passed position is in the bounds of the row and columns of the maze.
                  (in-bounds? 3 3 [4 0])
                  => false
                  (in-bounds? 3 3 [1 1])
                  => true"
                 [rows cols [x y]]
                 (not (or (< x 0) (< y 0) (>= x rows) (>= y cols))))

               (defn- valid-move?
                 "Checks to see if the position is a valid position given a move. Valid positions are only those that are in bounds and
                  have either a 0 or :E in their spot.
                  (valid-move? [[:x :x 1] [0 0 1] [1 0 :E]] [1 2])
                  => false
                  (valid-move? [[:x :x 1] [0 0 1] [1 0 :E]] [1 1])
                  => true"
                 [move pos]
                 (let [value (get-in move pos)]
                   (or (= value 0) (= value :E))))

               (defn- next-moves
                 "Returns only the next valid positions given a maze and a current position.
                 (next-moves [0 0] [[:x 0 1] [0 0 1] [1 0 :E]])
                 => ([1 0] [0 1])"
                 [[x y] maze]
                 (let [rows      (row-count maze)
                       cols      (col-count maze)
                       positions [[(+ x 1) y] [x (+ y 1)] [x (- y 1)] [(- x 1) y]]]
                   (filter #(and (in-bounds? rows cols %) (valid-move? maze %)) positions)))

               (defn- solved?
                 "Checks to see if the maze is solved by determining if there is an :E in the maze.
                  (solved? [[:x :x 1] [1 :x 1] [1 :x :x]])
                  => true
                  (solved? [[:x :x 1] [1 :x 1] [1 :x :E]])
                  => false"
                 [maze]
                 (= -1 (.indexOf (flatten maze) :E)))

               (defn- solutions
                 "Finds all possible solutions to the maze."
                 [position moves]
                 (let [current-move (last moves)
                       next-moves   (next-moves position current-move)]
                   (if-not (seq next-moves)
                     (when (solved? current-move)
                       [moves])
                     (mapcat #(solutions % (conj moves (assoc-in current-move % :x))) next-moves))))

               (defn solve-maze
                 "Solves the maze and returns the shortest solution."
                 [maze]
                 (let [start-position (start-position maze)
                       initial-moves  [(assoc-in maze start-position :x)]]
                   (->> (solutions start-position initial-moves)
                        (sort-by count)
                        first
                        last))))