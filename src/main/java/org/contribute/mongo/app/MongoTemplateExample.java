package org.contribute.mongo.app;

import org.contribute.mongo.data.MovieDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class MongoTemplateExample {

    private final Logger log = Logger.getLogger(MongoTemplateExample.class.toString());

    @Autowired
    private MongoTemplate template;

    public void doSomeWitchCraft() {

        Query query = Query.query(Criteria.where("year").is(1968).
                and("countries").is("USA"));
        query.fields().include("title");

        List<MovieDetails> results = template.find(query, MovieDetails.class);
        log.info(results.size() + " results found");
        results.forEach(result -> log.info(result.toString()));

    }

    public void getMeSomeNiceMovies() {

        BasicQuery query = new BasicQuery("{type: 'movie', year: {$gt: 2010}, 'imdb.rating': {$gt: 7}}");

        List<MovieDetails> results = template.find(query, MovieDetails.class);
        log.info(results.size() + " results found");
        results.forEach(result -> log.info(result.toString()));

    }


}
