FROM clojure:lein
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . .
RUN lein deps
EXPOSE 3000
RUN useradd -m clojure
USER clojure
CMD ["lein", "ring", "server-headless"]
