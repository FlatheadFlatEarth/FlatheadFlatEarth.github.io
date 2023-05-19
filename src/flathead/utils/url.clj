(ns flathead.utils.url
  (:import [java.net URLEncoder]
           [java.nio.charset StandardCharsets]))

(defn url-encode [s]
  (URLEncoder/encode s (.toString StandardCharsets/UTF_8)))
