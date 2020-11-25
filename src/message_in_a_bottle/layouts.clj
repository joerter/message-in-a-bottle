(ns message-in-a-bottle.layouts
  (:require [hiccup.page :as hp]))

(defn default
  [title & page-content]
  (hp/html5 {:lang "en"}
            [:head
             [:title title]
             (hp/include-css "/site.css")]
            [:body
             [:div.site [:div.header
                         [:h1 "✉️️ Message in a Bottle \uD83C\uDFDD️"]
                         [:h3 "The social network for deserted islanders"]]
              [:div.page-content page-content]]])

  )