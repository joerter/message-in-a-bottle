(ns message-in-a-bottle.handlers
  (:require [message-in-a-bottle.contents :as contents]))

(defn home
  []
  (contents/home))

(defn read-message
  []
  (contents/read-message "hello there!"))

(defn send-message
  []
  (contents/send-message))

(defn sent-message
  [message]
  (contents/sent-message))
