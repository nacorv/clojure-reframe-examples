(ns my-app.routes.home
  (:require
   [my-app.layout :as layout]
   [my-app.db.core :as db]
   [clojure.java.io :as io]
   [my-app.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html"))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/homepage" {:get (fn [_]
                         (-> (response/ok (-> "content/home-page.md" io/resource slurp))
                             (response/header "Content-Type" "text/plain; charset=utf-8")))}]
   ])
