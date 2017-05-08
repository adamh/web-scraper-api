(defproject web-scraper-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://adamh.io"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.6.0"]
                 [ring/ring-jetty-adapter "1.6.0"]
                 [ring/ring-defaults "0.3.0"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.6.0"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [org.xerial/sqlite-jdbc "3.7.2"]
                 [cheshire "5.7.1"]]
  :plugins [[lein-ring "0.11.0"]]
  ; See https://github.com/weavejester/lein-ring#web-server-options for the
  ; various options available for the lein-ring plugin
  :ring {:handler web-scraper-api.handler/app
         :port 8080
         :nrepl {:start? true
                 :port 9998}}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
