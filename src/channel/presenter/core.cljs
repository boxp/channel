(ns channel.presenter.core
  (:refer-clojure :exclude [update])
  (:require [cljsjs.pixi]
            [channel.infra.action.me :as action-me]))

(enable-console-print!)

(defprotocol IComponent
  (container [this])
  (open [this])
  (close [this]))

(def renderer (js/PIXI.autoDetectRenderer 256 256))

(def component (atom nil))

(defn render-loop []
  (js/requestAnimationFrame render-loop)
  (.render renderer (container @component)))

(defn render!
  [c]
  (js/document.body.appendChild (.-view renderer))
  (open c)
  (reset! component c)
  (render-loop))

(defn switch-component!
  [c]
  (close @component)
  (open c)
  (reset! @component c))
