(ns message-in-a-bottle.handlers
  (:require [message-in-a-bottle.contents :as contents]
            [message-in-a-bottle.db :as db]))

(defn valid-message? [message]
  (<= (count message) 250))

(defn home
  []
  (contents/home))

(defn read-message
  []
  (contents/read-message (db/get-message)))

(defn send-message
  []
  (contents/send-message nil))

(defn sent-message
  [message]
  (if (valid-message? message)
    (contents/sent-message (db/save-message message))
    (contents/send-message "Your message was too long!")))
