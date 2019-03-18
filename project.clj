(defproject sorting-hat "0.0.1"
  :description "Sort all the things"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
  				[org.clojure/java.jdbc "0.6.1"]
  				[org.xerial/sqlite-jdbc "3.23.1"]]
  :main ^:skip-aot my-stuff.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :repl-options {:init-ns sorting-hat.core})

