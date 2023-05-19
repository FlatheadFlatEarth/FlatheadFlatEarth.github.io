(defproject flathead "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [stasis/stasis "2.5.1"]
                 [hiccup/hiccup "1.0.5"]
                 [integrant/integrant "0.8.0"]
                 [optimus "2023-02-08"]
                 [ring/ring-jetty-adapter "1.10.0"]]
  :plugins [[lein-ring "0.12.6"]]
  :ring {:handler flathead.core/app}
  :main flathead.core
  :repl-options {:init-ns flathead.core})
