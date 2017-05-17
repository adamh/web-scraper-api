(ns web-scraper-api.database
    (:require [clojure.java.jdbc :as sql]))

(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "db/database.db"
   })

(defn output-all-animals
  [conn]
  (sql/query conn "SELECT * FROM animals"))

(defn output-animals-with-imgs
  [conn]
  (sql/query conn "SELECT * FROM animals WHERE img IS NOT NULL"))

(defn output-animal
  [conn, id]
  (sql/query conn ["SELECT * FROM animals WHERE id = ?" id]))