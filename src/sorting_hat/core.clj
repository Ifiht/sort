(ns sorting-hat.core
	(:gen-class)
	(:require '[clojure.java.jdbc :as sql]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "db/database.db"
   })

(defn -main [& args]
  (println "Welcome to my project! These are your args:" args))

(defn init-db []
  (try
    (sql/with-connection db
      (sql/create-table
       :books
       [:title "varchar(250)"]
       [:review "varchar(500)"]))
    (catch Exception ex
      (.getMessage (.getNextException ex)))))

(defn add-book
  [book]
  (sql/with-connection
    db
    (sql/insert-record :books book)))

(defn db-read-all
  []
  (sql/with-connection db
    (sql/with-query-results result
      ["SELECT * FROM books"]
      (into [] result))))