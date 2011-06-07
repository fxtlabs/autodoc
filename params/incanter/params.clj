(import (java.io File))

(let [file-prefix (.getAbsolutePath (File. "../autodoc-work-area/incanter"))
      root (str file-prefix "/src/")]
  {:name "Incanter",
   :file-prefix file-prefix,
   :root root,
   :source-path "modules",
   :web-src-dir "https://github.com/liebke/incanter/blob/",

   :web-home "http://liebke.github.com/incanter/",
   :output-path (str file-prefix "/autodoc/"),
   :external-doc-tmpdir "/tmp/autodoc/doc",
;;   :clojure-contrib-classes (str root "build"),

   :load-jar-dirs [(str root "lib")],

   :namespaces-to-document ["incanter"],
   :trim-prefix "incanter.",

   :branches [{:name "master"
               :version "next"
               :status "in development"
               :params {:built-clojure-jar (str root "lib/clojure-1.2.0.jar")
                        :load-classpath [#"/modules/[^/]+/src$"]}},
              {:name "1.0.x"
               :version "1.0"
               :status "stable"
               :params {:built-clojure-jar (str root "lib/clojure-slim.jar")
                        :load-classpath [#"/modules/[^/]+/src/main/clojure$"]}}]

   :load-except-list [#"/test/" #"/classes/" #"project.clj$"],
   })

