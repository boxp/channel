(ns channel.infra.store.core
  (:require-macros [channel.macros :refer [cljs-env]]))

(defn debug
  [action old-state next-state]
  (when (= (cljs-env :mode) :debug)
    (js/console.group)
    (js/console.log (str "prev state: " old-state))
    (js/console.log (str "action: " action))
    (js/console.log (str "next state: " next-state))
    (js/console.groupEnd)))
