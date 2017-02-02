(ns channel.presenter.status
  (:require [cljsjs.pixi]
            [channel.presenter.core :refer [IComponent]]
            [channel.infra.sub.me :as sub]
            [channel.infra.action.me :as action]))

(defn container []
  (js/PIXI.Container.))

(defn message []
  (js/PIXI.Text. "Hello, Pixi!"
                 #js {:fontFamily "Arial"
                      :fontSize 32
                      :fill "white"}))

(defrecord StatusComponent [container message]
  IComponent
  (container [this] (:container this))
  (open [this]
    (.addChild (:container this) (:message this))
    (-> (sub/get-me)
        (.subscribe
          (fn [me]
            (set! (.-text (:message this)) (:name me))))))
  (close [this]))

(defn status-component []
  (->StatusComponent (container) (message)))
