package com.springdemo.restapi.service;

import com.springdemo.restapi.NotFoundException;
import com.springdemo.restapi.entity.Award;
import com.springdemo.restapi.entity.Cast;
import com.springdemo.restapi.entity.Movie;
import com.springdemo.restapi.model.*;
import com.springdemo.restapi.repository.CastRepository;
import com.springdemo.restapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CastRepository castRepository;

    @Override
    public void create(MovieRequest movieRequest) {
        List<CastRequest> castRequests = movieRequest.getCastRequest();
        List<AwardRequest> awardRequests = movieRequest.getAwards();
        List<Cast> casts=new ArrayList<>();
        List<Award> awards = new ArrayList<>();
        for(CastRequest castRequest: castRequests){
            casts.add(castRepository.findByName(castRequest.getName())
                    .orElse(Cast.builder()
                                    .name(castRequest.getName())
                                    .build()
                    ));
        }
        for(AwardRequest awardRequest : awardRequests){
            awards.add(Award.builder().name(awardRequest.getName()).year(awardRequest.getYear()).build());
        }
        Movie movie = Movie.builder()
                .genre(movieRequest.getGenre())
                .language(movieRequest.getLanguage())
                .movieName(movieRequest.getName())
                .casts(casts)
                .awards(awards)
                .build();
        movieRepository.save(movie);
    }

    @Override
    public MovieResponse get(String name) throws NotFoundException{

        Movie movie= movieRepository.findByMovieName(name)
                    .orElseThrow(()->new NotFoundException("movie not found"));
        List<CastResponse> castResponses = new ArrayList<>();
        List<AwardResponse> awardResponses = new ArrayList<>();
        List<Cast> casts = movie.getCasts();
        List<Award> awards = movie.getAwards();
        for(Cast cast:casts){
            castResponses.add(CastResponse.builder().name(cast.getName()).build());
        }
        for(Award award : awards){
            awardResponses.add(AwardResponse.builder().name(award.getName()).year(award.getYear()).build());
        }
        return MovieResponse.builder()
                .name(movie.getMovieName())
                .genre(movie.getGenre())
                .language(movie.getLanguage())
                .castResponse(castResponses)
                .awards(awardResponses)
                .build();
    }

    @Override
    public void update(String name, MovieRequest movieRequest) throws NotFoundException{
        Movie movie = null;
        movie = movieRepository.findByMovieName(name).orElseThrow(()->new NotFoundException("Sorry No movie with given name found"));
        if(movieRequest.getGenre()!=null){
        movie.setGenre(movieRequest.getGenre());}
        if(movieRequest.getLanguage()!=null){
            movie.setLanguage(movieRequest.getLanguage());
        }
        movieRepository.save(movie);
    }

    @Override
    public void delete(String name) throws NotFoundException{

        Movie movie = movieRepository.findByMovieName(name).orElseThrow(()->new NotFoundException("No movie found with given name"));
        if(movie!=null){
            movieRepository.delete(movie);
        }
    }
}
