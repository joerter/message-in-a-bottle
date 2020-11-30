(ns message-in-a-bottle.db
  (:require [taoensso.carmine :as car :refer (wcar)]
            [environ.core :refer [env]]))

(def redis-uri
  (env :redis))

(def server1-conn {:pool {} :spec {:uri redis-uri}})
(defmacro wcar* [& body] `(car/wcar server1-conn ~@body))

(defn uuid []
  (.toString (java.util.UUID/randomUUID)))

(defn save-message [message]
  (wcar*
   (car/set (uuid) message)))

(defn random-key []
  (wcar*
   (car/randomkey)))

(defn get-message []
  (wcar*
   (car/get (random-key))))
