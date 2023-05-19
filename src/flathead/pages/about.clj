(ns flathead.pages.about
  (:require [flathead.template.page :as page]))

(defn render []
  (page/render
    [:div.grid-container
     ;;[:div.grid-x.mainContainer
     [:div.grid-x
      [:div {:class "cell"} [:h1 "About Flathead Flat Earth"]]
      [:p
       "Our mission is to educate the Flathead Valley on the evidence refuting the Globe model of the Earth." [:br]
       "We plan to do so through lectures, scientific experiments, and publications." [:br]
       "We have found that the shape of the Earth is not only an important subject in its own right but also an excellent subject for the practice of epistemology, mastery of which improves citizens' understanding of the world around them." [:br]
       "We meet on a regular basis in the Flathead Valley, Montana." [:br]
       "Please see our "
       [:a {:href "/events.html"} "events page"]
       " for information on upcoming and past events."
       ]]]))
