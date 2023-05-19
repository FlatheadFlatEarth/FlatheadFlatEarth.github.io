(ns flathead.core
  (:require
    [flathead.pages.about :as about]
    [flathead.pages.blog :as blog]
    [flathead.pages.events :as events]
    [flathead.pages.home :as home]
    [flathead.pages.model :as model]
    [flathead.utils.date :refer [parse-date]]
    [flathead.utils.parse :refer [parse-description]]

    [optimus.prime :as optimus]
    [optimus.assets :as assets]
    [optimus.optimizations :as optimizations]
    [optimus.strategies :refer [serve-live-assets]]
    [optimus.export]

    [ring.middleware.content-type :refer [wrap-content-type]]
    [ring.adapter.jetty :refer [run-jetty]]
    [stasis.core :as stasis]))

(def target-dir "target/")

(defn get-assets []
  (assets/load-assets "public" ["/styles/app.css"
                                ;;#"/img/presenters/.*\.jpg"
                                #"/img/.*\.jpg"
                                ]))


(def articles (stasis/slurp-directory "resources/articles/" #"\.md$"))

#_(def products (->> (slurp-directory "resources/products/" #"\.edn$")
                   (vals)
                   (map read-string)))

(defn read-datatype [dt]
  (->> (stasis/slurp-directory (format "resources/%s/" dt) #"\.edn$")
       (vals)
       (map read-string)))

(def venues (->> (read-datatype "venues")
                 (map (fn [v] [(:venue/id v) v]))
                 (into {})))

(def events (->> (read-datatype "events")
                 (map #(update % :date parse-date))
                 (map #(update % :description parse-description))
                 (sort-by :date)))
(def posts  (read-datatype "posts"))
(def presenters (->> (read-datatype "presenters")
                     (map (fn [p] [(:id p) p]))
                     (into {})))

(def context {:events events
              :venues venues
              :presenters presenters})

(defn get-pages []
  {"/index.html"  (home/render)
   "/about.html"  (about/render)
   "/blog.html"   (blog/render posts)
   "/model.html"  (model/render)
   "/events.html" (events/render context)})

;;(def app (stasis/serve-pages get-pages))

(def app (-> (stasis/serve-pages get-pages)
             (optimus/wrap get-assets optimizations/all serve-live-assets)
             wrap-content-type))

(defn export []
  (stasis/empty-directory! target-dir)
  (stasis/export-pages (get-pages) target-dir))

(defn run-server []
  (run-jetty app {:port 3000}))

(get-assets)

