(ns channel.infra.store.me
  (:require [cljsjs.rx]
            [channel.infra.store.core :refer [debug]]))

(defrecord MeState [id name])

(def me-state (atom {:me (map->MeState {})}))
(def me-sub (js/Rx.Subject.))

(defmulti reducer (fn [state action] (:type action)))

(defmethod reducer :update
  [state action]
  (assoc state :me (:me action)))

(defn dispatch!
  [action]
  (let [s (reducer @me-state action)]
      (debug action @me-state s)
      (reset! me-state s)
      (.onNext me-sub s)))

(defn observable []
  (.asObservable me-sub))
