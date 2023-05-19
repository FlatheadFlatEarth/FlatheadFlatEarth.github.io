(ns flathead.widgets.nav-bar)

(defn nav-bar []
  [:div {:class "top-bar"}

   [:div {:class "top-bar-left"}
    [:ul {:class "dropdown menu"
          :data-dropdown-menu ""}
     [:li {:class "menu-text"} "Flathead Flat Earth"]
     [:li
      [:a {:href "/index.html"} "Home"]]
     [:li
      [:a {:href "/events.html"} "Events"]]
     ;; [:li [:a {:href "/blog.html"} "Blog"]]
     [:li
      [:a {:href "/about.html"} "About"]]
     ]]

   #_[:div {:class "top-bar-right"}
    [:ul {:class "menu"}
     [:li
      [:input {:type "search" :placeholder "Search"}]]
     [:li
      [:button {:type "button" :class "button"} "Search"]]]]])
