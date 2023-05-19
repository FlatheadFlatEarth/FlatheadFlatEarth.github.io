(ns flathead.utils.parse
  (:require [clojure.string :as str]))

(defn parse-description [s]
  (let [lines (->> (str/split s #"\n")
                   (map str/trim))]
    (interpose [:br] lines)))

#_(parse-description "hello
                   this is a multi-line
                   string")
