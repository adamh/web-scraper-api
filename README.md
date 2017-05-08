# Web Scraper API

A Clojure JSON API for serving data scraped using the [caspca web scraper](https://github.com/adamh/clojure-web-scraper).

## Usage

* Make sure you've run the [web scraper](https://github.com/adamh/clojure-web-scraper) and have the sqlite database.
* Put the Database in the db/ directory
* Run `lein ring server-headless`

## API Endpoints

* GET /animals - Returns list of all the animals
* GET /animals/random - Return 6 random animals
* GET /animals/:id - Returns a single animal where id is a number 

### See these endpoints in action at adamh.io
* [http://adamh.io/spca-api/animals/](http://adamh.io/spca-api/animals/)
* [http://adamh.io/spca-api/animals/random](http://adamh.io/spca-api/animals/random)
* [http://adamh.io/spca-api/animals/1](http://adamh.io/spca-api/animals/1)

## License

2017 Adam Hockensmith

Distributed under the MIT license.
