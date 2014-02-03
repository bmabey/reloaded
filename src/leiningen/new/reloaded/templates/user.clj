(ns user
  "Bootstrap fn for dev env."
  (:require clojure.stacktrace))

(defn dev
  []
  (try
    (require 'dev)
    (in-ns 'dev)
    ;; (println "Run (tools-help) to see a list of useful functions.")
    :ok
    (catch Throwable t
      (println "ERROR: There was a problem loading the dev namespace\n")
      (clojure.stacktrace/print-cause-trace t)
      (println))))
