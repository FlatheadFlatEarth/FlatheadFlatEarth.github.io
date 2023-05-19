(ns flathead.pages.events
  (:require
   [flathead.template.page :as page]
   [flathead.utils.date :refer [format-date]]
   [flathead.utils.parse :refer [parse-description]]
   [flathead.utils.url :refer [url-encode]]))

(def future-topics
  ["Flight Paths"
   "Biblical Support for a Flat Earth"
   "Antarctica Fakery"
   "The Night Sky"
   "The Motive"])

(defn presenter-widget [{:keys [presenters] :as ctx} id]
  (let [{:keys [name photo/url] :as presenter} (get presenters id)]
  [:div {:class "cell small-2"}
   [:div name]
   [:img {:src url
          :width 50
          :height 50}]]))

(defn key-value-pair [k v]
  [:span
   [:span {:class "pairLabel"} (str k ":")]
   " "
   v])

(defn event-type-label [{:keys [event/type] :as event}]
  (case type
    :presentation [:span {:class "label primary"} "Presentation"]
    :experiment   [:span {:class "label warning"} "Experiment"]
    ""))

(defn venue-widget [{:keys [venues] :as ctx} id]
  (let [{:keys [venue/name
                venue/address
                venue/detail
                venue/maps-url
                venue/url] :as venue} (get venues id)]
    [:div {:class "cell"}
     [:div
      (key-value-pair "Venue"
                      (if url
                        [:a {:href url} name]
                        name))]
     [:div (key-value-pair "Address"
                           [:a {:href (if maps-url
                                        maps-url
                                        (str "https://maps.google.com/?q=" (url-encode address)))}
                            address])]
     [:div
      (key-value-pair "Details" detail)]]))

(defn event [ctx {:keys [title
                         date
                         time/start
                         time/end
                         host
                         presenters
                         venue
                         fee
                         description] :as event}]
  [:div {:class "grid-x event"}
   ;;[:div {:class "cell small-8"}]
   ;;[:div {:class "cell small-4"} (event-type-label event)]
   [:div {:class "cell small-8"}
    [:h3 title]]
   [:div {:class "grid-y small-4"}
    [:div {:class "cell"} (event-type-label event)]
    [:div {:class "cell"}
     (key-value-pair "Date" (format-date date))]
    [:div {:class "cell"}
     (key-value-pair "Time" (str start " - " end))]]


   [:div {:class "cell small-8 eventDescription"}
    [:p
     [:span {:class "pairLabel"} "Description: "]
     [:br] description]]
   [:div {:class "cell small-4"} "Presenters: "
    ;; TODO: update this so that they render in a grid, not linearly
    (for [p presenters]
      (presenter-widget ctx p))]
   ;; TODO: drive with real venue data
   (venue-widget ctx venue)
   [:div {:class "cell"}
    (key-value-pair "Fee" fee)]])

(defn render [{:keys [events] :as ctx}]
  (page/render
    ;;[:div.grid-x.mainContainer
    [:div.grid-container
     [:div.grid-x
      [:div {:class "cell"}
       [:h1 "Events"]
       (for [e events]
         (event ctx e))]]]))

