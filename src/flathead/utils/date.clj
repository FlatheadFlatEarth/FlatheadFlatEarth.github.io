(ns flathead.utils.date
  (:import
   [java.time.format DateTimeFormatter]
   [java.util Locale]
   [java.time LocalDate]))

(def formatter (DateTimeFormatter/ofPattern "M/d/yy" Locale/ENGLISH))

(def human-formatter (DateTimeFormatter/ofPattern "MMMM d, yyyy" Locale/ENGLISH))

(defn ordinal [^long i]
  (let [suffixes ["th" "st" "nd" "rd" "th" "th" "th" "th" "th" "th"]]
    (case (mod i 100)
      (11 12 13) (str i "th")
      (str i
        (nth suffixes (mod i 10) )))))

(defn parse-date [s]
  (LocalDate/parse s formatter))

(defn format-date [d]
  (.format human-formatter d))

#_(-> "12/01/23"
      parse-date
      format-date)

;;(format-date (LocalDate/now))

#_(->> (range 100)
     (map ordinal))
