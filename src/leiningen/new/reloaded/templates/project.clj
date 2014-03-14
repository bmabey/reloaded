(defproject {{full-name}} "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :profiles {:dev {:repl-options
                   {:init-ns user
                    :init (do (set! *print-length* 20)
                              (require '[colorize.core :refer [color]])
                              (->> "Run `(dev)` to enter the dev namespace."
                                   (color :cyan)
                                   println))}
                   :plugins [[lein-midje "3.1.1"]]
                   :dependencies [[org.clojure/tools.namespace "0.2.4"]

                                  [com.cemerick/pomegranate "0.2.0"]
                                  [criterium "0.4.3"]
                                  [midje "1.6.0"]
                                  [spyscope "0.1.4"]]
                   :source-paths ["dev"]}}
  :aliases {"dumbrepl" ["trampoline" "run" "-m" "clojure.main/main"]})
