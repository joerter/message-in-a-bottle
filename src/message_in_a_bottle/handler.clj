(ns message-in-a-bottle.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [message-in-a-bottle.handlers :as handlers]))

(defroutes app-routes
  (GET "/" [] (handlers/home))
  (GET "/read-message" [] (handlers/read-message))
  (GET "/send-message" [] (handlers/send-message))
  (POST "/send-message" [message] (handlers/sent-message message))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
