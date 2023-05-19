(ns flathead.pages.blog
  (:require [flathead.template.page :as page]))

(defn render [ctx]
  (page/render
    [:h1 "Blog"]

    ))
