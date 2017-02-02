(ns channel.infra.action.me
  (:require [channel.infra.store.me :refer [dispatch!]]))

(defn update-me
  [me]
  (dispatch! {:type :update :me me}))
