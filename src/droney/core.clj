(ns drone-remote.core
  (:import jline.Terminal)
  (:use [clj-drone.core])
  (:gen-class))

(defn drone-forward []
  (drone :tilt-front 1))

(defn drone-back []
  (drone :tilt-back 1))

(defn drone-left []
  (drone :tilt-left 1))

(defn drone-right []
  (drone :tilt-right 1))

(defn drone-up []
  (drone :up 0.3))

(defn drone-down []
  (drone :down 0.3))


(defn handle-command [key]
  (condp = key
        119 (drone-forward)
        122 (drone-back)
        97 (drone-left)
        115 (drone-right)
        61 (drone-up) ; + up
        45 (drone-down) ; - down
        113 (drone :land) ; q -> land
        116 (drone :take-off)  ; t -> take-off
        91 (drone :spin-left 1) ; [ -> spin left
        93 (drone :spin-right 1) ; ] -> spin right
        101 (drone :emergency) ; e -> emergency reset
        (println key)))

(defn get-input []
  (let [term (Terminal/getTerminal)]
    (while true
      (handle-command (.readCharacter term System/in)
       ))))

(defn -main [& args]
  (prn "Initializing Drone.. Ensure WiFi is connected")
  (drone-initialize)
  (prn "Waiting for commnds")
  (prn "W:forward Z:backwards A:left S:right -:down =:up Q:land T:takeoff [:spin left ]:spin right")
  (get-input))
