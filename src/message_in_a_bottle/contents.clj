(ns message-in-a-bottle.contents
  [:require [message-in-a-bottle.layouts :as layouts]
   [hiccup.form :as hf]
   [ring.util.anti-forgery :as rf]])

(defn home
  []
  (layouts/default "Message in a Bottle"
    [:p "You found a bottle on the shore!"]
    [:a {:href "/read-message"} "\uD83D\uDCE8 Read message"]))

(defn read-message
  [message]
  (layouts/default "Read Message"
    [:p "The message is..."]
    [:div.message [:p message]]
    [:p "What will you do now?"]
    [:a {:href "/send-message"} "✍️ Send your own message"]
    [:a {:href "read-message"} "\uD83D\uDCE8 Read another message"]))

(defn send-message
  [validation-message]
  (layouts/default "Send Message"
    [:p "Write your message below. Unfortunately, the paper can only hold 250 characters."]
    (if (nil? validation-message) [:span] [:p validation-message])
    (hf/form-to [:post "/send-message"]
                [:textarea {:name "message" :autofocus "true" :rows "10"}]
                [:input {:type "submit" :value "Send"}]
                (rf/anti-forgery-field))))

(defn sent-message
  [message-response]
  (layouts/default "Sent Message"
    [:h1 "Your message was sent!"]
    [:p "Would you like to read another message?"]
    [:a {:href "/read-message"} "\uD83D\uDCE8 Read another message"]))
