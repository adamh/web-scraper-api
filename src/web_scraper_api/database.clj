(ns web-scraper-api.database
    (:require [clojure.java.jdbc :as sql]))

(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "db/database.db"
   })

(defn output-all-animals
  [conn]
  (sql/query conn "select * from animals"))

(defn output-animal
  [conn, id]
  (sql/query conn ["select * from animals where id = ?" id]))