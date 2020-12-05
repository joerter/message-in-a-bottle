(defproject message-in-a-bottle "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring "1.8.2"]
                 [hiccup "1.0.5"]
                 [com.taoensso/carmine "3.1.0"]
                 [environ "1.2.0"]]
  :main message-in-a-bottle.handler
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler message-in-a-bottle.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
