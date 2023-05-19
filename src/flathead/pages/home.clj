(ns flathead.pages.home
  (:require [flathead.template.page :as page]))

(defn render []
  (page/render
    [:div.grid-container
     [:div.grid-x
      [:div {:class "cell"} [:h1 "Welcome to Flathead Flat Earth!"]]
      [:div {:class "cell"}
       [:div [:img {:src "/img/background/flatheadLake.jpg"}]]]
      [:div {:class "cell welcomeText"}
       [:p "We're an educational and research group based in the Flathead Valley, Montana."
        [:br]
        "For more information, please see our" [:a {:href "/about.html"} " about page"] "."
        [:br]
        "Curious to learn more? We invite you to join us at one of our upcoming " [:a {:href "/events.html"} " events."]]]]]
    [:div {:class "grid-container"}
     [:div.grid-x
      [:div {:class "cell"}
       [:p.align-center-middle [:a {:href "https://www.flickr.com/photos/rogerlynn/14465675086/in/photostream/"} "Photo Credit"]]]]]))
