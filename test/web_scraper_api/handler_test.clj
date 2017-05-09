(ns web-scraper-api.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [cheshire.core :refer :all]
            [web-scraper-api.handler :refer :all]))

; These tests rely on a database in db/database.db
; the handler needs to be refactored to allow
; a test database to exist.

(deftest test-app
  (testing "animals route"
    (let [response (app (mock/request :get "/animals"))]
      (is (= (:status response) 200))
      (is (= (:headers response) {"Content-Type" "application/json"}))))

  (testing "animals/random route"
    (let [response (app (mock/request :get "/animals/random"))]
      (is (= (:status response) 200))
      (is (= (:headers response) {"Content-Type" "application/json; charset=utf-8"}))
      (is (= (count (parse-string (:body response))) 6))))

  (testing "animals/:id route"
    (let [response (app (mock/request :get "/animals/1"))]
      (is (= (:status response) 200))
      (is (= (:headers response) {"Content-Type" "application/json"}))
      (let [body (parse-string (:body response))]
        (is (= (get body "id") 1)))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404))))

  (testing "animals/:id out of bounds route"
    (let [response (app (mock/request :get "/animals/99999999"))]
      (is (= (:status response) 404)))))
