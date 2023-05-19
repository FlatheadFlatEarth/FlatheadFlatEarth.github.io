(ns flathead.template.page
  (:require
   [flathead.widgets.nav-bar :refer [nav-bar]]
   [hiccup.core :refer [html]]))

(defn render [& content]
  (html
    [:head
     [:link
      {:rel "stylesheet"
       :href "https://cdn.jsdelivr.net/npm/foundation-sites@6.7.5/dist/css/foundation.min.css"
       :crossorigin "anonymous"}]

     [:link {:rel "stylesheet" :href "/styles/app.css"}]

     [:script
      {:src "https://cdn.jsdelivr.net/npm/foundation-sites@6.7.5/dist/js/foundation.min.js"
       :crossorigin "anonymous"}]]
    [:body
     (nav-bar)
     content]))
