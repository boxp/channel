(ns channel.infra.sub.me
  (:require [channel.infra.store.me :refer [observable]]))

(def obs (observable))

(defn get-me []
  (-> obs
      (.map #(:me %))
      .distinctUntilChanged))
