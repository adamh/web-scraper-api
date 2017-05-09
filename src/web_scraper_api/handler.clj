(ns web-scraper-api.handler
  (:use ring.util.response)
  (:require [web-scraper-api.database :refer :all]
            [compojure.handler :as handler]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn get-animal
  [id]
  (let [results (output-animal db id)]
    (if (empty? results)
      {:status 404}
      (-> (response (first results))
          (content-type "application/json"))))) 
          ; compojure/ring kept repsponding with text/plain (?!) 
          ; so I made an it an explicit content-type

(defn get-all-animals
    []
    (-> (response (output-all-animals db))
        (content-type "application/json")))

(defn get-random-animals
    []
    (let [animals (output-all-animals db)]
      (response [(rand-nth animals), (rand-nth animals), 
                (rand-nth animals), (rand-nth animals),
                (rand-nth animals), (rand-nth animals)])))

(defroutes app-routes
  (context "/animals" [] (defroutes animals-routes
    (GET "/" [] (get-all-animals))
    (GET "/random" [] (get-random-animals))
    (context "/:id{[0-9]+}" [id] (defroutes animal-routes
      (GET "/" [] (get-animal id))))))
  (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)
      (middleware/wrap-json-params)))
