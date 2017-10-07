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
                                                               (decipher "hcqxqqtqljmlzhwiivgbsapaiwcenmyu" "packmyboxwithfivedozenliquorjugs")) :default :advanced)))))))

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