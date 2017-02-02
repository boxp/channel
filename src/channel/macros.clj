(ns channel.macros
  (:require [environ.core :refer [env]]))

(defmacro cljs-env [k]
  (env k))
