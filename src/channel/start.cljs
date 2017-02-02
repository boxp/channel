(ns channel.start
  (:require [channel.presenter.core :refer [render!]]
            [channel.presenter.status :refer [status-component]]))

(enable-console-print!)

(defn ^:export main []
  (println "hoge")
  (render! (status-component)))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)

)
