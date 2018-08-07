package com.hand.infra.aop;

public class FilmEvent {

    public void BeforeInsertFilmEvent() {
        System.out.println("Before Insert Film Data");
    }

    public void AfterInsertFilmEvent(){
        System.out.println("After Insert Film Data");
    }
}
