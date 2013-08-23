(ns leiningen.new.bmabey-reloaded
  (:require [clojure.string :as str])
  (:use [leiningen.new.templates :only [renderer name-to-path ->files
                                        sanitize-ns project-name year]]))

(def render (renderer "reloaded/templates"))

(defn bmabey-reloaded
  "Project with tools.namespace, profiles, user.clj, midje, and other goodies.

This template generates a project skeleton using tools.namespace and
a :dev profile containing a user.clj file. It is based on the blog
article \"My Clojure Workflow, Reloaded\" at
http://thinkrelevance.com/blog/2013/06/04/clojure-workflow-reloaded

The only argument is a project name. The recommended form for a
project name is groupId/artifactId where groupId is a reversed domain
name that you own and artifactId is a descriptive name for the
project. Names without a groupId are also accepted."
  [name]
  (let [[groupId artifactId] (str/split name #"/" 2)
        artifactId (or artifactId groupId)]
    (println "Generating a project in directory" artifactId)
    (let [data {:full-name name
                :groupId groupId
                :artifactId artifactId
                :name artifactId  ; used by ->files
                :year (year)
                :main-ns (sanitize-ns name)
                :path (name-to-path name)}]
      (->files data
               [".gitignore" (render ".gitignore")]
               ["epl-v10.html" (render "epl-v10.html")]
               ["README.md" (render "README.md" data)]
               ["project.clj" (render "project.clj" data)]
               ["src/{{path}}.clj" (render "core.clj" data)]
               ["test/{{path}}_test.clj" (render "core_test.clj" data)]
               ["dev/user.clj" (render "user.clj" data)]))))
