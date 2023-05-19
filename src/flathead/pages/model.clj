(ns flathead.pages.model
  (:require [flathead.template.page :as page]))

(defn render []
  (page/render
    "The Model"))
