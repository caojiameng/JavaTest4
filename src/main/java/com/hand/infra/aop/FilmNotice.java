package com.hand.infra.aop;

public class FilmNotice {

    public void BeforeInsertFilmEvent() {
        System.out.println("Before Insert Film Data");
    }

    public void AfterInsertFilmEvent(){
        System.out.println("After Insert Film Data");
    }
}
